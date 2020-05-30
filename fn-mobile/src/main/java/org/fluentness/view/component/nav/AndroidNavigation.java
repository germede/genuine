package org.fluentness.view.component.nav;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import org.fluentness.AbstractMobile;
import org.fluentness.controller.AbstractMobileController;

public class AndroidNavigation extends ViewGroup implements Navigation<AbstractMobileController> {

    private static final int TAP_THRESHOLD = 6;
    private static final float MAXIMUM_TAP_VELOCITY = 100.0f;
    private static final float MAXIMUM_MINOR_VELOCITY = 150.0f;
    private static final float MAXIMUM_MAJOR_VELOCITY = 200.0f;
    private static final float MAXIMUM_ACCELERATION = 2000.0f;
    private static final int VELOCITY_UNITS = 1000;
    private static final int ANIMATION_FRAME_DURATION = 1000 / 60;
    private static final int EXPANDED_FULL_OPEN = -10001;
    private static final int COLLAPSED_FULL_CLOSED = -10002;

    private final LinearLayout menu;
    private final Button toggle;

    private final Rect mFrame = new Rect();
    private final Rect mInvalidate = new Rect();
    private boolean mTracking;
    private VelocityTracker mVelocityTracker;
    private final boolean mVertical = true;
    private boolean mExpanded;
    private final int mBottomOffset = 0;
    private final int mTopOffset = 0;
    private int mHandleHeight;
    private int mHandleWidth;

    private float mAnimatedAcceleration;
    private float mAnimatedVelocity;
    private float mAnimationPosition;
    private long mAnimationLastTime;
    private int mTouchDelta;
    private boolean mAnimating;
    private final boolean mAllowSingleTap = true;
    private final boolean mAnimateOnClick = true;

    private final int mTapThreshold;
    private final int mMaximumTapVelocity;
    private final int mMaximumMinorVelocity;
    private final int mMaximumMajorVelocity;
    private final int mMaximumAcceleration;
    private final int mVelocityUnits;

    private final Runnable mSlidingRunnable = this::doAnimation;

    public AndroidNavigation() {
        super(AbstractMobile.context);
        this.menu = new LinearLayout(AbstractMobile.context);

        this.toggle = new Button(AbstractMobile.context);
        toggle.setText("TOGGLE");
        toggle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));;

        final float density = getResources().getDisplayMetrics().density;
        mTapThreshold = (int) (TAP_THRESHOLD * density + 0.5f);
        mMaximumTapVelocity = (int) (MAXIMUM_TAP_VELOCITY * density + 0.5f);
        mMaximumMinorVelocity = (int) (MAXIMUM_MINOR_VELOCITY * density + 0.5f);
        mMaximumMajorVelocity = (int) (MAXIMUM_MAJOR_VELOCITY * density + 0.5f);
        mMaximumAcceleration = (int) (MAXIMUM_ACCELERATION * density + 0.5f);
        mVelocityUnits = (int) (VELOCITY_UNITS * density + 0.5f);

        setAlwaysDrawnWithCacheEnabled(false);
    }

    @Override
    public void open() {
        openDrawer();
        invalidate();
        requestLayout();
    }

    @Override
    public void close() {
        closeDrawer();
        invalidate();
        requestLayout();
    }

    @Override
    public void addSectionFor(AbstractMobileController controller) {
        android.widget.Button button = new android.widget.Button(AbstractMobile.context);
        button.setText(controller.getView().getTitle());
        button.setOnClickListener(
            v -> Toast.makeText(AbstractMobile.context,
                controller.getView().getTitle().toString(),
                Toast.LENGTH_SHORT)
        );
        menu.addView(button);
    }

    @Override
    protected void onFinishInflate() {
        toggle.setOnClickListener(v -> {
            if (mAnimateOnClick) animateToggle();
            else toggle();
        });
        menu.setVisibility(View.GONE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.UNSPECIFIED || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        measureChild(toggle, widthMeasureSpec, heightMeasureSpec);
        if (mVertical) {
            int height = heightSpecSize - toggle.getMeasuredHeight() - mTopOffset;
            menu.measure(MeasureSpec.makeMeasureSpec(widthSpecSize, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        } else {
            int width = widthSpecSize - toggle.getMeasuredWidth() - mTopOffset;
            menu.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(heightSpecSize, MeasureSpec.EXACTLY));
        }
        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        final long drawingTime = getDrawingTime();
        final View handle = this.toggle;

        drawChild(canvas, handle, drawingTime);

        if (mTracking || mAnimating) {
            final Bitmap cache = menu.getDrawingCache();
            if (cache != null) {
                if (mVertical) canvas.drawBitmap(cache, 0, handle.getBottom(), null);
                else canvas.drawBitmap(cache, handle.getRight(), 0, null);
            } else {
                canvas.save();
                canvas.translate(mVertical ? 0 : handle.getLeft() - mTopOffset, handle.getTop() - mTopOffset);
                drawChild(canvas, menu, drawingTime);
                canvas.restore();
            }

        } else if (mExpanded) {
            drawChild(canvas, menu, drawingTime);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mTracking) return;
        final int width = r - l;
        final int height = b - t;
        final View handle = this.toggle;
        int childWidth = handle.getMeasuredWidth();
        int childHeight = handle.getMeasuredHeight();
        int childLeft;
        int childTop;
        final View content = this.menu;
        if (mVertical) {
            childLeft = (width - childWidth) / 2;
            childTop = mExpanded ? mTopOffset : height - childHeight + mBottomOffset;
            content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                mTopOffset + childHeight + content.getMeasuredHeight());
        } else {
            childLeft = mExpanded ? mTopOffset : width - childWidth + mBottomOffset;
            childTop = (height - childHeight) / 2;
            content.layout(mTopOffset + childWidth, 0,
                mTopOffset + childWidth + content.getMeasuredWidth(),
                content.getMeasuredHeight());
        }

        handle.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        mHandleHeight = handle.getHeight();
        mHandleWidth = handle.getWidth();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        final Rect frame = mFrame;
        final View handle = this.toggle;
        handle.getHitRect(frame);
        if (!mTracking && !frame.contains((int) x, (int) y)) return false;
        if (action == MotionEvent.ACTION_DOWN) {
            mTracking = true;
            handle.setPressed(true);
            prepareContent();
            if (mVertical) {
                final int top = this.toggle.getTop();
                mTouchDelta = (int) y - top;
                prepareTracking(top);
            } else {
                final int left = this.toggle.getLeft();
                mTouchDelta = (int) x - left;
                prepareTracking(left);
            }
            mVelocityTracker.addMovement(event);
        }

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mTracking) {
            mVelocityTracker.addMovement(event);
            final int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_MOVE:
                    moveHandle((int) (mVertical ? event.getY() : event.getX()) - mTouchDelta);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(mVelocityUnits);

                    float yVelocity = velocityTracker.getYVelocity();
                    float xVelocity = velocityTracker.getXVelocity();
                    boolean negative;

                    final boolean vertical = mVertical;
                    if (vertical) {
                        negative = yVelocity < 0;
                        if (xVelocity < 0) {
                            xVelocity = -xVelocity;
                        }
                        if (xVelocity > mMaximumMinorVelocity) {
                            xVelocity = mMaximumMinorVelocity;
                        }
                    } else {
                        negative = xVelocity < 0;
                        if (yVelocity < 0) {
                            yVelocity = -yVelocity;
                        }
                        if (yVelocity > mMaximumMinorVelocity) {
                            yVelocity = mMaximumMinorVelocity;
                        }
                    }

                    float velocity = (float) Math.hypot(xVelocity, yVelocity);
                    if (negative) {
                        velocity = -velocity;
                    }

                    final int top = toggle.getTop();
                    final int left = toggle.getLeft();

                    if (Math.abs(velocity) < mMaximumTapVelocity) {
                        if (vertical ? (mExpanded && top < mTapThreshold + mTopOffset) ||
                            (!mExpanded && top > mBottomOffset + getBottom() - getTop() -
                                mHandleHeight - mTapThreshold) :
                            (mExpanded && left < mTapThreshold + mTopOffset) ||
                                (!mExpanded && left > mBottomOffset + getRight() - getLeft() -
                                    mHandleWidth - mTapThreshold)) {

                            if (mAllowSingleTap) {
                                playSoundEffect(SoundEffectConstants.CLICK);

                                if (mExpanded) {
                                    animateClose(vertical ? top : left);
                                } else {
                                    animateOpen(vertical ? top : left);
                                }
                            } else {
                                performFling(vertical ? top : left, velocity, false);
                            }

                        } else {
                            performFling(vertical ? top : left, velocity, false);
                        }
                    } else {
                        performFling(vertical ? top : left, velocity, false);
                    }
                }
                break;
            }
        }
        return mTracking || mAnimating || super.onTouchEvent(event);
    }


    private void animateClose(int position) {
        prepareTracking(position);
        performFling(position, mMaximumAcceleration, true);
    }

    private void animateOpen(int position) {
        prepareTracking(position);
        performFling(position, -mMaximumAcceleration, true);
    }

    private void performFling(int position, float velocity, boolean always) {
        mAnimationPosition = position;
        mAnimatedVelocity = velocity;
        if (mExpanded) {
            if (always || (velocity > mMaximumMajorVelocity ||
                (position > mTopOffset + (mVertical ? mHandleHeight : mHandleWidth) &&
                    velocity > -mMaximumMajorVelocity))) {
                mAnimatedAcceleration = mMaximumAcceleration;
                if (velocity < 0) mAnimatedVelocity = 0;
            } else {
                mAnimatedAcceleration = -mMaximumAcceleration;
                if (velocity > 0) mAnimatedVelocity = 0;
            }
        } else {
            if (!always && (velocity > mMaximumMajorVelocity ||
                (position > (mVertical ? getHeight() : getWidth()) / 2 &&
                    velocity > -mMaximumMajorVelocity))) {
                mAnimatedAcceleration = mMaximumAcceleration;
                if (velocity < 0) {
                    mAnimatedVelocity = 0;
                }
            } else {
                // We are collapsed, but they didn't move sufficiently to cause
                // us to retract.  Animate back to the collapsed position.
                mAnimatedAcceleration = -mMaximumAcceleration;
                if (velocity > 0) {
                    mAnimatedVelocity = 0;
                }
            }
        }

        long now = SystemClock.uptimeMillis();
        mAnimationLastTime = now;
        mAnimating = true;
        removeCallbacks(mSlidingRunnable);
        postDelayed(mSlidingRunnable, ANIMATION_FRAME_DURATION);
        stopTracking();
    }

    private void prepareTracking(int position) {
        mTracking = true;
        mVelocityTracker = VelocityTracker.obtain();
        boolean opening = !mExpanded;
        if (opening) {
            mAnimatedAcceleration = mMaximumAcceleration;
            mAnimatedVelocity = mMaximumMajorVelocity;
            mAnimationPosition = mBottomOffset + (mVertical ? getHeight() - mHandleHeight : getWidth() - mHandleWidth);
            moveHandle((int) mAnimationPosition);
            mAnimating = true;
            removeCallbacks(mSlidingRunnable);
            mAnimationLastTime = SystemClock.uptimeMillis();
            mAnimating = true;
        } else {
            if (mAnimating) {
                mAnimating = false;
                removeCallbacks(mSlidingRunnable);
            }
            moveHandle(position);
        }
    }

    private void moveHandle(int position) {
        final View handle = this.toggle;
        if (mVertical) {
            if (position == EXPANDED_FULL_OPEN) {
                handle.offsetTopAndBottom(mTopOffset - handle.getTop());
                invalidate();
            } else if (position == COLLAPSED_FULL_CLOSED) {
                handle.offsetTopAndBottom(mBottomOffset + getBottom() - getTop() - mHandleHeight - handle.getTop());
                invalidate();
            } else {
                final int top = handle.getTop();
                int deltaY = position - top;
                if (position < mTopOffset) {
                    deltaY = mTopOffset - top;
                } else if (deltaY > mBottomOffset + getBottom() - getTop() - mHandleHeight - top) {
                    deltaY = mBottomOffset + getBottom() - getTop() - mHandleHeight - top;
                }
                handle.offsetTopAndBottom(deltaY);
                final Rect frame = mFrame;
                final Rect region = mInvalidate;
                handle.getHitRect(frame);
                region.set(frame);
                region.union(frame.left, frame.top - deltaY, frame.right, frame.bottom - deltaY);
                region.union(0, frame.bottom - deltaY, getWidth(), frame.bottom - deltaY + menu.getHeight());
                invalidate(region);
            }
        } else {
            if (position == EXPANDED_FULL_OPEN) {
                handle.offsetLeftAndRight(mTopOffset - handle.getLeft());
                invalidate();
            } else if (position == COLLAPSED_FULL_CLOSED) {
                handle.offsetLeftAndRight(mBottomOffset + getRight() - getLeft() -
                    mHandleWidth - handle.getLeft());
                invalidate();
            } else {
                final int left = handle.getLeft();
                int deltaX = position - left;
                if (position < mTopOffset) {
                    deltaX = mTopOffset - left;
                } else if (deltaX > mBottomOffset + getRight() - getLeft() - mHandleWidth - left) {
                    deltaX = mBottomOffset + getRight() - getLeft() - mHandleWidth - left;
                }
                handle.offsetLeftAndRight(deltaX);
                final Rect frame = mFrame;
                final Rect region = mInvalidate;
                handle.getHitRect(frame);
                region.set(frame);
                region.union(frame.left - deltaX, frame.top, frame.right - deltaX, frame.bottom);
                region.union(frame.right - deltaX, 0, frame.right - deltaX + menu.getWidth(), getHeight());
                invalidate(region);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void prepareContent() {
        if (mAnimating) return;
        final View content = this.menu;
        if (content.isLayoutRequested()) {
            if (mVertical) {
                final int childHeight = mHandleHeight;
                int height = getBottom() - getTop() - childHeight - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(getRight() - getLeft(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
                content.layout(0, mTopOffset + childHeight, content.getMeasuredWidth(),
                    mTopOffset + childHeight + content.getMeasuredHeight());
            } else {
                final int childWidth = toggle.getWidth();
                int width = getRight() - getLeft() - childWidth - mTopOffset;
                content.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getBottom() - getTop(), MeasureSpec.EXACTLY));
                content.layout(childWidth + mTopOffset, 0,
                    mTopOffset + childWidth + content.getMeasuredWidth(),
                    content.getMeasuredHeight());
            }
        }
        content.getViewTreeObserver().dispatchOnPreDraw();
        if (!content.isHardwareAccelerated()) content.buildDrawingCache();
        content.setVisibility(View.GONE);
    }

    private void stopTracking() {
        toggle.setPressed(false);
        mTracking = false;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private void doAnimation() {
        if (mAnimating) {
            incrementAnimation();
            if (mAnimationPosition >= mBottomOffset + (mVertical ? getHeight() : getWidth()) - 1) {
                mAnimating = false;
                closeDrawer();
            } else if (mAnimationPosition < mTopOffset) {
                mAnimating = false;
                openDrawer();
            } else {
                moveHandle((int) mAnimationPosition);
                postDelayed(mSlidingRunnable, ANIMATION_FRAME_DURATION);
            }
        }
    }

    private void incrementAnimation() {
        long now = SystemClock.uptimeMillis();
        float t = (now - mAnimationLastTime) / 1000.0f;
        final float position = mAnimationPosition;
        final float v = mAnimatedVelocity;
        final float a = mAnimatedAcceleration;
        mAnimationPosition = position + (v * t) + (0.5f * a * t * t);
        mAnimatedVelocity = v + (a * t);
        mAnimationLastTime = now;
    }

    public void toggle() {
        if (!mExpanded) openDrawer();
        else closeDrawer();
        invalidate();
        requestLayout();
    }

    public void animateToggle() {
        prepareContent();
        if (!mExpanded) animateOpen(mVertical ? toggle.getTop() : toggle.getLeft());
        else animateClose(mVertical ? toggle.getTop() : toggle.getLeft());
    }

    private void closeDrawer() {
        moveHandle(COLLAPSED_FULL_CLOSED);
        menu.setVisibility(View.GONE);
        menu.destroyDrawingCache();
        if (!mExpanded) return;
        mExpanded = false;
    }

    private void openDrawer() {
        moveHandle(EXPANDED_FULL_OPEN);
        menu.setVisibility(View.VISIBLE);
        if (mExpanded) return;
        mExpanded = true;
    }

    public boolean isOpened() {
        return mExpanded;
    }
}

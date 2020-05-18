package org.fluentness.controller;

import android.content.Context;
import android.view.View;
import android.widget.*;
import org.fluentness.controller.android.AndroidTemplate;

public abstract class AbstractMobile extends AbstractPrerenderedView<MobileTemplate> {

    public static Context context;

    protected static MobileTemplate activity(View rootView) {
        return new AndroidTemplate(rootView);
    }

    protected static AdapterViewFlipper adapterViewFlipper() {
        return new AdapterViewFlipper(context);
    }

    protected static AnalogClock analogClock() {
        return new AnalogClock(context);
    }

    protected static AutoCompleteTextView autoCompleteText() {
        return new AutoCompleteTextView(context);
    }

    protected static Button button() {
        return new Button(context);
    }

    protected static CalendarView calendar() {
        return new CalendarView(context);
    }

    protected static CheckBox checkBox() {
        return new CheckBox(context);
    }

    protected static CheckedTextView checkedText() {
        return new CheckedTextView(context);
    }

    protected static Chronometer chronometer() {
        return new Chronometer(context);
    }

    protected static DatePicker datePicker() {
        return new DatePicker(context);
    }

    protected static DialerFilter dialerFilter() {
        return new DialerFilter(context);
    }

    protected static DigitalClock digitalClock() {
        return new DigitalClock(context);
    }

    protected static EdgeEffect edgeEffect() {
        return new EdgeEffect(context);
    }

    protected static EditText editText() {
        return new EditText(context);
    }

    protected static ExpandableListView expandableList() {
        return new ExpandableListView(context);
    }

    protected static FrameLayout frameLayout() {
        return new FrameLayout(context);
    }

    protected static GridLayout gridLayout() {
        return new GridLayout(context);
    }

    protected static GridView grid() {
        return new GridView(context);
    }

    protected static HorizontalScrollView horizontalScroll() {
        return new HorizontalScrollView(context);
    }

    protected static ImageButton imageButton() {
        return new ImageButton(context);
    }

    protected static ImageSwitcher imageSwitcher() {
        return new ImageSwitcher(context);
    }

    protected static ImageView image() {
        return new ImageView(context);
    }

    protected static LinearLayout linearLayout(View... views) {
        LinearLayout linearLayout = new LinearLayout(context);
        for (View view : views) {
            linearLayout.addView(view);
        }
        return linearLayout;
    }

    protected static ListPopupWindow listPopupWindow() {
        return new ListPopupWindow(context);
    }

    protected static ListView list() {
        return new ListView(context);
    }

    protected static MediaController mediaController() {
        return new MediaController(context);
    }

    protected static MultiAutoCompleteTextView multiAutoCompleteText() {
        return new MultiAutoCompleteTextView(context);
    }

    protected static NumberPicker numberPicker() {
        return new NumberPicker(context);
    }

    protected static OverScroller overScroller() {
        return new OverScroller(context);
    }

    protected static PopupMenu popupMenu(View anchor) {
        return new PopupMenu(context, anchor);
    }

    protected static PopupWindow popupWindow() {
        return new PopupWindow(context);
    }

    protected static ProgressBar progressBar() {
        return new ProgressBar(context);
    }

    protected static QuickContactBadge quickContactBadge() {
        return new QuickContactBadge(context);
    }

    protected static RadioButton radioButton() {
        return new RadioButton(context);
    }

    protected static RadioGroup radioGroup() {
        return new RadioGroup(context);
    }

    protected static RatingBar ratingBar() {
        return new RatingBar(context);
    }

    protected static RelativeLayout relativeLayout() {
        return new RelativeLayout(context);
    }

    protected static Scroller scroller() {
        return new Scroller(context);
    }

    protected static ScrollView scroll() {
        return new ScrollView(context);
    }

    protected static SearchView search() {
        return new SearchView(context);
    }

    protected static SeekBar seekBar() {
        return new SeekBar(context);
    }

    protected static ShareActionProvider shareActionProvider() {
        return new ShareActionProvider(context);
    }

    protected static SlidingDrawer slidingDrawer() {
        return new SlidingDrawer(context, null);
    }

    protected static Space space() {
        return new Space(context);
    }

    protected static Spinner spinner() {
        return new Spinner(context);
    }

    protected static StackView stack() {
        return new StackView(context);
    }

    protected static Switch switcher() {
        return new Switch(context);
    }

    protected static TabHost tabHost() {
        return new TabHost(context);
    }

    protected static TableLayout tableLayout() {
        return new TableLayout(context);
    }

    protected static TableRow tableRow() {
        return new TableRow(context);
    }

    protected static TabWidget tabWidget() {
        return new TabWidget(context);
    }

    protected static TextSwitcher textSwitcher() {
        return new TextSwitcher(context);
    }

    protected static TextView text(String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        return textView;
    }

    protected static TimePicker timePicker() {
        return new TimePicker(context);
    }

    protected static Toast toast() {
        return new Toast(context);
    }

    protected static ToggleButton toggleButton() {
        return new ToggleButton(context);
    }

    protected static TwoLineListItem twoLineListItem() {
        return new TwoLineListItem(context);
    }

    protected static VideoView video() {
        return new VideoView(context);
    }

    protected static ViewAnimator viewAnimator() {
        return new ViewAnimator(context);
    }

    protected static ViewFlipper viewFlipper() {
        return new ViewFlipper(context);
    }

    protected static ViewSwitcher viewSwitcher() {
        return new ViewSwitcher(context);
    }

    protected static ZoomButton zoomButton() {
        return new ZoomButton(context);
    }

    protected static ZoomControls zoomControls() {
        return new ZoomControls(context);
    }
}

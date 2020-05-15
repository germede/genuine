package org.fluentness.service.animator;

public class Animation {

    private final AnimationStep animationStep;
    private final AnimationFunction animationFunction;
    private final float from;
    private final float to;
    private final long duration;
    private long startTime;

    public Animation(AnimationFunction animationFunction, float from, float to, AnimationStep animationStep, long duration) {
        this.animationStep = animationStep;
        this.animationFunction = animationFunction;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public AnimationStep getAnimationStep() {
        return animationStep;
    }

    public AnimationFunction getAnimationFunction() {
        return animationFunction;
    }

    public float getFrom() {
        return from;
    }

    public float getTo() {
        return to;
    }

    public long getDuration() {
        return duration;
    }

    public long getStartTime() {
        return startTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }
}

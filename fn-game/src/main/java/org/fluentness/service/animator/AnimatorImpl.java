package org.fluentness.service.animator;

import java.util.LinkedList;
import java.util.List;

public class AnimatorImpl implements Animator {

    private final List<Animation> animations = new LinkedList<>();

    @Override
    public void animate(AnimationFunction animationFunction, float from, float to, AnimationStep animationStep, long duration) {
        Animation animation = new Animation(animationFunction, from, to, animationStep, duration);
        animations.add(animation);
        animation.start();
    }

    @Override
    public void step() {
        animations.removeIf(animation -> animation.getDuration() < System.currentTimeMillis() - animation.getStartTime());
        for (Animation animation : animations) {
            long passedTime = System.currentTimeMillis() - animation.getStartTime();
            float t = passedTime / (float)animation.getDuration();
            float x = animation.getAnimationFunction().f(t);
            float value = animation.getFrom() + x * (animation.getTo()-animation.getFrom());
            animation.getAnimationStep().set(value);
        }
    }

}

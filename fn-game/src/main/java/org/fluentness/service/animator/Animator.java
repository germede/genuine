package org.fluentness.service.animator;

public interface Animator {

    AnimationFunction LINEAR = t -> t;
    AnimationFunction BEZIER = t -> t * t * (3.0f - 2.0f * t);

    void animate(AnimationFunction animationFunction, float from, float to, AnimationStep animationStep, long duration);

    void step();
}

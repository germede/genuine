package org.fluentness.service.animator;

import org.fluentness.service.Service;

public interface Animator extends Service {

    AnimationFunction LINEAR = t -> t;
    AnimationFunction BEZIER = t -> t * t * (3.0f - 2.0f * t);

    void animate(AnimationFunction animationFunction, float from, float to, AnimationStep animationStep, long duration);

    void step();
}

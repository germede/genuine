package org.fluentness.service.algebra;

public final class VectorFactory {

    private VectorFactory() {
    }

    public static Vector2f zeroVector2f() {
        return new Vector2f(0, 0);
    }

    public static Vector3f zeroVector3f() {
        return new Vector3f(0, 0, 0);
    }

    public static Vector4f zeroVector4f() {
        return new Vector4f(0, 0, 0, 0);
    }

    public static Vector3f whiteRgb() {
        return new Vector3f(1, 1, 1);
    }

    public static Vector3f blackRgb() {
        return new Vector3f(0, 0, 0);
    }

    public static Vector4f whiteRgba() {
        return new Vector4f(1, 1, 1, 1);
    }

    public static Vector4f blackRgba() {
        return new Vector4f(0, 0, 0, 1);
    }

}

package org.fluentness.service.algebra;

public class DefaultAlgebra implements Algebra {

    @Override
    public Matrix4f translationMatrix(float x, float y, float z) {
        Matrix4f translation = new Matrix4f();

        translation.m03 = x;
        translation.m13 = y;
        translation.m23 = z;

        return translation;
    }

    @Override
    public Matrix4f rotationMatrix(float angle, float x, float y, float z) {
        Matrix4f rotation = new Matrix4f();

        float c = (float) Math.cos(Math.toRadians(angle));
        float s = (float) Math.sin(Math.toRadians(angle));
        Vector3f vec = new Vector3f(x, y, z);
        if (vec.length() != 1f) {
            vec = vec.normalize();
            x = vec.x;
            y = vec.y;
            z = vec.z;
        }

        rotation.m00 = x * x * (1f - c) + c;
        rotation.m10 = y * x * (1f - c) + z * s;
        rotation.m20 = x * z * (1f - c) - y * s;
        rotation.m01 = x * y * (1f - c) - z * s;
        rotation.m11 = y * y * (1f - c) + c;
        rotation.m21 = y * z * (1f - c) + x * s;
        rotation.m02 = x * z * (1f - c) + y * s;
        rotation.m12 = y * z * (1f - c) - x * s;
        rotation.m22 = z * z * (1f - c) + c;

        return rotation;
    }

    @Override
    public Matrix4f scaleMatrix(float x, float y, float z) {
        Matrix4f scaling = new Matrix4f();

        scaling.m00 = x;
        scaling.m11 = y;
        scaling.m22 = z;

        return scaling;
    }

    @Override
    public Matrix4f orthographicMatrix(float left, float right, float bottom, float top, float near, float far) {
        Matrix4f ortho = new Matrix4f();

        float tx = -(right + left) / (right - left);
        float ty = -(top + bottom) / (top - bottom);
        float tz = -(far + near) / (far - near);

        ortho.m00 = 2f / (right - left);
        ortho.m11 = 2f / (top - bottom);
        ortho.m22 = -2f / (far - near);
        ortho.m03 = tx;
        ortho.m13 = ty;
        ortho.m23 = tz;

        return ortho;
    }

    @Override
    public Matrix4f frustumMatrix(float left, float right, float bottom, float top, float near, float far) {
        Matrix4f frustum = new Matrix4f();

        float a = (right + left) / (right - left);
        float b = (top + bottom) / (top - bottom);
        float c = -(far + near) / (far - near);
        float d = -(2f * far * near) / (far - near);

        frustum.m00 = (2f * near) / (right - left);
        frustum.m11 = (2f * near) / (top - bottom);
        frustum.m02 = a;
        frustum.m12 = b;
        frustum.m22 = c;
        frustum.m32 = -1f;
        frustum.m23 = d;
        frustum.m33 = 0f;

        return frustum;
    }

    @Override
    public Matrix4f transformationMatrix(Vector3f translation, Vector3f rotation, float scale) {
        Matrix4f matrix4f = new Matrix4f();

        matrix4f = matrix4f.multiply(translationMatrix(translation.x, translation.y, translation.z));
        matrix4f = matrix4f.multiply(rotationMatrix(rotation.x, 1, 0, 0));
        matrix4f = matrix4f.multiply(rotationMatrix(rotation.y, 0, 1, 0));
        matrix4f = matrix4f.multiply(rotationMatrix(rotation.z, 0, 0, 1));
        matrix4f = matrix4f.multiply(scaleMatrix(scale, scale, scale));

        return matrix4f;
    }

    @Override
    public Matrix4f projectionMatrix(float fov, float aspect, float near, float far) {
        float f = (float) (1f / Math.tan(Math.toRadians(fov) / 2f));

        Matrix4f perspective = new Matrix4f();

        perspective.m00 = f / aspect;
        perspective.m11 = f;
        perspective.m22 = (far + near) / (near - far);
        perspective.m32 = -1f;
        perspective.m23 = (2f * far * near) / (near - far);
        perspective.m33 = 0f;

        return perspective;
    }

    @Override
    public Matrix4f viewMatrix(Vector3f translation, Vector3f rotation) {
        Matrix4f matrix4f = new Matrix4f();

        matrix4f = matrix4f.multiply(rotationMatrix(rotation.x, 1, 0, 0));
        matrix4f = matrix4f.multiply(rotationMatrix(rotation.y, 0, 1, 0));
        matrix4f = matrix4f.multiply(rotationMatrix(rotation.z, 0, 0, 1));
        matrix4f = matrix4f.multiply(translationMatrix(-translation.x, -translation.y, -translation.z));

        return matrix4f;
    }

    @Override
    public Vector2f zeroVector2f() {
        return new Vector2f(0, 0);
    }

    @Override
    public Vector3f zeroVector3f() {
        return new Vector3f(0, 0, 0);
    }

    @Override
    public Vector4f zeroVector4f() {
        return new Vector4f(0, 0, 0, 0);
    }

    @Override
    public Vector3f whiteRgb() {
        return new Vector3f(1, 1, 1);
    }

    @Override
    public Vector3f blackRgb() {
        return new Vector3f(0, 0, 0);
    }

    @Override
    public Vector4f whiteRgba() {
        return new Vector4f(1, 1, 1, 1);
    }

    @Override
    public Vector4f blackRgba() {
        return new Vector4f(0, 0, 0, 1);
    }
}

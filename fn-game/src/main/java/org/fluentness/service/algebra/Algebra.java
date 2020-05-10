package org.fluentness.service.algebra;

import org.fluentness.service.Service;

public interface Algebra extends Service {

    Matrix4f translationMatrix(float x, float y, float z);

    Matrix4f rotationMatrix(float angle, float x, float y, float z);

    Matrix4f scaleMatrix(float x, float y, float z);

    Matrix4f orthographicMatrix(float left, float right, float bottom, float top, float near, float far);

    Matrix4f frustumMatrix(float left, float right, float bottom, float top, float near, float far);

    Matrix4f transformationMatrix(Vector3f translation, Vector3f rotation, float scale);

    Matrix4f projectionMatrix(float fov, float aspect, float near, float far);

    Matrix4f viewMatrix(Vector3f translation, Vector3f rotation);

    Vector2f zeroVector2f();

    Vector3f zeroVector3f();

    Vector4f zeroVector4f();

    Vector3f whiteRgb();

    Vector3f blackRgb();

    Vector4f whiteRgba();

    Vector4f blackRgba();
}

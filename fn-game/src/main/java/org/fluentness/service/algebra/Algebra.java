package org.fluentness.service.algebra;

import org.fluentness.model.algebra.Matrix4f;
import org.fluentness.service.Service;

public interface Algebra extends Service {

    Matrix4f translationMatrix(float x, float y, float z);

    Matrix4f rotationMatrix(float angle, float x, float y, float z);

    Matrix4f scaleMatrix(float x, float y, float z);

    Matrix4f orthographicMatrix(float left, float right, float bottom, float top, float near, float far);

    Matrix4f frustumMatrix(float left, float right, float bottom, float top, float near, float far);

    Matrix4f transformationMatrix(float x, float y, float z, float pitch, float yaw, float roll, float scale);

    Matrix4f projectionMatrix(float fov, float aspect, float near, float far);

    Matrix4f viewMatrix(float x, float y, float z, float pitch, float yaw, float roll);

}

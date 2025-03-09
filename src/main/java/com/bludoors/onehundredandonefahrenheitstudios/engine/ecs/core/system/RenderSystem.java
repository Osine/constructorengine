package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.system;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import java.util.List;

import org.joml.Matrix4f;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Entity;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.SystemBase;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.CameraComponent;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.RenderComponent;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.TransformComponent;

public class RenderSystem extends SystemBase {

    @Override
    public void update(List<Entity> entities, float deltaTime) {
        Entity activeCameraEntity = null;
        CameraComponent activeCameraComponent = null;
        TransformComponent cameraTransform = null;

        for (Entity e : entities) {
            CameraComponent camera = e.getComponent(CameraComponent.class);
            if (camera != null) {
                activeCameraEntity = e;
                activeCameraComponent = camera;
                cameraTransform = e.getComponent(TransformComponent.class);
                break;
            }
        }

        if (activeCameraEntity == null || activeCameraComponent == null || cameraTransform == null) {
            return;
        }

        Matrix4f projectionMatrix = computeProjectionMatrix(activeCameraComponent);
        Matrix4f viewMatrix = computeViewMatrix(cameraTransform);

        glClearColor(0.1f, 0.1f, 0.1f, 1f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        for (Entity e : entities) {
            RenderComponent renderComponent = e.getComponent(RenderComponent.class);
            TransformComponent transformComponent = e.getComponent(TransformComponent.class);

            if (renderComponent != null && renderComponent.isVisible) {
                Matrix4f modelMatrix = new Matrix4f().identity();
                if (transformComponent != null) {
                    modelMatrix = computeModelMatrix(transformComponent);
                }

                Matrix4f modelViewProjection = new Matrix4f();
                projectionMatrix.mul(viewMatrix, modelViewProjection).mul(modelMatrix);
            }
        }
    }

    private Matrix4f computeProjectionMatrix(CameraComponent camera) {
        Matrix4f projection = new Matrix4f().identity();
        float aspectRatio = 16f / 9f; // in future dynamically compute this from window size.

        switch (camera.cameraType) {
            case PERSPECTIVE:
                projection.perspective((float) Math.toRadians(camera.fov), aspectRatio, camera.nearPlane,
                        camera.farPlane);
                break;
            case ORTHOGRAPHIC:
                projection.ortho(camera.left, camera.right, camera.bottom, camera.top, camera.nearPlane,
                        camera.farPlane);
                break;
        }
        return projection;
    }

    private Matrix4f computeViewMatrix(TransformComponent transform) {
        Matrix4f view = new Matrix4f().identity();

        view.rotateX((float) Math.toRadians(-transform.rotation.x))
                .rotateY((float) Math.toRadians(-transform.rotation.y))
                .rotateZ((float) Math.toRadians(-transform.rotation.z));

        view.translate(-transform.position.x, -transform.position.y, transform.position.z);

        return view;
    }

    private Matrix4f computeModelMatrix(TransformComponent transform) {
        Matrix4f model = new Matrix4f().identity();
        model.translate(transform.position);

        model.rotateXYZ((float) Math.toRadians(transform.rotation.x),
                (float) Math.toRadians(transform.rotation.y),
                (float) Math.toRadians(transform.rotation.z));

        model.scale(transform.scale);
        return model;
    }

}

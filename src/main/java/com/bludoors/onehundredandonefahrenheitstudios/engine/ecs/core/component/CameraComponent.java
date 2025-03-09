package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class CameraComponent extends Component{

    public enum CameraType{
        PERSPECTIVE,
        ORTHOGRAPHIC
    }

    public CameraType cameraType = CameraType.PERSPECTIVE;

    //perspective
    public float fov = 60.0f;
    public float nearPlane = 0.1f;
    public float farPlane = 1000.0f;

    //orthographic
    public float left = -10.0f;
    public float right = 10.0f;
    public float top = 10.0f;
    public float bottom = -10.0f;

    public boolean isActive = true;

    public CameraComponent(){}

    public CameraComponent(CameraType type){
        this.cameraType = type;
    }
    
}

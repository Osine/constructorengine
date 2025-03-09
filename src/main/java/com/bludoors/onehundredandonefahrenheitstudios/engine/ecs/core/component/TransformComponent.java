package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import org.joml.Vector3f;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class TransformComponent extends Component {

    public Vector3f position;
    public Vector3f rotation;
    public Vector3f scale;

    public TransformComponent(Vector3f position, Vector3f rotation, Vector3f scale){
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public TransformComponent(){
        this.position = new Vector3f(0,0,0);
        this.rotation = new Vector3f(0,0,0);
        this.scale = new Vector3f(1, 1,1);
    }
    
}

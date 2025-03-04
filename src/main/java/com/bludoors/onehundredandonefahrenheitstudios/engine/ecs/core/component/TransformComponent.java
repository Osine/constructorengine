package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class TransformComponent extends Component {

    public float x, y, z;

    public TransformComponent(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
}

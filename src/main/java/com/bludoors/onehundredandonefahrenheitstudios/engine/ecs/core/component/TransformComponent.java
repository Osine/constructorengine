package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class TransformComponent extends Component {

    public float x, y;

    public TransformComponent(float x, float y){
        this.x = x;
        this.y = y;
    }
    
}

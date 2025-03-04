package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class VelocityComponent extends Component {
    public float vx, vy;

    public VelocityComponent(float vx, float vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
}

package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class VelocityComponent extends Component {
    public float vx, vy, vz;

    public VelocityComponent(float vx, float vy, float vz) {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
    }
    
}

package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.system;

import java.util.List;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Entity;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.SystemBase;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.TransformComponent;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.VelocityComponent;

public class MovementSystem extends SystemBase {

    @Override
    public void update(List<Entity> entities, float deltaTime){
        for (Entity entity : entities){
            TransformComponent transform = entity.getComponent(TransformComponent.class);
            VelocityComponent velocity = entity.getComponent(VelocityComponent.class);

            if (transform != null && velocity != null){
                transform.x += velocity.vx *deltaTime;
                transform.y += velocity.vy * deltaTime;
            }
        }
    }
    
}

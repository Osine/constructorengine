package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core;

import java.util.List;

public abstract class SystemBase {

    public abstract void update(List<Entity> entities, float deltaTime);
    
}

package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs;

import java.util.HashMap;
import java.util.Map;

public class Entity {

    private Map<Class<? extends Component>, Component> components = new HashMap<>();

    public <T extends Component> void addComponent(T component){
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> componentClass){
        return componentClass.cast(components.get(componentClass));
    }
    
}

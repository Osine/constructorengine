package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {

    private Map<Class<? extends Component>, Component> components = new HashMap<>();

    public <T extends Component> void addComponent(T component){
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> componentClass){
        return componentClass.cast(components.get(componentClass));
    }

    public <T extends Component> List<T> getAllComponents(Class <T> componentClass){
        List <T> componentsOfType = new ArrayList<>();
        for (Component component : components.values()){
            if(componentClass.isInstance(component)){
                componentsOfType.add(componentClass.cast(component));
            }
        }

        return componentsOfType;
    }

    public <T extends Component> void removeComponent(T component){
        components.remove(component.getClass(), component);
    }
    public <T extends Component> void removeComponent(Class<T> componentClass) {
        components.remove(componentClass);
    }
    
}

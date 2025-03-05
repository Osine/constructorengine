package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Entity;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.ISerialisable;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.SystemBase;
import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component.SaveableComponent;

public class SaveLoadSystem extends SystemBase{

    @Override
    public void update(List<Entity> entities, float deltaTime) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void save(List<Entity> entities){
        Map<String, Map<String, Object>> savedData = new HashMap<>();

        for (Entity entity : entities){
            SaveableComponent saveableComponent = entity.getComponent(SaveableComponent.class);

            if (saveableComponent != null ){
                Map<String, Object> entityData = new HashMap<>();

                for (Component component : entity.getAllComponents(null)){
                    if (component instanceof ISerialisable){
                        ISerialisable serialisable = (ISerialisable) component;
                        entityData.put(component.getClass().getSimpleName(), serialisable.saveState());
                    }
                }

                savedData.put(saveableComponent.uniqueID, entityData);
            }
        }

        //write data to a file figure out data structure for this
    }

    public void load(List<Entity> entities){}
    
}

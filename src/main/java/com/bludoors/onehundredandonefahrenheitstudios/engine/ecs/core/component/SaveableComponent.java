package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class SaveableComponent extends Component{
    public String uniqueID;

    public SaveableComponent (String uniqueID){
        this.uniqueID = uniqueID;
    }
    
}

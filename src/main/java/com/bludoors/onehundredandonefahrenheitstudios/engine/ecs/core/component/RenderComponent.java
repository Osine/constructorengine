package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.component;

import com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core.Component;

public class RenderComponent extends Component{

    public String meshID;
    public String materialID;

    public boolean isVisible = true;

    public RenderComponent(){}

    public RenderComponent(String meshID, String materialID){
        this.meshID = meshID;
        this.materialID =  materialID;
    }
    
}

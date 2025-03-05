package com.bludoors.onehundredandonefahrenheitstudios.engine.ecs.core;

import java.util.Map;

public interface ISerialisable {
    Map<String, Object> saveState();
    void loadState(Map<String, Object> data);
}

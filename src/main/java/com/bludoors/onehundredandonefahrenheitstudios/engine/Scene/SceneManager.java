package com.bludoors.onehundredandonefahrenheitstudios.engine.Scene;

public class SceneManager {

    private Scene currentScene;

    public void setScene(Scene scene) {
        if (currentScene != null) {
            currentScene.cleanup();
        }

        currentScene = scene;
        currentScene.init();
    }

    public void update() {
        if (currentScene != null) {
            currentScene.update();
        }
    }

    public void render(){
        if(currentScene != null){
            currentScene.render();
        }
    }

    public void cleanup(){
        if(currentScene != null){
            currentScene.cleanup();
        }
    }

}

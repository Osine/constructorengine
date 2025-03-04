package com.bludoors.onehundredandonefahrenheitstudios.engine;

import com.bludoors.onehundredandonefahrenheitstudios.engine.Input.Input;
import com.bludoors.onehundredandonefahrenheitstudios.engine.Scene.SceneManager;
import com.bludoors.onehundredandonefahrenheitstudios.engine.test.InitialScene;

public class GameEngine {

    private Window window;
    private SceneManager sceneManager;
    private boolean running = false;

    public GameEngine(String title, int width, int height){
        window = new Window(title, width, height);
        sceneManager = new SceneManager();
    }

    public void start(){
        running = true;
        init();
        gameLoop();
        cleanup();
    }

    private void init(){
        window.init();

        Input.init(window);
        sceneManager.setScene(new InitialScene());
    }

    private void gameLoop(){
        long lastTime = System.nanoTime();
        final double nsPerUpdate = 1_000_000_000.0 / 60.0;
        double delta = 0;

        while (running && !window.shouldClose()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while (delta >= 1){
                update();
                delta--;
            }

            render();
            window.update();
        }
    }

    private void update(){
        Input.pollEvents();
        sceneManager.update();
    }

    private void render(){
        window.clear();
        sceneManager.render();
        window.swapBuffers();
    }

    private void cleanup(){
        sceneManager.cleanup();
        window.cleanup();
    }
    
}

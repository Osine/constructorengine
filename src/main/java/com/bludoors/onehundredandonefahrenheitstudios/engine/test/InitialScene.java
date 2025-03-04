package com.bludoors.onehundredandonefahrenheitstudios.engine.test;

import com.bludoors.onehundredandonefahrenheitstudios.engine.Input.Input;
import com.bludoors.onehundredandonefahrenheitstudios.engine.Scene.Scene;

import static org.lwjgl.opengl.GL11.*;


public class InitialScene extends Scene {

    @Override
    public void init() {}

    @Override
    public void update() {
        if (Input.isKeyDown(org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER)) {
        }
    }
    @Override
    public void render() {
        glBegin(GL_QUADS);
        glBegin(GL_QUADS);
        glColor3f(1.0f, 0f, 0f);
        glVertex2f(-0.5f, -0.5f);
        glVertex2f( 0.5f, -0.5f);
        glVertex2f( 0.5f,  0.5f);
        glVertex2f(-0.5f,  0.5f);
        glEnd();    
    }
    @Override
    public void cleanup() {}
    
}

package com.bludoors.onehundredandonefahrenheitstudios.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Window{
    private long windowHandle;
    private int width, height;
    private String title;

    public Window(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();

        if(!GLFW.glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        windowHandle = GLFW.glfwCreateWindow(width, height, title, NULL, NULL);
        if(windowHandle == NULL){
            throw new RuntimeException("Failed to create the GLFW window");
        }

        GLFW.glfwSetWindowPos(windowHandle, 100, 100);

        GLFW.glfwMakeContextCurrent(windowHandle);
        GL.createCapabilities();

        GLFW.glfwShowWindow(windowHandle);
    }

    public long getWindowHandle() {
        return windowHandle;
    }

    public boolean shouldClose(){
        return GLFW.glfwWindowShouldClose(windowHandle);
    }

    public void update(){
        GLFW.glfwPollEvents();
    }

    public void swapBuffers(){
        GLFW.glfwSwapBuffers(windowHandle);
    }

    public void clear(){
        glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void cleanup(){
        GLFW.glfwDestroyWindow(windowHandle);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }
} 

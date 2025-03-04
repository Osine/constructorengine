package com.bludoors.onehundredandonefahrenheitstudios.engine.Input;

import org.lwjgl.glfw.GLFW;

import com.bludoors.onehundredandonefahrenheitstudios.engine.Window;


public class Input {

    private static Window window;

    public static void init(Window initWindow){
        window = initWindow;
    }

    public static void pollEvents(){
        //code for key state updates goes here
    } 

    public static boolean isKeyDown(int keyCode){
        return GLFW.glfwGetKey(window.getWindowHandle(), keyCode) == GLFW.GLFW_PRESS;
    }
    
}

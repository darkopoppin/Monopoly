package gui;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;

public class Window {
	
	public static void run() {
		init();
	}
	
	private static void init() {
		GLFWErrorCallback.createPrint(System.err).set();
		
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");
		
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		
		//window = glfwCreateWindow(1600,1600,"Window",null,null);
	}
}

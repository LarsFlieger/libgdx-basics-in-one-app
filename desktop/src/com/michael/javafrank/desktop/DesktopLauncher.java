package com.michael.javafrank.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.michael.javafrank.Tutorial;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Example";
		config.width = 1920;
		config.height = 1080;
		config.resizable = true;
		config.fullscreen = false;
		config.samples = 2; //anti alasing
		config.vSyncEnabled = true;
		config.foregroundFPS = 60;
		config.backgroundFPS = 30;
		config.pauseWhenBackground = true; //Require this to pause and resume on focus

		config.addIcon("icons/icon_32.png", Files.FileType.Internal);
		config.addIcon("icons/icon_16.png", Files.FileType.Internal);
		config.addIcon("icons/icon_128.png", Files.FileType.Internal);

		//position where the windows spawns
		config.x = 0;
		config.y = 0;

		new LwjglApplication(new Tutorial(), config);
	}
}

package com.michael.javafrank.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.michael.javafrank.Tutorial;

public class DesktopLauncher {

	public static final boolean CREATE_ATLAS = false;

	public static void main (String[] arg) {

		if(CREATE_ATLAS) {
			TexturePacker.Settings settings = new TexturePacker.Settings();
			settings.edgePadding = true;
			settings.paddingX = 2;
			settings.paddingY = 2;
			settings.maxHeight = 2048;
			settings.maxWidth = 2048;
			TexturePacker.process(settings, "core\\assets\\textures","core\\assets","atlas");

		} else {
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
}

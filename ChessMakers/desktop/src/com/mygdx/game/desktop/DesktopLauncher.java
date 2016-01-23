package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ChessGame;
import com.mygdx.game.ChessGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.setProperty("user.name","Ne_eQ");
		config.width = 480;
		config.height = 480;
		new LwjglApplication(new ChessGame(), config);

	}
}


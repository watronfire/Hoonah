package com.nate.hoonah.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nate.hoonah.Hoonah;


public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle( "Hoonah" );
		config.setWindowedMode( 800, 480 );
		new Lwjgl3Application( new Hoonah(), config );
	}
}

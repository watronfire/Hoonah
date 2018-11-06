package com.nate.hoonah.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nate.hoonah.Hoonah;

public class MenuScreen implements Screen {

    private final Hoonah game;

    private OrthographicCamera camera;

    public MenuScreen( final Hoonah game ) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho( true );
    }

    @Override
    public void show() {

    }

    @Override
    public void render( float delta ) {

    }

    @Override
    public void resize( int width, int height ) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

package com.nate.hoonah;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nate.hoonah.entities.MoveableBox;

public class GameScreen implements Screen {
    final Hoonah game;

    private OrthographicCamera camera;
    private MoveableBox rect;

    public GameScreen( final Hoonah game ) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho( false, 800, 480 );

        rect = new MoveableBox( 100, 100, 100, 100 );
    }

    @Override
    public void show() {

    }

    @Override
    public void render( float delta ) {
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        camera.update();



        if( Gdx.input.isButtonPressed( Input.Buttons.LEFT ) ) {
            // Mouse coordinates are y-down while screen coordinates are y-up. Why they wouldn't use the same coordinate
            // system is beyond me.
            if( rect.contains( Gdx.input.getX(), Gdx.graphics.getHeight() - 1 - Gdx.input.getY() ) && !rect.getHeldStatus() ) {
                rect.click( Gdx.input.getX(), Gdx.graphics.getHeight() - 1 - Gdx.input.getY() );
            }
        } else {
            rect.release();
        }


        if( rect.getHeldStatus() ) {
            rect.setPosition( Gdx.input.getX(), Gdx.graphics.getHeight() - 1 - Gdx.input.getY() );
        }

        game.shapeRenderer.setProjectionMatrix( camera.combined );
        game.shapeRenderer.begin( ShapeRenderer.ShapeType.Filled );
        game.shapeRenderer.setColor( Color.BLACK );
        game.shapeRenderer.rect( rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight() );
        game.shapeRenderer.end();



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

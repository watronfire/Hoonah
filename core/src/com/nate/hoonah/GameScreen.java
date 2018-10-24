package com.nate.hoonah;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nate.hoonah.entities.MovableBox;
import com.nate.hoonah.managers.MovableBoxManager;

public class GameScreen implements Screen {
    private final Hoonah game;

    private OrthographicCamera camera;
    private MovableBoxManager mbm;

    public GameScreen( final Hoonah game ) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho( true );

        mbm = new MovableBoxManager( 3, camera.viewportWidth, camera.viewportHeight );

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
            mbm.click( Gdx.input.getX(), Gdx.input.getY() );
        } else {
            mbm.release();
        }

        mbm.updatePosition( camera.viewportWidth, camera.viewportHeight );

        game.shapeRenderer.setProjectionMatrix( camera.combined );
        game.shapeRenderer.begin( ShapeRenderer.ShapeType.Filled );
        for( MovableBox mb : mbm.getAllManagedBoxes() ) {
            if( mb.getHeldStatus() ) {
                game.shapeRenderer.setColor( Color.GOLD );
            } else {
                game.shapeRenderer.setColor( Color.BLACK );
            }
            game.shapeRenderer.rect( mb.getX(), mb.getY(), mb.getWidth(), mb.getHeight() );
        }
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

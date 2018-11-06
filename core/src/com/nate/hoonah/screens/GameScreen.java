package com.nate.hoonah.screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nate.hoonah.Hoonah;
import com.nate.hoonah.entities.MovableBox;
import com.nate.hoonah.managers.MovableBoxManager;

public class GameScreen implements Screen {
    private final Hoonah game;

    private OrthographicCamera camera;
    private MovableBoxManager mbm;
    private BitmapFont font;
    private Texture fontTex;
    private TextureRegion rect;

    public GameScreen( final Hoonah game ) {
        this.game = game;


        Gdx.gl.glEnable( GL20.GL_BLEND );
        Gdx.gl.glBlendFunc( GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA );
        camera = new OrthographicCamera();
        camera.setToOrtho( true );

        mbm = new MovableBoxManager( 3, camera.viewportWidth, camera.viewportHeight );
        font = new BitmapFont();

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

        int heldStatus = mbm.checkHeldBox();

        game.shapeRenderer.setProjectionMatrix( camera.combined );
        game.shapeRenderer.begin( ShapeRenderer.ShapeType.Filled );
        for( MovableBox mb : mbm.getAllManagedBoxes() ) {
            if( !mb.getHeldStatus() ) {
                game.shapeRenderer.setColor( Color.BLACK );
                game.shapeRenderer.rect( mb.getX(), mb.getY(), mb.getWidth(), mb.getHeight() );
            }
        }
        if( heldStatus > -1 ) {
            MovableBox heldBox = mbm.getManagedBox( heldStatus );
            game.shapeRenderer.setColor( new Color( 1, 0.84f, 0, 0.95f ) );
            game.shapeRenderer.rect( heldBox.getX(), heldBox.getY(), heldBox.getWidth(), heldBox.getHeight() );
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

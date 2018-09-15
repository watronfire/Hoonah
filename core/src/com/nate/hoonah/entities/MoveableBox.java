package com.nate.hoonah.entities;

import com.badlogic.gdx.math.Rectangle;

public class MoveableBox {
    private Rectangle rect;
    private boolean isHeld;
    private float heldDX;
    private float heldDY;

    public MoveableBox( int x, int y, int height, int width ) {
        rect = new Rectangle();
        rect.x = x;
        rect.y = y;
        rect.height = height;
        rect.width = width;
        isHeld = false;
        heldDX = 0;
        heldDY = 0;
    }

    public boolean contains( float x, float y ) {
        return rect.contains( x, y );
    }
    public void setPosition( float x, float y ) {
        if( isHeld ) {
            rect.setPosition( x + heldDX, y + heldDY );
        } else {
            rect.setPosition( x, y );
        }

    }

    public boolean getHeldStatus() { return isHeld; }
    public void click( float x, float y ) {
        isHeld = true;
        heldDX = rect.x - x;
        heldDY = rect.y - y;
    }
    public void release() {
        isHeld = false;
    }

    public float getX() { return rect.x; }
    public float getY() { return rect.y; }
    public float getHeight() { return rect.height; }
    public float getWidth() { return rect.width; }



}

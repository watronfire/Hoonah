package com.nate.hoonah.entities;

import com.badlogic.gdx.math.Rectangle;

public class MoveableBox extends Rectangle {
    private boolean isHeld;
    private float heldDX;
    private float heldDY;


    public MoveableBox( float x, float y, float width, float height ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        isHeld = false;
        heldDX = 0;
        heldDY = 0;
    }


    @Override
    public Rectangle setPosition( float x, float y ) {
        if( isHeld ) {
            this.x = x + heldDX;
            this.y = y + heldDY;
        } else {
            this.x = x;
            this.y = y;
        }
        return this;
    }

    public boolean getHeldStatus() { return isHeld; }
    public void click( float x, float y ) {
        isHeld = true;
        heldDX = this.x - x;
        heldDY = this.y - y;
    }
    public void release() { isHeld = false; }




}

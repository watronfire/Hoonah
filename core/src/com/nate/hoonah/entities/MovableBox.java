package com.nate.hoonah.entities;

import com.badlogic.gdx.math.Rectangle;

public class MovableBox extends Rectangle {
    private boolean isHeld;
    private float heldDX;
    private float heldDY;
    private String contents;
    private boolean inPosition;


    public MovableBox( float x, float y, float width, float height ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        isHeld = false;
        heldDX = 0;
        heldDY = 0;
        inPosition = true;
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

    public void addString( String string ) {
        this.contents = string;
        // Would also like to modify string location here.
    }

    public String getContents() {
        return contents;
    }
    public boolean isInPosition() { return inPosition; }

    public void setInPosition() { inPosition = true; }

    public boolean getHeldStatus() { return isHeld; }
    public void click( float x, float y ) {
        isHeld = true;
        inPosition = false;
        heldDX = this.x - x;
        heldDY = this.y - y;
    }
    public void release() { isHeld = false; }




}

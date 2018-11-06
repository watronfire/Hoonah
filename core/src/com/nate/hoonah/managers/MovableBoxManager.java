package com.nate.hoonah.managers;

import com.badlogic.gdx.math.Interpolation;
import com.nate.hoonah.entities.MovableBox;

import java.util.ArrayList;

public class MovableBoxManager {

    private final int BOX_SPACE = 25;
    private final int BOX_SIZE = 100;

    private ArrayList<MovableBox> managedBoxes;

    public MovableBoxManager( int numberOfBoxes, float viewportWidth, float viewportHeight ) {

        managedBoxes = new ArrayList<MovableBox>();

        // All boxes will have the same X value which allows them to be centered on the screen.
        float mbX = getInitialXPosition( BOX_SIZE, viewportWidth );


        for( int i = 0; i < numberOfBoxes; i += 1 ) {
            float mbY = getInitialYPosition( i, numberOfBoxes, BOX_SIZE, BOX_SPACE, viewportHeight );
            MovableBox mb = new MovableBox( mbX, mbY, BOX_SIZE, BOX_SIZE );
            managedBoxes.add( mb );
        }
    }

    private float getInitialXPosition( int boxSize, float viewportWidth ) {
        return ( viewportWidth / 2 ) - ( boxSize / 2 );
    }

    private float getInitialYPosition( int index, int numOfBoxes, int boxSize, int boxSpace, float viewportHeight ) {
        return (float) ( ( viewportHeight / 2 ) - ( ( ( numOfBoxes * boxSize ) + ( ( numOfBoxes - 1.0 ) * boxSpace ) ) / 2 ) + ( index * ( boxSize + boxSpace ) ) );
    }

    private void addManagedBox( float x, float y, float width, float height ) {
        MovableBox mb = new MovableBox( x, y, width, height );
        managedBoxes.add( mb );
    }

    public ArrayList<MovableBox> getAllManagedBoxes() {
        return managedBoxes;
    }

    public MovableBox getManagedBox( int index ) {
        return managedBoxes.get( index );
    }

    public int checkHeldBox() {
        for( int i = 0; i < managedBoxes.size(); i += 1 ) {
            if( managedBoxes.get( i ).getHeldStatus() ) {
                return i;
            }
        }
        return -1;
    }

    public void click( float x, float y ) {
        int heldStatus = checkHeldBox();
        if( heldStatus > -1 ) {
            managedBoxes.get( heldStatus ).setPosition( x, y );
        } else {
            for( MovableBox mb : managedBoxes ) {
                if( mb.contains( x, y ) ) {
                    mb.click( x, y );
                    break;
                }
            }
        }
    }
    public void release() {
        for( MovableBox mb : managedBoxes ) {
            mb.release();
        }
    }

    public void updatePosition( float viewportWidth, float viewportHeight ) {
        int index = 0;
        for( MovableBox mb : managedBoxes ) {
            if( !mb.getHeldStatus() && !mb.isInPosition() ) {
                float gotoXPos = getInitialXPosition( BOX_SIZE, viewportWidth );
                float gotoYpos = getInitialYPosition( index, managedBoxes.size(), BOX_SIZE, BOX_SPACE, viewportHeight );
                if( Math.abs( gotoYpos - mb.getY() ) < 1 && Math.abs( gotoXPos -  mb.getX() ) < 1 ) {
                    mb.setPosition( gotoXPos, gotoYpos );
                    mb.setInPosition();
                } else {
                    float updatedXPos = Interpolation.linear.apply( mb.getX(), gotoXPos, 0.2f );
                    float updatedYPos = Interpolation.linear.apply( mb.getY(), gotoYpos, 0.2f );
                    mb.setPosition( updatedXPos, updatedYPos );
                    System.out.println( "Updated!" );
                }

            }
            index += 1;
        }
    }

}

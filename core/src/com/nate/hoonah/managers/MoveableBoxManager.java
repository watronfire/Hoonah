package com.nate.hoonah.managers;

import com.nate.hoonah.entities.MoveableBox;

import java.util.ArrayList;

public class MoveableBoxManager {
    private ArrayList<MoveableBox> managedBoxes;

    public MoveableBoxManager( int numberOfBoxes, float viewportWidth, float viewportHeight ) {
        managedBoxes = new ArrayList<MoveableBox>();

        // All boxes will have the same X value which allows them to be centered on the screen.
        float mbX = ( viewportWidth / 2 ) - ( 100 / 2 );


        for( int i = 0; i < numberOfBoxes; i += 1 ) {
            float mbY = ( viewportHeight / 2 ) - ( ( ( numberOfBoxes * 100 ) + ( ( numberOfBoxes - 1 ) * 50 ) ) / 2 ) + ( i * ( 100  + 50 ) );
            MoveableBox mb = new MoveableBox( mbX, mbY, 100, 100 );
            managedBoxes.add( mb );
        }
    }

    private void addManagedBox( float x, float y, float width, float height ) {
        MoveableBox mb = new MoveableBox( x, y, width, height );
        managedBoxes.add( mb );
    }

    public ArrayList<MoveableBox> getAllManagedBoxes() {
        return managedBoxes;
    }

}

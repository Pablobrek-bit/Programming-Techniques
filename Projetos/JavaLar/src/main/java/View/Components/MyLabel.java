package View.Components;

import model.Entities.Components.Coordinates;

import javax.swing.*;

public class MyLabel extends JLabel {

    private final Coordinates coordinates;

    public MyLabel(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }



}

package model.Entities.BugsDevs;

import model.Entities.Components.Coordinates;

import java.util.List;

public class Verifications {


    //Check the coordinates of the devs and bugs with those of the planets
    public static boolean checkCoordinates(List<Coordinates> list, int x, int y) {
        for (Coordinates coord : list) {
            if (coord.getX() == x && coord.getY() == y) {
                list.remove(coord);
                return true;
            }
        }
        return false;
    }
    
}

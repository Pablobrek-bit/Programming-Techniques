package Model.Entities.BugsDevs;

import Model.Entities.Components.Coordinates;

import java.util.List;

public class Verifications {
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

package Control.Calculations;

import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Planets;

import java.util.List;


//class that will do the calculations
public class Calculation {

    //constants
    private static final int LINE_MERIDIAN = 12;
    private static final int LINE_EQUATOR = 8;
    private static final int LINE_START_NORTH = 9;
    private static final int LINE_START_SOUTH = 7;
    private static final int LINE_CENTER = 12;

    public Integer quantityDays(int instant, double rotation) {
        return (int) (instant * rotation);
    }

    //Calculating the orbit of the planet
    public static int calculateOrbit(int x){
        return (x - 8) * 8;
    }

    //Calculate how many years have passed on each planet
    public static double calculateYear(int dislocation, int orbit){
        return (double) dislocation / orbit;
    }

    public static Integer[] northEntity(List<Coordinates> entity){

        Integer[] quadrantesUmDois = {0, 0};
        for (Coordinates coordinates : entity) {
            if((coordinates.getX() >=LINE_START_NORTH) && (coordinates.getY() != 12)){
                if(coordinates.getY() < 12){
                    quadrantesUmDois[1]++;
                }else {
                    quadrantesUmDois[0]++;
                }
            }
        }
        return quadrantesUmDois;
    }

    public static Integer[] southEntity(List<Coordinates> entity){

        Integer[] quadrantesTresQuatro = {0, 0};
        for (Coordinates coordinates : entity) {
            if((coordinates.getX() <= LINE_START_SOUTH) && (coordinates.getY() != 12)){
                if(coordinates.getY() > 12){
                    quadrantesTresQuatro[1]++;
                }else {
                    quadrantesTresQuatro[0]++;
                }
            }
        }
        return quadrantesTresQuatro;
    }








    //Calculate the average speed of translation
    public int mediaVelocity(Planets planets){

        return (planets.getDistanceTraveled() / planets.getInstants());
    }



}

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


    //Calculating translation speed
    public int translationSpeed(int instant, int dislocation) {
        return instant * dislocation;
    }

    //Calculating rotation speed
    public int rotationSpeed(int instant, int dislocation) {
        return instant *  dislocation;
    }

    public Integer quantityDays(int instant, double rotation) {
        return (int) (instant * rotation);
    }

    //calculating at Euclidean distance
    public double euclideanDistance(Planets planet1, Planets planet2){
        return Math.sqrt(Math.pow((planet2.getLocation().getCoord().getX() - planet1.getLocation().getCoord().getX()), 2) + Math.pow((planet2.getLocation().getCoord().getY() - planet1.getLocation().getCoord().getY()), 2));
    }

    //Calculate the area of the distance from one planet to another
    public int planetsArea(Planets planet1, Planets planet2){
        return (Math.abs(planet1.getLocation().getCoord().getX() - planet2.getLocation().getCoord().getX()) + 1) * (Math.abs(planet1.getLocation().getCoord().getY() - planet2.getLocation().getCoord().getY()) + 1);
    }

    //Calculating the orbit of the planet
    public static int calculateOrbit(int x){
        return (x - 8) * 8;
    }

    //Calculate how many years have passed on each planet
    public static double calculateYear(int dislocation, int orbit){
        return (double) dislocation / orbit;
    }

    //Calculating quantity of planets in each area
    public int north(List<Planets> planets){

        int north = 0;
        for (Planets planet : planets) {
            if((planet.getLocation().getCoord().getX() >=LINE_START_NORTH) && (planet.getLocation().getCoord().getY() != 12)) north++;
        }
        return north;
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

    public int south(List<Planets> planets){

        int south = 0;
        for (Planets planet : planets) {
            if((planet.getLocation().getCoord().getX() <= LINE_START_SOUTH) && (planet.getLocation().getCoord().getY() != 12)) south++;
        }
        return south;
    }


    public int equator(List<Planets> planets){

        int equator = 0;
        for (Planets planet : planets) {
            if(planet.getLocation().getCoord().getX() == LINE_EQUATOR) equator++;
        }
        return equator;
    }

    public int meridian(List<Planets> planets){

        int meridian = 0;
        for (Planets p: planets) {
            if(p.getLocation().getCoord().getY() == LINE_MERIDIAN) meridian++;
        }
        return meridian;
    }

    //Calculate the average speed of translation
    public int mediaVelocity(Planets planets){

        return (planets.getDistanceTraveled() / planets.getInstants());
    }

    //Calculate the area of the polygon formed by the JavaLar system
    public double coverageArea(List<Planets> planets){
        double sum = 0;
        double subtraction = 0;

        int n = planets.size();

        for (int i = 0; i < n; i++) {
            Planets current = planets.get(i);
            Planets next = planets.get((i + 1) % n);

            sum += (current.getLocation().getCoord().getX() * next.getLocation().getCoord().getY());
            subtraction += (current.getLocation().getCoord().getY() * next.getLocation().getCoord().getX());
        }

        return 0.5 * Math.abs(sum - subtraction);
    }

}

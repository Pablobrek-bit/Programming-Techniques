package Model.Entities.BugsDevs;

import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Planets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BugsDevs {
    private Random random = new Random();
    private static List<Coordinates> bugs = new ArrayList<>();
    private static  List<Coordinates> devs = new ArrayList<>();
    private static List<Coordinates> possibleCoordinates = new ArrayList<>();


    //Method that will generate the coordinates of the devs and bugs
    public void generateCoordinates(List<Coordinates> list, List<Planets> planets,int quantity){
        generatePossibleCoordinates();
        List<Coordinates> availableCoordinates = new ArrayList<>(possibleCoordinates);

        //remove the coordinates that the planets are in
        removePositionsPlanets(availableCoordinates, planets);
        removePositions(availableCoordinates, list);

        //Generate the coordinates of the devs and bugs
        for(int i = 0; i < quantity && !availableCoordinates.isEmpty(); i++){
            //Index that will be drawn to take the random position of a possible coordinate
            int index = random.nextInt(availableCoordinates.size());
            list.add(availableCoordinates.get(index));
            availableCoordinates.remove(index);
        }
    }

    //Remove available positions according to existing devs and bugs
    public static void removePositions(List<Coordinates> availableCoordinates, List<Coordinates> list){
        for(Coordinates coord : list){
            for(int i = 0; i < availableCoordinates.size(); i++){
                if(availableCoordinates.get(i).getX() == coord.getX() && availableCoordinates.get(i).getY() == coord.getY()){
                    availableCoordinates.remove(i);

                }
            }
        }
    }

    //Remove the available positions according to the positions the planets are in
    public static void removePositionsPlanets(List<Coordinates> availableCoordinates, List<Planets> planets){

        for(Planets planet : planets){
            for(int i = 0; i < availableCoordinates.size(); i++){
                if(availableCoordinates.get(i).getX() == planet.getLocation().getCoord().getX() && availableCoordinates.get(i).getY() == planet.getLocation().getCoord().getY()){
                    availableCoordinates.remove(i);
                }
            }
        }
    }
    //Generates all the possible coordinates that the elements can have within the system
    public static void generatePossibleCoordinates() {
        for (int i = 1; i <= 15; i++) {
            for (int j = 5; j <= 19; j++) {
                if (i != 8 || j != 12) {
                    possibleCoordinates.add(new Coordinates(i, j));
                }
            }
        }
    }

    //Get methods
    public static List<Coordinates> getBugs() {
        return bugs;
    }

    public static List<Coordinates> getDevs() {
        return devs;
    }

    
}

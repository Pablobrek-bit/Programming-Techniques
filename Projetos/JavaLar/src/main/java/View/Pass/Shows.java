package View.Pass;

import java.util.List;

import Model.Entities.BugsDevs.BugsDevs;
import Control.Calculations.Calculation;
import Model.Entities.Components.Planets;



//Class that will organize the information for printing
public class Shows {

    private static Calculation calc = new Calculation();

    public static void showAll(List<Planets> planets, int instant){
        showDaysYears(planets, instant);
        showDevs();
        showBugs();
        showLocation(planets);
        showArea(planets);
        showDistanceEuclidean(planets);
        showCoverageArea(planets);

    }



    //Method that will sample all the devs and their coordinates
    public static void showDevs(){
        System.out.println("===================Devs===================");
        for(int i = 0; i < BugsDevs.getDevs().size(); i++){
            int x = BugsDevs.getDevs().get(i).getX();
            int y = BugsDevs.getDevs().get(i).getY();
            System.out.println("Dev " + (i + 1) + ": X=" + x + ", Y=" + y);
        }
    }

    //Method that will sample all the bugs and their coordinates
    public static void showBugs(){
        System.out.println("===================Bugs===================");
        for(int i = 0; i < BugsDevs.getBugs().size(); i++){
            int x = BugsDevs.getBugs().get(i).getX();
            int y = BugsDevs.getBugs().get(i).getY();
            System.out.println("Bug " + (i + 1) + ": X=" + x + ", Y=" + y);
        }
    }

    //Method that will organize the areas from each planet to the other
    public static void showArea(List<Planets> planets){
        System.out.println("===================Planets Area===================");

        for(int i = 0; i < planets.size(); i++){
            System.out.println();
            System.out.println("==================== " + planets.get(i).getName() + " ===================");

            for(int j = 0; j < planets.size(); j++){
                if(i == j) continue;
                System.out.println("Area from planet " + planets.get(i).getName() + " to " + planets.get(j).getName() + ": " + calc.planetsArea(planets.get(i), planets.get(j)));
            }
        }
    }

    //Method that will organize the Euclidean distances of the planets
    public static void showDistanceEuclidean(List<Planets> planets){
        System.out.println("===================Euclidean Distance===================");

        for(int i = 0; i < planets.size();i++){
            System.out.println();
            System.out.println("==================== " + planets.get(i).getName() + " ===================");

            for(int j = 0; j < planets.size(); j++){
                if(i == j) continue;
                System.out.printf("Euclidean distance from planet %s to %s: %.2f%n", planets.get(i).getName(), planets.get(j).getName(), calc.euclideanDistance(planets.get(i), planets.get(j)));

                //System.out.println("Euclidean distance from planet " + planets.get(i).getName() + " to " + planets.get(j).getName() + ": " + calc.euclideanDistance(planets.get(i), planets.get(j)));
            }
        }
    }

    //Method that will organize the translation speeds of the planets
    public void showTranslationSpeed(List<Planets> planets, int instant){
        System.out.println("===================Translation Speed===================");
        for (Planets planet : planets) {
            System.out.println("Translation speed from planet " + planet.getName() + ": " + calc.translationSpeed(instant, planet.getDislocation()));
        }
    }

    //Method that will organize the days and years of each planet
    public static void showDaysYears(List<Planets> planets, int instant){
        System.out.println("===================Days and Years===================");
        for (Planets planet : planets) {
            System.out.printf("Days from planet %s: %.2f%n", planet.getName(), calc.quantityDays(instant, planet.getRotation()));
            System.out.printf("Years from planet %s: %.2f%n", planet.getName(), planet.getYears());
            System.out.println();
        }
    }

    //Method that will organize the summaries of each planet
    public void showSummaryPlanets(List<Planets> planets){
        System.out.println("===================Summary Planets===================");
        for (Planets planet : planets) {
            System.out.println();
            System.out.println("==================== " + planet.getName() + " ===================");
            System.out.println(planet.getHistory());
        }
    }

    //Method that will print the destroyed planets
    public void showDestroyedPlanets(List<Planets> planets){
        boolean anyPlanetDestroyed = false;
        System.out.println("===================Destroyed Planets===================");
        for (Planets planet : planets) {
            if (!planet.isAlive()) {
                System.out.println(planet.getName() + " was destroyed");
                anyPlanetDestroyed = true; // Define a variável como true se algum planeta for destruído
            }
        }

        if (!anyPlanetDestroyed) {
            System.out.println("No planet was destroyed");
        }
    }

    //Method that will print the collisions of planets with devs and bugs
    public void showBugsDevsHit(List<Planets> planets){
        System.out.println("===================Bugs and Devs Hit===================");
        for (Planets planet : planets) {
            System.out.println("==================== " + planet.getName() + " ===================");
            System.out.println("Bugs hit: " + planet.getHitBugs());
            System.out.println("Devs hit: " + planet.getHitDevs());
        }
    }

    //Method that will print all the information
    public void showSummary(List<Planets> planets, int instant, int instantAccumulator){
        System.out.println("===================Summary Planets===================");
        showBugsDevsHit(planets);
        velocityPlanets(planets, instantAccumulator);
        showDestroyedPlanets(planets);
        System.out.println("=================================================");
        System.out.println("Total Instant: " + instantAccumulator);
        showDaysYears(planets, instantAccumulator);
        showSummaryPlanets(planets);
    }

    //Method that will print the velocity of the planets
    public void velocityPlanets(List<Planets> planets, int instantAccumulator){
        System.out.println("===================Velocity Planets===================");

        for (Planets planet : planets) {
            System.out.println("==================== " + planet.getName() + " ===================");
            System.out.println("Average Translation Speed: " + calc.mediaVelocity(planet, instantAccumulator));
            System.out.println("Rotation Speed: " + calc.rotationSpeed(instantAccumulator, planet.getDislocation()));
        }
    }

    public static void showLocation(List<Planets> planetsList){
        System.out.println("===================Informs=======================");
        System.out.println("Total of Planets in the North: "+ calc.north(planetsList));
        System.out.println("Total of Planets in the South: "+ calc.south(planetsList));
        System.out.println("Total of Planets in the Equator: "+ calc.equator(planetsList));
        System.out.println("Total of Planets in the Meridian: "+ calc.meridian(planetsList));
    }

    public static void showCoverageArea(List<Planets> planets){
        System.out.println("===================Coverage Area===================");
        System.out.println("Area: " + calc.coverageArea(planets));
    }

}

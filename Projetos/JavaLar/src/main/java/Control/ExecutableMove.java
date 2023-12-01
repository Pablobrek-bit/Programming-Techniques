package Control;

import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Planets;
import Model.Entities.Planets.*;

import java.util.ArrayList;
import java.util.List;

public class ExecutableMove {

    public static final List<Planets> planetsList = instances();
    private final BugsDevs ident = new BugsDevs();

    private static List<Planets> instances(){
        List<Planets> planetsList = new ArrayList<>();

        planetsList.add(new Python());
        planetsList.add(new JS());
        planetsList.add(new RubyRails());
        planetsList.add(new Php());
        planetsList.add(new CSharp());
        planetsList.add(new CPlusPlus());
        planetsList.add(new C());

        return planetsList;
    }

    public void generateEntities(String[] line){

        ident.generateCoordinates(BugsDevs.getBugs(), planetsList, Integer.parseInt(line[8]));
        ident.generateCoordinates(BugsDevs.getDevs(), planetsList, Integer.parseInt(line[9]));

    }

    public void movePlanets(String[] line) {

        for(int i = 0; i < planetsList.size(); i++){
            planetsList.get(i).move(Integer.parseInt(line[i+1]));
        }
    }
}

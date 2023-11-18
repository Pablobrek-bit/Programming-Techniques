package View.Pass;

import Model.Entities.BugsDevs.BugsDevs;
import Model.Entities.Components.Planets;
import Model.Entities.Components.SystemJavaLar;
import Model.Entities.Planets.*;

import java.util.ArrayList;
import java.util.List;

public class Executable2 {
    private List<Planets> planetsList = instances();
    private Communication inter = new Communication();
    private Shows show = new Shows();
    private BugsDevs ident = new BugsDevs();

    public Executable2(){
        runSimulation();
    }
    
    private void runSimulation(){
        while(inter.menu()){
        generateBugsDevsCoordinates();
        System.out.println("===========================================");
        movePlanets();
        SystemJavaLar.showMatriz(planetsList);
        Shows.showAll(planetsList, inter.getInstants());

    }
        show.showSummary(planetsList, inter.getInstants(), inter.getInstantAccumulator());
    }

    private void generateBugsDevsCoordinates() {
        ident.generateCoordinates(BugsDevs.getBugs(), planetsList,inter.getBugs());
        ident.generateCoordinates(BugsDevs.getDevs(), planetsList,inter.getDevs());
    }

    public void movePlanets() {
        for (Planets planet : planetsList) {
            planet.move(inter.getInstants());
        }

    }

    private List<Planets> instances(){
        List<Planets> planetsList = new ArrayList<>();

        planetsList.add(new C());
        planetsList.add(new CPlusPlus());
        planetsList.add(new CSharp());
        planetsList.add(new JS());
        planetsList.add(new Php());
        planetsList.add(new Python());
        planetsList.add(new RubyRails());

        return planetsList;
    }
}


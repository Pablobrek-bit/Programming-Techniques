package View;

import Model.Entities.Components.Planets;
import Model.Entities.Planets.*;

import java.util.ArrayList;
import java.util.List;

public class ExecutableMove {

    public static final List<Planets> planetsList = instances();



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

    public void movePlanets(String[] line) {

        //i = 0, line = 1 = 2 python
        //i = 1, line = 2 = 8 js
        //i = 2, line = 3 = 11 ruby
        //i = 3, line = 4 = 7 php
        //i = 4, line = 5 = 5 c#
        //i = 5, line = 6 = 6 c++
        //i = 6, line = 7 = 2 c
        //i = 7, line = 8 = 6 bugs
        //i = 8, line = 9 = 4 devs
        for(int i = 0; i < planetsList.size(); i++){
            System.out.println("O planeta "+planetsList.get(i).getName()+" vai se mover "+line[i+1]+" instants");
            planetsList.get(i).move(Integer.parseInt(line[i+1]));
        }

//        for (Planets planet : planetsList) {
//            planet.move(1);
//        }

    }
}

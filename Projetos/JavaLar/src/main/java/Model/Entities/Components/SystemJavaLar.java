package Model.Entities.Components;

import Model.Entities.BugsDevs.BugsDevs;

import java.util.List;

public class SystemJavaLar {

    public static void showMatriz(List<Planets> planets) {
        String[][] matrizPlan = new String[15][15];
        fillMatriz(matrizPlan);
        matrizPlan[7][7] = "\u001B[31mJ\u001B[0m";

        fillPlanets(planets, matrizPlan);
        fillBugs(matrizPlan);
        fillDevs(matrizPlan);
        putMatriz(matrizPlan);
    }

    private static void fillMatriz(String[][] matrizPlan){
        for(int i = 0; i < matrizPlan.length; i++){
            for(int j = 0; j < matrizPlan[i].length; j++){
                matrizPlan[i][j] = "*";
            }
        }
    }

    private static void putMatriz(String[][] matrizPlan){
        for(int i = 14; i >= 0; i--){
            for(int j = 14;j >= 0; j--){
                System.out.print(" "+matrizPlan[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void fillPlanets(List<Planets> planets, String[][] matrizPlan){
        for (Planets planet : planets) {
            int x = planet.getLocation().getCoord().getY() - 5;
            int y = planet.getLocation().getCoord().getX() - 1;

            matrizPlan[y][Math.abs(14 - x)] = "\u001B[33mX\u001B[0m";
        }
    }

    private static void fillBugs(String[][] matrizPlan){
        for(int i = 0; i < BugsDevs.getBugs().size(); i++){

            int x = BugsDevs.getBugs().get(i).getX() - 1;
            int y = BugsDevs.getBugs().get(i).getY() - 5;

            matrizPlan[x][Math.abs(14 - y)] = "\u001B[32mB\u001B[0m";
        }
    }

    private static void fillDevs(String[][] matrizPlan){
        for(int i = 0; i < BugsDevs.getDevs().size(); i++){

            int x = BugsDevs.getDevs().get(i).getX() - 1;
            int y = BugsDevs.getDevs().get(i).getY() - 5;

            matrizPlan[x][Math.abs(14 - y)] = "\u001B[34mD\u001B[0m";
        }
    }




}


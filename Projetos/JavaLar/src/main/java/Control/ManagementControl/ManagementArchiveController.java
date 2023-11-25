package Control.ManagementControl;

import View.Containers.Interaction.Buttons;
import View.Containers.Universe.MainFrame;
import View.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementArchiveController{

    private ManagementArchiveModel managementArchiveModel = null;
    private static final ExecutableMove executableMove = new ExecutableMove();
    public static String archiveSelected;
    public List<String[]> javaLar;
    private int allLine;



    public void run(){
        if(!(archiveSelected == null)){
            handleProcessInstant();
        } else {
            showErrorDialog("Select a file");
        }
    }


    public void readArchive(){

        managementArchiveModel = new ManagementArchiveModel(archiveSelected);
        managementArchiveModel.readArchive();
        allLine = managementArchiveModel.extractNumberFromArchiveSelected();

    }

    public String[] getLine(int line){
        return managementArchiveModel.getArchive(line);
    }

    public void handleProcessInstant() {
        Buttons.line++;
        int line = Buttons.line;

        if(line <= allLine) {

            executableMove.generateEntities(getLine(line));
            executableMove.movePlanets(getLine(line));
            MainFrame.universe.updates(ExecutableMove.planetsList);


        } else {
            showErrorDialog("End of file");
        }

    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String mostCommomName(){
        int size = javaLar.size();
        String[] names = new String[size];
        int[] counts = new int[size];

        for(int i = 0; i < size;i++){
            names[i] = javaLar.get(i)[0];
            counts[i] = 0;
        }
        countFrequency(names, counts);
        int maxCountIndex = commomName(counts);

        return names[maxCountIndex];
    }

    private int commomName(int[] counts) {
        int maxCountIndex = 0;
        for (int i = 1; i < javaLar.size(); i++) {
            if (counts[i] > counts[maxCountIndex]) {
                maxCountIndex = i;
            }
        }
        return maxCountIndex;
    }

    private void countFrequency(String[] names, int[] counts) {
        for (int i = 0; i < javaLar.size(); i++) {
            for (int j = i; j < javaLar.size(); j++) {
                if (names[i].equals(names[j])) {
                    counts[i]++;
                    counts[j]++;
                }
            }
        }
    }

    //Metodo para achar a matricula usando o nome mais utilizado
    private String foundMatricula(String commomName){
        for (String[] strings : javaLar) {
            if (strings[0].equals(commomName)) {
                return strings[1];
            }
        }
        return null;
    }

    public void quadrantMostBugs() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return;
        }

        String[] bugQuadrants = {"39", "40", "41", "42"};
        String[] devQuadrants = {"43", "44", "45", "46"};
        int[] bugs = new int[bugQuadrants.length];
        int[] devs = new int[devQuadrants.length];

        for (String[] record : javaLar) {
            for (int i = 0; i < bugQuadrants.length; i++) {
                if (bugQuadrants[i].equals(record[38])) {
                    bugs[i]++;
                    break;
                }
            }

            int devIndex = Integer.parseInt(record[42]) - 43;
            if (devIndex >= 0 && devIndex < devs.length) {
                devs[devIndex]++;
            }
        }

        int maxBugsIndex = commomBugs(bugs);
        int maxDevsIndex = commomDevs(devs);

        showErrorDialog("Quadrante com mais bugs: " + bugQuadrants[maxBugsIndex]);
        showErrorDialog("Quadrante de dev com mais ocorrências: " + devQuadrants[maxDevsIndex]);
    }

    private int commomDevs(int[] devs) {
        int maxDevsIndex = 0;
        for (int i = 1; i < devs.length; i++) {
            if (devs[i] > devs[maxDevsIndex]) {
                maxDevsIndex = i;
            }
        }
        return maxDevsIndex;
    }

    private int commomBugs(int[] bugs) {
        int maxBugsIndex = 0;
        for (int i = 1; i < bugs.length; i++) {
            if (bugs[i] > bugs[maxBugsIndex]) {
                maxBugsIndex = i;
            }
        }
        return maxBugsIndex;
    }

    public void yearsTotal() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;
            for (int i = 32; i < 38; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }

        System.out.println("Soma total dos anos: " + totalSum);
    }

    //Agora fazer o metodo que pega todas as horas passadas no total
    //O index das horas começa do 24 até o 30
    public void hoursTotal() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;
            for (int i = 25; i < 32; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }

        System.out.println("Soma total das horas: " + totalSum);
    }

    //agora criar um metodo que vai pegar todos os bugs ocorridos no sistema
    //para isso é apenas somar os quadrantes de cada linha e depois somar todos os quadrantes
    //os quadrantes dos bugs tem os index de 39 até 42

    public void sumBugQuadrants() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;

            for (int i = 39; i <= 42; i++) {
                recordSum += Integer.parseInt(record[i]);
            }


            totalSum += recordSum;
        }

        System.out.println("Soma total dos quadrantes dos bugs em todo o banco de dados: " + totalSum);
    }

    public void sumDevQuadrants() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;

            for (int i = 43; i <= 46; i++) {
                recordSum += Integer.parseInt(record[i]);
            }


            totalSum += recordSum;
        }

        System.out.println("Soma total dos quadrantes dos devs em todo o banco de dados: " + totalSum);
    }

    public void totalInstants(){

        System.out.println("Total de instants: " + javaLar.size());

    }

    //Agora fazer um metodo para poder achar a velocidade media de cada planeta
    //Para isso é preciso pegar
    public List<Double> averageSpeedPerPlanet() {
        List<Double> averageSpeeds = new ArrayList<>();

        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return averageSpeeds;
        }

        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};

        for (int velocityIndex : velocityIndexes) {
            int planetVelocitySum = 0;

            for (String[] record : javaLar) {
                planetVelocitySum += Integer.parseInt(record[velocityIndex]);
            }

            double averageSpeed = (double) planetVelocitySum / javaLar.size();

            averageSpeeds.add(averageSpeed);
        }

        return averageSpeeds;
    }

    public String planetWithMostDeaths() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return "Nenhum planeta encontrado";
        }

        // Índices das velocidades dos planetas
        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};

        // Mapa para armazenar as contagens de velocidades igual a 0 para cada planeta
        Map<String, Integer> deathsCountMap = new HashMap<>();

        for (int planetIndex = 0; planetIndex < velocityIndexes.length; planetIndex++) {
            String planetName = "Planeta " + (planetIndex + 1); // Personalize conforme necessário

            int deathsCount = 0;

            for (String[] record : javaLar) {
                // Verifica se a velocidade do planeta no registro atual é igual a 0
                if (Integer.parseInt(record[velocityIndexes[planetIndex]]) == 0) {
                    deathsCount++;
                }
            }

            // Armazena a contagem no mapa
            deathsCountMap.put(planetName, deathsCount);
        }

        // Encontra o planeta com mais ocorrências de velocidade igual a 0
        String planetWithMostDeaths = findMaxDeathsPlanet(deathsCountMap);

        return "Planeta com mais mortes: " + planetWithMostDeaths;
    }

    private String findMaxDeathsPlanet(Map<String, Integer> deathsCountMap) {
        String planetWithMostDeaths = "Nenhum planeta encontrado";
        int maxDeaths = 0;

        for (Map.Entry<String, Integer> entry : deathsCountMap.entrySet()) {
            if (entry.getValue() > maxDeaths) {
                maxDeaths = entry.getValue();
                planetWithMostDeaths = entry.getKey();
            }
        }

        return planetWithMostDeaths;
    }

    public String planetWithHighestAverageSpeed() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return "Nenhum planeta encontrado";
        }

        // Índices das velocidades dos planetas
        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};

        // Mapa para armazenar as somas de velocidades para cada planeta
        Map<String, Integer> totalSpeedMap = new HashMap<>();

        // Mapa para armazenar o número de ocorrências para cada planeta
        Map<String, Integer> occurrencesMap = new HashMap<>();

        for (int planetIndex = 0; planetIndex < velocityIndexes.length; planetIndex++) {
            String planetName = "Planeta " + (planetIndex + 1); // Personalize conforme necessário

            int totalSpeed = 0;
            int occurrences = 0;

            for (String[] record : javaLar) {
                // Obtém a velocidade do planeta no registro atual
                int speed = Integer.parseInt(record[velocityIndexes[planetIndex]]);

                // Verifica se a velocidade é maior que zero
                if (speed > 0) {
                    totalSpeed += speed;
                    occurrences++;
                }
            }

            // Armazena a soma e o número de ocorrências no mapa
            totalSpeedMap.put(planetName, totalSpeed);
            occurrencesMap.put(planetName, occurrences);
        }

        // Encontra o planeta com a maior velocidade média
        String planetWithHighestAverageSpeed = findPlanetWithHighestAverageSpeed(totalSpeedMap, occurrencesMap);

        return "Planeta com maior velocidade média: " + planetWithHighestAverageSpeed;
    }

    private String findPlanetWithHighestAverageSpeed(Map<String, Integer> totalSpeedMap, Map<String, Integer> occurrencesMap) {
        String planetWithHighestAverageSpeed = "Nenhum planeta encontrado";
        double maxAverageSpeed = 0;

        for (Map.Entry<String, Integer> entry : totalSpeedMap.entrySet()) {
            String planetName = entry.getKey();
            int totalSpeed = entry.getValue();
            int occurrences = occurrencesMap.get(planetName);

            // Calcula a velocidade média
            double averageSpeed = (double) totalSpeed / occurrences;

            // Verifica se a velocidade média é maior que a atual máxima
            if (averageSpeed > maxAverageSpeed) {
                maxAverageSpeed = averageSpeed;
                planetWithHighestAverageSpeed = planetName;
            }
        }

        return planetWithHighestAverageSpeed;
    }

}




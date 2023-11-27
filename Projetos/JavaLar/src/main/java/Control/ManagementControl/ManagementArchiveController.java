package Control.ManagementControl;

import View.Containers.Interaction.Buttons;
import View.Containers.Universe.MainFrame;
import View.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;
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
    private String reportDate;



    public void run() {
        if (archiveSelected != null) {
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
            String[] lineArchive = getLine(line);
            executableMove.generateEntities(lineArchive);
            executableMove.movePlanets(lineArchive);
            MainFrame.universe.updates(ExecutableMove.planetsList);
        } else {
            showErrorDialog("End of file");
        }

    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private String mostCommomName(){
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

    private String foundMatricula(String commomName){
        for (String[] strings : javaLar) {
            if (strings[0].equals(commomName)) {
                return strings[1];
            }
        }
        return null;
    }

    private String[] quadrantMostBugsDevs() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return null;
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

        String[] quadrants = new String[2];
        quadrants[0] = bugQuadrants[maxBugsIndex];
        quadrants[1] = devQuadrants[maxDevsIndex];
        return quadrants;

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

    private String hoursTotal() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return null;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;
            for (int i = 25; i < 32; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }
        return String.valueOf(totalSum);

    }

    private String sumBugQuadrants() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return null;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;

            for (int i = 39; i <= 42; i++) {
                recordSum += Integer.parseInt(record[i]);
            }


            totalSum += recordSum;
        }
        return String.valueOf(totalSum);
    }

    private String sumDevQuadrants() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return null;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;

            if (record.length >= 47) {
                for (int i = 43; i <= 46; i++) {
                    if (record[i] != null && record[i].length() > 0) {
                        try {
                            recordSum += Integer.parseInt(record[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter para inteiro: " + record[i]);
                        }
                    }
                }
            }
            totalSum += recordSum;
        }

        return String.valueOf(totalSum);
    }

    private String totalYears(){
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return null;
        }

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;
            for (int i = 32; i < 38; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }
        return String.valueOf(totalSum);
    }

    private String[] averageSpeedPerPlanet() {
        List<String> averageSpeeds = new ArrayList<>();

        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return averageSpeeds.toArray(new String[0]);
        }

        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};

        for (int velocityIndex : velocityIndexes) {
            int planetVelocitySum = 0;

            for (String[] record : javaLar) {
                planetVelocitySum += Integer.parseInt(record[velocityIndex]);
            }

            double averageSpeed = (double) planetVelocitySum / javaLar.size();

            averageSpeeds.add(String.valueOf(averageSpeed));
        }

        return averageSpeeds.toArray(new String[0]);
    }


    private String planetWithMostDeaths() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Lista vazia ou nula");
            return "Nenhum planeta encontrado";
        }

        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};
        String[] planetNames = {"Python", "JS", "Ruby on Rails", "PHP", "C#", "C++", "C"};

        Map<String, Integer> deathsCountMap = new HashMap<>();

        for (int planetIndex = 0; planetIndex < velocityIndexes.length; planetIndex++) {
            String planetName = String.valueOf((planetIndex + 1));

            int deathsCount = 0;

            for (String[] record : javaLar) {
                if (Integer.parseInt(record[velocityIndexes[planetIndex]]) == 0) {
                    deathsCount++;
                }
            }

            deathsCountMap.put(planetName, deathsCount);
        }

        String planetWithMostDeaths = findMaxDeathsPlanet(deathsCountMap);
        return planetNames[Integer.parseInt(planetWithMostDeaths)];

    }

    private String findMaxDeathsPlanet(Map<String, Integer> deathsCountMap) {
        String planetWithMostDeaths = "No planet found";
        int maxDeaths = 0;

        for (Map.Entry<String, Integer> entry : deathsCountMap.entrySet()) {
            if (entry.getValue() > maxDeaths) {
                maxDeaths = entry.getValue();
                planetWithMostDeaths = entry.getKey();
            }
        }

        return planetWithMostDeaths;
    }

    private String planetWithHighestAverageSpeed() {
        if (javaLar == null || javaLar.isEmpty()) {
            System.out.println("Empty or null list");
            return "No planet found";
        }

        int[] velocityIndexes = {18, 19, 20, 21, 22, 23, 24};
        String[] planetsNames = {"Python", "JS", "Ruby on Rails", "PHP", "C#", "C++", "C"};

        Map<String, Integer> totalSpeedMap = new HashMap<>();

        Map<String, Integer> occurrencesMap = new HashMap<>();

        for (int planetIndex = 0; planetIndex < velocityIndexes.length; planetIndex++) {
            String planetName = String.valueOf(planetIndex + 1);

            int totalSpeed = 0;
            int occurrences = 0;

            for (String[] record : javaLar) {
                int speed = Integer.parseInt(record[velocityIndexes[planetIndex]]);

                if (speed > 0) {
                    totalSpeed += speed;
                    occurrences++;
                }
            }

            totalSpeedMap.put(planetName, totalSpeed);
            occurrencesMap.put(planetName, occurrences);
        }

        String planetWithHighestAverageSpeed = findPlanetWithHighestAverageSpeed(totalSpeedMap, occurrencesMap);
        return planetsNames[Integer.parseInt(planetWithHighestAverageSpeed) - 1];
    }

    private String findPlanetWithHighestAverageSpeed(Map<String, Integer> totalSpeedMap, Map<String, Integer> occurrencesMap) {
        String planetWithHighestAverageSpeed = "No planet found";
        double maxAverageSpeed = 0;

        for (Map.Entry<String, Integer> entry : totalSpeedMap.entrySet()) {
            String planetName = entry.getKey();
            int totalSpeed = entry.getValue();
            int occurrences = occurrencesMap.get(planetName);

            double averageSpeed = (double) totalSpeed / occurrences;

            if (averageSpeed > maxAverageSpeed) {
                maxAverageSpeed = averageSpeed;
                planetWithHighestAverageSpeed = planetName;
            }
        }

        return planetWithHighestAverageSpeed;
    }

    public String buildReport(){
        String commumName = mostCommomName();
        String matricula = foundMatricula(commumName);
        String planetWithMostDeaths = planetWithMostDeaths();
        String planetWithHighestAverageSpeed = planetWithHighestAverageSpeed();
        String[] quadrant = quadrantMostBugsDevs();
        String quadrantMostBugs = quadrant[0];
        String quadrantMostDevs = quadrant[1];
        String totalInstants = String.valueOf(javaLar.size());
        String[] averageSpeedPerPlanet = averageSpeedPerPlanet();
        String bugs = String.valueOf(sumBugQuadrants());
        String devs = String.valueOf(sumDevQuadrants());
        String hours = String.valueOf(hoursTotal());
        String years = totalYears();

        reportDate = matricula + " - " + commumName + ", " + planetWithMostDeaths + ", " + planetWithHighestAverageSpeed + ", " +
                quadrantMostBugs + ", " + quadrantMostDevs + ", " + totalInstants + ", Python: " + averageSpeedPerPlanet[0] + " - JavaScript:" +
                averageSpeedPerPlanet[1] + " - Ruby on Rails: " + averageSpeedPerPlanet[2] + " \n- PH: "+ averageSpeedPerPlanet[3] +
                " - C#: " + averageSpeedPerPlanet[4] + " - C++: " + averageSpeedPerPlanet[5] + " - C: " + averageSpeedPerPlanet[6] +
                ", " + bugs + ", " + devs + ", " + hours + ", " + years;

        return reportDate;
    }

}




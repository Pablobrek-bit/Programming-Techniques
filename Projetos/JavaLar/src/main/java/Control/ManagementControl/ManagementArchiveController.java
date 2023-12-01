package Control.ManagementControl;

import Model.Archives.manageFiles.ReportArchive;
import View.Containers.Interaction.Buttons;
import View.Containers.Universe.MainFrame;
import Control.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ManagementArchiveController{

    private ManagementArchiveModel managementArchiveModel = null;
    private static final ExecutableMove executableMove = new ExecutableMove();
    public static String archiveSelected;
    public List<String[]> javaLar;
    private int allLine;
    private String reportDate;



    public void run() {
    	
            handleProcessInstant();
            
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

        String[] bugQuadrants = {"39", "40", "41", "42"};
        String[] devQuadrants = {"43", "44", "45", "46"};
        int[] bugs = new int[bugQuadrants.length];
        int[] devs = new int[devQuadrants.length];

        for (String[] record : javaLar) {
            for (int i = 0; i < bugQuadrants.length; i++) {
                if (bugQuadrants[i].equals(record[36])) {
                    bugs[i]++;
                    break;
                }
            }

            int devIndex = Integer.parseInt(record[40]) - 41;
            if (devIndex >= 0 && devIndex < devs.length) {
                devs[devIndex]++;
            }
        }

        int maxBugsIndex = commomBugs(bugs);
        int maxDevsIndex = commomDevs(devs);

        String[] quadrants = new String[2];
        int bugQuadrant = Integer.parseInt(bugQuadrants[maxBugsIndex]) - 38;
        int devQuadrant = Integer.parseInt(devQuadrants[maxDevsIndex]) - 42;
        quadrants[0] = String.valueOf(bugQuadrant);
        quadrants[1] = String.valueOf(devQuadrant);
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
            for (int i = 23; i <= 29; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }
        return String.valueOf(totalSum);

    }

    private String sumBugQuadrants() {

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;

            for (int i = 37; i <= 40; i++) {
                recordSum += Integer.parseInt(record[i]);
            }


            totalSum += recordSum;
        }
        return String.valueOf(totalSum);
    }

    private String sumDevQuadrants() {
        int totalSum = 0;

        for (String[] record : javaLar) {

            int recordSum = 0;

            for (int i = 41; i < 45; i++) {
                recordSum += Integer.parseInt(record[i]);
            }

            totalSum += recordSum;
        }

        return String.valueOf(totalSum);
    }

    private String totalYears(){

        int totalSum = 0;

        for (String[] record : javaLar) {
            int recordSum = 0;
            for (int i = 30; i <= 36; i++) {
                recordSum += Integer.parseInt(record[i]);
            }
            totalSum += recordSum;
        }
        return String.valueOf(totalSum);
    }

    private String[] averageSpeedPerPlanet() {
        List<String> averageSpeeds = new ArrayList<>();

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
        int[] velocityIndexes = {16,17,18,19,20,21,22};
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


        int[] velocityIndexes = {16,17,18,19,20,21,22};

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

    private Map<String, Integer> countNameOccurrences(List<String[]> nameList) {
        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String[] record : nameList) {
            String name = record[0];

            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        return nameCountMap;
    }

    public List<String> rankNamesByOccurrences() {
        Map<String, Integer> nameCountMap = countNameOccurrences(javaLar);

        List<String> rankedNames = nameCountMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return rankedNames;
    }

    public boolean buildReport(){
        ReportArchive reportArchive = new ReportArchive();

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

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        reportDate = matricula + " - " + commumName + ", " + planetWithMostDeaths() + ", " +
                planetWithHighestAverageSpeed() + ", " + quadrantMostBugs + ", " +
                quadrantMostDevs + ", " + totalInstants + ", Python: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[0])) + " - JavaScript: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[1])) + " - Ruby on Rails: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[2])) + " \n- PH: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[3])) + " - C#: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[4])) + " - C++: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[5])) + " - C: " +
                decimalFormat.format(Double.parseDouble(averageSpeedPerPlanet[6])) + ", " +
                bugs + ", " + devs + ", " + hours + ", " + years;
        System.out.println(reportDate);
        return reportArchive.saveReport(reportDate);
    }

}




package Control.ManagementControl;

import View.Containers.Interaction.Buttons;
import View.Containers.Universe.MainFrame;
import View.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class ManagementArchiveController {

    private ManagementArchiveModel managementArchiveModel = null;
    private static final ExecutableMove executableMove = new ExecutableMove();
    public static String archiveSelected;
    public List<String[]> javaLar;

    public ManagementArchiveController(){
        if(!(archiveSelected == null)){
            managementArchiveModel = new ManagementArchiveModel(archiveSelected);
            handleProcessInstant();
        } else {
            showErrorDialog("Select a file");
        }
    }

    public String[] getLine(int line){
        return managementArchiveModel.getArchive(line);
    }

    private int extractNumberFromArchiveSelected() {
        try {
            String fileName = new File(archiveSelected).getName();

            String nameWithoutExtension = fileName.replace(".csv", "");

            String[] parts = nameWithoutExtension.split("_");
            return Integer.parseInt(parts[1]);
        } catch (Exception e) {
            return -1;
        }
    }

    public void handleProcessInstant() {
        Buttons.line++;
        int line = Buttons.line;
        int totalLines = extractNumberFromArchiveSelected();

        if(line <= totalLines) {

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

}

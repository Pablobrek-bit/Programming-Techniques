package Control.ManagementControl;

import View.Containers.Interaction.Buttons.Buttons;
import View.Containers.Universe.MainFrame;
import View.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;
import java.io.File;

public class ManagementArchiveController {

    private ManagementArchiveModel managementArchiveModel = null;
    private static final ExecutableMove executableMove = new ExecutableMove();
    public static String archiveSelected;

    public ManagementArchiveController(){
        if(!(archiveSelected == null)){
            managementArchiveModel = new ManagementArchiveModel(archiveSelected);
            handleProcessInstant();
        } else {
            JOptionPane.showMessageDialog(null,"Select one option", "Error", JOptionPane.ERROR_MESSAGE);
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

        if(!(line > totalLines)) {

            executableMove.generateEntities(getLine(line));
            executableMove.movePlanets(getLine(line));

            MainFrame.universe.updateBugs();
            MainFrame.universe.updateDevs();
            MainFrame.universe.updatePlanets(ExecutableMove.planetsList);

        } else {
            JOptionPane.showMessageDialog(null,"End of file");
        }



    }

}

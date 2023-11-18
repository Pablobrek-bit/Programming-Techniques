package Control.ManagementControl;

import View.Containers.Interaction.Buttons.Buttons;
import View.Containers.Universe.Universe;
import View.ExecutableMove;
import Model.Archives.manageFiles.ManagementArchiveModel;

import javax.swing.*;


public class ManagementArchiveController {

    private ManagementArchiveModel managementArchiveModel = null;
    private final Universe universe = new Universe(ExecutableMove.planetsList);
    private static final ExecutableMove executableMove = new ExecutableMove();
    public static String archiveSelected;

    public ManagementArchiveController(){
        if(!(archiveSelected == null)){
            managementArchiveModel = new ManagementArchiveModel(ManagementArchiveController.archiveSelected);
            handleProcessInstant();
        }
    }

    public String[] getLine(int line){
        return managementArchiveModel.getArchive(line);
    }

    //Esse metodo vai ser chamado no primeiro botão
    public void handleProcessInstant() {
        Buttons.line++;
        int line = Buttons.line;

        if(!(line > Integer.parseInt(archiveSelected))){

            System.out.println("Linha: " + line);
            executableMove.movePlanets(getLine(line));

        } else {
            JOptionPane.showMessageDialog(null,"End of file");
            return;
        }

        universe.updatePlanets(ExecutableMove.planetsList);
        universe.revalidate();
        universe.repaint();
    }

}

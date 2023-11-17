package Control.ManagementControl;

import View.Containers.Interaction.Buttons.Buttons;
import View.Containers.Universe.Universe;
import View.ExecutableMove;
import model.Archives.manageFiles.ManagementArchiveModel;


public class ManagementArchiveController {

    private final ManagementArchiveModel managementArchiveModel;
    private final Universe universe = new Universe(ExecutableMove.planetsList);
    private static final ExecutableMove executableMove = new ExecutableMove();
    private String archiveSelected = "10";

    public ManagementArchiveController(String archiveSelected){
        if(!(archiveSelected == null)){
            this.archiveSelected = archiveSelected;
        }

        managementArchiveModel = new ManagementArchiveModel(this.archiveSelected);
    }

    public String[] getLine(int line){
        return managementArchiveModel.getArchive(line);
    }

    //Esse metodo vai ser chamado no primeiro botão
    public void handleProcessInstant() {
        if (archiveSelected == null) {
            return;
        }
        Buttons.line++;
        int line = Buttons.line;
        executableMove.movePlanets(getLine(line));
        universe.updatePlanets(ExecutableMove.planetsList);
        universe.revalidate();
        universe.repaint();
    }

    public String getArchiveSelected() {
        return archiveSelected;
    }
}

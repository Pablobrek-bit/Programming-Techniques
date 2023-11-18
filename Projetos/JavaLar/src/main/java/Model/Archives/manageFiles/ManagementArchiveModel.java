package Model.Archives.manageFiles;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagementArchiveModel {
    private final String path;
    private String archiveSelected;
    private String[] archive;


    public ManagementArchiveModel(String archiveSelected){

        this.archiveSelected = archiveSelected;
        path = "src/main/java/model/Archives/AE_"+this.archiveSelected+".csv";
        validateFileExistence();
        readArchive();

    }

    private void validateFileExistence() {
        if (!new File(path).exists()) {
            JOptionPane.showMessageDialog(null, "Choose a file ", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("File not found");
        }
    }

    private void readArchive() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            saveArchive(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveArchive(BufferedReader br) throws IOException {

        List<String> list = new ArrayList<>();

        while(br.ready()) {
            String line = br.readLine();
            list.add(line);
        }

        archive = list.toArray(new String[0]);

    }

    public String[] getArchive(int line){
        return archive[line].split(",");
    }
}




package Model.Archives.manageFiles;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagementArchiveModel {
    private static String path;
    private String archiveSelected;
    private static String[] archive;

    public ManagementArchiveModel(String archiveSelected) {
        this.archiveSelected = archiveSelected;
        path = archiveSelected;
        validateFileExistence();
        readArchive();
    }

    private void validateFileExistence() {
        File file = new File(path);
        if (!file.exists()) {
            showErrorDialog("Archive not found");
            throw new RuntimeException("Archive not found");
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void readArchive() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            saveArchive(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveArchive(BufferedReader br) throws IOException {
        List<String> list = new ArrayList<>();
        while (br.ready()) {
            String line = br.readLine();
            list.add(line);
        }
        archive = list.toArray(new String[0]);
    }

    public int extractNumberFromArchiveSelected() {
        try {
            String fileName = new File(archiveSelected).getName();
            String nameWithoutExtension = fileName.replace(".csv", "");
            String[] parts = nameWithoutExtension.split("_");
            return Integer.parseInt(parts[1]);
        } catch (Exception e) {
            return -1;
        }
    }

    public String[] getArchive(int line) {
        return archive[line].split(",");
    }
}

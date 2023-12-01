package Model.Archives.manageFiles;

import java.io.*;

public class ReportArchive {

    private static final String PATH = "src/main/java/Model/Archives/manageFiles/ReportArchive.txt";

    public boolean saveReport(String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, false))) {
            bufferedWriter.write(data);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Error while saving the report.", e);
        }
    }
}

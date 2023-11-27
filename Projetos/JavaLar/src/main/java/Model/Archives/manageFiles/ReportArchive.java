package Model.Archives.manageFiles;

import java.io.*;

public class ReportArchive {

    private static final String PATH = "src/main/java/Model/Archives/manageFiles/ReportArchive.txt";

    public boolean saveReport(String dates){
        File file = new File(PATH);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(dates);
            bufferedWriter.close();
            fileWriter.close();

            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

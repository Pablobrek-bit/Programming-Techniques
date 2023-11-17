package model.Archives.manageFiles;

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

        if (!new File(path).exists()) {

            throw new IllegalArgumentException("Arquivo não encontrado: " + path);
        }

        try {
            readArchive();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setArchiveSelected(String archiveSelected) {
        this.archiveSelected = archiveSelected;
    }


    private void readArchive() throws IOException {
        File file = new File(path);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        saveArchive(br);

    }

    private void saveArchive(BufferedReader br) throws IOException {

        List<String> list = new ArrayList<>();

        while(br.ready()) {
            String line = br.readLine();
            list.add(line);
        }
        br.close();


        archive = list.toArray(new String[0]);

    }

    public String[] getArchive(int line){
        return archive[line].split(",");
    }
}




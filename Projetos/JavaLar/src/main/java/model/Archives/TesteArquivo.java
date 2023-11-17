package model.Archives;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteArquivo {

    public static void main(String[] args){
        File arquivo = new File("src/main/java/model/Archives/AE_10.csv");
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()){
                String linha = br.readLine();
                list.add(linha);
            }

            String[] vetorDeString = list.toArray(new String[0]);


            System.out.println(vetorDeString[1]);
            String[] vetor = vetorDeString[1].split(",");
            System.out.println("Id: "+vetor[0]);

            for (String s : vetor) {
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

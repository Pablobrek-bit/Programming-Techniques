package Questoes;

import java.util.Scanner;

public class Quest20 {
    public static void main(String[] args) {
        Scanner cop = new Scanner(System.in);

        System.out.print("Digite o primeiro numero:");
        int A = cop.nextInt();
        System.out.print("Digite o segundo numero:");
        int B = cop.nextInt();

        if ((A > 10) || ((A + B) == 20)) {
            System.out.println("Numeros validos");
            System.out.println("Sejam bem-vindos à disciplina de Técnicas de Programação");
        } else {
            System.out.println("Numeros invalidos");
            System.out.println("Sejam bem-vindos à disciplina de Técnicas de Programação");
        }

        cop.close();
    }
}

package Questoes;

import java.util.Scanner;

public class Quest11 {
    public static void main(String[] args) {
        Scanner cop = new Scanner(System.in);

        System.out.print("Digite o primeiro numero:");
        int A = cop.nextInt();
        System.out.print("Digite o segundo numero:");
        int B = cop.nextInt();

        if (!(A > 10)) {
            if (A + B == 20) {
                System.out.println("A + B == 20");
            } else {
                System.out.println("número não válido");
            }
        }

        cop.close();
    }

}

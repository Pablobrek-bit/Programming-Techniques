package Quests;

import java.util.Scanner;

public class Quest18 {
    public static void main(String[] args){
        Scanner cop = new Scanner(System.in);
		
		System.out.print("Digite o primeiro numero:");
		int A = cop.nextInt();
		System.out.print("Digite o segundo numero:");
		int B = cop.nextInt();

        if((A > 10) || ((A + B) == 20)){
            System.out.println("Numero valido");
        } else {
            System.out.println("Numero invalido");
        }

        cop.close();
    }
}

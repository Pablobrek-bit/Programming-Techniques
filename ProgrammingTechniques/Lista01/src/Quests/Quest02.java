package Quests;

import java.util.Scanner;

public class Quest02 {

	public static void main(String[] args) {
		Scanner cop = new Scanner(System.in);
		
		System.out.print("Digite o primeiro numero:");
		int A = cop.nextInt();
		System.out.print("Digite o segundo numero:");
		int B = cop.nextInt();
		
		if(A < 10) {
			System.out.println("A < 10");
		}else if((A + B) == 20) {
			System.out.println("A + B == 20");
		}else {
			System.out.println("Número não válido");
		}

		cop.close();
	}

}

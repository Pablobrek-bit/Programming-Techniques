package Questoes;

import java.util.Scanner;

public class Quest04 {

	public static void main(String[] args) {
		Scanner cop = new Scanner(System.in);

		System.out.print("Digite o primeiro numero:");
		int A = cop.nextInt();
		System.out.print("Digite o segundo numero:");
		int B = cop.nextInt();
		
		if((A > 10) || (A + B == 20)) {
			System.out.println("Número válido");
		}else if(A == B) {
			System.out.println("(A é igual B; A e B são\r\n"
					+ "diferentes de 10; A é menor que 10)");
		}else {
			System.out.println("Número não válido");
		}

		cop.close();
	}

}

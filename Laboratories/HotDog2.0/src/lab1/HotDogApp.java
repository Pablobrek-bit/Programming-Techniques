package lab1;

import lab1.HotDog.Enums.*;
import lab1.HotDog.HotDog;
import lab1.People.*;
import lab1.Stall.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotDogApp {

	private static List<Sale> sales = new ArrayList<>();
	private static int[] proteinSales = new int[Protein.values().length];
	private static int[] drinkSales = new int[Drink.values().length];
	private static double totalRevenue = 0.0;
	private static double totalDiscounts = 0.0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu de opções:");
			System.out.println("1. Fazer um pedido");
			System.out.println("2. Encerrar o pedido");
			System.out.println("3. Mostrar estatísticas");
			System.out.println("4. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpe o buffer de entrada

			switch (opcao) {
				case 1:
					Sale sale = criarVenda(scanner);
					sales.add(sale);
					atualizarEstatisticas(sale);
					break;
				case 2:
					if (!sales.isEmpty()) {
						calcularValorTotal();
						sales.clear();
					} else {
						System.out.println("Nenhuma venda para encerrar.");
					}
					break;
				case 3:
					mostrarEstatisticas();
					break;
				case 4:
					System.out.println("Obrigado por usar nosso sistema!");
					return;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static Sale criarVenda(Scanner scanner) {
		System.out.println("Bem-vindo ao sistema de pedidos de Hot Dog!");

		System.out.print("Digite seu nome: ");
		String nome = scanner.nextLine();
		System.out.print("Digite sua matrícula: ");
		int matricula = scanner.nextInt();
		People pessoa = new Aluno(nome, matricula);

		List<HotDog> hotDogs = new ArrayList<>();

		while (true) {
			HotDog hotDog = criarHotDog(scanner);
			hotDogs.add(hotDog);

			System.out.println("Deseja adicionar outro hot dog? (S/N)");
			String resposta = scanner.next();
			if (!resposta.equalsIgnoreCase("S")) {
				break;
			}
		}

		System.out.println("Escolha a bebida:");
		for (Drink drink : Drink.values()) {
			System.out.println(drink.getId() + ". " + drink.name());
		}
		int drinkId = scanner.nextInt();

		return new Sale(pessoa, hotDogs);
	}

	private static HotDog criarHotDog(Scanner scanner) {
		HotDog hotDog = new HotDog();

		System.out.println("\nCriando um novo hot dog:");
		System.out.println("Escolha a proteína:");
		for (Protein protein : Protein.values()) {
			System.out.println(protein.getId() + ". " + protein.name());
		}
		int proteinId = scanner.nextInt();
		hotDog.setProtein(Protein.getProtein(proteinId));

		// Adicione lógica semelhante para escolher queijo e ingredientes adicionais

		return hotDog;
	}

	private static void calcularValorTotal() {
		totalRevenue = 0.0;
		totalDiscounts = 0.0;

		for (Sale sale : sales) {
			sale.CalculateValue();
			totalRevenue += sale.getValue();
			totalDiscounts += sale.getDiscountAmount();
		}

		System.out.println("Total de vendas: R$" + totalRevenue);
		System.out.println("Total de descontos: R$" + totalDiscounts);
	}

	private static void atualizarEstatisticas(Sale sale) {
		for (HotDog hotDog : sale.getHotDogs()) {
			int proteinId = hotDog.getProtein().getId();
			proteinSales[proteinId - 1]++;
			int drinkId = hotDog.getDrink().getId();
			drinkSales[drinkId - 1]++;
		}
	}

	private static void mostrarEstatisticas() {
		System.out.println("Estatísticas de vendas:");
		System.out.println("Número total de vendas: " + sales.size());

		System.out.println("\nVendas por tipo de proteína:");
		for (Protein protein : Protein.values()) {
			int quantidade = proteinSales[protein.getId() - 1];
			System.out.println(protein.name() + ": " + quantidade);
		}

		System.out.println("\nTotal de cachorros-quentes vendidos: " + sales.size());
		System.out.println("Tipo de cachorro-quente mais vendido: " + tipoCachorroQuenteMaisVendido());
		System.out.println("Tipo de bebida mais vendida: " + tipoBebidaMaisVendida());
	}

	private static String tipoCachorroQuenteMaisVendido() {
		int maxCount = 0;
		String maisVendido = "";

		for (Protein protein : Protein.values()) {
			int quantidade = proteinSales[protein.getId() - 1];
			if (quantidade > maxCount) {
				maxCount = quantidade;
				maisVendido = protein.name();
			}
		}

		return maisVendido;
	}

	private static String tipoBebidaMaisVendida() {
		int maxCount = 0;
		String maisVendida = "";

		for (Drink drink : Drink.values()) {
			int quantidade = drinkSales[drink.getId() - 1];
			if (quantidade > maxCount) {
				maxCount = quantidade;
				maisVendida = drink.name();
			}
		}

		return maisVendida;
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bean.Client;
import Bean.HotDog;
import Bean.Sale;
import Enums.CheeseEnum;
import Enums.DrinkEnum;
import Enums.ProteinEnum;

public class Exec {
    private static List<Client> clients = new ArrayList<>();
    private static List<Sale> sales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Sair");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerClient(scanner);
                    break;
                case 2:
                    makeSale(scanner);
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void registerClient(Scanner scanner) {
        System.out.println("Digite o nome do cliente:");
        String name = scanner.next();
        System.out.println("Digite o número de matrícula do cliente:");
        int id = scanner.nextInt();

        Client client = new Client(id, name);
        clients.add(client);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void makeSale(Scanner scanner) {
        System.out.println("Digite o número de matrícula do cliente:");
        int id = scanner.nextInt();
        Client client = findClientById(id);

        if (client == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Escolha a proteína (salsicha, linguica, frango, bacon):");
        String proteinSelection = scanner.next();
        ProteinEnum protein = ProteinEnum.getProteina(proteinSelection);

        System.out.println("Escolha o queijo (mussarela, prato, parmesao, coalho):");
        String cheeseSelection = scanner.next();
        CheeseEnum cheese = CheeseEnum.getCheese(cheeseSelection);

        List<String> additionalIngredients = new ArrayList<>();
        System.out.println("Escolha os ingredientes adicionais (maionese, ketchup, ovo, batata palha). Digite 'fim' para encerrar:");
        while (true) {
            String ingredient = scanner.next();
            if (ingredient.equals("fim")) {
                break;
            }
            additionalIngredients.add(ingredient);
        }

        System.out.println("Escolha a bebida (Coca-cola, Del-Rio, Suco-do-Chaves):");
        String drinkSelection = scanner.next();
        DrinkEnum drink = DrinkEnum.getDrink(drinkSelection);

        HotDog hotDog = new HotDog(cheese, protein, additionalIngredients, drink);
        Sale sale = new Sale(client, hotDog);
        sales.add(sale);

        System.out.println("Venda registrada com sucesso.");
    }

    private static Client findClientById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}

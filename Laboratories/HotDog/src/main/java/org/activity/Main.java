package org.activity;

import org.activity.Bean.Client;
import org.activity.Bean.HotDog;
import org.activity.Enums.CheeseEnum;
import org.activity.Enums.DrinkEnum;
import org.activity.Enums.ProteinEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner cop = new Scanner(System.in);

    public static Client registerClient() {
        System.out.println("Digite seu nome:");
        String name = cop.next();
        System.out.println("Digite seu número de matrícula:");
        int id = cop.nextInt();

        Client client = new Client(id, name);
        return client;

    }

    public static HotDog registerHotDog(){
        System.out.println("Digite o tipo de proteína (salsicha, linguica, frango, bacon):");
        ProteinEnum protein = ProteinEnum.getProteina(cop.next());

        System.out.println("Digite o drink (Coca-cola, Del-Rio, Suco-do-Chaves):");
        DrinkEnum drink = DrinkEnum.getDrink(cop.next());

        System.out.println("Digite o queijo (mussarela, prato, parmesao, coalho):");
        CheeseEnum cheese = CheeseEnum.getCheese(cop.next());

        List<String> additionalIngredient = new ArrayList<String>();

        System.out.println("Você quer batata palha? (sim/nao):");
        if(cop.next().equals("sim")){
            additionalIngredient.add("batata palha");
        }

        System.out.println("Você quer ovo? (sim/nao):");
        if(cop.next().equals("sim")){
            additionalIngredient.add("ovo");
        }

        System.out.println("Você quer maionese? (sim/nao):");
        if(cop.next().equals("sim")){
            additionalIngredient.add("maionese");
        }

        System.out.println("Você quer ketchup? (sim/nao):");
        if(cop.next().equals("sim")){
            additionalIngredient.add("ketchup");
        }

        HotDog hotDog = new HotDog(cheese, protein, additionalIngredient, drink);

        return hotDog;

    }
}
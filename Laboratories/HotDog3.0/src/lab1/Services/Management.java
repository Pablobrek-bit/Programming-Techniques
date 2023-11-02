package lab1.Services;

import lab1.DAO.ClientDAO;
import lab1.DAO.ClientsHotDogsDAO;
import lab1.DAO.HotDogDAO;
import lab1.Model.People.Client.Client;
import lab1.Model.People.HotDog.HotDog;
import lab1.Model.People.Sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class Management {
    public static List<Sale> sales = new ArrayList<>();
    private static Value value;

//    private static Client createdClient(String name, String matricula){
//        return new Client(name, matricula);
//    }

    private static void createdClient(Client client){
        ClientDAO.insertUser(client);
    }

    private static void createdHotDog(HotDog hotDog, Client client){
        HotDogDAO.createHotDog(hotDog, value.calculateValue(hotDog, HotDogDAO.getQuantityHotDogs(Integer.parseInt(client.getId()))));
    }

    private static void createdClientHotDog(Client client){
        ClientsHotDogsDAO.createClientHotDog(Integer.parseInt(client.getId()));
    }

    public static boolean addSale(Client client, HotDog hotDog){
        createdClient(client);
        createdHotDog(hotDog, client);


        return true;
    }
//    private static HotDog createdHotDog(String drink, String cheese, String protein, List<Additional> additional){
//
//        return new HotDog(drink, cheese, protein, additional);
//    }

//    public static boolean addSale(String name, String matricula, String drink, String cheese, String protein, List<Additional> additional){
//        value = new Value();
//        Client client = createdClient(name, matricula);
//        HotDog hotDog = createdHotDog(drink, cheese, protein, additional);
//        int validationResult = Validations.findUserByIdUser(name, matricula);
//
//
//        if(validationResult == -1) {
//            JOptionPane.showMessageDialog(null, "Venda não permitida");
//            return false;
//        }
//        if(validationResult == 0) {
//            JOptionPane.showMessageDialog(null, "Matricula|Nome não pode ser vazio");
//            return false;
//        }
//
//        sales.add(new Sale(client, hotDog, value.calculateValue(hotDog, Validations.findHotDogByIdUser(matricula)), value.calculateDiscont(hotDog, Validations.findHotDogByIdUser(matricula))));
//        System.out.println(sales.get(sales.size()-1).toString());
//        return true;
//    }







}

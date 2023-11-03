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

//    private static void createdClient(Client client){
//        ClientDAO.insertUser(client);
//    }

    private static Client createOrGetClient(Client client) {
        Client existingClient = ClientDAO.findUserbyName(client.getName());
        if (existingClient.getId().isEmpty()) {
            ClientDAO.insertUser(client);
            return client;
        } else {
            return existingClient;
        }
    }

    private static void createdHotDog(HotDog hotDog, Client client){
        HotDogDAO.createHotDog(hotDog, client);
    }

    private static void createdClientHotDog(Client client){
        ClientsHotDogsDAO.createClientHotDog(Integer.parseInt(client.getId()));
    }

    public static boolean addSale(Client client, HotDog hotDog){
        client = createOrGetClient(client);
        createdHotDog(hotDog, client);
        createdClientHotDog(client);
        return true;
    }


}

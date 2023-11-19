package lab1.Services;

import lab1.Model.People.DAO.ClientDAO;
import lab1.Model.People.DAO.ClientsHotDogsDAO;
import lab1.Model.People.DAO.HotDogDAO;
import lab1.Model.People.Client.Client;
import lab1.Model.People.HotDog.HotDog;
import lab1.Model.People.Sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public static List<Sale> sales = getAllSales();
    private static Value value;

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

    public static List<Sale> getAllSales() {
        List<Sale> listSale = new ArrayList<>();

        for (Client client : ClientDAO.listClient()) {
            List<HotDog> hotDogs = HotDogDAO.listarHotDogsPorCliente(Integer.parseInt(client.getId()));

            for (HotDog hotDog : hotDogs) {
                listSale.add(new Sale(client, hotDog,0.0,0.0));
            }
        }
        return listSale;
    }
}

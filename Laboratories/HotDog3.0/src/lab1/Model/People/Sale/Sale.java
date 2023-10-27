package lab1.Model.People.Sale;

import lab1.Model.People.Client.Client;
import lab1.Model.People.HotDog.HotDog;

public class Sale {

    private Client client;
    private HotDog hotDog;

    public Sale(Client client, HotDog hotDog) {
        this.client = client;
        this.hotDog = hotDog;
    }

    public Client getClient() {
        return client;
    }

    public HotDog getHotDog() {
        return hotDog;
    }

    public String toString(){
        return client.getName() + "; " +
                "; " + client.getId() + "; " + hotDog.getDrink() + hotDog.getCheese() + "; " + hotDog.getProtein() + "; " + hotDog.getAdditional() + "; ";
    }

}

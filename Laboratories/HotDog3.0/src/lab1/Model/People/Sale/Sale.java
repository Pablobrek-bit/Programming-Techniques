package lab1.Model.People.Sale;

import lab1.Model.People.Client.Client;
import lab1.Model.People.HotDog.HotDog;

public class Sale {

    private Client client;
    private HotDog hotDog;

    private Double value;

    private Double discountAmount;

    public Sale(Client client, HotDog hotDog, Double value, Double discountAmount) {
        this.client = client;
        this.hotDog = hotDog;
        this.value = value;
        this.discountAmount = discountAmount;
    }

    public Client getClient() {
        return client;
    }

    public HotDog getHotDog() {
        return hotDog;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String toString(){
        return client.getName() + "; " +
                "; " + client.getId() + "; " + hotDog.getDrink() + hotDog.getCheese() + "; " + hotDog.getProtein() + "; " + hotDog.getAdditional() + "; ";
    }

}

package org.activity.Bean;

import java.util.List;

public class Sale {
    private Client client;
    private List<HotDog> hotDog;

    public Sale(Client client, List<HotDog> hotDog) {
        this.client = client;
        this.hotDog = hotDog;
    }

    public Client getClient() {
        return client;
    }

    public List<HotDog> getHotDog() {
        return hotDog;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "client=" + client.getName() +
                ", hotDog=" + hotDog +
                '}';
    }
}

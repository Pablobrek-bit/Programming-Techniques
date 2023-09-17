package Bean;

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
    
    @Override
    public String toString() {
        return "Sale{" +
                "client=" + client.getName() +
                ", hotDog=" + hotDog +
                '}';
    }
}

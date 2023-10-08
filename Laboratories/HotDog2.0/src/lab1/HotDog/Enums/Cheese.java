package lab1.HotDog.Enums;

public enum Cheese {

    //MOZZARELLA, PRATO, PARMESAN, COALHO

    MOZZARELLA(1),
    PRATO(2),
    PARMESAN(3),
    COALHO(4);

    private int id;

    Cheese(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Cheese getCheese(int id) {
        for (Cheese cheese : Cheese.values()) {
            if (cheese.getId() == id) {
                return cheese;
            }
        }
        return null;
    }
}

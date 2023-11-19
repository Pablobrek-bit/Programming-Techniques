package lab1.Model.People.Enums;

public enum Drink {

    //COCACOLA, DELRIO, SUCOCHAVES
    COCACOLA(1),
    DELRIO(2),
    SUCOCHAVES(3);

    private int id;

    Drink(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Drink getDrink(int id) {
        for (Drink drink : Drink.values()) {
            if (drink.getId() == id) {
                return drink;
            }
        }
        return null;
    }

    public static Drink fromString(String text) {
        for (Drink drink : Drink.values()) {
            if (drink.name().equalsIgnoreCase(text)) {
                return drink;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Drink.class + "." + text);
    }
}
package lab1.HotDog.Enums;

public enum Protein {

    SALSICHA(1, 2.0),
    SAUSAGE(2, 3.0),
    CHICKEN(3, 2.5),
    BACON(4, 3.5);

    private int id;
    private double price;

    Protein(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public int getId() {
        return id;
    }

    public static Protein getProtein(int id) {
        for (Protein protein : Protein.values()) {
            if (protein.getId() == id) {
                return protein;
            }
        }
        return null;
    }
}

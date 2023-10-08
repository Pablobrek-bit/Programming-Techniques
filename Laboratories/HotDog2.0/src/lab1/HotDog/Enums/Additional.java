package lab1.HotDog.Enums;

public enum Additional {

    MAIONESE(1),
    KETCHUP(2),
    OVO(3),
    BATATA_PALHA(4);

    private int id;


    Additional(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Additional getAdditional(int id) {
        for (Additional additional : Additional.values()) {
            if (additional.getId() == id) {
                return additional;
            }
        }
        return null;
    }
}

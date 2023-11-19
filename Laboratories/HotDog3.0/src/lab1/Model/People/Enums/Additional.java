package lab1.Model.People.Enums;

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
    public static Additional fromString(String text) {
        for (Additional additional : Additional.values()) {
            if (additional.name().equalsIgnoreCase(text)) {
                return additional;
            }
        }
        throw new IllegalArgumentException("No enum constant lab1.Model.People.Enums.Additional." + text);
    }
}

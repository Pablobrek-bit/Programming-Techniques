package org.activity.Enums;

public enum DrinkEnum {
    COCA_COLA("Coca-cola"),
    DEL_RIO("Del-Rio"),
    SUCO_DO_CHAVES("Suco-do-Chaves");

    private String nome;

    DrinkEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static DrinkEnum getDrink(String nome) {
        switch (nome) {
            case "Coca-cola":
                return COCA_COLA;
            case "Del-Rio":
                return DEL_RIO;
            case "Suco-do-Chaves":
                return SUCO_DO_CHAVES;
            default:
                return null;
        }
    }
}

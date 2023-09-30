package org.activity.Enums;

public enum ProteinEnum {
    SALSICHA("salsicha"),
    LINGUICA("linguica"),
    FRANGO("frango"),
    BACON("bacon");

    private String selecao;

    public String getSelecao() {
        return selecao;
    }

    ProteinEnum(String selecao) {
        this.selecao = selecao;
    }

    public static ProteinEnum getProteina(String selecao) {
        switch (selecao) {
            case "salsicha":
                return SALSICHA;
            case "linguica":
                return LINGUICA;
            case "frango":
                return FRANGO;
            case "bacon":
                return BACON;
            default:
                return null;
        }
    }
}
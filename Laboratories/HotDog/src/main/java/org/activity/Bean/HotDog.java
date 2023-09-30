package org.activity.Bean;

import org.activity.Enums.CheeseEnum;
import org.activity.Enums.DrinkEnum;
import org.activity.Enums.ProteinEnum;

import java.util.List;

public class HotDog {

    private CheeseEnum cheese;
    private ProteinEnum protein;
    private List<String> additionalIngredient;
    private DrinkEnum drink;

    public HotDog(CheeseEnum cheese, ProteinEnum protein, List<String> additionalIngredient, DrinkEnum drink) {
        super();
        this.cheese = cheese;
        this.protein = protein;
        this.additionalIngredient = additionalIngredient;
        this.drink = drink;
    }

    public CheeseEnum getCheese() {
        return cheese;
    }
    public void setCheese(CheeseEnum cheese) {
        this.cheese = cheese;
    }
    public ProteinEnum getProtein() {
        return protein;
    }
    public void setProtein(ProteinEnum protein) {
        this.protein = protein;
    }
    public List<String> getAdditionalIngredient() {
        return additionalIngredient;
    }
    public void setAdditionalIngredient(List<String> additionalIngredient) {
        this.additionalIngredient = additionalIngredient;
    }
    public DrinkEnum getDrink() {
        return drink;
    }
    public void setDrink(DrinkEnum drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "HotDog [cheese=" + cheese + ", protein=" + protein + ", additionalIngredient=" + additionalIngredient
                + ", drink=" + drink + "]";
    }


}

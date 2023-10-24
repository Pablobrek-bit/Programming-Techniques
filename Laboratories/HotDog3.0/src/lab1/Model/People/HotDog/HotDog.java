package lab1.Model.People.HotDog;

import lab1.Model.People.Enums.Additional;
import lab1.Model.People.Enums.Cheese;
import lab1.Model.People.Enums.Drink;
import lab1.Model.People.Enums.Protein;

import java.util.List;

public class HotDog {

    private Drink drink;
    private Cheese cheese;
    private Protein protein;
    private List<Additional> additional;

    public HotDog(){
        super();
    }

    public HotDog(Drink drink, Cheese cheese, Protein protein, List<Additional> additional) {
        this.drink = drink;
        this.cheese = cheese;
        this.protein = protein;
        this.additional = additional;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public List<Additional> getAdditional() {
        return additional;
    }

    public void setAdditional(List<Additional> additional) {
        this.additional = additional;
    }


}

package lab1.Stall;

import lab1.HotDog.Enums.Protein;
import lab1.HotDog.HotDog;
import lab1.People.People;

import java.util.List;

public class Sale {

    private People people;
    private List<HotDog> hotDogs;

    private Double value = 0.0;

    public Sale(People people, List<HotDog> hotDogs) {
        this.people = people;
        this.hotDogs = hotDogs;
    }

    public void CalculateValue() {

        for(int i = 0; i < hotDogs.size(); i++) {
            Protein protein = hotDogs.get(i).getProtein();
            Discount(protein, hotDogs.size());
        }

    }

    private void Discount(Protein protein, int quantityHotDogs){

            if((protein == Protein.SALSICHA) && (quantityHotDogs > 2)){
                value += protein.getPrice() * 0.9;
            }else if((protein == Protein.SAUSAGE) && (quantityHotDogs > 2)){
                value += protein.getPrice() * 0.88;
            }
            else if((protein == Protein.CHICKEN) && (quantityHotDogs > 3)){
                value += protein.getPrice() * 0.87;
            }
            else if((protein == Protein.BACON) && (quantityHotDogs > 3)){
                value += protein.getPrice() * 0.86;
            }
    }

    public Double getDiscountAmount() {
        double discountAmount = 0.0;

        for (int i = 0; i < hotDogs.size(); i++) {
            Protein protein = hotDogs.get(i).getProtein();
            if ((protein == Protein.SALSICHA) && (hotDogs.size() > 2)) {
                discountAmount += protein.getPrice() * 0.1;
            } else if ((protein == Protein.SAUSAGE) && (hotDogs.size() > 2)) {
                discountAmount += protein.getPrice() * 0.12;
            } else if ((protein == Protein.CHICKEN) && (hotDogs.size() > 3)) {
                discountAmount += protein.getPrice() * 0.13;
            } else if ((protein == Protein.BACON) && (hotDogs.size() > 3)) {
                discountAmount += protein.getPrice() * 0.14;
            }
        }

        return discountAmount;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public List<HotDog> getHotDogs() {
        return hotDogs;
    }

    public void setHotDogs(List<HotDog> hotDogs) {
        this.hotDogs = hotDogs;
    }

    public Double getValue() {
        return value;
    }
}

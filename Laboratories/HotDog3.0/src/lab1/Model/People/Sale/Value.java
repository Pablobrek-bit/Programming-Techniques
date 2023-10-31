package lab1.Model.People.Sale;

import lab1.Model.People.Enums.Protein;
import lab1.Model.People.HotDog.HotDog;



public class Value {
    private Double value = 0.0;
    private Double discountAmount = 0.0;

    public Double calculateValue(HotDog hotDogs, int quantityHotDogs) {

        for(int i = 0; i <= quantityHotDogs; i++) {
            Protein protein = hotDogs.getProtein();
            discount(protein, quantityHotDogs);
        }
        return value;

    }

    public Double calculateDiscont(HotDog hotDogs, int quantityHotDogs){

        for(int i = 0; i <= quantityHotDogs; i++) {
            Protein protein = hotDogs.getProtein();
            setDiscountAmount(protein, quantityHotDogs);
        }
        return discountAmount;
    }

    private void discount(Protein protein, int quantityHotDogs){


        if((protein == Protein.SALSICHA) && (quantityHotDogs > 2)){
            value += protein.getPrice() * 0.9;
        }else if((protein == Protein.LINGUICA) && (quantityHotDogs > 2)){
            value += protein.getPrice() * 0.88;
        }
        else if((protein == Protein.FRANGO) && (quantityHotDogs > 3)){
            value += protein.getPrice() * 0.87;
        }
        else if((protein == Protein.BACON) && (quantityHotDogs > 3)){
            value += protein.getPrice() * 0.86;
        } else {
            value += protein.getPrice();
        }
    }

    public void setDiscountAmount(Protein protein, int quantityHotDogs) {;
        for (int i = 0; i < quantityHotDogs; i++) {

            if ((protein == Protein.SALSICHA) && (quantityHotDogs > 2)) {
                discountAmount += protein.getPrice() * 0.1;
            } else if ((protein == Protein.LINGUICA) && (quantityHotDogs > 2)) {
                discountAmount += protein.getPrice() * 0.12;
            } else if ((protein == Protein.FRANGO) && (quantityHotDogs > 3)) {
                discountAmount += protein.getPrice() * 0.13;
            } else if ((protein == Protein.BACON) && (quantityHotDogs > 3)) {
                discountAmount += protein.getPrice() * 0.14;
            }
        }
    }



}

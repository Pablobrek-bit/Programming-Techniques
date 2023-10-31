package lab1.Model.People.Sale;

import lab1.Model.People.Enums.Protein;
import lab1.Model.People.HotDog.HotDog;



public class Value {
    private Double value = 0.0;

    public Double calculateValue(HotDog hotDogs, int quantityHotDogs) {

        for(int i = 0; i < quantityHotDogs; i++) {
            Protein protein = hotDogs.getProtein();
            discount(protein, quantityHotDogs);
        }
        return value;

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
        }
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public HotDog getHotDogs() {
//        return hotDogs;
//    }
//
//    public void setHotDogs(HotDog hotDogs) {
//        this.hotDogs = hotDogs;
//    }
//
//    public Double getValue() {
//        return value;
//    }
}

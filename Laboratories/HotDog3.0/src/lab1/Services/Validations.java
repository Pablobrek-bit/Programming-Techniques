package lab1.Services;

import lab1.Model.People.Client.Client;
import lab1.Model.People.Sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class Validations {


    //primeiro vamos ver se a matricula bate com o nome
    //caso bater então vai permitir a venda
    //caso não bater então vai retornar uma mensagem de erro

    public static int findUserByIdUser(String name, String id){
        if(id.isEmpty() || name.isEmpty()){
            return 0;
        } else {
            for(int i = 0; i < Management.sales.size(); i++){
                Sale sale = Management.sales.get(i);
                if (sale.getClient().getId().equals(id) && !sale.getClient().getName().equals(name)) {
                    return -1;
                }
            }
        }
        return 3;
    }

    public static int findHotDogByIdUser(String id) {
        int cont = 0;
        if (id.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < Management.sales.size(); i++) {
                Sale sale = Management.sales.get(i);
                if (sale.getClient().getId().equals(id)) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static List<Client> findUsers(){
        List<Client> clients = new ArrayList<>();

        for(int i = 0; i < Management.sales.size(); i++) {
            Sale sale = Management.sales.get(i);

            if(!clients.contains(sale.getClient())){
                clients.add(sale.getClient());
            }

        }
        return clients;
    }
}






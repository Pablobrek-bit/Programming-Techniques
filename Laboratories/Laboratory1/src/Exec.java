import java.util.ArrayList;
import java.util.List;

import Bean.Client;
import Bean.HotDog;
import Bean.Sale;
import Registration.Register;

public class Exec {
    public static void main(String[] args) {
        Client client = Register.registerClient();
        List<HotDog> hotDogs = new ArrayList<>();

        boolean registerHotDog = true;
        while (registerHotDog) {
            HotDog hotDog = Register.registerHotDog();
            hotDogs.add(hotDog);

            System.out.println("Deseja cadastrar outro hot dog? (sim/nao)");
            if (!Register.cop.next().equals("sim")) {
                registerHotDog = false;
            }
        }

        Sale sale = new Sale(client, hotDogs);

        System.out.println(sale);
    }
}

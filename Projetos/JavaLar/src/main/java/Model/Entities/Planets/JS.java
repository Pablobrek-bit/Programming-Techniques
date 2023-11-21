package Model.Entities.Planets;

import View.Components.Create;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;


public class JS extends Planets {

    public JS() {
        this.name = "JS";
        dislocation = 3;
        rotation = 10;
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/script-java.png", 48, 48);


        Coordinates coord = new Coordinates(10, 12);
        Coordinates minCoord = new Coordinates(6, 10);
        Coordinates maxCoord = new Coordinates(10, 14);

        this.location = new Location(coord, minCoord, maxCoord);
    }

}

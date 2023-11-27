package Model.Entities.Planets;

import View.Components.Icons;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class C extends Planets {



    public C() {
        this.name = "C";
        dislocation = 10;
        rotation = 0.1;
        this.imageIcon = Icons.createIcon("src/main/java/View/Sources/letra-c.png", 40, 40);

        Coordinates coord = new Coordinates(15, 12);
        Coordinates minCoord = new Coordinates(1, 5);
        Coordinates maxCoord = new Coordinates(15, 19);

        this.location = new Location(coord, minCoord, maxCoord);
    }
}

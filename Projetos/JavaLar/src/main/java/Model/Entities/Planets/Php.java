package Model.Entities.Planets;


import View.Components.Create;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class Php extends Planets {
    
    public Php() {
        this.name = "Php";
        dislocation = 2;
        rotation = 60;
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/php.png", 48, 48);


        Coordinates coord = new Coordinates(12, 12);
        Coordinates minCoord = new Coordinates(4, 8);
        Coordinates maxCoord = new Coordinates(12, 16);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

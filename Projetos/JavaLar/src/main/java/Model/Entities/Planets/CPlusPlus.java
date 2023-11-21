package Model.Entities.Planets;


import View.Components.Create;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class CPlusPlus extends Planets {

    public CPlusPlus() {
        this.name = "C++";
        dislocation = 2;
        rotation = 0.5;
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/c-.png", 48, 48);


        Coordinates coord = new Coordinates(14, 12);
        Coordinates minCoord = new Coordinates(2, 6);
        Coordinates maxCoord = new Coordinates(14, 18);

        this.location = new Location(coord, minCoord, maxCoord);

    }
    
}

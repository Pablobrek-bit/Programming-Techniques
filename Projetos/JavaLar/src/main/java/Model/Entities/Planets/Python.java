package Model.Entities.Planets;


import View.Components.Icons;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class Python extends Planets {
    
    public Python() {
        this.name = "Python";
        dislocation = 4;
        rotation = 24;
        this.imageIcon = Icons.createIcon("src/main/java/View/Sources/python.png", 40, 40);

        Coordinates coord = new Coordinates(9, 12);
        Coordinates minCoord = new Coordinates(7, 11);
        Coordinates maxCoord = new Coordinates(9, 13);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

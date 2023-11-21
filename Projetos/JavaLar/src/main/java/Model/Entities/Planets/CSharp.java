package Model.Entities.Planets;


import View.Components.Create;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class CSharp extends Planets {

    public CSharp() {
        this.name = "C#";
        dislocation = 1;
        rotation = 4;
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/do-sustenido.png", 48, 48);


        Coordinates coord = new Coordinates(13, 12);
        Coordinates minCoord = new Coordinates(3, 7);
        Coordinates maxCoord = new Coordinates(13, 17);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

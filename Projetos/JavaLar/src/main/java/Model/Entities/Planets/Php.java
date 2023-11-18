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
        this.history = "PHP is a general-purpose scripting language especially suited to web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1994.\nThe PHP reference implementation is now produced by The PHP Group. PHP originally stood for Personal Home Page, but it now stands for the recursive initialism PHP: Hypertext Preprocessor.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/php.png", 48, 48);


        Coordinates coord = new Coordinates(12, 12);
        Coordinates minCoord = new Coordinates(4, 8);
        Coordinates maxCoord = new Coordinates(12, 16);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

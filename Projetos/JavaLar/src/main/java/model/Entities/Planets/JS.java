package model.Entities.Planets;

import View.Components.Create;
import model.Entities.Components.Coordinates;
import model.Entities.Components.Location;
import model.Entities.Components.Planets;


public class JS extends Planets {

    public JS() {
        this.name = "JS";
        dislocation = 3;
        rotation = 10;
        this.history = "JavaScript, often abbreviated as JS, is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm.\nIt has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/script-java.png", 48, 48);


        Coordinates coord = new Coordinates(10, 12);
        Coordinates minCoord = new Coordinates(6, 10);
        Coordinates maxCoord = new Coordinates(10, 14);

        this.location = new Location(coord, minCoord, maxCoord);
    }

}

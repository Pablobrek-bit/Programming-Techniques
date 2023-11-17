package model.Entities.Planets;


import View.Components.Create;
import model.Entities.Components.Coordinates;
import model.Entities.Components.Location;
import model.Entities.Components.Planets;

public class Python extends Planets {
    
    public Python() {
        this.name = "Python";
        dislocation = 4;
        rotation = 24;
        this.history = "Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991, Python's design philosophy emphasizes code readability with its notable use of significant whitespace.\nIts language constructs and object-oriented approach aim to help programmers write clear, logical code for small and large-scale projects.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/python.png", 48, 48);


        Coordinates coord = new Coordinates(9, 12);
        Coordinates minCoord = new Coordinates(7, 11);
        Coordinates maxCoord = new Coordinates(9, 13);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

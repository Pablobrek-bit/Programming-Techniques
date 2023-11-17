package model.Entities.Planets;

import View.Components.Create;
import model.Entities.Components.Coordinates;
import model.Entities.Components.Location;
import model.Entities.Components.Planets;

public class C extends Planets {



    public C() {
        this.name = "C";
        dislocation = 10;
        rotation = 0.1;
        this.history = "C is a general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, with a static type system. \nBy design, C provides constructs that map efficiently to typical machine instructions. It has found lasting use in applications previously coded in assembly language. \nSuch applications include operating systems and various application software for computer architectures that range from supercomputers to PLCs and embedded systems.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/letra-c.png", 48, 48);

        Coordinates coord = new Coordinates(15, 12);
        Coordinates minCoord = new Coordinates(1, 5);
        Coordinates maxCoord = new Coordinates(15, 19);

        this.location = new Location(coord, minCoord, maxCoord);
    }
}

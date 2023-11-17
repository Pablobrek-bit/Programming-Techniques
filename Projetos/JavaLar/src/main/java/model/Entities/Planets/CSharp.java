package model.Entities.Planets;


import View.Components.Create;
import model.Entities.Components.Coordinates;
import model.Entities.Components.Location;
import model.Entities.Components.Planets;

public class CSharp extends Planets {

    public CSharp() {
        this.name = "C#";
        dislocation = 1;
        rotation = 4;
        this.history = "C# is a general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.\nIt was developed around 2000 by Microsoft as part of its .NET initiative, and later approved as an international standard by Ecma (ECMA-334) and ISO (ISO/IEC 23270:2018).\nMono is the name of the free and open-source project to develop a compiler and runtime for the language.\nC# is one of the programming languages designed for the Common Language Infrastructure.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/do-sustenido.png", 48, 48);


        Coordinates coord = new Coordinates(13, 12);
        Coordinates minCoord = new Coordinates(3, 7);
        Coordinates maxCoord = new Coordinates(13, 17);

        this.location = new Location(coord, minCoord, maxCoord);
    }

    
}

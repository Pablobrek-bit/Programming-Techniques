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
        this.history = "C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or \"C with Classes\".\nThe language has expanded significantly over time, and modern C++ now has object-oriented, generic, and functional features in addition to facilities for low-level memory manipulation.\nIt is almost always implemented as a compiled language, and many vendors provide C++ compilers, including the Free Software Foundation, LLVM, Microsoft, Intel, Oracle, and IBM, so it is available on many platforms.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/c-.png", 48, 48);


        Coordinates coord = new Coordinates(14, 12);
        Coordinates minCoord = new Coordinates(2, 6);
        Coordinates maxCoord = new Coordinates(14, 18);

        this.location = new Location(coord, minCoord, maxCoord);

    }
    
}

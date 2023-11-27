package Model.Entities.Planets;


import View.Components.Icons;
import Model.Entities.Components.Coordinates;
import Model.Entities.Components.Location;
import Model.Entities.Components.Planets;

public class RubyRails extends Planets {

    public RubyRails() {
        this.name = "Ruby on Rails";
        dislocation = 2;
        rotation = 48;
        this.imageIcon = Icons.createIcon("src/main/java/View/Sources/icons8-ruby-programming-language-48.png", 40, 40);

        Coordinates coord = new Coordinates(11, 12);
        Coordinates minCoord = new Coordinates(5, 9);
        Coordinates maxCoord = new Coordinates(11, 15);

        this.location = new Location(coord, minCoord, maxCoord);
    }

}

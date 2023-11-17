package model.Entities.Planets;


import View.Components.Create;
import model.Entities.Components.Coordinates;
import model.Entities.Components.Location;
import model.Entities.Components.Planets;

public class RubyRails extends Planets {

    public RubyRails() {
        this.name = "Ruby on Rails";
        dislocation = 2;
        rotation = 48;
        this.history = "Ruby on Rails, or Rails, is a server-side web application framework written in Ruby under the MIT License. Rails is a model–view–controller (MVC) framework, providing default structures for a database, a web service, and web pages.\nIt encourages and facilitates the use of web standards such as JSON or XML for data transfer, HTML, CSS and JavaScript for user interfacing. Rails is a framework, providing default structures for a database, a web service, and web pages.\nIt encourages and facilitates the use of web standards such as JSON or XML for data transfer, HTML, CSS and JavaScript for user interfacing.";
        this.imageIcon = Create.createIcon("src/main/java/View/Sources/icons8-ruby-programming-language-48.png", 48, 48);

        Coordinates coord = new Coordinates(11, 12);
        Coordinates minCoord = new Coordinates(5, 9);
        Coordinates maxCoord = new Coordinates(11, 15);

        this.location = new Location(coord, minCoord, maxCoord);
    }

}

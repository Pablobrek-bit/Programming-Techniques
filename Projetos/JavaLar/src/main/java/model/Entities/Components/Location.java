package model.Entities.Components;

//Class that will store the point at which the entities are in the system
public class Location {

	//Coordinates of the planets
	private Coordinates coord;
	private Coordinates minCoord;
	private Coordinates maxCoord;

	public Location(Coordinates coord, Coordinates minCoord, Coordinates maxCoord) {
		this.coord = coord;
		this.minCoord = minCoord;
		this.maxCoord = maxCoord;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public Coordinates getMinCoord() {
		return minCoord;
	}

	public Coordinates getMaxCoord() {
		return maxCoord;
	}

	@Override
	public String toString() {
		return "x = " + coord.getX() + " y = " + coord.getY();
	}
}




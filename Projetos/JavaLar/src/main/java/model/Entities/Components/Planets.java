package model.Entities.Components;


import model.Entities.BugsDevs.BugsDevs;
import model.Calculations.Calculation;
import model.Entities.BugsDevs.Verifications;


public abstract class Planets {

	protected String name;
	protected boolean isAlive = true;
	protected int dislocation;
	protected int distanceTraveled;
	protected double rotation;
	protected String history;
	protected double years = 0;
	protected int hitDevs;
	protected int hitBugs;
	protected Location location;

	private void setAlive() {
		if (dislocation <= 0) {
			this.isAlive = false;
		}
	}

	//Method for defining what will happen at a specific time
	public void move(int instant){
		//Variable to store how far the planet has moved in a period
		int distanceInYear = 0;
		for (int i = 0; i < instant; i++) {
			if (isAlive) {
				checkCoordinatesBugsDevs();
				this.distanceTraveled += dislocation;
				distanceInYear += dislocation;
				moveLocation();
			}
		}
		years += Calculation.calculateYear(distanceInYear, Calculation.calculateOrbit(location.getMaxCoord().getX()));
	}

	//Method for checking if the planet was hit by a bug or a dev
	private void checkCoordinatesBugsDevs() {
		int x = location.getCoord().getX();
		int y = location.getCoord().getY();

		if (Verifications.checkCoordinates(BugsDevs.getBugs(), x, y)) {
			handleBugHit();
		}
		if (Verifications.checkCoordinates(BugsDevs.getDevs(), x, y)) {
			handleDevHit();
		}
	}

	private void handleBugHit() {
		dislocation--;
		hitBugs++;
		System.out.println("The planet " + this.name + " was hit by a bug!");
		setAlive();
	}

	private void handleDevHit() {
		dislocation++;
		hitDevs++;
		System.out.println("The planet " + this.name + " was hit by a dev!");
	}

	//Method for moving the planet
	private void moveLocation(){
		for (int i = 0; i < this.dislocation; i++) {

			if (location.getCoord().getY() == location.getMinCoord().getY() && location.getCoord().getX() > location.getMaxCoord().getX()) {
				location.getCoord().setX(location.getCoord().getX() - 1);
				continue;
			} else if (location.getCoord().getX() == location.getMinCoord().getX() && location.getCoord().getY() < location.getMaxCoord().getY()) {
				location.getCoord().setY(location.getCoord().getY() + 1);
				continue;
			} else if (location.getCoord().getY() == location.getMaxCoord().getY() && location.getCoord().getX() < location.getMaxCoord().getX()) {
				location.getCoord().setX(location.getCoord().getX() + 1);
				continue;
			} else if (location.getCoord().getX() == location.getMaxCoord().getX() && location.getCoord().getY() > location.getMinCoord().getY()) {
				location.getCoord().setY(location.getCoord().getY() - 1);
				continue;
			} else if (location.getCoord().getY() == location.getMinCoord().getY() && location.getCoord().getX() > location.getMinCoord().getX()) {
				location.getCoord().setX(location.getCoord().getX() - 1);
				continue;
			}
		}
	}

	//Methods Getters and Setters
	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public int getDislocation() {
		return dislocation;
	}

	public double getRotation() {
		return rotation;
	}

	public String getHistory() {
		return history;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getHitDevs() {
		return hitDevs;
	}

	public int getHitBugs() {
		return hitBugs;
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public double getYears() {
		return years;
	}
}

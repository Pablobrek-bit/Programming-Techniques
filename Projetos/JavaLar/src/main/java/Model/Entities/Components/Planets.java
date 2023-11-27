package Model.Entities.Components;


import Model.Entities.BugsDevs.BugsDevs;
import Control.Calculations.Calculation;
import Model.Entities.BugsDevs.Verifications;
import View.Containers.Universe.MainFrame;
import com.sun.tools.javac.Main;

import javax.swing.*;


public abstract class Planets {

	protected String name;
	protected boolean isAlive = true;
	protected int dislocation;
	protected int distanceTraveled;
	protected double rotation;
	protected double years = 0;
	protected int hitDevs;
	protected int hitBugs;
	protected Location location;
	protected ImageIcon imageIcon;
	protected int instants = 0;

	private void setAlive() {
		if (dislocation <= 0) {
			MainFrame.warnings.addWarning("The planet " + this.name + " was destroyed by bugs!", "RedStyle");
			this.isAlive = false;
		}
	}

	//Method for defining what will happen at a specific time
	public void move(int instant){
		instants += instant;
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
		MainFrame.warnings.addWarning("The planet " + this.name + " was hit by a bug!", "GreenStyle");
		setAlive();
	}

	private void handleDevHit() {
		dislocation++;
		hitDevs++;
		MainFrame.warnings.addWarning("The planet " + this.name + " was hit by a dev!",  "BlueStyle");
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

	public Location getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public double getRotation() {
		return rotation;
	}

	public int getInstants() {
		return instants;
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

	public int getYears() {
		return (int) years;
	}

	public boolean isAlive() {
		return isAlive;
	}
}

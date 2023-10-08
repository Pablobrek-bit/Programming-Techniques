package lab1.HotDog;

import lab1.HotDog.Enums.Additional;
import lab1.HotDog.Enums.Cheese;
import lab1.HotDog.Enums.Drink;
import lab1.HotDog.Enums.Protein;

import java.util.List;

public class HotDog {

	private Drink drink;
	private Protein protein;
	private Cheese cheese;
	private List<Additional> additional;

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public List<Additional> getAdditional() {
		return additional;
	}

	public void setAdditional(List<Additional> additional) {
		this.additional = additional;
	}
}

package Bean;
import java.util.List;

import Enums.CheeseEnum;
import Enums.DrinkEnum;
import Enums.ProteinEnum;

public class HotDog {
	
	private CheeseEnum cheese;
	private ProteinEnum protein;
	private List<String> additionalIngredient;
	private DrinkEnum drink;
	
	public HotDog(CheeseEnum cheese, ProteinEnum protein, List<String> additionalIngredient, DrinkEnum drink) {
		super();
		this.cheese = cheese;
		this.protein = protein;
		this.additionalIngredient = additionalIngredient;
		this.drink = drink;
	}
	
	public CheeseEnum getCheese() {
		return cheese;
	}
	public void setCheese(CheeseEnum cheese) {
		this.cheese = cheese;
	}
	public ProteinEnum getProtein() {
		return protein;
	}
	public void setProtein(ProteinEnum protein) {
		this.protein = protein;
	}
	public List<String> getAdditionalIngredient() {
		return additionalIngredient;
	}
	public void setAdditionalIngredient(List<String> additionalIngredient) {
		this.additionalIngredient = additionalIngredient;
	}
	public DrinkEnum getDrink() {
		return drink;
	}
	public void setDrink(DrinkEnum drink) {
		this.drink = drink;
	}
	
}

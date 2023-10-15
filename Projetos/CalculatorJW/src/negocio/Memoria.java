package negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Memoria {

	private String digits = "";
	private final List<String> operadores;
	private Double n1, n2;
	private String operator;
	private Boolean valorDado = true;

	public Memoria() {
		operadores = new ArrayList<>();
		operadores.add("+");
		operadores.add("-");
		operadores.add("*");
		operadores.add("/");
	}

	public void setNumerous(String digits) {
		this.digits += digits;
	}

	public void setOperates() {

		for(String op : operadores) {
			if(digits.contains(op)) {
				operator = op;
				return;
			}
		}
	}


	public Boolean getValorDado() {
		return valorDado;
	}

	public void setValorDado(Boolean valorDado) {
		this.valorDado = valorDado;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public String getDigits() {
		return digits;
	}

	public void defineNumerous() {

		setOperates();
		String[] nums = digits.split(Pattern.quote(operator));
		n1 = Double.parseDouble(nums[0]);
		n2 = Double.parseDouble(nums[1]);

	}

	public void clear() {

		digits = "";
		n1 = 0.0;
		n2 = 0.0;
		operator = "";
		valorDado = true;
	}

	public double calculator() {
		defineNumerous();
		switch (operator) {
		case "+":
			return n1+n2;
		case "-":
			return n1-n2;
		case "*":
			return n1*n2;
		case "/":
			return n1/n2;
		default:
			break;
		}
		return 0;
	}
}



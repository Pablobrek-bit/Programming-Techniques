import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

	public double summation(double[] arrayNumbs) {

		double total_sum = 0;

		for (int i = 0; i < arrayNumbs.length; i++) {
			total_sum += arrayNumbs[i];
		}

		return total_sum;
	}

	public void evenNumbers(int startNumb, int finalNumb) {

		for (int i = startNumb; i < finalNumb; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public double average(double[] arrayNumbs1, double[] arrayNumbs2) {

		double average = 0;
		double sum1 = summation(arrayNumbs1);
		double sum2 = summation(arrayNumbs2);

		average = (sum1 + sum2) / (arrayNumbs1.length + arrayNumbs2.length);

		return average;
	}

	public double weightedAverage(double[] arrayNumbs, double[] arrayWeights) {

		double weightedAverage = 0;

		for (int i = 0; i < arrayNumbs.length; i++) {
			weightedAverage += (arrayNumbs[i] * arrayWeights[i]);
		}

		return weightedAverage / summation(arrayWeights);
	}

	public int countElement(double[] arrayNumbs1, double[] arrayNumbs2, double element) {

		int count = 0;

		for (int i = 0; i < arrayNumbs1.length; i++) {
			if (arrayNumbs1[i] == element) {
				count++;
			}
		}

		for (int i = 0; i < arrayNumbs2.length; i++) {
			if (arrayNumbs2[i] == element) {
				count++;
			}
		}

		return count;
	}

	public double[] copyArray(double[] arrayNumbs) {

		double[] copyArray = new double[arrayNumbs.length];

		for (int i = 0; i < arrayNumbs.length; i++) {
			copyArray[i] = arrayNumbs[i];
		}

		return copyArray;
	}

	public double[] ascendingOrder(double[] arrayNumbs) {

		double[] ascendingOrder = copyArray(arrayNumbs);
		double aux = 0;

		for (int i = 0; i < ascendingOrder.length; i++) {
			for (int j = 0; j < ascendingOrder.length; j++) {
				if (ascendingOrder[i] < ascendingOrder[j]) {
					aux = ascendingOrder[i];
					ascendingOrder[i] = ascendingOrder[j];
					ascendingOrder[j] = aux;
				}
			}
		}

		return ascendingOrder;
	}

	public boolean verifyAscending(double[] arrayNumbs) {

		boolean isAscending = true;

		for (int i = 0; i < arrayNumbs.length - 1; i++) {
			if (arrayNumbs[i] > arrayNumbs[i + 1]) {
				return isAscending = false;
			}
		}

		return isAscending;
	}

	public double higherValue(double[] arrayNumbs, int k) {
		if (k > arrayNumbs.length) {
			return -1;
		}

		double[] ascendingOrder = ascendingOrder(arrayNumbs);

		return ascendingOrder[ascendingOrder.length - k];
	}

	public double lowestValue(double[] arrayNumbs, int k) {
		if (k > arrayNumbs.length) {
			return -1;
		}

		double[] ascendingOrder = ascendingOrder(arrayNumbs);

		return ascendingOrder[k - 1];
	}

	public boolean verifyEqual(double[] arrayNumbs1, double[] arrayNumbs2) {

		boolean isEqual = true;

		if (arrayNumbs1.length != arrayNumbs2.length) {
			return isEqual = false;
		}

		for (int i = 0; i < arrayNumbs1.length; i++) {
			if (arrayNumbs1[i] != arrayNumbs2[i]) {
				return isEqual = false;
			}
		}

		return isEqual;
	}

	public double potency(double base, double exponent) {

		return Math.pow(base, exponent);
	}

	public boolean primeNumb(int numb) {

		boolean isPrime = true;

		for (int i = 2; i < numb; i++) {
			if (numb % i == 0) {
				return isPrime = false;
			}
		}

		return isPrime;
	}

	public List<Double> occurrences(double[] arrayNumbs1, double[] arrayNumbs2) {

		List<Double> occurrences = new ArrayList<Double>();

		for (int i = 0; i < arrayNumbs1.length; i++) {
			for (int j = 0; j < arrayNumbs2.length; j++) {
				if (arrayNumbs1[i] == arrayNumbs2[j]) {
					occurrences.add(arrayNumbs1[i]);
				}
			}
		}

		return occurrences;
	}

	public List<Double> removeElement(double[] arrayNumbs, double element) {

		List<Double> removeElement = new ArrayList<Double>();

		for (int i = 0; i < arrayNumbs.length; i++) {
			if (arrayNumbs[i] != element) {
				removeElement.add(arrayNumbs[i]);
			}
		}

		return removeElement;
	}

	public boolean palindrome(String word) {

		boolean isPalindrome = true;
		String reverseWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}

		if (!word.equals(reverseWord)) {
			return isPalindrome = false;
		}

		return isPalindrome;
	}

	public boolean numbPrime(int numb) {
		return primeNumb(numb);
	}

	public String invertWord(String word) {

		String invertWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			invertWord += word.charAt(i);
		}

		return invertWord;
	}

	public double compoundInterest(double initialValue, double interestRate, int time) {

		return initialValue * Math.pow((1 + interestRate), time);
	}

	public boolean perfectNumber(int numb) {

		boolean isPerfect = true;
		int sum = 0;

		for (int i = 1; i < numb; i++) {
			if (numb % i == 0) {
				sum += i;
			}
		}

		if (sum != numb) {
			return isPerfect = false;
		}

		return isPerfect;
	}

	public void decreaseVector(int tam) {

		int[] array = new int[tam];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		while (tam > 1) {
			array = Arrays.copyOf(array, tam - 1);
			tam--;
		}
	}

	public void quest22a(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public void quest22b(int n) {

		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" @ ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
	}

	public void quest22c(int n){

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
			  if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
				System.out.print("@");
			  } else if (i == j) {
				System.out.print("@");
			  } else if (i == n / 2 && j == n / 2) {
				System.out.print("@");
			  } else {
				System.out.print(" ");
			  }
			}
			System.out.println();
		}
	}

	public void quest22d(int n){

		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = Math.min(Math.min(i, j), Math.min(n - 1 - i, n - 1 - j));
                System.out.print(Math.abs(value - (n - 1) / 2) + " ");
            }
            System.out.println();
        }
	}
}

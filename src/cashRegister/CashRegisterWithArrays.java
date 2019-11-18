package cashRegister;

import java.util.Scanner;

public class CashRegisterWithArrays {

	public static void main(String[] args) {
		// open scanner
		Scanner kb = new Scanner(System.in);

		// ask for and initialize item price and amount tendered as doubles
		System.out.println("Enter price of item: ");
		double itemPrice = kb.nextDouble();
		System.out.println("Enter amount tendered: ");
		double amountTendered = kb.nextDouble();

		// quick decision on how to act based on amounts
		if (itemPrice > amountTendered) {
			System.out.println("Please confirm price and amount tendered, amount tendered too low.");
		} else if (itemPrice == amountTendered) {
			System.out.println("Exact amount tendered.");
		} else {
			String changeText = makeChange(itemPrice, amountTendered); // go to method to calculate and produce change
																		// String
			System.out.println(changeText);
		}

		kb.close();
	}

	public static String makeChange(double price, double tendered) {
		// initialize all needed information since everything lives in an if statement
		String output = "";
		double[] billCoinAmount = { 100, 20, 10, 5, 1, .25, .1, .05, .01 };
		int[] changeNumber = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String[] changeText = { " $100 [hundreds]", " $20 [twenties]", " $10 [tens]", " $5 [fives]", " $1 [ones]",
				" $0.25 [quarters]", " $0.10 [dimes]", " $0.05 [nickels]", " $0.01 [pennies]" };

//		int bill100 = 100, bill20 = 20, bill10 = 10, bill5 = 5, bill1 = 1;
//		double coin25 = 0.25, coin10 = 0.10, coin5 = 0.05, coin1 = 0.01;
//		int hundreds = 0, twenties = 0, tens = 0, fives = 0, ones = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;

		// calculate needed change, add amount to prevent double rounding errors (s.t.
		// change >> buffer >> errors)
		double changeNeeded = (tendered - price) + 0.000001;

		output = "Provide the customer with :"; // start the output, new lines added if the bill/coin is needed

		for (int i = 0; i < changeNumber.length; i++) {
			if (changeNeeded >= billCoinAmount[i]) {
				changeNumber[i] = (int) (changeNeeded / billCoinAmount[i]);
				changeNeeded = changeNeeded - (changeNumber[i] * billCoinAmount[i]);
				output += ("\n" + changeNumber[i] + changeText[i]);
			}
		}

		return output;
	}

}

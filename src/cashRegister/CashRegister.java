package cashRegister;

import java.util.Scanner;

public class CashRegister {

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
			String changeText = makeChange(itemPrice, amountTendered); // go to method to calculate and produce change String
			System.out.println(changeText);
		}
		
		kb.close();
	}

	public static String makeChange(double price, double tendered) {
		// initialize all needed information since everything lives in an if statement
		String output = "";
		int bill100 = 100, bill20 = 20, bill10 = 10, bill5 = 5, bill1 = 1;
		double coin25 = 0.25, coin10 = 0.10, coin5 = 0.05, coin1 = 0.01;
		int hundreds = 0, twenties = 0, tens = 0, fives = 0, ones = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		
		// calculate needed change, add amount to prevent double rounding errors (s.t. change >> buffer >> errors)
		double changeNeeded = (tendered - price) + 0.000001;
		
		output = "Provide the customer with :"; // start the output, new lines added if the bill/coin is needed
		if (changeNeeded >= bill100) {
			hundreds = (int)(changeNeeded/bill100);
			changeNeeded = changeNeeded - (hundreds*bill100);
			output += ("\n" + hundreds + " $100 [hundreds]");
		}
		if (changeNeeded >= bill20) {
			twenties = (int)(changeNeeded/bill20);
			changeNeeded = changeNeeded - (twenties*bill20);
			output += ("\n" + twenties + " $20 [twenties]");
		}
		if (changeNeeded >= bill10) {
			tens = (int)(changeNeeded/bill10);
			changeNeeded = changeNeeded - (tens*bill10);
			output += ("\n" + tens + " $10 [tens]");
		}
		if (changeNeeded >= bill5) {
			fives = (int)(changeNeeded/bill5);
			changeNeeded = changeNeeded - (fives*bill5);
			output += ("\n" + fives + " $5 [fives]");
		}
		if (changeNeeded >= bill1) {
			ones = (int)(changeNeeded/bill1);
			changeNeeded = changeNeeded - (ones*bill1);
			output += ("\n" + ones + " $1 [ones]");
		}
		if (changeNeeded >= coin25) {
			quarters = (int)(changeNeeded/coin25);
			changeNeeded = changeNeeded - (quarters*coin25);
			output += ("\n" + quarters + " $0.25 [quarters]");
		}
		if (changeNeeded >= coin10) {
			dimes = (int)(changeNeeded/coin10);
			changeNeeded = changeNeeded - (dimes*coin10);
			output += ("\n" + dimes + " $0.10 [dimes]");
		}
		if (changeNeeded >= coin5) {
			nickels = (int)(changeNeeded/coin5);
			changeNeeded = changeNeeded - (nickels*coin5);
			output += ("\n" + nickels + " $0.05 [nickels]");
		}
		if (changeNeeded >= coin1) {
			pennies = (int)(changeNeeded/coin1);
			changeNeeded = changeNeeded - (pennies*coin1);
			output += ("\n" + pennies + " $0.01 [pennies]");
		}
		
		// potential array: [ double-billCoinAmount, int-billCoinCount, String-billCoinString ]
		// if (changeNeeded >= billCoinAmount[i]) {
		//    billCoinCount[i] = (int)(changeNeeded/billCoinAmount[i];
		//    changeNeeded = changeNeeded - ( billCoinCount[i] / billCoinAmount[i] );
		//    output += ("/n" + billCoinCount[i] + billCoinString[i]);
		
		return output;
	}
	
	
	
}

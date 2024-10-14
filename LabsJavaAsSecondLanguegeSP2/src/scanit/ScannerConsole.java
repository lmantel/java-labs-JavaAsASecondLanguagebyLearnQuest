package scanit;

import java.util.Scanner;
import java.io.IOException;

public class ScannerConsole {
	

	public double getTotal(double cst, int amt) {
		double cost = cst;
		int num = amt;
		double tot = cost * num;
		return tot;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ScannerConsole sc = new ScannerConsole();
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String userName = myScan.nextLine();
				
		System.out.println("Enter the number of items purchased");
		int items = myScan.nextInt();
		
		System.out.println("Enter the price of items purchased");
		double price = myScan.nextDouble();
		
		double total = sc.getTotal(price, items);
		
		System.out.println("Greetings " + userName);
		System.out.println("The number of items is " + items);
		System.out.println("The price is " + price);
		System.out.println("The total is " + total);
		myScan.close();
		
	}

}
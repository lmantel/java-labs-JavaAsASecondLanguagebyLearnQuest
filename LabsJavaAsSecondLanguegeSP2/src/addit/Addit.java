package addit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Addit {
	

	public int AddEm(int numA, int numB) {
		int sum = numA + numB;
		return sum;
	}

	public String getName(String nm) {
		return "Greetings " + nm + "\n";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Addit myAddit = new Addit();
		BufferedReader readit = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter yout name");
		
		String myname = readit.readLine();
		String ident = myAddit.getName(myname);
		
		System.out.println(ident);
		
		System.out.println("Enter first number to add");
		String num = readit.readLine();
		
		int num0 = Integer.parseInt(num);
		
		System.out.println("Enter 2nd number to add");
		num = readit.readLine();
		
		int numb1 = Integer.parseInt(num);
		int tot = myAddit.AddEm(num0, numb1);
		
		System.out.println("The sum of " + num0 + " and " + numb1 + " is " + tot);	
		
	}

}

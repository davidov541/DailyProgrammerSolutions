package net.davidmcginnis.dailyprogrammer.vampirenumbers;

import java.util.ArrayList;

public class VampireNumbersMain {
	public static void main(String[] args) {
		IVampireNumberFactory factory = new RecursiveVampireNumberFactory();
		if(args.length != 2)
		{
			System.out.println("You must provide two numbers for the program to use.");
			return;
		}
		int numDigits = Integer.parseInt(args[0]);
		int numFactors = Integer.parseInt(args[1]);
		if(numDigits < 2)
		{
			System.out.println("Number of digits must be at least 2.");
		}
		if(numFactors < 1)
		{
			System.out.println("Number of factors must be at least 1.");
		}
		ArrayList<VampireNumber> numbers = factory.getVampireNumbers(numDigits, numFactors);
		if(numbers.size() == 0)
		{
			System.out.println("No vampire numbers exist for these parameters.");
		}
		for(int i = 0; i < numbers.size(); i++)
		{
			System.out.println(numbers.get(i).toString());
		}
	}
}
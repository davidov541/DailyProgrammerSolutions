package net.davidmcginnis.dailyprogrammer.vampirenumbers;

import java.util.ArrayList;

public class VampireNumbersMain {
	public static void main(String[] args) {
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
		ArrayList<VampireNumber> numbers = getVampireNumbers(numDigits, numFactors);
		if(numbers.size() == 0)
		{
			System.out.println("No vampire numbers exist for these parameters.");
		}
		for(int i = 0; i < numbers.size(); i++)
		{
			System.out.println(numbers.get(i).toString());
		}
	}
	
	private static ArrayList<VampireNumber> getVampireNumbers(int digits, int factors)
	{
		ArrayList<VampireNumber> numbers = new ArrayList<VampireNumber>();
		int minResult = (int)Math.pow(10,  digits - 1);
		int maxResult = minResult * 10;
		for(int result = minResult; result < maxResult; result++)
		{
			VampireNumber number = tryGetVampireNumber(result);
			if(number != null)
			{
				numbers.add(number);
			}
		}
		return numbers;
	}
	
	private static VampireNumber tryGetVampireNumber(int result)
	{
		String strResult = Integer.toString(result);
		if(strResult.lastIndexOf('0') != strResult.indexOf('0'))
		{
			return null;
		}
		ArrayList<Integer> elements = new ArrayList<Integer>();
		for(int i = 0; i < strResult.length(); i++)
		{
			elements.add(Integer.parseInt(strResult.substring(i, i + 1)));
		}
		return tryGetVampireNumber(elements, new ArrayList<Integer>(), result);
	}
	
	private static VampireNumber tryGetVampireNumber(ArrayList<Integer> elementsLeft, ArrayList<Integer> elementsPlaced, int expectedResult)
	{
		if(elementsLeft.size() == 0)
		{
			int result = 1;
			ArrayList<Integer> fullNumbers = new ArrayList<Integer>();
			for(int i = 0; i < elementsPlaced.size(); i += 2)
			{
				int num = elementsPlaced.get(i) * 10 + elementsPlaced.get(i + 1);
				result *= num;
				fullNumbers.add(num);
			}
			if(expectedResult == result)
			{
				return new VampireNumber(result, fullNumbers);
			}
			return null;
		}
		for(int i = 0; i < elementsLeft.size(); i++)
		{
			int newIndex = elementsLeft.remove(i);
			elementsPlaced.add(newIndex);
			VampireNumber num = tryGetVampireNumber(elementsLeft, elementsPlaced, expectedResult);
			if(num != null)
			{
				return num;
			}
			elementsPlaced.remove(elementsPlaced.size() - 1);
			elementsLeft.add(newIndex);
		}
		return null;
	}
}
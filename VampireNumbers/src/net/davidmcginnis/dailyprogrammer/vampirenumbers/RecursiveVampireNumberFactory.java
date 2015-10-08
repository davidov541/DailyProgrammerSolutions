package net.davidmcginnis.dailyprogrammer.vampirenumbers;

import java.util.ArrayList;

public class RecursiveVampireNumberFactory implements IVampireNumberFactory {

	@Override
	public ArrayList<VampireNumber> getVampireNumbers(int numDigits, int numFactors) {
		ArrayList<VampireNumber> numbers = new ArrayList<VampireNumber>();
		int minResult = (int)Math.pow(10,  numDigits - 1);
		int maxResult = minResult * 10;
		for(int result = minResult; result < maxResult; result++)
		{
			VampireNumber number = tryGetVampireNumber(result, numDigits / numFactors);
			if(number != null)
			{
				numbers.add(number);
			}
		}
		return numbers;
	}

	
	private VampireNumber tryGetVampireNumber(int result, int digitsInFangs)
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
		return tryGetVampireNumber(elements, new ArrayList<Integer>(), result, digitsInFangs);
	}
	
	private VampireNumber tryGetVampireNumber(ArrayList<Integer> elementsLeft, ArrayList<Integer> elementsPlaced, int expectedResult, int digitsInFangs)
	{
		if(elementsLeft.size() == 0)
		{
			int result = 1;
			ArrayList<Integer> fullNumbers = new ArrayList<Integer>();
			for(int i = 0; i < elementsPlaced.size(); i += digitsInFangs)
			{
				int num = 0;
				for(int j = i; j < i + digitsInFangs; j++)
				{
					num = num * 10 + elementsPlaced.get(j);
				}
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
			VampireNumber num = tryGetVampireNumber(elementsLeft, elementsPlaced, expectedResult, digitsInFangs);
			if(num != null)
			{
				return num;
			}
			elementsPlaced.remove(elementsPlaced.size() - 1);
			elementsLeft.add(i, newIndex);
		}
		return null;
	}
}

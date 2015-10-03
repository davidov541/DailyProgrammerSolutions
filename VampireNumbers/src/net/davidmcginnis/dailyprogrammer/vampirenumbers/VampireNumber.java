package net.davidmcginnis.dailyprogrammer.vampirenumbers;

import java.util.ArrayList;

public class VampireNumber {
	private int _result;
	private ArrayList<Integer> _factors;
	
	public VampireNumber(int result, ArrayList<Integer> factors)
	{
		_result = result;
		_factors = factors;
	}
	
	public int getResult()
	{
		return _result;
	}
	
	public ArrayList<Integer> getFactors()
	{
		return _factors;
	}
	
	@Override
	public String toString()
	{
		String result = _result + " = ";
		for(int i = 0; i < _factors.size(); i++)
		{
			result += _factors.get(i);
			if(i + 1 != _factors.size())
			{
				result += " * ";
			}
		}
		return result;
	}
}

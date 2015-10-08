package net.davidmcginnis.dailyprogrammer.vampirenumbers.tests;

import java.util.ArrayList;
import org.junit.Assert;
import net.davidmcginnis.dailyprogrammer.vampirenumbers.*;

public class VampireNumberFactoryTests {
	protected void runTest(IVampireNumberFactory factory, int numDigits, int numFactors)
	{
		ArrayList<VampireNumber> actual = factory.getVampireNumbers(numDigits, numFactors);
		int expected = getExpectedVampireNumbers(numDigits, numFactors);
		Assert.assertEquals(expected, actual.size());
	}
	
	private int getExpectedVampireNumbers(int numDigits, int numFactors)
	{
		if(numDigits == 4 && numFactors == 2)
		{
			return 7;
		}
		else if(numDigits == 6 && numFactors == 3)
		{
			return 17;
		}
		else if(numDigits == 6 && numFactors == 2)
		{
			return 149;
		}
		else if(numDigits == 8 && numFactors == 4)
		{
			return 34;
		}
		return 0;
	}
}

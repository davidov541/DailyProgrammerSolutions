package net.davidmcginnis.dailyprogrammer.vampirenumbers;

import java.util.ArrayList;

public interface IVampireNumberFactory {
	ArrayList<VampireNumber> getVampireNumbers(int numDigits, int numFactors);
}

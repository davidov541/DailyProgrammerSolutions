package net.davidmcginnis.dailyprogrammer.vampirenumbers.tests;

import org.junit.Test;
import net.davidmcginnis.dailyprogrammer.vampirenumbers.RecursiveVampireNumberFactory;

public class RecursiveVampireNumberFactoryTests extends VampireNumberFactoryTests {

	@Test
	public void testGetVampireNumbers_twoFour() {
		runTest(new RecursiveVampireNumberFactory(), 4, 2);
	}

	@Test
	public void testGetVampireNumbers_threeSix() {
		runTest(new RecursiveVampireNumberFactory(), 6, 3);
	}

	@Test
	public void testGetVampireNumbers_twoSix() {
		runTest(new RecursiveVampireNumberFactory(), 6, 2);
	}

	@Test
	public void testGetVampireNumbers_fourEight() {
		runTest(new RecursiveVampireNumberFactory(), 8, 4);
	}

}

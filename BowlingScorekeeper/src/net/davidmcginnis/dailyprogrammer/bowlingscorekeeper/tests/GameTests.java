package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import net.davidmcginnis.dailyprogrammer.bowlingscorekeeper.Game;

public class GameTests {

	@Test
	public void testPerfectGame() {
		Game g = Game.parseGame("X X X X X X X X X XXX");
		assertEquals(300, g.getScore(), 0.1);
	}

	@Test
	public void testChallenge1() {
		Game g = Game.parseGame("X -/ X 5- 8/ 9- X 81 1- 4/X");
		assertEquals(137, g.getScore(), 0.1);
	}

	@Test
	public void testChallenge2() {
		Game g = Game.parseGame("62 71 X 9- 8/ X X 35 72 5/8");
		assertEquals(140, g.getScore(), 0.1);
	}

	@Test
	public void testChallenge3() {
		Game g = Game.parseGame("62 71 X 9- 8/ X X 35 72 53");
		assertEquals(130, g.getScore(), 0.1);
	}
}

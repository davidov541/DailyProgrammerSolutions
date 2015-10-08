package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import net.davidmcginnis.dailyprogrammer.bowlingscorekeeper.Frame;

public class FrameTests {

	@Test
	public void testNormal() {
		Frame f = Frame.parseFrame("34");
		assertEquals(7, f.getScore());
	}

	@Test
	public void testGutterBallFirst() {
		Frame f = Frame.parseFrame("-3");
		assertEquals(3, f.getScore());
	}

	@Test
	public void testGutterBallLast() {
		Frame f = Frame.parseFrame("3-");
		assertEquals(3, f.getScore());
	}
	
	@Test
	public void testStrike() {
		Frame f = Frame.parseFrame("X");
		assertEquals(10, f.getScore());
	}

	@Test
	public void testSpare() {
		Frame f = Frame.parseFrame("6/");
		assertEquals(10, f.getScore());
	}

	@Test
	public void testSpareNotLast() {
		Frame f = Frame.parseFrame("6/");
		Frame next = Frame.parseFrame("X");
		f.setNext(next);
		assertEquals(20, f.getScore());
	}

	@Test
	public void testSpareNextNotStrike() {
		Frame f = Frame.parseFrame("6/");
		Frame next = Frame.parseFrame("53");
		f.setNext(next);
		assertEquals(15, f.getScore());
	}
	
	@Test
	public void testStrikeNotLast() {
		Frame f = Frame.parseFrame("X");
		Frame next = Frame.parseFrame("X");
		f.setNext(next);
		assertEquals(20, f.getScore());
	}
	
	@Test
	public void testStrikeNextNotStrike() {
		Frame f = Frame.parseFrame("X");
		Frame next = Frame.parseFrame("53");
		f.setNext(next);
		assertEquals(18, f.getScore());
	}
	
	@Test
	public void testStrikeNextStrike() {
		Frame f = Frame.parseFrame("X");
		Frame next = Frame.parseFrame("X");
		f.setNext(next);
		Frame nextNext = Frame.parseFrame("X");
		next.setNext(nextNext);
		assertEquals(30, f.getScore());
	}
	
	@Test
	public void testStrikeNextStrikeNextNextNotStrike() {
		Frame f = Frame.parseFrame("X");
		Frame next = Frame.parseFrame("X");
		f.setNext(next);
		Frame nextNext = Frame.parseFrame("56");
		next.setNext(nextNext);
		assertEquals(25, f.getScore());
	}
}

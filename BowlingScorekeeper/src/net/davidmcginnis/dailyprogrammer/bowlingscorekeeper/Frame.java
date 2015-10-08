package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper;

public class Frame {
	private int firstBall;
	private int secondBall;
	private int thirdBall;

	private Frame nextFrame;

	private Frame(int firstBall, int secondBall)
	{
		this(firstBall, secondBall, 0);
	}
	
	private Frame(int firstBall, int secondBall, int thirdBall)
	{
		this.firstBall = firstBall;
		this.secondBall = secondBall;
		this.thirdBall = thirdBall;
		this.nextFrame = null;
	}
	
	public static Frame parseFrame(String frameRep)
	{
		int firstBall = parseBall(frameRep.substring(0, 1), 0);
		int secondBall = 0;
		if(frameRep.length() > 1)
		{
			secondBall = parseBall(frameRep.substring(1, 2), firstBall);
		}
		int thirdBall = 0;
		if(frameRep.length() > 2)
		{
			thirdBall = parseBall(frameRep.substring(2, 3), secondBall);
		}
		return new Frame(firstBall, secondBall, thirdBall);
	}
	
	private static int parseBall(String str, int previousBalls)
	{
		if(str.equals("X"))
		{
			return 10;
		}
		else if(str.equals("/"))
		{
			return 10 - previousBalls;
		}
		else if(str.equals("-"))
		{
			return 0;
		}
		else
		{
			return Integer.parseInt(str);
		}
	}
	
	public int getScore()
	{
		int score = firstBall + secondBall + thirdBall;
		if(firstBall == 10 && nextFrame != null)
		{
			score += nextFrame.firstBall + nextFrame.secondBall;
			if(nextFrame.firstBall == 10 && nextFrame.nextFrame != null)
			{
				score += nextFrame.nextFrame.firstBall;
			}
		}
		else if(score == 10 && nextFrame != null)
		{
			score += nextFrame.firstBall;
		}
		return score;
	}

	public Frame getNext()
	{
		return this.nextFrame;
	}
	
	public void setNext(Frame next)
	{
		this.nextFrame = next;
	}
}

package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper;

public class Frame {
	private int firstBall;
	private int secondBall;

	private Frame nextFrame;

	private Frame(int firstBall, int secondBall)
	{
		this.firstBall = firstBall;
		this.secondBall = secondBall;
		this.nextFrame = null;
	}
	
	public static Frame parseFrame(String frameRep)
	{
		int firstBall = 0;
		int secondBall = 0;
		if(frameRep == "X")
		{
			firstBall = 10;
		}
		else
		{
			if(frameRep.substring(0, 1) != "-")
			{
				firstBall = Integer.parseInt(frameRep.substring(0, 1));
			}
			if(frameRep.substring(1, 1) == "/")
			{
				secondBall = 10 - firstBall;
			}
			else if(frameRep.substring(1, 1) != "-")
			{
				secondBall = Integer.parseInt(frameRep.substring(1, 1));
			}
		}
		return new Frame(firstBall, secondBall);
	}
	
	public int getScore()
	{
		int score = firstBall + secondBall;
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

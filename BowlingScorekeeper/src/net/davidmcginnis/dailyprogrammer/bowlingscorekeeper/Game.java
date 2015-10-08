package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper;

public class Game {
	private Frame firstFrame;
	
	private Game(Frame firstFrame)
	{
		this.firstFrame = firstFrame;
	}
	
	public static Game parseGame(String game)
	{
		String[] frames = game.split(" ");
		Frame previousFrame = null;
		Frame firstFrame = null;
		for(int i = 0; i < frames.length; i++)
		{
			Frame currFrame = Frame.parseFrame(frames[i]);
			if(previousFrame != null)
			{
				previousFrame.setNext(currFrame);
			}
			else
			{
				firstFrame = currFrame;
			}
			previousFrame = currFrame;
		}
		return new Game(firstFrame);
	}
	
	public int getScore()
	{
		int score = 0;
		Frame currFrame = firstFrame;
		while(currFrame != null)
		{
			score += currFrame.getScore();
			currFrame = currFrame.getNext();
		}
		return score;
	}	
}

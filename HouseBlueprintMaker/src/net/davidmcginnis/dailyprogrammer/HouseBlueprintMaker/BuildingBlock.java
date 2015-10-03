package net.davidmcginnis.dailyprogrammer.HouseBlueprintMaker;

import java.util.Random;

public class BuildingBlock extends Block {
	private Random _rand = new Random();
	private boolean _displayDoor = false;

	public boolean getIsOnGroundFloor()
	{
		return below instanceof EmptyBlock;
	}
	
	public BuildingBlock(boolean displayDoor)
	{
		_displayDoor = displayDoor;
	}
	
	@Override
	public void Draw(char[][] output, int outputLine, int outputCol) {
		// Fill block with door or window.
		if(_displayDoor)
		{
			output[outputLine + 1][outputCol + 1] = '|';
			output[outputLine + 1][outputCol + 2] = '|';
		}
		else if(_rand.nextBoolean())
		{
			output[outputLine + 1][outputCol + 1] = 'o';
		}
	}

}

package net.davidmcginnis.HouseBlueprintMaker;

public class EmptyBlock extends Block {

	public EmptyBlock()
	{
	}
	
	@Override
	public void Draw(char[][] output, int outputLine, int outputCol) {
		if(left != null && left instanceof BuildingBlock)
		{
			DrawHorizontalWall(output, left, outputLine, outputCol - 1);
		}
		if(right != null && right instanceof BuildingBlock)
		{
			DrawHorizontalWall(output, right, outputLine, outputCol + 3);
		}
		if(above != null && above instanceof BuildingBlock)
		{
			DrawVerticalWall(output, above, outputLine - 1, outputCol);
		}
		if(below != null && below instanceof BuildingBlock)
		{
			DrawVerticalWall(output, below, outputLine + 3, outputCol);
		}
	}

	private void DrawHorizontalWall(char[][] output, Block side, int outputLine, int outputCol)
	{
		if(output[outputLine][outputCol] != ' ')
		{
			output[outputLine][outputCol] = '+';
		}
		else
		{
			output[outputLine][outputCol] = '|';
		}
		output[outputLine + 1][outputCol] = '|';
		if(output[outputLine + 2][outputCol] != ' ')
		{
			output[outputLine + 2][outputCol] = '+';
		}
		else
		{
			output[outputLine + 2][outputCol] = '|';
		}
	}
	
	private void DrawVerticalWall(char[][] output, Block side, int outputLine, int outputCol)
	{
		if(output[outputLine][outputCol - 1] == '|' || 
				output[outputLine - 1][outputCol - 1] == '|')
		{
			output[outputLine][outputCol - 1] = '+';
		}
		else
		{
			output[outputLine][outputCol - 1] = '-';
		}
		output[outputLine][outputCol] = '-';
		output[outputLine][outputCol + 1] = '-';
		output[outputLine][outputCol + 2] = '-';
		if(output[outputLine][outputCol + 3] != ' ' || 
				output[outputLine - 1][outputCol + 3] == '|')
		{
			output[outputLine][outputCol + 3] = '+';
		}
		else
		{
			output[outputLine][outputCol + 3] = '-';
		}
	}
}

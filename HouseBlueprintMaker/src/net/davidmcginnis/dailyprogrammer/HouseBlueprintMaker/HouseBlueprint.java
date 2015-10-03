package net.davidmcginnis.dailyprogrammer.HouseBlueprintMaker;

public class HouseBlueprint {
	private char[][] _output;
	
	public HouseBlueprint(int numberOfLines, int numberOfCols)
	{
		int numberOf_outputCols = (numberOfCols + 1)*5;
		int numberOf_outputLines = (numberOfLines + 1)*3 + numberOf_outputCols;
		_output = new char[numberOf_outputLines][numberOf_outputCols];
		for(int line = 0; line < _output.length; line++)
		{
			for(int col = 0; col < _output[line].length; col++)
			{
				_output[line][col] = ' ';
			}
		}
	}

	public void createRooms(Block[][] input)
	{
		for(int line = 0; line < input.length; line++)
		{
			for(int col = 0; col < input[line].length; col++)
			{
				input[line][col].Draw(_output, line * 3 + _output[0].length, col * 4);
			}
		}
	}

	public void drawRoofs()
	{
		int colIndex = 0;
		while(colIndex < _output[0].length)
		{
			int topLine = 0;
			while(topLine < _output.length && _output[topLine][colIndex] == ' ')
			{
				topLine++;
			}
			if(topLine == _output.length || _output[topLine][colIndex] == '+')
			{
				colIndex++;
				continue;
			}
			int roofWidth = getRoofWidth(_output, topLine, colIndex - 1);
			drawRoof(_output, topLine - 1, colIndex, roofWidth);
			colIndex += roofWidth;
		}
	}
	
	@Override
	public String toString() {
		String totalOutput = "";
		for(int line = 0; line < _output.length; line++)
		{
			boolean foundOutput = false;
			String output = "";
			for(int col = 0; col < _output[line].length; col++)
			{
				output += _output[line][col];
				foundOutput |= _output[line][col] != ' ';
			}
			if(foundOutput)
			{
				totalOutput += output + "\n";
			}
		}
		return totalOutput;
	}
	
	private int getRoofWidth(char[][] _output, int lineIndex, int startingCol)
	{
		int width = 0;
		startingCol++;
		while(startingCol < _output[lineIndex].length && _output[lineIndex][startingCol] == '-')
		{
			width++;
			startingCol++;
		}
		return width;
	}
	
	private void drawRoof(char[][] _output, int lineIndex, int colIndex, int roofWidth)
	{
		int midPoint = colIndex + roofWidth / 2;
		for(int col = colIndex; col < midPoint; col++)
		{
			_output[lineIndex--][col] = '/';
		}
		_output[lineIndex++][midPoint] = 'A';
		for(int col = midPoint + 1; col < colIndex + roofWidth; col++)
		{
			_output[lineIndex++][col] = '\\';
		}
	}
}

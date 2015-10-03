package net.davidmcginnis.HouseBlueprintMaker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public abstract class Block {
	public Block above;
	public Block below;
	public Block left;
	public Block right;
	private static Random _rand = new Random();
	
	public boolean getHasBlockAbove()
	{
		return getHasBlockToDirection(above);
	}
	
	public boolean getHasBlockToLeft()
	{
		return getHasBlockToDirection(left);
	}
	
	public boolean getHasBlockToRight()
	{
		return getHasBlockToDirection(right);
	}
	
	public boolean getHasBlockBelow()
	{
		return getHasBlockToDirection(below);
	}
	
	private boolean getHasBlockToDirection(Block side)
	{
		return side != null && side instanceof BuildingBlock;
	}
	
	public boolean getHasBlockAboveAndToLeft()
	{
		return above != null && above.getHasBlockToLeft();
	}
	
	public boolean getHasBlockAboveAndToRight()
	{
		return above != null && above.getHasBlockToRight();
	}
	
	public boolean getIsOnGroundFloor()
	{
		return false;
	}
	
	public static Block[][] createBlocksFromFile(String filePath)
	{
		Object[] lines = readInLines(filePath);
		if(lines == null)
		{
			return null;
		}
		int numberOfLines = lines.length + 2;
		int numberOfCols = getNumberOfColumns(lines);
		
		Block[][] blocks = new Block[numberOfLines][numberOfCols];
		createEmptyRow(blocks, 0);
		for(int lineIndex = 1; lineIndex < numberOfLines - 1; lineIndex++)
		{
			String line = (String)lines[lineIndex - 1];
			parseLineFromFile(blocks, numberOfLines, numberOfCols, lineIndex, line);
		}
		createEmptyRow(blocks, blocks.length - 1);
		return blocks;
	}

	private static void createEmptyRow(Block[][] blocks, int lineIndex) {
		for(int colIndex = 0; colIndex < blocks[0].length; colIndex++)
		{
			blocks[lineIndex][colIndex] = createBlock(lineIndex == 0 ? null : blocks[lineIndex - 1][colIndex], colIndex == 0 ? null : blocks[lineIndex][colIndex - 1], false, false);
		}
	}
	
	public abstract void Draw(char[][] output, int outputLine, int outputCol);

	private static Object[] readInLines(String filePath) {
		Object[] lines;
		try {
			lines = Files.lines(Paths.get(filePath)).toArray();
		} catch (IOException e) {
			System.out.println("The file " + filePath + " was not found.");
			return null;
		}
		return lines;
	}

	private static int getNumberOfColumns(Object[] lines) {
		int numberOfCols = 0;
		for(int lineIndex = 0; lineIndex < lines.length; lineIndex++)
		{
			String line = (String)lines[lineIndex];
			if(line.length() > numberOfCols)
			{
				numberOfCols = line.length();
			}
		}
		return numberOfCols + 2;
	}

	private static void parseLineFromFile(Block[][] blocks, int numberOfLines, int numberOfCols, int lineIndex, String line) {
		int maxColIndex = blocks[0].length - 1;
		int doorIndex = _rand.nextInt(numberOfCols - 2) + 1;
		blocks[lineIndex][0] = createBlock(lineIndex == 0 ? null : blocks[lineIndex - 1][0], null, false, false);
		for(int col = 1; col < numberOfCols - 1; col++)
		{
			if(col <= line.length() && line.charAt(col - 1) == '*')
			{
				blocks[lineIndex][col] = createBlock(blocks[lineIndex - 1][col], blocks[lineIndex][col - 1], true, lineIndex == numberOfLines - 2 && col == doorIndex);
			}
			else
			{
				blocks[lineIndex][col] = createBlock(blocks[lineIndex - 1][col], blocks[lineIndex][col - 1], false, false);
			}
		}
		blocks[lineIndex][maxColIndex] = createBlock(lineIndex == 0 ? null : blocks[lineIndex - 1][maxColIndex], blocks[lineIndex][maxColIndex - 1], false, false);
	}

	private static Block createBlock(Block aboveBlock, Block leftBlock, boolean isPartOfBuilding, boolean shouldDisplayDoor) {
		Block block;
		if(isPartOfBuilding)
		{
			block = new BuildingBlock(shouldDisplayDoor);
		}
		else
		{
			block = new EmptyBlock();
		}
		if(aboveBlock != null)
		{
			aboveBlock.below = block;
			block.above = aboveBlock;
		}
		if(leftBlock != null)
		{
			leftBlock.right = block;
			block.left = leftBlock;
		}
		return block;
	}
}

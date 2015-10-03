package net.davidmcginnis.dailyprogrammer.HouseBlueprintMaker;

public class HouseBlueprintMaker {

	public static void main(String[] args) {
		if(args.length < 1)
		{
			System.out.println("Not enough arguments!");
			return;
		}
		Block[][] blocks = Block.createBlocksFromFile(args[0]);
		if(blocks == null)
		{
			return;
		}

		HouseBlueprint blueprint = new HouseBlueprint(blocks.length, blocks[0].length);
		blueprint.createRooms(blocks);
		blueprint.drawRoofs();
		
		System.out.println(blueprint.toString());
	}
}

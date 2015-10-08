package net.davidmcginnis.dailyprogrammer.bowlingscorekeeper;

import java.io.*;

public class BowlingScorekeeper {

	public static void main(String[] args) {
		if(args.length == 0)
		{
			System.out.println("The single argument should be a file path.");
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	Game g = Game.parseGame(line);
		    	System.out.println(g.getScore());
		    }
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file " + args[0] + ".");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Tiles.*;

public class Board<Tile> {
	private List <Tile> tiles;
	
	public Board () throws FileNotFoundException {
		this.tiles = new ArrayList<Tile>();
		Scanner input;
		input = new Scanner(new File("./resources/LandTile.txt"));
		
		String [] tile = input.nextLine().split(",");
		int id = Integer.parseInt(tile[0]);
		int value = Integer.parseInt(tile[2]);
		int rent = Integer.parseInt(tile[3]);
			
		LandTile landTile = new Property(id, tile[1], value, rent, tile[4]);
		
	}
}

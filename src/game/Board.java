package game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tiles.*;

public class Board {
	private List <Tile> tiles;
	
	public Board () throws FileNotFoundException {
		this.tiles = new ArrayList<Tile>();
		makeTiles();
		
	}
	
	public void makeTiles() throws FileNotFoundException {
		Scanner input = new Scanner(new File("./resources/LandTile.txt"));
		Tile initTile = null;
		while (input.hasNextLine()) {
			String [] tile = input.nextLine().split(",");
			
			if (tile.length == 5) { // if the tile has 5 tokens its a property
				int id = Integer.parseInt(tile[0]);
				int value = Integer.parseInt(tile[2]);
				int rent = Integer.parseInt(tile[3]);
				initTile = new Property(id, tile[1], value, rent, tile[4]);
			}
			else if (tile.length == 4 ){ //if the tile has 4 tokens its a station
				//initiliaze a station here
			}
			this.tiles.add(initTile);
		}
		
	}
}

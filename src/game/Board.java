package game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import tiles.*;

public class Board {
	private Map<Integer, Tile> tiles;

	public Board () throws FileNotFoundException {
		this.tiles = new HashMap<>();
		makeLandTiles();
		makePoolTiles();

	}

	public void makeLandTiles() throws FileNotFoundException {
		Scanner input = new Scanner(new File("./resources/LandTile.txt"));
		int id;
		String name;
		int value;
		int rent;
		LandTile initTile = null;

		while (input.hasNextLine()) {
			String [] tile = input.nextLine().split(",");
			if (tile.length == 1){
				id = Integer.parseInt(tile[0]);
				if (id == 30){
					initTile = new CornerTile(id);
				}
			}
			else if (tile.length == 5) { // if the tile has 5 tokens its a property
				id = Integer.parseInt(tile[0]);
				name = tile[1];
				value = Integer.parseInt(tile[2]);
				rent = Integer.parseInt(tile[3]);
				initTile = new Property(id, name, value, rent, tile[4]);
				this.tiles.put(id, initTile);
			}
			else if (tile.length == 4 && tile[1].contains("Station")){ //if the tile has 4 tokens its a station
				id = Integer.parseInt(tile[0]);
				name = tile[1];
				value = Integer.parseInt(tile[2]);
				rent = Integer.parseInt(tile[3]);
				initTile = new Station(id, name, value, rent);
				this.tiles.put(id, initTile);
			}
			else if (tile.length == 4 && tile[1].contains("Company")) {
				id = Integer.parseInt(tile[0]);
				name = tile[1];
				value = Integer.parseInt(tile[2]);
				rent = Integer.parseInt(tile[3]);
				initTile = new Utility(id, name, value, rent);
				this.tiles.put(id, initTile);
			}
		}
	}

	public void makePoolTiles() throws FileNotFoundException {

		}

	public Tile getTile(int index) {
		return this.tiles.get(index);
	}
}

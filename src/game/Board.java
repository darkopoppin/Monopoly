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
	private Map<Integer, Tile> landTiles;

	public Board () throws FileNotFoundException {
		this.landTiles = new HashMap<>();
		makeLandTiles();
		makePoolTiles();
	}
	
	/*
	 * creates HashMap of LandTiles, that maps the position of a LandTile on the board
	 * to the LandTile object
	 */
	public void makeLandTiles() throws FileNotFoundException {
		//LandTile.txt contains property,station and utility attributes
		Scanner input = new Scanner(new File("./resources/LandTile.txt"));

		while (input.hasNextLine()) {
			String [] landTile = input.nextLine().split(",");
			/*if (tile.length == 1){
				id = Integer.parseInt(tile[0]);
				if (id == 30){
					initTile = new CornerTile(id);
				}
			}*/
			// if the landTile has 5 tokens it's a property
			//
			if (landTile.length == 5) {
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Property(id, name, value, rent, landTile[4]);
				this.landTiles.put(id, initTile);
			}
			else if (landTile.length == 4 && landTile[1].contains("Station")){ //if the tile has 4 tokens its a station
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Station(id, name, value, rent);
				this.landTiles.put(id, initTile);
			}
			else if (landTile.length == 4 && landTile[1].contains("Company")) {
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Utility(id, name, value, rent);
				this.landTiles.put(id, initTile);
			}
		}
	}

	public void makePoolTiles() throws FileNotFoundException {
			
		}

	public Tile getPosition(int index) {
		return this.landTiles.get(index);
	}
}

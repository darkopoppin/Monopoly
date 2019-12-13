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
	private Map<Integer, LandTile> landTiles;
	private Map<Integer, PoolTile> poolTiles;
	private final ArrayList<Integer> PoolTilesPosistion= new ArrayList<>();
	
	public Board () throws FileNotFoundException {
		this.landTiles = new HashMap<>();
		this.poolTiles = new HashMap<>();
		makeLandTiles();
		makePoolTiles();
	}
	
	/*
	 * add Properties, Companies and Stations to the tiles map
	 * (Key, Value) = (a position of a LandTile on the board, the object LandTile)
	 */
	public void makeLandTiles() throws FileNotFoundException {
		//LandTile.txt contains property,station and utility attributes
		Scanner input = new Scanner(new File("./resources/LandTile.txt"));

		while (input.hasNextLine()) {
			String [] landTile = input.nextLine().split(",");

			// if the landTile has 5 tokens it's a property
			if (landTile.length == 5) {
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Property(id, name, value, rent, landTile[4]);
				this.landTiles.put(id, initTile);
			}
			// contains Station in the name
			else if (landTile[1].contains("Station")){ //if the tile has 4 tokens its a station
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Station(id, name, value, rent);
				this.landTiles.put(id, initTile);
			}
			// if it contains Company in the name 
			else if (landTile[1].contains("Company")) {
				int id = Integer.parseInt(landTile[0]);
				String name = landTile[1];
				int value = Integer.parseInt(landTile[2]);
				int rent = Integer.parseInt(landTile[3]);
				
				LandTile initTile = new Utility(id, name, value, rent);
				this.landTiles.put(id, initTile);
			}
		}
	}
	/*
	 * adds PoolTiles to the tiles map 
	 * (Key, Value) = (a position of a PoolTile on the board, the object PoolTile)
	 */
	public void makePoolTiles() throws FileNotFoundException {
		Scanner input = new Scanner(new File("./resources/PoolTiles.txt"));
		
		while(input.hasNextLine()) {
			int id = Integer.parseInt(input.nextLine());
			PoolTile pool = new PoolTile(id);
			this.poolTiles.put(id,pool);
			this.PoolTilesPosistion.add(id);
		}
		
	}
	/*
	 * returns the tile at the index
	 */
	public LandTile getLandTile(int index) {
		return this.landTiles.get(index);
	}
	
	public PoolTile getPoolTile(int index) {
		return this.poolTiles.get(index);
	}
	
	public ArrayList getPositions () {
		return this.PoolTilesPosistion;
	}
}

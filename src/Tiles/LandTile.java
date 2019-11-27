package Tiles;
import game.Player;

public abstract class LandTile<Tile> {
	final int ID;
	String name;
	int value;
	int rent;
	Player owner;
	boolean mortgageStatus = false;
	
	public LandTile(int id, String name, int value, int rent) {
		this.ID = id;
		this.name = name;
		this.value = value;
		this.rent = rent;
	}
	
	public void setMortgageStatus() {
		
	}
	
	
}

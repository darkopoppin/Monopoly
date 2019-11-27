package Tiles;
import game.Player;

public abstract class LandTile {
	final int ID;
	String name;
	int value;
	int rent;
	Player owner;
	
	public LandTile(int id, String name, int value) {
		this.ID = id;
		this.name = name;
		this.value = value;
	}
}

package tiles;
import game.Player;

public abstract class LandTile extends Tile {
	String name;
	int value;
	int rent;
	Player owner;
	Boolean mortgageStatus;

	
	public LandTile(int id, String name, int value, int rent) {
		super(id);
		this.name = name;
		this.value = value;
		this.rent = rent;
	}

	public void setMortgageStatus(Boolean status){
		mortgageStatus = status;
	}

	private int calculateRent(){
		return rent;
	}

	public String getName(){
		return name;
	}

	public int getValue(){
		return value;
	}

	public int getRent(){
		return calculateRent();
	}
	public Boolean getMortgageStatus(){
		return mortgageStatus;
	}

	public Player getOwner(){
		return owner;
	}

	public void setOwner(Player playerName){
		owner = playerName;
	}
	
	public void setMortgageStatus() {
		
	}
	
	
}

package game;
import tiles.CornerTile;
import tiles.LandTile;
import tiles.PoolTile;
import tiles.Tile;

import java.util.HashSet;
import java.util.Random;


public class Player {

	private int playerId;
	private String playerName;
	private int balance;
	private int currPosition;
	private int mortgageOwed;
	private HashSet<LandTile> propertyOwned;
	private Boolean inJail;

	public Player(String playerName) {
		//this.playerId = player;
		this.playerName = playerName;
		this.balance = 1500;
		this.propertyOwned = new HashSet<>();
		this.inJail = false;
	}
	/*
	 * action for landTile object
	 *
	 */
	public void action(Tile tile){
		switch(tile.getClassName()) {
		case "LandTile":
			LandTile landTile = (LandTile) tile;
			if (landTile.getOwner() != null)
				this.buyProperty(landTile);
			else
				this.payRent(landTile);
		}
	}

	public void action(PoolTile poolTile) {

	}

	public void action(CornerTile cornerTile) {

	}

	public void auction(){
		// Auction between players
		// increasing bid prices
	}

	public Boolean rollDice(){
		// Some random number between 2 - 12
		Random r = new Random();
		int dice1 =  r.nextInt((6 - 2) + 1) + 2;
		int dice2 =  r.nextInt((6 - 2) + 1) + 2;


		currPosition = currPosition + dice1 + dice2;

		if(currPosition >= 40){
			balance = balance + 200;
			currPosition = currPosition - 40;

		}
		
		if(dice1 == dice2)
			return true;
		else 
			return false;


	}

	public void setUpTrade(){

	}

	public void setBalance(int newBalance){
		balance = newBalance;

	}

	public void buyProperty(LandTile p){
		if(balance >= p.getValue()){
			// ask for choice
			setBalance(balance - p.getValue());
			propertyOwned.add(p);
			p.setOwner(this);
		} else {
			// Display in the UI that there is insufficient funds
			// Open option to mortgage properties
		}


	}

	public void payRent(LandTile property){
		if(property.getMortgageStatus() == false){
			int rent = property.getRent();
			if(balance > rent){
				// pay the rent
				}
			else {
				// Force the user to mortgage owned properties
				// Make the player pick which properties to mortgage
				// Automatically pay rent when the player finishes mortgaging properties
				//

				}
			}

		}

	public void mortgage(LandTile property){
		property.setMortgageStatus(true);
		balance = balance + (property.getValue()/2);
	}

	public void payMortgage(LandTile property){
		property.setMortgageStatus(false);
		int due = property.getValue()/2;
		balance = (int) (balance - due - due * 0.1);
	}

	public int getBalance(){
		return balance;
	}

	public String getPlayerName(){
		return playerName;
	}
	
	public int getPosition() {
		return this.currPosition;
	}

}

package game;
import tiles.CornerTile;
import tiles.LandTile;
import tiles.PoolTile;
import tiles.Tile;

import java.util.HashSet;
import java.util.Random;
import java.util.*;

public class Player {

	//private int playerId; - not used at the moment 
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
	 * Depending on the type of Tile
	 * Buy a property, pay rent, draw a card from a pool
	 */
	public <T extends Object> void action(T tile){
		String name = tile.getClass().getName();
		switch(tile.getClass().getName()) {
		case "tiles.Property":
		case "tiles.Utility":
		case "tiles.Station":
			LandTile landTile = (LandTile) tile;
			if (landTile.getOwner() == null)
				this.buyProperty(landTile);
			else if (landTile.getOwner() != this)
				this.payRent(landTile);
			break;
	
		case "tiles.PoolTile":
			PoolTile poolTile = (PoolTile) tile;
			poolTile.drawCard();
		}
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


		this.currPosition = this.currPosition + dice1 + dice2;

		if(currPosition >= 40){
			balance = balance + 200;
			currPosition = currPosition - 40;

		}
		
		//later we will use it for jail
		if(dice1 == dice2)
			return true;
		else
			return false;


	}

	public void setUpTrade(){

	}

	public void changeBalance(int newBalance){
		this.balance += newBalance;
	}

	public void buyProperty(LandTile p){
		if(balance >= p.getValue()){
			// ask for choice
			changeBalance(- p.getValue());
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
				Player owner = property.getOwner();
				changeBalance(-rent);
				owner.changeBalance(rent);
				}
			else {
				// Force the user to mortgage owned properties
				// Make the player pick which properties to mortgage
				// Automatically pay rent when the player finishes mortgaging properties

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
	
	public void doCard(Tile tile) {
		PoolTile poolTile = (PoolTile) tile;
		String [] card = poolTile.drawCard();
		int value = Integer.parseInt(card[1]);
		//if the value of the card is 2 digits -> chest card
		if (value >= 10 || value < -10) {
			this.changeBalance(value);
		}
		
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

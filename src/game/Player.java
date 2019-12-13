package game;
import tiles.CornerTile;
import tiles.LandTile;
import tiles.PoolTile;


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
	private int jailTime;

	public Player(String playerName) {
		//this.playerId = player;
		this.playerName = playerName;
		this.balance = 1500;
		this.propertyOwned = new HashSet<>();
		this.inJail = false;
		this.jailTime = 0;
	}
	
	/*
	 * action for a LandTile such as Property, Station or Utility
	 */
	public void action(LandTile landTile){
		Scanner input = new Scanner(System.in);

		if (landTile.getOwner() == null) {
			System.out.println("Buy the property?");
			String respond = input.nextLine();
			if (respond.equals("y"))
				this.buyProperty(landTile);
		}
		else if (landTile.getOwner() != this)
			this.payRent(landTile);
	}
	/*
	 * action for a PoolTile
	 */
	public void action(PoolTile poolTile) {
		this.doCard(poolTile);
		
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

		if (this.inJail && (this.jailTime > 3 || dice1 == dice2)) {
			this.inJail = false;
			this.jailTime = 0;
			this.currPosition = this.currPosition + dice1 + dice2;
		}
		else if (this.inJail) {
			this.jailTime++;
		}
		else {
			this.currPosition = this.currPosition + dice1 + dice2;
			
			if(currPosition >= 40){
				balance = balance + 200;
				currPosition = currPosition - 40;
			}
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
	
	public void doCard(PoolTile poolTile) {
		String [] card = poolTile.drawCard();
		int value = Integer.parseInt(card[1]);
		//if the value of the card is 2 digits -> chest card
		System.out.println(card[0]);
		if (value >= 10 || value < -10) {
			this.changeBalance(value);
		}
		else
			this.currPosition = value;
		
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
	
	public void goToJail() {
		this.inJail = true;
	}
}

package game;
import tiles.LandTile;

import java.util.HashSet;
import java.util.Random;


public class Player {
	
	private int playerId;
	private String playerName;
	private int balance;
	private int currPosition;
	private int mortgageOwed;
	private HashSet propertyOwned;
	
	public Player(String playerName) {
		//this.playerId = player;
		this.playerName = playerName;
		this.balance = 1500;
		this.propertyOwned = new HashSet<LandTile>();
	}
	public void action(){

	}
	
	public void auction(){

	}
	
	public void rollDice(){
		// Some random number between 2 - 12
		Random r = new Random();		
		int roll =  r.nextInt((12 - 2) + 1) + 2;
		System.out.println(roll);
		currPosition = currPosition + roll;
	}

	public void setUpTrade(){

	}

	public void setBalance(int newBalance){
		balance = newBalance;

	}

	public void buyProperty(LandTile p){
		if(balance >= p.getValue()){
			setBalance(balance - p.getValue());
			propertyOwned.add(p);
			p.setOwner(this);
		} else {
			// DIsplay in the UI that there is insufficient funds
			System.out.println("Insufficient funds");
		}
		

	}

	public void payRent(LandTile payup){
		int rent = payup.getRent();
		if(balance > rent){
			// pay the rent
		}
		else if(rent > balance){
			// Force the user to mortgage owned properties
			// Code here 

			}
		}

	public void mortgage(){

	}

	public void payMortgage(){

	}

	public int getBalance(){
		return balance;
	}

	public String getPlayerName(){
		return playerName;
	}

}

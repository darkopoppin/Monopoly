package game;
import tiles.PoolTile;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import tiles.LandTile;

public class GameEnvironment {

	private Board board;
	private List <Player> player_array;
	
	public GameEnvironment (Player host) { // called when a player create a server
		//initialize server here
		this.player_array = new ArrayList<>();
		this.player_array.add(host);
	}
	
	/*
	 * the main loop of the game
	 */
	public void start_game() { // when player click start game
		this.board = makeBoard(); //initialize board
		ArrayList PoolTilesPositions = this.board.getPositions();
		
		while (this.player_array.size() != 0) { //while there are more than 1 player keep the game running
			for (Player player : this.player_array) { //each player's turn
				player.rollDice();
				int position = player.getPosition();
				//determine the type of Tile
				if (PoolTilesPositions.contains(position)) {
					PoolTile tile = this.board.getPoolTile(position);
					player.action(tile);
				}
				else if (position == 30) {
					player.goToJail();
				}
				else {
					LandTile tile = this.board.getLandTile(position);
					player.action(tile);
				}
			}
		}
		
	}
	/*
	 * initializes the board with all the tiles
	 */
	public Board makeBoard() {
		Board board = null;
		try {
			board = new Board(); // Pass the number of players
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	public void join_server(Player player) {
		this.player_array.add(player);
		//add player to the server
	}
}

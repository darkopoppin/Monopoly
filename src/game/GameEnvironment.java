package game;

import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {

	Board board;
	List <Player> player_array;
	
	public GameEnvironment (Player host) { // called when a player create a server
		//initialize server here
		this.player_array = new ArrayList<>();
		this.player_array.add(host);
	}
	
	public void start_game() { // when player click start game
		this.board = makeBoard();
		
	}
	public Board makeBoard() {
		Board board = new Board(); // Pass the number players
		return board;
	}
	
	public void join_server(Player player) {
		//add player to the server
		
	}
}

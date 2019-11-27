package game;

public class Player {
	
	int player_id;
	String player_name;
	int balance;
	int curr_position;
	
	public Player(String name) {
		this.player_name = name;
	}
	
	public int roll_dice() {
		return 0;
	}
	
}

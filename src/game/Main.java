package game;

import gui.Window;

public class Main {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		Player host = new Player("player1");
		GameEnvironment game = new GameEnvironment(host);
		game.start_game();

		//Window.run();
	}


}

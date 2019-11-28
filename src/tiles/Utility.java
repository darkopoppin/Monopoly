package tiles;
import game.Player;
import game.Board;
// import LandTile;


public class Utility extends LandTile {

	private int rent;

	public Utility(int ID, String name, int value, int rent) {
		super(ID, name, value, rent);
	}
	
	// public int calculateRent() {
	// 	int [] lst = {4, 12, 28, 38};
	// 	int count = 0;
	// 	for(int index : propertyOwned) {
	// 		if(contains(lst, index)){
	// 			count++;
	// 		}
	// 	}
	// 	return count * rent;
		
	// }

	private boolean contains(int[] lst, int index) {
		for(int i : lst){
			if(i == index) return true;
		}
		return false;
	}
}

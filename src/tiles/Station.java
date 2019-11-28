package tiles;
<<<<<<< HEAD

import game.Player;
import game.Board;

public class Station extends LandTile {

	private int rent;
=======
import game.Player;
public class Station extends LandTile{
>>>>>>> 82bce5f19630b4d00e2249395fb712ebea600ddd

    public Station(int ID, String name, int value, int rent){
        super(ID, name, value, rent);
    }

<<<<<<< HEAD
    public int calculateRent(){
        int [] lst = {5, 15, 25, 35};
=======
    /*public int calculateRent(){
>>>>>>> 82bce5f19630b4d00e2249395fb712ebea600ddd
        int count = 0;
        for(int index : propertyOwned){
            if(contains(lst, index)){
                count++;
            }
        }
<<<<<<< HEAD
        return count*rent;
    }

    private boolean contains(int[] lst, int index) {
		for(int i : lst){
			if(i == index) return true;
		}
		return false;
	}
}
=======
    }*/
}
>>>>>>> 82bce5f19630b4d00e2249395fb712ebea600ddd

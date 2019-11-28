package tiles;

import game.Player;
import game.Board;

public class Station extends LandTile{

    public Station(int ID, String name, int value, int rent){
        super(ID, name, value, rent);
    }
}
    /*public int calculateRent(){
        int [] lst = {5, 15, 25, 35};
    }
}
        return count*rent;
    }

    private boolean contains(int[] lst, int index) {
		for(int i : lst){
			if(i == index) return true;
		}
		return false;
	}
=======
    }*/


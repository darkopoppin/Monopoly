package tiles;
import game.Player;
public class Station extends LandTile{

    public Station(int ID, String name, int value, int rent){
        super(ID, name, value, rent);
    }

    /*public int calculateRent(){
        int count = 0;
        for(int index : propertyOwned){
            if(contains(lst, index)){
                count++;
            }
        }
    }*/
}

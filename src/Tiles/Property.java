package Tiles;
import game.Player;;

public class Property extends LandTile{
    private int houses;
    private String colourGroup;

    public Property(int ID, String name, int value, int rent, Boolean mortgageStatus, Player owner, int houses, String colourGroup){
        super(ID, name, value, rent, mortgageStatus, owner);
        this.houses = houses;
        this.colourGroup = colourGroup;

    }

    public static void Upgrade(){

    }

    public int calculateRent(){
        int rent = 0;
        // Multiplier given the houses * rent

        return rent;
    }

    public String getColourGroup(){
        String colourGroup = null;

        return colourGroup;
    }
}
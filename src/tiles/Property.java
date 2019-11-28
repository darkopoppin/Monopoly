package tiles;
import game.Player;;

public class Property extends LandTile{
    private int houses;
    private String colourGroup;

    public Property(int ID, String name, int value, int rent, String colourGroup){
        super(ID, name, value, rent);
        this.houses = 0;
        this.colourGroup = colourGroup;

    }

    public void upgrade(){
        // Check if the player owns all properties in the same colourGroup => Increase house count
       houses++;
        
    }

    public int calculateRent(){
        // Rent modifier given the houses
        if(houses != 0){
        rent = super.getRent();
        } 
        else if(houses == 1){
            rent = rent*5;
        }
        else if(houses == 2){
            rent = rent*15;
        }
        else if(houses == 3){
            rent = rent*35;
        }
        else if(houses == 4){
            rent = rent*42;
        }
        else if(houses == 5){
            rent = rent*50;
        }
        return rent;
    }

    public String getColourGroup(){
        return colourGroup;
    }

}
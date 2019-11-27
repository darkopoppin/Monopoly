package Tiles;
import game.Player;;

public class Property extends LandTile{
    private int houses;
    private String colourGroup;

    public Property(int ID, String name, int value, int rent, int houses, String colourGroup){
        super(ID, name, value, rent);
        this.houses = houses;
        this.colourGroup = colourGroup;

    }

    public void Upgrade(){
        // Increase house count
        houses ++;
        
    }

    public int calculateRent(){
        // Rent modifier given the houses
        if(houses != 0){
        int rent = super.getRent();
        } else{
            if(colourGroup == "Purple"){

            }
            else if(colourGroup == "Teal"){

            }
            else if(colourGroup == "Pink"){

            }
            else if(colourGroup == "Orange"){

            }
            else if(colourGroup == "Red"){

            }
            else if(colourGroup == "Yellow"){

            }
            else if(colourGroup == "Green"){

            }
            else if(colourGroup == "Blue"){
                
            }

        }
        return rent;
    }

    public String getColourGroup(){
        String colourGroup = null;

        return colourGroup;
    }

}
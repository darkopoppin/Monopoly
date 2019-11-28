package tiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class PoolTile extends Tile{
	
	private String tile;
	private ArrayList <String> pool;

	public PoolTile(int id) throws FileNotFoundException{
		super(id);
		if(id==2 || id==17 || id ==33){
			this.pool = new ArrayList<>();
			makeChest();
		}
		else{
			this.pool = new ArrayList<>();
			makeChance();
		}
	}

	public void makeChest() throws FileNotFoundException{
		Scanner input = new Scanner(new File("./resources/ChestCards.txt"));
		
		while(input.hasNextLine()){
			tile = input.nextLine();
			pool.add(tile);
		}
		input.close();
	}

	public void makeChance() throws FileNotFoundException{
		Scanner input = new Scanner(new File("./resourcesChanceCards.txt"));

		while(input.hasNextLine()){
			tile = input.nextLine();
			pool.add(tile);
		}
		input.close();
	}

	public String drawCard(){
		Random rand = new Random();
		int rItem = rand.nextInt(pool.size());
		String randomCard = pool.get(rItem);
		return randomCard;
	} 
}

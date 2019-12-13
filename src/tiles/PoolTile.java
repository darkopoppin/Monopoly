	package tiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class PoolTile{

	private ArrayList <String> pool;
	int id;
	public PoolTile(int id) throws FileNotFoundException{
		this.id = id;
		this.pool = new ArrayList<>();
		//there are chests only at these positions
		if(id==2 || id==17 || id ==33){
			makeChest();
		}
		//at all the other positions chances exist
		else{
			makeChance();
		}
	}

	public void makeChest() throws FileNotFoundException{
		Scanner input = new Scanner(new File("./resources/ChestCards.txt"));

		while(input.hasNextLine()){
			String card = input.nextLine();
			pool.add(card);
		}
		input.close();
	}

	public void makeChance() throws FileNotFoundException{
		Scanner input = new Scanner(new File("./resources/ChanceCards.txt"));

		while(input.hasNextLine()){
			String card = input.nextLine();
			pool.add(card);
		}
		input.close();
	}

	public String [] drawCard(){
		Random rand = new Random();
		int rItem = rand.nextInt(pool.size());
		String randomCard = pool.get(rItem);
		return randomCard.split(",");
	}
}

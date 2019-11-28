package tiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PoolTile extends Tile{
	private HashMap <Integer, String> pool;
	private final File INPUT;
	
	public PoolTile(int id) {
		super(id);
		this.INPUT = new File("./resources/PoolTile.txt");
		this.pool = new HashMap<>();
	}
	
	public void initializePool() throws FileNotFoundException {
		Scanner input = new Scanner(this.INPUT);
		while (input.hasNextLine()) {
			String [] tile = input.nextLine().split(",");
			this.pool.put(Integer.parseInt(tile[1]), tile[0]);
		}
	}

}

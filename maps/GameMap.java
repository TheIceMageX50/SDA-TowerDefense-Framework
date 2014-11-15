package maps;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import memento.Memento;
import misc.GameEngine;
import misc.TerrainType;


public abstract class GameMap
{
	//TODO Probably remove detail fields?
	protected String detailOne;
	protected String detailTwo;
	protected GridSquare[][] grid;
	protected int width, height;
	protected GridSquare[][] state;
	protected Point defaultTowerPos, defaultTowerPos2, towerPos, towerPos2;
	
	public GameMap()
	{
		this(30, 50);
	}
	
	public GameMap(int width, int height)
	{
		defaultTowerPos = new Point((width / 2) - 1, 1);
		//height -2 accounts for 0-based indices AND that it is to be in second last row.
		defaultTowerPos2 = new Point((width / 2) - 1, height - 2); 
		grid = new GridSquare[height][width];
		loadMapDef("../mapdef.txt");
	}
	
	public abstract void addHomeGrounds();
	public abstract void addNotTraversibleTerrain();
	public abstract void addSurroundingTerrain();
	
	public String toString() {
		//Add some stuff
		return "";
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int val)
	{
		width = val;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int val)
	{
		height = val;
	}
	
	//TODO Probably convert to place wall? Base towers will be 2 per map and we don't have
	//another kind of turret/tower class atm.
	public void placeTower(int x, int y)
	{
		if (grid[x][y].getTerrainType() == TerrainType.BASE_TOWER) {
			System.out.println("No can do..");
		} else {
			grid[x][y] = GridSquare.getGridSquareByType(TerrainType.BASE_TOWER) ;
		}
	}
	
	public void takeTower(int x, int y)
	{
		grid[x][y] = GridSquare.getGridSquareByType(TerrainType.DEFAULT);
	}
	
	public void set(GridSquare[][] g)
	{
		this.state = g;
	}
	
	public Point getDefaultTower1Pos()
	{
		return defaultTowerPos;
	}
	
	public Point getDefaultTower2Pos()
	{
		return defaultTowerPos2;
	}
	
	public Memento saveToMemento()
	{
		return new Memento(state);
	}
	public void  restoreFromMemento(Memento m)
	{
		state = m.getSavedState();
	}
	
	//TODO Probably going to remove this; it's been replaced by part of loadMapDef really.
	/*private void setUpDefaultSquares()
	{
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new GridSquare(TerrainType.DEFAULT);
			}
		}
	}*/
	
	private void loadMapDef(String filepath)
	{
		int lineNo = 0;
		boolean tower1Placed = false, tower2Placed = false;
		Scanner scanner = null;
		GameEngine engine = GameEngine.getInstance();
		try {
			scanner = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			engine.display("mapdef file not found! Exiting... D:");
			System.exit(-1);
		}
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			char ch;
			for (int i = 0; i < line.length(); i++) {
				ch = line.charAt(i);
				if (ch == 'T' && (!tower1Placed || !tower2Placed)) {
					if (!tower1Placed) {
						tower1Placed = true;
						towerPos = new Point(lineNo, i);
						grid[lineNo][i] = GridSquare.getGridSquareByType(parseMapDefToTerrain(ch));
					} else if (!tower2Placed) {
						tower2Placed = true;
						towerPos2 = new Point(lineNo, i);
						grid[lineNo][i] = GridSquare.getGridSquareByType(parseMapDefToTerrain(ch));
					} else { //at this point 2 towers have been detected; do not allow any more.
						engine.display("[Warning] More than 2 Towers found in Mapdef, extras will be treated as default squares.");
						grid[lineNo][i] = GridSquare.getGridSquareByType(TerrainType.DEFAULT);
					}
				} else {
					grid[lineNo][i] = GridSquare.getGridSquareByType(parseMapDefToTerrain(ch));
				}
			}
			lineNo++;
		}
		scanner.close();
		//outer (while) loop has finished, ensure there are 2 towers on map. If there are not,
		//fall back to default positions.
		if (!tower1Placed && !tower2Placed) {
			towerPos = defaultTowerPos;
			grid[towerPos.y][towerPos.x] = GridSquare.getGridSquareByType(TerrainType.BASE_TOWER);
			towerPos2 = defaultTowerPos2;
			grid[towerPos2.y][towerPos2.x] = GridSquare.getGridSquareByType(TerrainType.BASE_TOWER);
		}
	}
	
	private TerrainType parseMapDefToTerrain(char ch)
	{
		switch(ch) {
		case 'X': return TerrainType.MAP_WALL;
		case 'T': return TerrainType.BASE_TOWER;
		case '-': return TerrainType.DEFAULT;
		default: return null;
		}
	}
}

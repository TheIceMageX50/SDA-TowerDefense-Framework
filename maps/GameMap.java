package maps;

import misc.TerrainType;
import memento.Memento;


public abstract class GameMap
{
	protected String detailOne;
	protected String detailTwo;
	protected GridSquare[][] grid;
	protected int width, height;
	protected GridSquare[][] state;
	
	public GameMap()
	{
		this(30, 50);
	}
	
	public GameMap(int width, int height)
	{
		grid = new GridSquare[height][width];
		setUpDefaultSquares();
	}
	
	public abstract void addHomeGround();
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
	public void placeTower(int x, int y)
	{
		if(grid[x][y].getTerrainType()==TerrainType.BASE_TOWER){
			System.out.println("No can do..");
		} else {
			grid[x][y] = new GridSquare( TerrainType.PLACED_WALL ) ;
		}
	}
	
	public void takeTower(int x, int y)
	{
		grid[x][y] = new GridSquare(TerrainType.DEFAULT);
	}
	
	private void setUpDefaultSquares()
	{
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new GridSquare(TerrainType.DEFAULT);
			}
		}
	}
	public void set(GridSquare[][] g)
	{
		this.state = g;
	}
	
	public Memento saveToMemento()
	{
		return new Memento(state);
	}
	public void  restoreFromMemento(Memento m)
	{
		state = m.getSavedState();
	}
	
	
	
	
}

package maps;

import misc.TerrainType;


public abstract class GameMap
{
	protected String detailOne;
	protected String detailTwo;
	protected GridSquare[][] grid;
	protected int width, height;
	
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
	
	private void setUpDefaultSquares()
	{
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new GridSquare(TerrainType.DEFAULT);
			}
		}
	}
}

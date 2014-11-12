package maps;

import misc.TerrainType;

public class LargeHillMap extends GameMap 
{
	
	public LargeHillMap()
	{
		super();
		hillify();
	}
	
	public LargeHillMap(int width, int height)
	{
		super(width, height);
		hillify();
	}

	@Override
	public void addHomeGround() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNotTraversibleTerrain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSurroundingTerrain() {
		// TODO Auto-generated method stub
		
	}
	
	public void hillify()
	{
		int a, b;
		for (int i = 0; i < 10; i++) {
			do {
				a = (int) (Math.random() * grid.length);
				b = (int) (Math.random() * grid[0].length);
			} while (grid[a][b].getTerrainType() == TerrainType.HILLS);
			grid[a][b] = new GridSquare(TerrainType.HILLS);
		}
	}
}
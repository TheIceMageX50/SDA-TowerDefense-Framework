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
	public void addHomeGrounds() {
		// TODO Auto-generated method stub
		
	}

	public void hillify()
	{
		int a, b;
		TerrainType selectedSquareType;
		for (int i = 0; i < 10; i++) {
			do {
				a = (int) (Math.random() * grid.length);
				b = (int) (Math.random() * grid[0].length);
				selectedSquareType = grid[a][b].getTerrainType();
			} while (selectedSquareType == TerrainType.MAP_WALL
					|| selectedSquareType == TerrainType.HILLS
					|| selectedSquareType == TerrainType.BASE_TOWER);
		
			grid[a][b] = GridSquare.getGridSquareByType(TerrainType.HILLS);
		}
	}
}
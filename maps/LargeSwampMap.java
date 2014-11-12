package maps;

import misc.TerrainType;

public class LargeSwampMap extends GameMap
{
	
	public LargeSwampMap()
	{
		super();
		swampify();
	}
	
	public LargeSwampMap(int width, int height)
	{
		super(width, height);
		swampify();
		//give detail one
		//give detail two
		//areas.add("bwn onwognwiugr infowgn");
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
	
	private void swampify()
	{
		int a, b;
		for (int i = 0; i < 10; i++) {
			do {
				a = (int) (Math.random() * grid.length);
				b = (int) (Math.random() * grid[0].length);
			} while (grid[a][b].getTerrainType() == TerrainType.SWAMP_WATER);
			grid[a][b] = new GridSquare(TerrainType.SWAMP_WATER);
		}
	}
}
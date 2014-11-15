package maps;

import misc.GameEngine;
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
	public void addHomeGrounds()
	{
		int tow1X, tow1Y, tow2X, tow2Y;
		tow1X = towerPos.x;
		tow1Y = towerPos.y;
		tow2X = towerPos2.x;
		tow2Y = towerPos2.y;
		GameEngine engine = GameEngine.getInstance();
		engine.renderTowerOnMap(tow1X, tow1Y);
		engine.renderTowerOnMap(tow2X, tow2Y);
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
		TerrainType selectedSquareType;
		for (int i = 0; i < 10; i++) {
			//Loop to ensure Swamp water is not placed over
			//a) previously placed swamp water
			//b) a wall of the map
			//c) one of the player's base towers, an unlikely but dangerous edge case.
			do {
				a = (int) (Math.random() * grid.length);
				b = (int) (Math.random() * grid[0].length);
				selectedSquareType = grid[a][b].getTerrainType();
			} while (selectedSquareType == TerrainType.MAP_WALL
					|| selectedSquareType == TerrainType.SWAMP_WATER
					|| selectedSquareType == TerrainType.BASE_TOWER);
		
			grid[a][b] = GridSquare.getGridSquareByType(TerrainType.SWAMP_WATER);
		}
	}
}
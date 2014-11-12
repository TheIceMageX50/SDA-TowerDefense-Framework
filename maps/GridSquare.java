package maps;

import misc.TerrainType;

public class GridSquare
{
	private TerrainType type;
	
	public GridSquare(TerrainType type)
	{
		this.type = type;
	}
	
	public TerrainType getTerrainType()
	{
		return type;
	}
}

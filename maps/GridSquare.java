package maps;

import java.util.HashMap;
import java.util.Map;

import misc.GameEngine;
import misc.TerrainType;
//http://en.wikipedia.org/wiki/Lazy_initialization#Java
public class GridSquare
{
	private static Map<TerrainType, GridSquare> terrainTypes = new HashMap<>();
	private TerrainType type;
	
	private GridSquare(TerrainType type)
	{
		this.type = type;
	}
	
	public static GridSquare getGridSquareByType(TerrainType type)
	{
		GridSquare grid;
		
		if(!terrainTypes.containsKey(type)) {
			GameEngine engine = GameEngine.getInstance();
			engine.display("[Lazy Initialisation Pattern] GridSquare of type " + type 
					+" was requested for the first time, creating...");
			grid = new GridSquare(type);
			terrainTypes.put(type,grid);
		} else {
			grid = terrainTypes.get(type);
		}
		
		return grid;
	}
	
	public TerrainType getTerrainType()
	{
		return type;
	}
}

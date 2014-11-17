package maps;

import misc.GameEngine;

public class MapFactory 
{
	private int mapWidth, mapHeight;
	
	public MapFactory(int customWidth, int customHeight)
	{
		mapWidth = customWidth;
		mapHeight = customHeight;
	}
	
	public GameMap createDefaultSizeMap(String type) throws Exception 
	{
		GameEngine engine = GameEngine.getInstance();
		engine.display("[Factory Pattern] MapFactory.createDefaultSizeMap() was called. Type requested - "
				+ type);
		GameMap map;
		switch (type) {
		case "LargeHill": map = new LargeHillMap();
		break;
		case "LargeSwamp": map = new LargeSwampMap();
		break;
		case "LargeMap": map = new LargeMap();
		break;
		default: throw new Exception("Invalid type supplied.");
		}
		engine.display("[Factory Pattern] Therefore, returning an instance of " + map.getClass().getName() + ".");
		return map;
	}
	
	public GameMap createCustomSizeMap(String type) throws Exception
	{
		switch (type) {
		case "LargeHill": return new LargeHillMap(mapWidth, mapHeight);
		case "LargeSwamp": return new LargeSwampMap(mapWidth, mapHeight);
		case "LargeMap": return new LargeMap(mapWidth, mapHeight);
		default: throw new Exception("Invalid type supplied.");
		}
	}
}

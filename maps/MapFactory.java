package maps;

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
		switch (type) {
		case "LargeHill": return new LargeHillMap();
		case "LargeSwamp": return new LargeSwampMap();
		case "LargeMap": return new LargeMap();
		default: throw new Exception("Invalid type supplied.");
		}
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

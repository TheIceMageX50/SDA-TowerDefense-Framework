package maps;

public class MapFactory {
	
	public GameMap createMap(String type) throws Exception {
		switch (type) {
		case "LargeHill": return new LargeHillMap();
		case "LargeSwamp": return new LargeSwampMap();
		case "LargeMap": return new LargeMap();
		default: throw new Exception("Invalid type supplied.");
		}
	}
}

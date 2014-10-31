public class LargeMap extends MapFactory {
	Map createMap(String type) {
		if (type.equals("hill")) {
			return new LargeHillMap();
		} else if (type.equals("swamp")) {
			return new LargeSwampMap();
		} else {
			return null;
		}
	}
}
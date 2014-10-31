public abstract class MapFactory {
	abstract Map createMap(String type) ;
	public Map setUpMap(String whatMap) {
		Map map = createMap(whatMap);
		map.addHomeGround();
		map.addNotTraversibleTerrain();
		map.addSurroundingTerrain();
		return map;
	}
}
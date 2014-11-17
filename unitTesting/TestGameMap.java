package unitTesting;

import static org.junit.Assert.*;
import maps.GameMap;
import maps.MapFactory;
import misc.TerrainType;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestGameMap {

	private static GameMap map;
	@BeforeClass
	public static void before() throws Exception
	{
		//N.B. these params only dictate the size of a custom map.
		MapFactory mf = new MapFactory(30, 30);
		map = mf.createDefaultSizeMap("LargeSwamp");
	}

	@Test
	public void testGetWidth() {
		assertTrue(map.getWidth() == 50);
	}

	@Test
	public void testGetHeight() {
		assertTrue(map.getHeight() == 30);
	}

	@Test
	public void testPlaceAndTakeWall() {
		TerrainType t;
		t = map.inspect(1, 1);
		assertEquals(TerrainType.DEFAULT, t);
		map.placeWall(1, 1);
		t = map.inspect(1, 1);
		assertEquals(TerrainType.PLACED_WALL, t);
		map.takeWall(1, 1);
		t = map.inspect(1, 1);
		assertEquals(TerrainType.DEFAULT, t);
	}
}

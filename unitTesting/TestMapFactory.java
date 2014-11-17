package unitTesting;

import static org.junit.Assert.*;
import maps.GameMap;
import maps.LargeHillMap;
import maps.LargeMap;
import maps.LargeSwampMap;
import maps.MapFactory;

import org.junit.Test;

public class TestMapFactory
{

	@Test
	public void testCreateDefaultSizeMap() throws Exception
	{
		MapFactory mf = new MapFactory(50, 30);
		GameMap m1, m2, m3;
		m1 = mf.createDefaultSizeMap("LargeSwamp");
		m2 = mf.createDefaultSizeMap("LargeHill");
		m3 = mf.createDefaultSizeMap("LargeMap");
		
		assertTrue(m1 instanceof LargeSwampMap);
		assertTrue(m2 instanceof LargeHillMap);
		assertTrue(m3 instanceof LargeMap);
	}

}

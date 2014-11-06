package misc;

import maps.GameMap;


public class GameEngine 
{
	private Renderer renderer;
	private SoundEngine se;
	
	public GameEngine(GameMap map)
	{
		renderer = new Renderer(System.out, map);
		se = new SoundEngine();
	}
	
	public void renderMap(GameMap map) 
	{
		renderer.renderMap();
	}
}

package misc;

import maps.GameMap;

public class GameEngine
{
	private static final GameEngine theEngine = new GameEngine();
	private Renderer renderer;
	private SoundEngine se;
	
	private GameEngine()
	{
		//renderer = new Renderer(System.out, map);
		se = new SoundEngine();
	}
	
	public void renderMap() 
	{
		renderer.renderMap();
	}
	
	public void renderTowerOnMap(int x, int y)
	{
		renderer.renderTower(x, y);
	}
	
	public void bindMap(GameMap map)
	{
		theEngine.renderer = new Renderer(System.out, map);
	}
	
	public void display(Object toDisplay)
	{
		renderer.displayToScreen(toDisplay);
	}
	
	public static GameEngine getInstance()
	{
		return theEngine;
	}
}

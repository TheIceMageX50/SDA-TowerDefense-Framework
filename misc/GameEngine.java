package misc;

import maps.GameMap;

public class GameEngine
{
	private static final GameEngine theEngine = new GameEngine();
	private Renderer renderer;
	private SoundEngine se;
	
	private GameEngine()
	{
		initRendererToDisplay();
		se = new SoundEngine();
	}
	
	private void initRendererToDisplay()
	{
		renderer = new Renderer(System.out, null);
	}

	public void renderMap() 
	{
		renderer.renderMap();
	}
	
	public void renderTowerOnMap(int x, int y)
	{
		renderer.renderTower(x, y);
	}
	
	public void renderPlacedWallOnMap(int x, int y)
	{
		renderer.renderPlacedWall(x, y);
	}
	
	public void bindMap(GameMap map)
	{
		theEngine.renderer = new Renderer(System.out, map);
	}
	
	public GameMap getMap()
	{
		return renderer.getMap();
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

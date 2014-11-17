package misc;

import java.util.ArrayList;

import maps.GameMap;

public class GameEngine
{
	private static GameEngine theEngine = null;
	private Renderer renderer;
	private SoundEngine se;
	private static ArrayList<String> preInitPrints = new ArrayList<String>();
	
	private GameEngine()
	{
		preInitPrints.add("[Façade Pattern] Renderer created as underlying part of GameEngine.");
		initRendererToDisplay();
		//renderer is not null now...but might as well print this statement in same way.
		preInitPrints.add("[Façade Pattern] SoundEngine created as underlying part of GameEngine.");
		se = new SoundEngine();
		
		while (!preInitPrints.isEmpty()) {
			renderer.displayToScreen(preInitPrints.remove(0));
		}
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
		
		if (theEngine == null) {
			preInitPrints.add("[Façade Pattern] Creating GameEngine");
			theEngine = new GameEngine();
		}
		return theEngine;
	}
}

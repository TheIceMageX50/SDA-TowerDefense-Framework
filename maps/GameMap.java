package maps;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMap
{
	protected String detailOne;
	protected String detailTwo;
	protected List<Object> areas;
	protected int width, height;
	
	public GameMap()
	{
		areas = new ArrayList<Object>(); //TODO make it a list of something other
										 //than Objects?
	}
	
	public abstract void addHomeGround();
	public abstract void addNotTraversibleTerrain();
	public abstract void addSurroundingTerrain();
	
	public String toString() {
		//Add some stuff
		return "";
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int val)
	{
		width = val;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int val)
	{
		height = val;
	}
}

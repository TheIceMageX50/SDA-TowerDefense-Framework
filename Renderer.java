import java.io.PrintStream;

public class Renderer
{
	private PrintStream screen;
	private GameMap map;

	public Renderer(PrintStream output, GameMap map)
	{
		screen = output;
		this.map = map;
	}
	
	//TODO Create GameMap class
	public void renderMap()
	{
		int height, width;
		//TODO
		//render the map
		height = map.getHeight();
		width = map.getWidth();
		screen.println("Successfully rendered map of dimensions " + width + "x" + height + ".");
	}
}

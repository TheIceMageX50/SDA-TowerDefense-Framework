
public class GameEngine 
{
	private Renderer renderer;
	private SoundEngine se;
	
	public GameEngine(GameMap map)
	{
		renderer = new Renderer(System.out, map);
		se = new SoundEngine();
	}
}

package player;

public interface Command
{
	public void execute();
	public void undo();
}
package memento;

import maps.GridSquare;

public class Memento {
	private GridSquare[][] state;
	
	public Memento(GridSquare[][] stateToSave)
	{
		state = stateToSave;
	}
	public GridSquare[][] getSavedState()
	{
		return state;
	}
}

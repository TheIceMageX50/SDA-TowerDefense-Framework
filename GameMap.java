import java.util.ArrayList;
import java.util.List;

public abstract class GameMap {
	String detailOne;
	String detailTwo;
	List areas;
	int width, height;
	
	public GameMap() {
		areas = new ArrayList();
	}
	
	void addHomeGround() {
		//do stuff
	}
	
	void addNotTraversibleTerrain() {
		//do stuff
	}
	
	void addSurroundingTerrain() {
		//do stuff
	}
	
	public String toString() {
		//Add some stuff
		return "";
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int val) {
		width = val;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int val) {
		height = val;
	}
}

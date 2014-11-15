package misc;

import java.awt.Point;
import java.util.Scanner;

import maps.GameMap;
import maps.MapFactory;
import minions.Minion;
import player.Command;
import player.Player;
import player.PlayerHealCommand;
import towers.BaseTower;
import towers.StrongTowerDecorator;
import towers.Tower;

@SuppressWarnings("unused")
public class GameDriver
{
	static GameEngine engine = GameEngine.getInstance();
	
	public static void main(String[] args) throws Exception //TODO handle exception differently?
	{
		MapFactory mf = new MapFactory(50, 50);
		//this method is where an exception could, but won't, be thrown.
		GameMap map = mf.createDefaultSizeMap("LargeSwamp");
		engine = GameEngine.getInstance();
		engine.bindMap(map);
		//Create Player's Towers
		Tower p1Tow = new BaseTower();
		Point p1Pos = map.getDefaultTower1Pos();
		Player player = new Player("Player1", p1Tow, p1Pos.x, p1Pos.y);
		Tower p2Tow = new StrongTowerDecorator(new BaseTower());
		Point p2Pos = map.getDefaultTower2Pos();
		Player player2 = new Player("Player2",p2Tow, p2Pos.x, p2Pos.y);
		//start game
		engine.display("~~~~~~~Tower Defense Game Framework Demo~~~~~~~");
		map.addHomeGrounds();
		
		//Start of core loop
		while (player.getTower().getHP() > 0 && player2.getTower().getHP() > 0) {
			Scanner scanner = new Scanner(System.in);
			engine.display("Begin Placement phase...");
			engine.display(player.getName() + "'s turn: You have " + player.getPoint() + " points available.");
			takeTurn(player, scanner);
			engine.display(player2.getName() + "'s turn: You have " + player2.getPoint() + " points available.");
			takeTurn(player2, scanner);
			//start wave phase
			for (int i = 0; i < 5; i++) {
				//p1 minion spawn
				Minion p1Min = p1Tow.spawnMinion();
				//p2 minion spawn
				Minion p2Min = p2Tow.spawnMinion();
				//spoof minions finding and confronting one another
				engine.display("Opposing minions have confronted one another. They will engage in combat!");
			    //minions fight
				while (p1Min.getHealth() > 0 && p2Min.getHealth() > 0 /*minions both still alive*/) {
					//TODO randomise who attacks first maybe?
					p1Min.attackObject(p2Min);
					p2Min.attackObject(p1Min);
				}
				//spoof surviving minion finding its way to enemy tower
				//explode on/collide with tower to damage
			//}
			}
		}
			
	}
	
	private static void takeTurn(Player player, Scanner scanner)
	{
		String next;
		do {
			next = scanner.next();
			//engine.display(next); //Instead of printing back, will process Command
			Command command = commandToObject(next, player);
			try {command.execute(); } catch(NullPointerException e) {}
		} while (!next.equals("done"));
	}
	
	private static Command commandToObject(String termInput, Player actingPlayer)
	{
		switch (termInput) {
			case "heal" : return new PlayerHealCommand(actingPlayer.getTower());
			default : return null;
		}
	}
}

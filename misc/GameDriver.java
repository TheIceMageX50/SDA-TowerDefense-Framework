package misc;

import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import maps.GameMap;
import maps.MapFactory;
import minions.Minion;
import player.Player;
import towers.BaseTower;
import towers.StrongTowerDecorator;
import towers.Tower;
import command.Command;
import command.DoneCommand;
import command.PlayerHealCommand;
import command.PlayerPlaceWallCommand;

//@SuppressWarnings("unused")
public class GameDriver
{
	static GameEngine engine;
	static Stack<Command> history = new Stack<Command>();
	
	public static void main(String[] args) throws Exception //TODO handle exception differently?
	{
		engine = GameEngine.getInstance();
		MapFactory mf = new MapFactory(50, 50);
		//this method is where an exception could, but won't, be thrown.
		GameMap map = mf.createDefaultSizeMap("LargeSwamp");
		engine.bindMap(map);
		//Create Player's Towers
		Tower p1Tow = new BaseTower();
		Point p1Pos = map.getTowerPos();
		String p1Name = "Player1", p2Name = "Player2";
		Player player = new Player(p1Name, p1Tow, p1Pos.x, p1Pos.y);
		Tower p2Tow = new StrongTowerDecorator(new BaseTower());
		Point p2Pos = map.getTower2Pos();
		Player player2 = new Player(p2Name, p2Tow, p2Pos.x, p2Pos.y);
		int roundCount = 1;
		//start game
		engine.display("~~~~~~~Tower Defense Game Framework Demo~~~~~~~");
		map.addHomeGrounds();
		
		//Start of core loop
		while (p1Tow.getHP() > 0 && p2Tow.getHP() > 0) {
			Scanner scanner = new Scanner(System.in);
			engine.display("Begin Placement phase...");
			engine.display(p1Name + "'s turn: You have " + player.getPoints() + " points available.");
			takeTurn(player, scanner);
			engine.display(p2Name + "'s turn: You have " + player2.getPoints() + " points available.");
			takeTurn(player2, scanner);
			
			//start wave phase
			for (int i = 0; i < 5; i++) {
				//Report Wave number
				engine.display("Round " + roundCount + " - Wave " + (i + 1));
				//p1 minion spawn
				Minion p1Min = p1Tow.spawnMinion();
				//p2 minion spawn
				Minion p2Min = p2Tow.spawnMinion();
				//spoof minions finding and confronting one another
				engine.display("Opposing minions have confronted one another. They will engage in combat!");
			    //minions fight continuously while both are still alive
				while (p1Min.getHealth() > 0 && p2Min.getHealth() > 0) {
					//TODO randomise who attacks first maybe?
					engine.display(p1Name + "'s Minion attacking...");
					p1Min.attackObject(p2Min);
					engine.display(p2Name + "'s Minion attacking...");
					p2Min.attackObject(p1Min);
				}
				//spoof surviving minion finding its way to enemy tower
				if (p1Min.getHealth() <= 0) {
					engine.display(p1Name + "'s Minion is dead, " + p2Name + "'s Minion has found its way to "
					+ p1Name + "'s tower!");
					player2.setPoints(player2.getPoints() + 300);
					p2Min.attackObject(p1Tow);
				}  else {
					engine.display(p2Name + "'s Minion is dead, " + p1Name + "'s Minion has found its way to "
					+ p2Name + "'s tower!");
					player.setPoints(player.getPoints() + 300);
					p1Min.attackObject(p2Tow);
				}
			}
			roundCount++;
		}
		
		//Game over; One of the players has won.
		if (p1Tow.getHP() <= 0) {
			engine.display(p1Name + ", you have won! Congratulations!");
		} else {
			engine.display(p2Name + ", you have won! Congratulations!");
		}
	}
	
	private static void takeTurn(Player player, Scanner scanner)
	{
		String next;
		do {
			next = scanner.next();
			if (!next.equals("undo")) {
				Command command = commandToObject(next, player, scanner);
				command.execute();
				history.push(command);
			} else {
				Command prev = history.pop();
				prev.undo();
			}
		} while (!next.equals("done"));
	}
	
	private static Command commandToObject(String termInput, Player actingPlayer, Scanner scanner)
	{
		//Just set to Max value as an indicator that this variable is not set with user input.
		//Easily broken by "malicious" user entering int max value...but generally it works.
		int input = Integer.MAX_VALUE, input2 = Integer.MAX_VALUE;
		switch (termInput) {
			case "heal" : return new PlayerHealCommand(actingPlayer);
			case "placewall":
			case "placeWall": engine.display("Where will the wall be placed?");
				while (input == Integer.MAX_VALUE || input2 == Integer.MAX_VALUE) {
					try {
						if (input == Integer.MAX_VALUE) {
							input = scanner.nextInt();
						} else {
							input2 = scanner.nextInt();
						}
						
					} catch (InputMismatchException ime) {
						engine.display("You must enter an integer value.");
						scanner.next();
					}
				}
				return new PlayerPlaceWallCommand(actingPlayer, input, input2);
			case "done" : return new DoneCommand();
			default : return null;
		}
	}
}

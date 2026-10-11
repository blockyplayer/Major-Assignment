import java.util.ArrayList;
import java.time.*;

public class Main {
	public static void main(String[] args) {
		final LocalTime globalGameStart = getGameStartTime();
		int r = random(50, 150);
		
		Robot robot1 = new Robot(30, 30);
		Robot robot2 = new Robot(100, 60);
		Robot enemy = new Robot(100, 60);
		ArrayList<Robot> list = new ArrayList<>();
		list.add(robot1);
		list.add(robot2);

		Battle battle = new Battle(list, 1);

		System.out.println("" + robot1.damage + "" + robot1.health + "" + robot1.isAlive);
		System.out.println("" + robot2.damage + "" + robot2.health + "" + robot2.isAlive);
		System.out.println(battle.attack.offence.health);
		// System.out.println(randomEvent.deltaTime(globalGameStart));
	}


	public static int random(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}

	public static LocalTime getGameStartTime() {
		final LocalTime globalGameStartTime = LocalTime.now();
		return globalGameStartTime;
	}


	// public void kill(Robot robot) {
	// 	if (robot.isAlive == false) {
	// 		data.
	// 		robot = null;
	// 	}
	// }
}
	// Add function to save player score to file
	// and retrieve when executed
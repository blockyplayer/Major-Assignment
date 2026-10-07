import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String newString = "Hello";
		Integer.parseInt(newString);
		
		int r = random(50, 150);
		
		Robot robot1 = new Robot(r, 61);
		Robot robot2 = new Robot(100, 60);
		Robot enemy = new Robot(100, 60);


		ArrayList<Robot> robotList = new ArrayList<Robot>(5);
		Battle battle = new Battle(robotList);
		Attack attack = new Attack(robot1, enemy, userAttack);
	}
	// Add function to save player score to file
	// and retrieve when executed

	public static int random(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}

}

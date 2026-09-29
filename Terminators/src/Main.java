public class Main {
	public static void main(String[] args) {
		
		Robot robot1 = new Robot(101, 61, 1);
		Robot robot2 = new Robot(100, 60, 1);
		Robot enemy = new Robot(100, 60, 1);

		robot1.attack(enemy, 1);
		System.out.println(robot1.canAttack(enemy));
		System.out.println(enemy.canAttack(robot1));
		System.out.println(robot2.canAttack(enemy));
	}
	// Add function to save player score to file
	// and retrieve when executed
}

import java.util.Scanner;

// Driver class: owns the Scanner, the menu and the game flow.
// Game rules live in Robot, Battle and Match; file I/O lives in PlayerData.
public class Main {
	private static final String SAVE_FILE = "save.txt";

	// Shop prices and effects
	private static final int REPAIR_COST = 20;
	private static final int REPAIR_AMOUNT = 25;
	private static final int UPGRADE_COST = 50;
	private static final int UPGRADE_AMOUNT = 5;

	// Tournament rewards, and the health a defeated player's robot is restored to
	private static final int WIN_REWARD = 100;
	private static final int LOSS_REWARD = 30;
	private static final int REVIVE_HEALTH = 100;

	// Allowed ranges for the player's robot and the random range for computer robots
	private static final int MIN_HEALTH = 50;
	private static final int MAX_HEALTH = 150;
	private static final int MIN_DAMAGE = 5;
	private static final int MAX_DAMAGE = 15;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		// load returns null when there is no valid save file, so a new player
		// builds their robot from keyboard input
		PlayerData data = PlayerData.load();
		if (data == null) {
			data = new PlayerData(createPlayerRobot(in), 0);
		}

		boolean running = true;
		while (running) {
			showMenu(data);
			int choice = readChoice(in, 1, 4);

			if (choice == 1) {
				if (data.spend(REPAIR_COST)) {
					data.getRobot().repair(REPAIR_AMOUNT);
					System.out.println("Repaired " + REPAIR_AMOUNT + " health.");
				} else {
					System.out.println("Not enough credits.");
				}
			} else if (choice == 2) {
				if (data.spend(UPGRADE_COST)) {
					data.getRobot().upgrade(UPGRADE_AMOUNT);
					System.out.println("Damage increased by " + UPGRADE_AMOUNT + ".");
				} else {
					System.out.println("Not enough credits.");
				}
			} else if (choice == 3) {
				runTournament(data, in);
			} else {
				data.save();
				System.out.println("Progress saved. Goodbye!");
				running = false;
			}
		}
		in.close();
	}

	// Asks the player for their robot's name, health and damage.
	private static Robot createPlayerRobot(Scanner in) {
		System.out.println("Create your robot.");
		String name = readName(in);

		System.out.println("Choose health (" + MIN_HEALTH + "-" + MAX_HEALTH + "):");
		int health = readChoice(in, MIN_HEALTH, MAX_HEALTH);

		System.out.println("Choose damage (" + MIN_DAMAGE + "-" + MAX_DAMAGE + "):");
		int damage = readChoice(in, MIN_DAMAGE, MAX_DAMAGE);
		Robot robo = new Robot(name, health, damage);
		robo.isPlayer = true;
		return robo;
	}

	// Keeps asking until the name is not blank and has no comma.
	private static String readName(Scanner in) {
		while (true) {
			System.out.println("Enter a name for your robot:");
			String name = in.nextLine().trim();
			if (!name.isEmpty() && !name.contains(",")) {
				return name;
			}
			System.out.println("The name can't be blank or contain a comma.");
		}
	}

	// Keeps asking until the player types a whole number from min to max inclusive.
	// Public because Battle uses it to read attack choices.
	public static int readChoice(Scanner in, int min, int max) {
		while (true) {
			String line = in.nextLine();
			try {
				int number = Integer.parseInt(line.trim());
				if (number >= min && number <= max) {
					return number;
				}
			} catch (NumberFormatException e) {
				// not a number, fall through to the message below
			}
			System.out.println("Enter a number from " + min + " to " + max + ":");
		}
	}

	private static void showMenu(PlayerData data) {
		Robot robot = data.getRobot();
		System.out.println();
		System.out.println(robot.name + " | health: " + robot.health
				+ " | damage: " + robot.damage + " | credits: " + data.getCredits());
		System.out.println("1: Repair (" + REPAIR_COST + " credits)");
		System.out.println("2: Upgrade damage (" + UPGRADE_COST + " credits)");
		System.out.println("3: Enter tournament");
		System.out.println("4: Save and quit");
	}

	// Plays a full bracket, pays out credits and saves the result.
	private static void runTournament(PlayerData data, Scanner in) {
		Robot player = data.getRobot();
		Robot winner = buildBracket(player).winner(in);

		if (winner == player) {
			System.out.println("You won the tournament! +" + WIN_REWARD + " credits.");
			data.earn(WIN_REWARD);
		} else {
			System.out.println(winner.name + " won the tournament. +"
					+ LOSS_REWARD + " credits.");
			data.earn(LOSS_REWARD);
		}

		// A defeated robot has 0 health, so restore some before it is saved
		if (!player.isAlive()) {
			player.repair(REVIVE_HEALTH);
		}
		data.save();
	}

	// Builds a four-robot bracket: the player plus three computer robots with
	// random stats. A new bracket is built every tournament.
	private static Match buildBracket(Robot player) {
		Robot bot1 = createBot("Bot 1");
		Robot bot2 = createBot("Bot 2");
		Robot bot3 = createBot("Bot 3");

		System.out.println("Opponents:");
		printStats(bot1);
		printStats(bot2);
		printStats(bot3);

		return new Match(
				new Match(new Match(player), new Match(bot1)),
				new Match(new Match(bot2), new Match(bot3)));
	}

	private static Robot createBot(String name) {
		return new Robot(name, random(MIN_HEALTH, MAX_HEALTH),
				random(MIN_DAMAGE, MAX_DAMAGE));
	}

	private static void printStats(Robot robot) {
		System.out.println(robot.name + " | health: " + robot.health
				+ " | damage: " + robot.damage);
	}

	// Random whole number from min to max inclusive.
	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
}
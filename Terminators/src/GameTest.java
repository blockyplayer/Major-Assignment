import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

// Five tests covering Robot.attack, Robot.takeDamage, PlayerData.spend,
// Match.winner and PlayerData.load.
public class GameTest {

	// Damage dealt is the attacker's damage times the attack multiplier
	// (attack 0 has multiplier 1, attack 2 has multiplier 3).
	@Test
	public void attackDealsDamageTimesMultiplier() {
		Robot attacker = new Robot("A", 100, 10);
		Robot target = new Robot("B", 100, 10);

		attacker.attack(0, target);
		assertEquals(90.0, target.health, 0.001);

		attacker.attack(2, target);
		assertEquals(60.0, target.health, 0.001);
	}

	// Boundary: damage larger than the remaining health stops at 0, not below.
	@Test
	public void takeDamageStopsAtZero() {
		Robot robot = new Robot("A", 50, 10);
		robot.takeDamage(500);
		assertEquals(0.0, robot.getHealth(), 0.001);
		assertFalse(robot.isAlive());
	}

	// Boundary: spending the exact balance works, spending one more fails.
	@Test
	public void spendChecksBalance() {
		Robot robo = new Robot("A", 100, 10);
		PlayerData data = new PlayerData(robo, 50);

		assertFalse(data.spend(51));
		assertEquals(50, data.getCredits());
		assertTrue(data.spend(50));
		assertEquals(0, data.getCredits());
	}

	// The strong robot's first attack always kills a weak one, so the result
	// is the same every run even though computer attacks are random.
	@Test
	public void strongRobotWinsBracket() {
		Robot strong = new Robot("Strong", 10000, 1000);
		Match bracket = new Match(
				new Match(new Match(new Robot("W1", 1, 1)), new Match(strong)),
				new Match(new Match(new Robot("W2", 1, 1)),
						new Match(new Robot("W3", 1, 1))));
		assertSame(strong, bracket.winner(new Scanner("")));
	}

	// Edge case: first run, no save file exists, so load returns null.
	// A temporary file name is used so the real save file is not touched.
	@Test
	public void loadMissingFileReturnsNull() {
		String original = PlayerData.fileName;
		PlayerData.fileName = "no_such_file_for_test.csv";
		new File(PlayerData.fileName).delete();
		try {
			try {
				assertNull(PlayerData.load());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			PlayerData.fileName = original;
		}
	}
}
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Robot {
	double health;
	double damage;
	int attackIndex;
	String[] names = { "" };

	 
	int[] attackTypesIndexes;
	boolean isAlive;

	public Robot(double health_, double damage_) {
		health = health_;

		// The attack array is in order of attack damage dealt, so we can directly use
		// the index in calculations.
		damage = damage_;
		isAlive = true;

	}
}

	// public void attack(Robot other, int attackIndex) {
	// 	damage *= (attackIndex + 1);
	// 	if (canAttack(other)) {
	// 		other.isAlive = false;
	// 	} else {
	// 		this.isAlive = false;
	// 	}
	// }

	// public boolean canAttack(Robot other) {
	// double damageThreshehold = (other.damage / 5);
	// return (health > other.health && damage > damageThreshehold);
	// }

	// public void defend(Robot other) {
	// 	isAlive = this.canAttack(other);
	// }

// Add method to write recent attacks to file

// Add method canAttack for File I/O to store recent attacks.
// Return false if attackIndex is in file between lines (file.length - 1) and
// (file.length - 3)
// Return true otherwise. Also move the health and damageThreshehold check here.

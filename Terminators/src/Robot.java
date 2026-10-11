import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Robot {
	double health;
	double damage;
	ArrayList<Attack> attacks;
	String name;
	boolean isPlayer;

	public Robot(String robotName, double health_, double damage_) {
		health = health_;
		damage = damage_;
		name = robotName;
		isPlayer = true;
	}

	public String attack(int attackIndex, Robot other) {
		Attack newAttack = new Attack(attackIndex);
		String description = "" + name + " used " + newAttack.getName() + " against " + other.name + "! " + other.name + " took " + newAttack.getMultiplier() + " damage!"
		return description;

	}

	public void takeDamage(double damageTaken) {
		if (this.health > 0) {
			this.health -= damageTaken;
		}
	}

	public boolean isAlive() {
		if (this.health > 0) {
			return true;
		}
		return false;
	}

	public void repair(double amount) {
		this.health += amount;
	}

	public void upgrade(double amount) {
		this.damage += amount;
	}

	public int getAttackCount() {
		return attacks.size();
	}

	public String getAttackNames(int index) {
		return attacks.get(index).getName();
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

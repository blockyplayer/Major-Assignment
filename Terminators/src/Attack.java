import java.util.*;

public class Attack {
  Robot offence;
  Robot other;
  
  public Attack(Robot offensiveRobot, Robot otherRobot, int attackIndex) {
    offence = offensiveRobot;
    other = otherRobot;

    // Ordered in ascending attack damage dealt
    String[] attackTypes =
    { "1: Basic shoot", 
    "2: Laser eyes", 
    "3: Missile launch",
    "4: Defend" };
     
    
  }

  public boolean canAttack(int attack) {
    double scaledDamage = offence.damage * (offence.attackIndex + 1);
    double otherDamage = other.damage * (1.5);
    double damageThreshehold = (other.damage / 5);
	  return (offence.health > other.health && offence.damage > damageThreshehold);
  }
}

import java.util.*;

public class Attack {
  public String name;
  public double multiplier;
  public Attack(int attackMultiplier) {
    // Ordered in ascending attack damage dealt
    
    String[] attackTypes =
    { "1: Basic shoot", 
    "2: Laser eyes", 
    "3: Missile launch",
    "4: Defend" };

    name = attackTypes[attackMultiplier];
    multiplier = attackMultiplier + 1;
    
    // double offenceDamage = offence.damage * (multiplier + 1);
    // double otherDamage = other.damage * (1.5);
    // double damageThreshehold = (other.damage / 5);
  }
  
  public String getName() {
    return name;
  }

  public double getMultiplier() {
    return multiplier;
  }
  
}

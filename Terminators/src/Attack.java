import java.util.*;

public class Attack {
  Robot offence;
  Robot other;
  public Attack(Robot offensiveRobot, Robot otherRobot) {
    offence = offensiveRobot;
    other = otherRobot;
  }

  public boolean canAttack() {
    double scaledDamage = offence.damage * (offence.attackIndex + 1);
    double otherDamage = other.damage * (1.5);

    return scaledDamage > otherDamage;
  }
}

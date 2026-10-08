import java.util.ArrayList;

public class Battle {
  ArrayList<Robot> robotList;
  Attack attack; 
  int index;

  public Battle(ArrayList<Robot> list, int attackIndex) {
    robotList = list;
    index = attackIndex;
    attack = new Attack(robotList.get(0), robotList.get(1), index);
  }

  //This method changes attributes of the Robots. 
  public void fight() {
    while (attack.offence.isAlive && attack.other.isAlive) {
      if (attack.offence.damage == attack.otherDamage || attack.other.health == attack.offenceDamage) {
        
        System.out.println("Broke");
        break;
      }
      attack.offence.health -= attack.otherDamage; // [robotName].damage is not scaled, whilst [robotName]Damage is.
      attack.other.health -= attack.offenceDamage;
    }

  }

  public void kill(Robot robot) {
    if (robot.isAlive == false) {
      robot = null;
    }
  }
}

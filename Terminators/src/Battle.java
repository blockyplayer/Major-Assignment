import java.util.ArrayList;

public class Battle {
  ArrayList<Robot> list;
  Attack attack; 
  int index;

  public Battle(ArrayList<Robot> RobotList, int attackIndex) {
    list = RobotList;
    index = attackIndex;
    attack = new Attack(list.get(0), list.get(1), index);
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
}

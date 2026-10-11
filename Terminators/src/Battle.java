import java.util.ArrayList;
import java.util.Scanner;
public class Battle {
  ArrayList<Robot> list;
  Attack attack; 
  int index;
  Robot offence;
  Robot target;

  public Battle(ArrayList<Robot> RobotList) {
    list = RobotList;
    offence = RobotList.get(0);
    target = RobotList.get(1);
  }

  //This method changes attributes of the Robots. 
  public Robot fight(Scanner in) {
    while (offence.isAlive() && target.isAlive()) {
      System.out.println(turn(offence, target, in));
      if (target.isAlive()) {
        System.out.println(turn(target, offence, in));
      }

    }

    return winner(offence, target);

  }

  public String turn(Robot offence, Robot target, Scanner in) {
    if (offence.isPlayer) {
      for (int i = 0; i < offence.getAttackCount(); i++) {
        System.out.print(offence.getAttackNames(i));
        index = Main.readChoice(in, 1, offence.getAttackCount()) - 1;
      }
      
    } else {
      index = (int) (Math.random() * offence.getAttackCount());
    }
    return offence.attack(index, target);
  }

  public Robot winner(Robot robot1, Robot robot2) {
    if (robot1.isAlive()) {
      return robot1;
    }
    return robot2;
  }
}

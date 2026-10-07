import java.util.ArrayList;

public class Battle {
  ArrayList<Robot> robots;
  Attack attack; 
  public Battle(ArrayList<Robot> list) {
    robots = list;
    attack = new Attack();
  }

  
}

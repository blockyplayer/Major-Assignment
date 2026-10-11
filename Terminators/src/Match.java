import java.util.Scanner;
import java.util.ArrayList;

public class Match {
  // Each round is a new Match. If there is only one robot passed
  // then it becomes
  Robot robot;
  Match left;
  Match right;
  ArrayList<Robot> robots;
  public Match(Robot other) {
    robot = other;
  }

  public Match(Match leftSide, Match rightSide) {
    left = leftSide;
    right = rightSide;

    
  }

  public Robot winner(Scanner in) {
    if (robot != null) {
      return robot;
    }
    else {
      robots.add(left.winner(in));
      robots.add(right.winner(in));

      return new Battle(robots).fight(in);
    }
  }
  
}

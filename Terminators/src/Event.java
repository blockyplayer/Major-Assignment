import java.time.*;
import java.math.*;

public class Event {
  Robot robot;
  int n;

  public Event(Robot robotTrigger, int randomNumber) {
    n = randomNumber;
    robot = robotTrigger;
  }
  
  public String events() {
    String[] eventList = {"Damage Buff", "Health Buff", "Revive"};
    String event = eventList[n];

    if (n == 0) {
      robot.damage += 50;
    }
    if (n == 1) {
      robot.health += 50;
    }
    return ("You got " + event + "! ");
  }
}

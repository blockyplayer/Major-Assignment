import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


// Handles File I/O for player data, and score calculations

public class PlayerData {
  int score;
  Robot r;
  static String fileName = "playerData.csv";
  public PlayerData(Robot player, int playerScore) {
    r = player;
    score = playerScore;
  }

  public boolean spend(int amount) {
    if (score < amount) {
      return false;
    }
    score -= amount;
    return true;
  }

  void earn(int amount) {
    score += amount;
  }
  public Robot getRobot() {
    return r;
  }

  public int getCredits() {
    return score;
  }

  public void save() {
    
    try {
      PrintWriter file = new PrintWriter(new FileWriter(fileName));
      String data = "" + r.name + "," + r.health + "," + r.damage + "," + score;
      file.println(data);
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  public static PlayerData load() throws Exception {

    File file = new File(fileName);

    try (Scanner output = new Scanner(file)) {
      String[] data = output.nextLine().split(",");
      // name, health, damage
      Robot robot = new Robot(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[3]));
      return new PlayerData(robot, Integer.parseInt(data[3]));
    } catch (Exception e) {
      return null;
    }

  }
  
}

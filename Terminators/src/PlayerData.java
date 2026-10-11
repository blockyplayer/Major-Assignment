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

  public void save(String fileName) throws Exception {
    PrintWriter file = new PrintWriter(fileName);
    String data = "" + r.name + "," + r.damage + "," + r.health + "," + score;
    file.append(data);
  }

  public static PlayerData load(String filename) throws Exception {
    Scanner file = new Scanner(filename);
    
  }
  
}

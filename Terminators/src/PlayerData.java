import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


// Handles File I/O for player data, and score calculations

public class PlayerData {
  Robot r;
  public void main(String[] args) throws Exception {
    log();
  }
  public PlayerData(Robot playerRobot) {
    r = playerRobot;
  }
  public void log() throws Exception {
    FileWriter myWriter = new FileWriter("filename.txt", true);
    myWriter.write(r.name, r.isAlive, r.damage, r.health);
    myWriter.close();
  }
}

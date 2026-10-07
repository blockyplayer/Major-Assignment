import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


// Handles File I/O for player data, and score calculations

public class PlayerData {
  public PlayerData() {

  }
  public void fileIO() throws FileNotFoundException {
  Scanner scanner = new Scanner(new File("user-data.csv"));
  scanner.nextLine();
  scanner.useDelimiter(",");

  PrintWriter writer = new PrintWriter(new File("analysis.txt"));

  while (scanner.hasNextLine()) {

    int attackIDData = scanner.nextInt();
    int attackIndexData = scanner.nextInt();
    String attackTypeData = scanner.next();
    scanner.nextLine();

    writer.println("" + attackIDData + attackIndexData + attackTypeData);

  //            if(homeScore > awayScore) {
  //                writer.println(homeTeam+" won at home against "+awayTeam+" by "+homeScore+" - "+awayScore);
  //            }
  //            else if(homeScore < awayScore) {
  //                writer.println(awayTeam+" won away from home against "+homeTeam+" by "+awayScore+" - "+homeScore);
  //            }
  //            else {
  //                writer.println(homeTeam+" drew at home against "+awayTeam+" with full time score of "+homeScore+" - "+awayScore);
  //            }
  }

  scanner.close();
  writer.close();
  }
}

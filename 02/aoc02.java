import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class aoc02 {
  // 0 = draw, -1 = player loss, 1 = player win
  private static int outcome(final char playerChoice, final char opponentChoice) {
    int diff = opponentChoice - playerChoice;
    switch (diff) {
      // opponent win
      case -2:
      case 1:
        return -1;
      // player win
      case -1:
      case 2:
        return 1;
      // draw
      case 0:
      default:
        return 0;
    }
  }

  private static int outcomeScore(final int outcome) {
    switch (outcome) {
      case -1:
        return 0;
      case 0:
        return 3;
      case 1:
        return 6;
      default:
        return -1;
    }
  }

  private static int shapeScore(final char shape) {
    switch (shape) {
      case 'A':
        return 1;
      case 'B':
        return 2;
      case 'C':
        return 3;
      default:
        return 0;
    }
  }

  public static void main(String args[]) throws FileNotFoundException, IOException {
    File file = new File("./02/input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    int totalScore = 0;

    while ((line = br.readLine()) != null) {
      char opponentChoice = line.charAt(0);
      char playerChoice = line.charAt(2);
      // convert player choice to A B C
      playerChoice -= ('Z' - 'C');
      int outcome = outcome(playerChoice, opponentChoice);
      int score = outcomeScore(outcome) + shapeScore(playerChoice);
      System.out.printf("PLR %c CPU %c outcome: %d score: %d\n",
          playerChoice, opponentChoice, outcome, score);
      totalScore += score;
    }

    System.out.printf("Total score: %d\n", totalScore);

    br.close();
  }
}
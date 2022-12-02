import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class aoc0202 {
  public static int decryptOutcome(final char encryptedOutcome) {
    switch (encryptedOutcome) {
      case 'X':
        return -1;
      case 'Y':
        return 0;
      case 'Z':
        return 1;
      default:
        return -2;
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

  private static char playerChoiceFromOutcome(final int outcome, final char opponentChoice) {
    char playerChoice = (char) ((int) opponentChoice + outcome);
    // range check
    if (playerChoice < 'A') {
      playerChoice = 'C';
    } else if (playerChoice > 'C') {
      playerChoice = 'A';
    }
    return playerChoice;
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
      char desiredOutcome = line.charAt(2);
      int outcome = decryptOutcome(desiredOutcome);
      char playerChoice = playerChoiceFromOutcome(outcome, opponentChoice);
      int score = outcomeScore(outcome) + shapeScore(playerChoice);
      System.out.printf("PLR %c CPU %c outcome: %d score: %d\n",
          playerChoice, opponentChoice, outcome, score);
      totalScore += score;
    }

    System.out.printf("Total score: %d\n", totalScore);

    br.close();
  }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class aoc01 {
  private static void processElfCalories(int[] calorieCounts, int calorieCount) {
    // compare the calorie count to the top entries
    // only need to compare to the first element as the array is sorted
    if (calorieCount > calorieCounts[0]) {
      // set this as the largest elf
      calorieCounts[0] = calorieCount;
      // sort the array
      Arrays.sort(calorieCounts);
    }
  }

  public static void main(String args[]) throws FileNotFoundException, IOException {
    File file = new File("./01/input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    int calorieCount = 0;
    final int TOP_ELVES = 3;
    int[] topCalorieCounts = new int[TOP_ELVES];

    while ((line = br.readLine()) != null) {
      line = line.trim();
      if (line.isEmpty()) {
        // blank line, last calorie record for this elf
        processElfCalories(topCalorieCounts, calorieCount);
        calorieCount = 0;
      } else {
        // parse the line to an int
        int calories = Integer.parseInt(line);
        calorieCount += calories;
      }
    }

    // end of file, last calorie record for this elf
    processElfCalories(topCalorieCounts, calorieCount);

    int topCaloriesSum = Arrays.stream(topCalorieCounts).sum();
    System.out.printf("Most calories: %d\n", topCalorieCounts[TOP_ELVES - 1]);
    System.out.printf("Sum of top %d elves' calories: %d\n", TOP_ELVES, topCaloriesSum);

    br.close();
  }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class aoc01 {
  public static void main(String args[]) throws FileNotFoundException, IOException {
    File file = new File("./01/input.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    int elfCount = 0;
    int largestElf = -1;
    int calorieCount = 0;
    int maxCalories = 0;

    while ((line = br.readLine()) != null) {
      line = line.trim();
      if (line.isEmpty()) {
        // blank line, update variables
        if (largestElf < 0 || calorieCount > maxCalories) {
          // set this as the largest elf
          largestElf = elfCount;
          maxCalories = calorieCount;
        }
        elfCount++;
        calorieCount = 0;
      } else {
        // parse the line to an int
        int calories = Integer.parseInt(line);
        calorieCount += calories;
      }
    }

    System.out.printf("Elf %d has %d calories\n", largestElf, maxCalories);

    br.close();
  }
}
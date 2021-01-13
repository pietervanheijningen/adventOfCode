package aoc2020.dec10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static ArrayList<Integer> getInput(String filename) {
        try (Scanner scanner = new Scanner(new FileReader("solutions/aoc2020/dec10/input/" + filename))) {
            ArrayList<Integer> ints = new ArrayList<>();
            while (scanner.hasNextInt()) {
                ints.add(scanner.nextInt());
            }

            return ints;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

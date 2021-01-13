package aoc2019.dec01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static ArrayList<Integer> getInput() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("solutions/aoc2019/dec01/input/input.txt");
            Scanner scanner = new Scanner(fr);

            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}

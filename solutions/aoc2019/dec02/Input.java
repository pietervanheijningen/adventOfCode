package aoc2019.dec02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static ArrayList<Integer> getInput() {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("solutions/aoc2019/dec02/input/input.txt"))) {
            while (scanner.hasNextLine()) {
                list.addAll(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}

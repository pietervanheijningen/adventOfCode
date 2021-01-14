package aoc2019.dec03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    public static ArrayList<ArrayList<String>> getInput() {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("solutions/aoc2019/dec03/input/input.txt"))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                list.add(i, new ArrayList<>());
                list.get(i).addAll(Arrays.asList(scanner.nextLine().split(",")));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}

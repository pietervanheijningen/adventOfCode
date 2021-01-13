package aoc2020.dec10;

import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> input = Input.getInput("testInputBig.txt");
        assert input != null;
        input.add(0);
        input.add(Collections.max(input) + 3);
        Collections.sort(input);

        int oneCount = 0;
        int threeCount = 0;
        for (int i = 1; i < input.size(); i++) {
            int diff = input.get(i) - input.get(i - 1);
            if (diff == 1) {
                oneCount++;
            } else if (diff == 3) {
                threeCount++;
            }
        }

        System.out.println(oneCount * threeCount);
    }
}

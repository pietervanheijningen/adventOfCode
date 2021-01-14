package aoc2019.dec02;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> list = Input.getInput();
        list.set(1, 12);
        list.set(2, 2);
        int i = 0;
        while (true) {
            int opCode = list.get(i);

            if (opCode == 1) {
                list.set(list.get(i + 3), list.get(list.get(i + 1)) + list.get(list.get(i + 2)));
            } else if (opCode == 2) {
                list.set(list.get(i + 3), list.get(list.get(i + 1)) * list.get(list.get(i + 2)));
            } else if (opCode == 99) {
                System.out.println(list.get(0));
                System.exit(0);
            }

            i += 4;
        }
    }
}

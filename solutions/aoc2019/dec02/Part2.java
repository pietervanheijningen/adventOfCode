package aoc2019.dec02;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (runCodeModified(i, j) == 19690720) {
                    System.out.println(100 * i + j);
                }
            }
        }
    }

    public static int runCodeModified(int noun, int verb) {
        List<Integer> list = Input.getInput();
        list.set(1, noun);
        list.set(2, verb);
        int ip = 0;
        while (true) {
            int opCode = list.get(ip);

            if (opCode == 1) {
                list.set(list.get(ip + 3), list.get(list.get(ip + 1)) + list.get(list.get(ip + 2)));
            } else if (opCode == 2) {
                list.set(list.get(ip + 3), list.get(list.get(ip + 1)) * list.get(list.get(ip + 2)));
            } else if (opCode == 99) {
                return list.get(0);
            }

            ip += 4;
        }
    }
}

package aoc2019.dec01;

public class Part2 {
    private static int sum;

    public static void main(String[] args) {
        for (Integer mass : Input.getInput()) {
            int fuel = mass;
            while (true) {
                fuel = fuel / 3 - 2;
                if (fuel <= 0) {
                    break;
                }
                sum += fuel;
            }
        }
        System.out.println(sum);
    }
}

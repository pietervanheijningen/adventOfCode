package aoc2019.dec01;

public class Part1 {
    private static int sum;

    public static void main(String[] args) {
        for (Integer mass : Input.getInput()) {
            sum += mass / 3 - 2;
        }
        System.out.println(sum);
    }
}

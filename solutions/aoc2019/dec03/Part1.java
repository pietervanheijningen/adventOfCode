package aoc2019.dec03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = Input.getInput();
        ArrayList<Tuple<Integer, Integer>> cordsOfAccessedPositionsByLine0 = new ArrayList<>();
        ArrayList<Tuple<Integer, Integer>> overLappingPoints = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            int x = 0;
            int y = 0;
            for (String lineInstruction : list.get(i)) {
                int amountToMove = Integer.parseInt(lineInstruction.replaceAll("[RULD]", ""));

                System.out.println(cordsOfAccessedPositionsByLine0.size());
                if (i == 0) {
                    switch (lineInstruction.charAt(0)) {
                        case 'R':
                            for (int j = 1; j <= amountToMove; j++) {
                                cordsOfAccessedPositionsByLine0.add(new Tuple<>(x + j, y));
                            }
                            x += amountToMove;
                            break;
                        case 'U':
                            for (int j = 1; j <= amountToMove; j++) {
                                cordsOfAccessedPositionsByLine0.add(new Tuple<>(x, y + j));
                            }
                            y += amountToMove;
                            break;
                        case 'L':
                            for (int j = 1; j <= amountToMove; j++) {
                                cordsOfAccessedPositionsByLine0.add(new Tuple<>(x - j, y));
                            }
                            x -= amountToMove;
                            break;
                        case 'D':
                            for (int j = 1; j <= amountToMove; j++) {
                                cordsOfAccessedPositionsByLine0.add(new Tuple<>(x, y - j));
                            }
                            y -= amountToMove;
                            break;
                    }
                } else {
                    switch (lineInstruction.charAt(0)) {
                        case 'R':
                            for (int j = 1; j <= amountToMove; j++) {
                                if (cordsOfAccessedPositionsByLine0.contains(new Tuple<>(x + j, y))) {
                                    overLappingPoints.add(new Tuple<>(x + j, y));
                                }
                            }
                            x += amountToMove;
                            break;
                        case 'U':
                            for (int j = 1; j <= amountToMove; j++) {
                                if (cordsOfAccessedPositionsByLine0.contains(new Tuple<>(x, y + j))) {
                                    overLappingPoints.add(new Tuple<>(x, y + j));
                                }
                            }
                            y += amountToMove;
                            break;
                        case 'L':
                            for (int j = 1; j <= amountToMove; j++) {
                                if (cordsOfAccessedPositionsByLine0.contains(new Tuple<>(x - j, y))) {
                                    overLappingPoints.add(new Tuple<>(x - j, y));
                                }
                            }
                            x -= amountToMove;
                            break;
                        case 'D':
                            for (int j = 1; j <= amountToMove; j++) {
                                if (cordsOfAccessedPositionsByLine0.contains(new Tuple<>(x, y - j))) {
                                    overLappingPoints.add(new Tuple<>(x, y - j));
                                }
                            }
                            y -= amountToMove;
                            break;
                    }
                }


            }
        }
        List<Integer> distances = new ArrayList<>();

        System.out.println(overLappingPoints);
        for (Tuple<Integer, Integer> overLappingPoint : overLappingPoints) {
            distances.add(Math.abs(overLappingPoint.fst) + Math.abs(overLappingPoint.snd));
        }

        System.out.println(Collections.min(distances));
    }
}

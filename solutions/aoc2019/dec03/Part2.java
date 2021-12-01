package aoc2019.dec03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Tuple<Character, Integer>>> list = Input.getInput();

        int x0 = 0;
        int y0 = 0;

        for (Tuple<Character, Integer> lineInstruction0 : list.get(0)) {

            int x1 = 0;
            int y1 = 0;
            // search for if intersecting
            for (Tuple<Character, Integer> lineInstruction1 : list.get(1)) {
                // parallel, not intersecting
                if (lineInstruction0.fst == lineInstruction1.fst
                        || (lineInstruction0.fst == 'R' && lineInstruction1.fst == 'L')
                        || (lineInstruction0.fst == 'L' && lineInstruction1.fst == 'R')
                        || (lineInstruction0.fst == 'U' && lineInstruction1.fst == 'D')
                        || (lineInstruction0.fst == 'D' && lineInstruction1.fst == 'U')
                ) {
                    continue;
                }

                if (lineInstruction0.fst == 'U') {
                    lineInstruction0.snd
                }

                // update x and y
                switch (lineInstruction1.fst) {
                    case 'R':
                        x1 += lineInstruction1.snd;
                        break;
                    case 'U':
                        y1 += lineInstruction1.snd;
                        break;
                    case 'L':
                        x1 -= lineInstruction1.snd;
                        break;
                    case 'D':
                        y1 -= lineInstruction1.snd;
                        break;
                }
            }

            // update x and y
            switch (lineInstruction0.fst) {
                case 'R':
                    x0 += lineInstruction0.snd;
                    break;
                case 'U':
                    y0 += lineInstruction0.snd;
                    break;
                case 'L':
                    x0 -= lineInstruction0.snd;
                    break;
                case 'D':
                    y0 -= lineInstruction0.snd;
                    break;
            }
        }


    }
}

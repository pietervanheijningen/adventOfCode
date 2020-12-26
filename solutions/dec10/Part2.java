package dec10;

import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
    public static void main(String[] args) {
        ArrayList<Integer> input = Input.getInput("testInputSmall.txt");
        assert input != null;
        input.add(0);
        input.add(Collections.max(input) + 3);
        Collections.sort(input);

        System.out.println(input);
        System.out.println(arrangementsCount(input));
    }

    public static long arrangementsCount(ArrayList<Integer> list) {
        long lanesCount = 1;

        int currentElement;
        int nextElement;
        int lastElementForked = 0;
        boolean forkedAtFirst;

        for (int i = 0; i < list.size() - 1; i++) {
            currentElement = list.get(i);
            nextElement = list.get(i + 1);
            int diff = nextElement - currentElement;
            forkedAtFirst = false;

            if (diff < 3) {
                if (diff == 1) {
                    if (list.contains(currentElement + 2)) {

                        if (i != 0 && lastElementForked == list.get(i - 1)) {
                            lanesCount++;
                        } else {
                            lanesCount *= 2;
                        }

//                        System.out.println("Fork from " + currentElement + " to " + (currentElement + 2));
                        forkedAtFirst = true;
                        lastElementForked = currentElement;
                    }
                }

                if (list.contains(currentElement + 3)) {
                    if (forkedAtFirst) {
                        lanesCount *= 1.5;
                    } else if (i != 0 && lastElementForked == list.get(i - 1)) {
                        System.out.println("plusb");
                        lanesCount++;
                    } else {
                        System.out.println("times2b");
                        lanesCount *= 2;
                    }
//                    System.out.println("Fork from " + currentElement + " to " + (currentElement + 3));
                    lastElementForked = currentElement;
                }
            }

//            System.out.println(lanesCount);
        }

        return lanesCount;
    }
}

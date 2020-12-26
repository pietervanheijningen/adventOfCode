package dec10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Part2 {
    private static HashMap<ArrayList<Integer>, Long> resultsCache = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Integer> input = Input.getInput("input.txt");
        assert input != null;
        input.add(0);
        input.add(Collections.max(input) + 3);
        Collections.sort(input);

        System.out.println(arrangementsCount(input));
    }

    public static long arrangementsCount(ArrayList<Integer> list) {
        if (resultsCache.containsKey(list)) {
            return resultsCache.get(list);
        }

        if (list.size() == 3) {
            return 1;
        }

        long arrangementCount = 1;

        int currentElement;
        int nextElement;

        for (int i = 0; i < list.size() - 1; i++) {
            currentElement = list.get(i);
            nextElement = list.get(i + 1);
            int diff = nextElement - currentElement;

            if (diff <= 2) {
                if (diff != 2) {
                    int indexOfElem2 = list.indexOf(currentElement + 2);
                    if (indexOfElem2 != -1) {
                        arrangementCount += arrangementsCount(new ArrayList<>(list.subList(indexOfElem2, list.size())));
                    }
                }

                int indexOfElem3 = list.indexOf(currentElement + 3);
                if (indexOfElem3 != -1) {
                    arrangementCount += arrangementsCount(new ArrayList<>(list.subList(indexOfElem3, list.size())));
                }
            }
        }

        resultsCache.put(list, arrangementCount);
        return arrangementCount;
    }
}

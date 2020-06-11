package recursive.SomeMath;

import java.util.ArrayList;
import java.util.List;

public class Rec {



    public int fact(int value) {
        if (value == 0)
            return 1;
        else {
            return value * fact(value - 1);
        }
    }

    public void counter(int value) throws InterruptedException {
        if (value <= 1) {
            System.out.print(value);
            System.out.println();
            return;
        } else {
            System.out.print(value + " ");

            Thread.sleep(600);
            counter(value - 1);
        }
    }

    public List<Integer> fillInList() {
        ArrayList<Integer> theList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int random = (int) (Math.random() * 100);
            theList.add(random);
        }
        return theList;
    }

    public int sumList(List<Integer> theList) {
        int sum = 0;
        for (Integer i : theList) {
            sum += i;
        }
        return sum;
    }

    public int maxValue(List<Integer> theList) {
        int max = 0;
        for (Integer i : theList) {
            if (max < i)
                max = i;
            else
                continue;
        }
        return max;
    }
}

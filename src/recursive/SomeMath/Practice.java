package recursive.SomeMath;

import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        Rec rec = new Rec();
        System.out.println(rec.fact(5));
        rec.counter(5);
        List<Integer> theList=rec.fillInList();
        System.out.println(theList);
        System.out.println(rec.sumList(theList));
        System.out.println(rec.maxValue(theList));
        List<Integer> newList = new ArrayList<>();
        System.out.println(rec.maxValue(newList));
    }
}

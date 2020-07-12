package classArrays;

import java.util.Arrays;

public class ArTest {

    public static void main(String[] args) {

        int[] first = new int[]{1,5,86,93,35,25,8,357};
        int[] second = new int[12];
        for (int i = 0; i < second.length; i++) {
            second[i]=(int)Math.random()*1000;
        }
        int[] third = {6778,546,852,45,68,1221,854,2,6546,1};
        Arrays.sort(first);
        System.out.println("first "+Arrays.toString(first));
        Arrays.fill(first,1);
        Arrays.fill(second,97);
        System.out.println("first "+Arrays.toString(first));
        System.arraycopy(first,0,third,0,first.length);
        System.out.println("third "+Arrays.toString(third));
        System.out.println(Arrays.equals(first,second));
        int [] forth = new int[first.length];
        System.arraycopy(first,0,forth,0,first.length);
        System.out.println(Arrays.equals(first, forth));
        Arrays.fill(forth,5);
        System.out.println(Arrays.toString(first));
    }
}

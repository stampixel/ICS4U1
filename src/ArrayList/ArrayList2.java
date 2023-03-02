package ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayList2 {
    public static void main(String[] args) {

    }

    public static int findMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static ArrayList<String> swapFirstLast(ArrayList<String> list) {

        String last = list.get(list.size() - 1);

        list.set(list.size() - 1, list.get(0));
        list.set(0, last);

        return list;
    }

    public static int search(ArrayList<Integer> list, int number) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return i;
            }
        }
        return -1;
    }
}

package Unit2Practice;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        System.out.println(num); // [1, 2, 3]

        ArrayList<String> str = new ArrayList<>();
        str.add("hello");
        str.add("bye");
        str.add("salute");
        System.out.println(str); // [hello, bye, salute]
    }
}

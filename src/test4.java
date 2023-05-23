import java.util.Arrays;

public class test4 {
    public static void main(String[] args) {
        boolean smallStraightFound = true;


        int[] arr = {1, 2, 7, 4, 5};
        boolean[] dup = {false, false, false, false, false};

        // SMALL STRIAGHT HERE STARTS HERE JE SEEEEEEEE
        Arrays.sort(arr);
        int dups = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                dups++;
                dup[i] = true; // Is a duplicate
            }
        }
        int duplicateCount = arr.length - dups;



        int[] tempArr = new int[duplicateCount];

        for (int i = 0; i < arr.length; i++) {
            if (dup[i] == false) {
                tempArr[i] = arr[i];
            }
        }


        if (tempArr.length < 4) {
            smallStraightFound = false;
        } else {
            // bubble sort copied array in ascending order
            // Used for detecting small straights and large straights
            for (int i = 0; i < tempArr.length - 1; i++) {
                for (int j = 0; j < tempArr.length - i - 1; j++) {
                    if (tempArr[j] > tempArr[j + 1]) {
                        int temp = tempArr[j];
                        tempArr[j] = tempArr[j + 1];
                        tempArr[j + 1] = temp;
                    }
                }
            }

            for (int i = 0; i < tempArr.length-1; i++) {
                if (tempArr[i]+1 == tempArr[i+1]) {
                    continue;
                }
                smallStraightFound = false;
                break;
            }
        }
        System.out.println(smallStraightFound);
    }
}

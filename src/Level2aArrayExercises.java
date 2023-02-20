public class Level2aArrayExercises {
    public static void main(String[] args) {

    }

    public static void findMax(int[] array) {
        int max = array[0];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int num : array) {
            if (num == max) {
                count++;
            }
        }

        System.out.println("The max number is: " + max + ", # of occurrences is " + count);
    }

    /**
     * Finding the min value
     *
     * @param array
     */
    public static void findMin(int[] array) {
        int min = array[0];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        for (int num : array) {
            if (num == min) {
                count++;
            }
        }
        System.out.println("The min number is: " + min + ", # of occurrences is " + count);
    }

    public static void search(int[] array, int number) {
        boolean[] location = new boolean[array.length]; // Value defaults to false
        boolean exist = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                location[i] = true;
            }
        }

        for (int num : array) {
            if (num == number) {
                exist = true;
                break;
            }
        }
        if (exist) {
            System.out.println("The number " + number + " is found in the following positions: ");

            for (int i = 0; i < location.length; i++) {
                if (location[i]) {
                    System.out.print(i + 1);
                }
            }
        }
    }
}
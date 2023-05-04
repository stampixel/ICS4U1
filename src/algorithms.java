public class algorithms {
    public static void main(String[] args) {

    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void ImprovedBSort(int[] array) {
        boolean swapped = false;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapped = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void SelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = array[0];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minIndex) {
                    minIndex = array[j];
                }
            }
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    public void InsertionSort(int[] array) {

    }

    public int BinarySearch(int[] array, int value) {
        int min = 0;
        int max = array.length;
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;
            if (value == array[mid]) {
                return mid;
            } else if (value > array[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }
}

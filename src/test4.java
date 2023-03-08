public class test4 {
    public static void main(String[] args) {
        int[][] num = new int[][]{{3, 3}};

        for (int i = 0; i < 10; i++) {
            int randomNum = (int) (Math.random() * 6) + 1;
            System.out.println(randomNum);
        }
    }
}

public class IntObject {
    private int num;
    public IntObject() {
        num = 0;
    }
    public IntObject(int n) {
        num = n;
    }
    public void increment() {
        num++;
    }

        public static IntObject someMethod(IntObject obj) {
            IntObject ans = obj;
            ans.increment();
            return ans;

    }

    public static void main(String[] args) {
        IntObject x = new IntObject(2);
        IntObject y = new IntObject(7);
        IntObject a = y;
        x = someMethod(y);
        a = someMethod(x);

        System.out.println(x.num);
        System.out.println(y.num);
        System.out.println(a.num);
    }
}

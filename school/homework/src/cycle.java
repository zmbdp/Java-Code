public class cycle {
    public static void main(String[] args) {
        System.out.println(circulate(1));
        System.out.println(circulate(1,2));
        System.out.println(circulate(1,2,3));
    }
    public static double circulate(int a) {
        double ret = 0;
        for (double i = 1; i < 100; i += 2) {
            ret += 1 / (i * i);
        }
        return ret;
    }
    public static double circulate(int a, int b) {
        double ret = 0;
        double i = -1;
        while ((i += 2) < 100) {
            ret += 1 / (i * i);
        }
        return ret;
    }
    public static double circulate(int a, int b, int c) {
        double ret = 0;
        double i = 1;
        do {
            ret += 1 / (i * i);
        }
        while ((i += 2) < 100);
        return ret;
    }
}

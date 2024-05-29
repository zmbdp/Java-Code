package xi_er_pai_xu;
import java.util.Random;

public class Test {
    public static void testShellSort(int[] array) {
        long startTime = System.currentTimeMillis();
        ShellSort.shellSort(array);
        long endtTime = System.currentTimeMillis();
        System.out.println("时间->" + (endtTime - startTime));
    }

    public static void orderArray(int[] array) {
        Random ra = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ra.nextInt(1000);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100_0000];
        orderArray(array);
        testShellSort(array);
    }
}

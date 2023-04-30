package fanxing;
//静态泛型
class FinMax {
    public static<T extends Comparable<T>> T finMax(T[] arrays) {
        T max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (max.compareTo(arrays[i]) < 0) {
                max = arrays[i];
            }
        }
        return max;
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Integer[] irr = {123,2341,543,564,213,654,6754};
        int max = FinMax.finMax(irr);
        System.out.println(max);
        System.out.println("==================");
        String[] srr = {"asfds", "dsfdaf", "sdfargfreg", "sdafsdfsd"};
        String max1 = FinMax.finMax(srr);
        System.out.println(max1);
    }
}



//非静态
/*class FinMax<T extends Comparable<T>> {//表示不擦除为Object类，擦除为一个实现了Comparable接口的类
    public T finMax(T[] arrays) {
        T max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (max.compareTo(arrays[i]) < 0) {
                max = arrays[i];
            }
        }
        return max;
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Integer[] irr = {123,2341,543,564,213,654,6754};
        FinMax<Integer> finMaxI = new FinMax<>();
        int max = finMaxI.finMax(irr);
        System.out.println(max);


        String[] srr = {"asfds", "dsfdaf", "sdfargfreg", "sdafsdfsd"};
        FinMax<String> finMaxS = new FinMax<>();
        String max1 = finMaxS.finMax(srr);
        System.out.println(max1);
    }
}*/

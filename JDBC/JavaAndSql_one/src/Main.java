import org.omg.PortableServer.ForwardRequestHelper;
import sun.text.resources.et.FormatData_et_EE;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    /*public int halveArray(int[] nums) {
        int count = 1;
        Queue<Double> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int x : nums) {
            double a = (double)x;
            sum += a;
            queue.offer(a);
            Map map = new HashMap<>();
            map.put(1,3);
            Set set = new HashSet();
            set.add(1);
        }
        sum /= 2;
        double cum = 0;
        while (true) {
            double n = queue.poll() / 2;
            cum += n;
            queue.add(n);
            // 如果拿出的数字加起来是大于等于 sum 的，就弹出
            if (cum >= sum) {
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {5,19,8,1};
        System.out.println(new Main().halveArray(arr));
    }*/


    /*public String largestNumber(int[] nums) {
        // 先创建好数组
        String[] arr = new String[nums.length];
        int i = 0;
        for (int x : nums) {
            // 把所有数字全部转化成字符串，再比较 ASLL 码的大小来排序
            arr[i++] = String.valueOf(x);
        }
        // 判断，如果把 a 拼接上 b 小于 b 拼接上 a，那就返回 b 拼接上 a
        Arrays.sort(arr, (a , b) -> (b + a).compareTo(a + b));

        //String str = String.join("", arr);// 字符串拼接
        StringBuffer str = new StringBuffer();
        for (String x : arr) {
            str.append(x);
        }

        // 判断第一个字符串是否为 0 ，如果为 0 ，那后面的就全是 0 ，直接返回 0
        return str.charAt(0) == '0' ? "0" : str.toString();
    }*/
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        // 设置一个标志性的数字，如果下次要大于零，他就为 1 ，如果下次要小于 0 ，他就为-1
        int logo = (nums[1] - nums[0]) > 0 ? -1 : 1;
        int count = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            // loge 记录上次的数值，如果大于零，但是这次还是大于 0 ，那就直接返回
            if (logo > 0) {
                logo *= (nums[i] - nums[i - 1]);
                logo = (logo % 2818) == 0 ? (logo % 2818) : (logo % 2819);
                if (logo >= 0) {
                    if (logo == 0) {
                        left = -1;
                        logo = 1;
                    }
                    if (((nums[i] - nums[i - 1]) < 0) && left > 0) {
                        count++;
                    }
                    continue;
                }
                count++;
            }
            // 说明上一次是正数
            else if (logo < 0) {
                logo *= -(nums[i] - nums[i - 1]);
                logo = (logo % 2818) == 0 ? (logo % 2818) : (logo % 2819);
                if (logo <= 0) {
                    // 如果为 0 了，得把它变回去
                    // 在这里，说明上一个是正数，下一个就要是负的
                    if (logo == 0) {
                        left = 1;
                        logo = -1;
                    }
                    if (((nums[i] - nums[i - 1]) > 0) && left < 0) {
                        count++;
                    }
                    continue;
                }
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,7};
        System.out.println(new Main().wiggleMaxLength(arr));
    }

}
import java.util.*;

public class Solution1 {
    public static void isDays(int year,int month,int day) {
        
    }
    public int numJewelsInStones(String jewels/*宝石的类型*/, String stones/*你手里有的所有东西*/) {
        Set<Character> set = new TreeSet<>();
        Set<Integer> set1 = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("eqrw",99);
        map.put("weqr",29);
        map.put("weq",29);
        map.put("adfs",9);
        System.out.println(map.get(12));
        System.out.println(map);
        int i = 0;
        while (i < jewels.length()) {
            set.add(jewels.charAt(i));
            i++;
        }
        i = 0;
        int count = 0;
        while (i < stones.length()) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
            i++;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入宝石类型->");
        String jewels = sc.nextLine();//aA
        System.out.print("请输入您拥有的石头->");
        String stones = sc.nextLine();//aAAbbbb
        System.out.println(solution.numJewelsInStones(jewels, stones));
    }
}
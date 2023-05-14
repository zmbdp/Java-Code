import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class demo1 {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();//双链表
        //没有单链表
        List<Integer> arrayList = new ArrayList<>();//顺序表
        int[] arr = {1, 2, 3, 4};
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        linkedList.addAll(arrayList);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList);
        System.out.println("==================");

        ListIterator<Integer> lis = linkedList.listIterator();
        while (lis.hasNext()) {
            System.out.print(lis.next() + " ");
        }
        System.out.println();
        System.out.println("==================");

        ListIterator<Integer> lis2 = linkedList.listIterator(linkedList.size());
        while (lis2.hasPrevious()) {
            System.out.print(lis2.previous() + " ");
        }
        System.out.println();
        System.out.println("==================");
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(linkedList);
        System.out.println(lists);
        System.out.println(lists.get(0));
        System.out.println("==================");
    }
}

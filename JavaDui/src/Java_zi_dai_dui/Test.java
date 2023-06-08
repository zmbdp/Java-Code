package Java_zi_dai_dui;
import java.util.*;

class Student {
    public int age;
    public String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

/**实现比较器
 * 比较年龄，年龄大的放前面
 */
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age - o1.age;
    }
}

/**实现比较器
 * 比较名字，大根堆
 */
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.name.compareTo(o1.name);
    }
}
class IntSort implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class Test {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        // IDEA自带的双端队列（堆）是自动默认小顶堆
        priorityQueue1.offer(11);
        priorityQueue1.offer(6);
        priorityQueue1.offer(1);
        priorityQueue1.offer(8);
        priorityQueue1.offer(9);
        System.out.println(priorityQueue1.peek());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        Student s1 = new Student(11, "张三");
        Student s2 = new Student(9, "李四");
        AgeComparator ageComparator = new AgeComparator();
        NameComparator nameComparator = new NameComparator();
        //按什么排序自个儿控制
        PriorityQueue<Student> pStudent = new PriorityQueue<>(ageComparator);
        pStudent.offer(s1);
        pStudent.offer(s2);
        System.out.println(pStudent.poll());
        int a = 1;
        int b = 3;
        // 把排序传过去，从小到大排序
        IntSort sort = new IntSort();
        PriorityQueue<Integer> iPriorityQueue = new PriorityQueue<>(sort);
        iPriorityQueue.offer(a);
        iPriorityQueue.offer(b);
        System.out.println(iPriorityQueue.poll());
        System.out.println(iPriorityQueue.poll());
    }
}

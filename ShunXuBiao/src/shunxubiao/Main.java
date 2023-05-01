package shunxubiao;

public class Main {
    public static void main(String[] args) {
        //尾插
        System.out.print("尾插->");
        SeqList seqList = new SeqList(3);
        seqList.add(23542);
        seqList.add(2352);
        seqList.add(242);
        seqList.add(252);
        seqList.add(2);
        seqList.display();//打印数组
        System.out.println("==================");
        System.out.println();
        //删除
        seqList.display();
        System.out.println("删除->");
        seqList.remove(252);
        seqList.remove(2352);
        seqList.display();
        System.out.println("==================");
        System.out.println();
        //查找
        seqList.display();
        System.out.println("查找位置元素->");
        try {
            System.out.print(seqList.get(1) + " ");
            System.out.println(seqList.get(10));
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("输入下标不合法!!!");
        } catch (Exception e){
            System.out.println("出现异常");
            e.printStackTrace();
        }
        System.out.println("==================");
        System.out.println();
        System.out.println("查找元素位置->");
        System.out.print(seqList.indexOf(242) + ",");
        System.out.println(seqList.indexOf(23542));
        System.out.println("==================");
        System.out.println();
        //改值
        seqList.display();
        System.out.println("改值->");
        seqList.set(3,99);
        seqList.display();
        System.out.println("==================");
        System.out.println();
        //在任意位置新增元素
        seqList.display();
        System.out.println("在任意位置新增元素->");
        seqList.add(2,55);
        seqList.add(4,52);
        seqList.display();
        System.out.println("==================");
        System.out.println();
        //检查是否包含某个元素
        System.out.println("检查是否包含某个元素->");
        System.out.println(seqList.contains(23542));
        System.out.println(seqList.contains(52));
        System.out.println(seqList.contains(5));
        System.out.println("==================");
        System.out.println();
        //清空顺序表
        System.out.println("清空顺序表");
        seqList.clear();
    }
}

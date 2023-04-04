public class ZuoChe{
	public static void main(String[] args){
        //一开始没有乘客。
        int a = 0;
        //第一站:上去一位乘客
        a++;
        //第二站:上去两位乘客,下来一位乘客
        a += 2 - 1;
        //第三站:上去两位乘客,下来一位乘客
        a += 2 - 1;
        //第四站:下来一位乘客
        a--;
        //第五站:上去一位乘客
        a++;
        //请问:到了终点站，车上一共几位乘客。
        System.out.println("到了终点站，一共有" + a + "人");
    }
}
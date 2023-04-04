public class ZiMianLiang{
	public static void main(String[] args){
		
		//数字的书写格式
		
		//整数格式：
		System.out.println(666);
		System.out.println(-132);
		
		System.out.println();
		
		//小数格式：
		System.out.println(6.6);
		System.out.println(-1.2);
		
		
		System.out.println();//换行
		
		
		//字符格式
		//字符串格式:
		System.out.println("abcd");
		
		//单个字符格式：
		System.out.println('A');
		
		
		System.out.println();//换行
		
		
		//布尔值(bool)
		System.out.println(true);
		System.out.println(false);
		
		
		System.out.println();//换行
		
		
		//空(NULL)
		//细节：NULL不能直接打印的。
		//如果我们要打印NULL，那么只能用字符串的形式进行打印
		System.out.println("NULL");//NULL不能直接打印，会报错
		
		
		System.out.println();//换行
		
		
		//‘\t’(水平制表符)
		//没加的时候：
		System.out.println("name:付豪");
		System.out.println("age:19");
		
		System.out.println();//换行
		
		//加了的时候
		System.out.println("name:" + "\t" + "付豪");
		System.out.println("age:" + "\t" + 19);
	}
}
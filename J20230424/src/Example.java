public class Example{
    String str = new String("good");
    char[] ch = { 'a' , 'b' , 'c' };
    public static void main(String[] args){
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
        Integer[] a = {1, 2, 3};
        for (int x : a) {
            System.out.println(x);
        }
    }
    public void change(String str, char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }
}
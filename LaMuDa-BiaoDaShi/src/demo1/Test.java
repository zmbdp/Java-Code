package demo1;

//1、无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//2、无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//3、无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//4、有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//5、有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//6、有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class Test {
    /*
        1、无返回值无参数
        @FunctionalInterface
        interface NoParameterNoReturn {
          void test();
        }
=======================================================================================================
        2、无返回值一个参数
        @FunctionalInterface
        interface OneParameterNoReturn {
            void test(int a);
        }
=======================================================================================================
        3、无返回值多个参数
        @FunctionalInterface
        interface MoreParameterNoReturn {
            void test(int a,int b);
        }
     */

    /**
     * 无返回值的
     */
    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()->System.out.println("1、无返回值无参数—>  ");
        noParameterNoReturn.test();
        System.out.println("=================================");
        OneParameterNoReturn oneParameterNoReturn = (x)->{
            System.out.print("2、无返回值一个参数—> ");
            System.out.println(x);
        };
        oneParameterNoReturn.test(10);

        System.out.println("=================================");
        MoreParameterNoReturn moreParameterNoReturn = (x, y)->{
            System.out.print("3、无返回值多个参数—> ");
            System.out.println(x + "," + y);
        };
        moreParameterNoReturn.test(10 , 20);
    }


    /*
      4、有返回值无参数
        @FunctionalInterface
        interface NoParameterReturn {
            int test();
        }
        5、有返回值一个参数
        @FunctionalInterface
        interface OneParameterReturn {
            int test(int a);
        }
        6、有返回值多参数
        @FunctionalInterface
        interface MoreParameterReturn {
            int test(int a,int b);
        }
     */
    public static void main(String[] args) {
        //NoParameterReturn noParameterReturn = () ->{return 10;};
        // 简写
        NoParameterReturn noParameterReturn = () -> 10;
        System.out.println("4、有返回值无参数");
        System.out.println(noParameterReturn.test());
        System.out.println("=================================");
        System.out.println("5、有返回值一个参数");
        OneParameterReturn oneParameterReturn = x -> x * 2;
        System.out.println(oneParameterReturn.test(10));
        System.out.println("=================================");
        System.out.println("6、有返回值多参数");
        MoreParameterReturn moreParameterReturn = (a, b) -> a * b;
        System.out.println(moreParameterReturn.test(10, 20));
    }
}

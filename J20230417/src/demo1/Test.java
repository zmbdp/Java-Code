package demo1;


interface IShape {
    ///*public static final */int n = 1;//接口中的成员变量默认是->public static final，不写也不会报错
    /*public abstract*/ void drow();//接口中的抽象方法默认是->public abstract

    //只留抽象方法，保持代码简洁性
    /*default *//*public*//* void drow1() {//接口中的public都可以不写
        System.out.println("父类drow1");
    }
    *//*public*//* static void drow2() {
        System.out.println("父类drow2");
    }*/

}
class Cycle implements IShape {//类和接口之间，必须使用关键字->implements来进行关联
    @Override
    public void drow() {
        System.out.println("子类drow");
    }
    /*public static void drow2() {//父类的default方法是否重写都可以，不会报错，具体需要看需求
        System.out.println("子类drow2");
    }*/
    /*void drow2() {
        System.out.println("子类drow2");
    }*/
}
class Rectangle implements IShape {
    @Override
    public void drow() {
        System.out.println("□");
    }
}
class Flower implements IShape {
    @Override
    public void drow() {
        System.out.println("❀");
    }
}


public class Test {
    public static void drow(IShape sh) {
        sh.drow();
    }
    public static void main(String[] args) {
        //IShape is = new IShape();//接口函数不可被new实例化对象
        //cy.drow2();//因为有了static关键字，所以不可被对象调用
        Cycle cy = new Cycle();
        //cy.drow1();
        //IShape.drow2();//只能通过类名访问
        //Cycle.drow2();因为有static关键字修饰，所以不能进行重写
        System.out.println("=========");
        IShape is[] = {new Rectangle(), new Flower(), new Cycle(), new Flower()};
        for (IShape x : is) {
            Test.drow(x);
        }
    }
}





















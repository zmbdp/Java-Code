package abstractMethods;

//加了 “abstract” 的这个类就叫抽象类
abstract class Shapes {//形状
    public abstract void draw() ;//这个方法叫抽象方法，不用写大括号
}
class Triangle extends Shapes {
    @Override
    public void draw() {
        System.out.println("▲");
    }
}
class Rectangle extends Shapes {
    @Override
    public void draw() {
        System.out.println("□");
    }
}
class Flower extends Shapes {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Rotundity extends Shapes {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}


public class School {
    public static void main(String[] args) {
        Shapes shapes[] = {new Rectangle(), new Rotundity(), new Triangle(), new Flower(), new Triangle()};
                            //  矩形              圆               三角形        花
        for (Shapes x : shapes) {
            x.draw();
        }
        //抽象方法不能实例化对象，会报错
        //shapes sh = new abstractMethods.Shapes();
    }
}

package dayintuxing;

import javafx.scene.shape.DrawMode;
import org.omg.PortableServer.ForwardRequestHelper;

import java.sql.SQLOutput;
import java.util.Objects;

class Shapes {//形状
    public void draw() {

    }
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
public class Graphics {
    public static void main(String[] args) {
        Shapes shapes[] = {new Rectangle(), new Rotundity(), new Triangle(), new Flower(), new Triangle()};
                            //  矩形              圆               三角形        花
        for (Shapes x : shapes) {
            x.draw();
        }
    }
}

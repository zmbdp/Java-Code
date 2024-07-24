import java.util.Scanner;

class Shape {
    private final double radius;
    public Shape(double radius)
    {
        this.radius = radius;
    }
    public double getArea()
    {
        return (3.14 * radius * radius);
    }
    public double getCircum()
    {
        return (2 * 3.14 * radius);
    }
}
public class MyShape {
    public static void main(String[] args) {
        double radius;
        System.out.print("请输入圆的半径->");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            radius = sc.nextDouble();
            Shape shape = new Shape(radius);
            System.out.println("原的面积为：" + shape.getArea());
            System.out.println("原的周长为：" + shape.getCircum());
            System.out.print("\n请输入圆的半径->");
        }
    }
}
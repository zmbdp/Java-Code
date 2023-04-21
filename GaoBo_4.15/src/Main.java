import java.util.Scanner;

/**
 * 有父类Base，内部定义了x、y属性。有子类Sub，继承自父类Base。
 * 子类新增了一个z属性，并且定义了calculate方法，
 * 在此方法内计算了父类和子类中x、y、z属性三者的乘积。
 * 请补全子类构造方法的初始化逻辑，使得该计算逻辑能够正确执行。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            Sub sub = new Sub(x, y, z);
            System.out.println(sub.calculate());
        }
    }
}
class Base {
    private int x;
    private int y;
    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
class Sub extends Base {
    private int z;
    public Sub(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
    public int getZ() {
        return z;
    }
    public int calculate() {
        return super.getX() * super.getY() * this.getZ();
    }
}
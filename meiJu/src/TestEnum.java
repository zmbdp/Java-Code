import java.time.temporal.ValueRange;

public enum TestEnum {
    RED,BLACK,GREEN,WHITE;

    public static void main(String[] args) {
        TestEnum testEnum = TestEnum.BLACK;
        switch (testEnum) {
            case RED:
                System.out.println("RED = " + testEnum.ordinal());
                break;
            case BLACK:
                System.out.println("BLACK = " + testEnum.ordinal());
                break;
            case GREEN:
                System.out.println("GREEN = " + testEnum.ordinal());
                break;
            default:
                System.out.println("颜色错误！！！");
                break;
        }
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 1; i < testEnums.length; i++) {
            System.out.print(i + " = " + testEnums[i]);
            ifi(i);
        }
    }

    private static void ifi(int i) {
        TestEnum[] testEnums = TestEnum.values();
        if (i < testEnums.length) {
            System.out.print(" ; ");
        }
    }
}
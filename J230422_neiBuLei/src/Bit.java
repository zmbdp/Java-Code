public class Bit {
    public static void main(String[] args) {
        String str = "Hello, my name is John";
        char[] crr = str.toCharArray();
        int count = 1;
        if (crr.length == 0) {
            count = 0;
        }
        else {
            for (int i = 1; i < crr.length; i++) {
                if ((!(((crr[i] >= 'A') && (crr[i - 1] <= 'Z')) || ((crr[i] >= 'a') && (crr[i] <= 'z'))))) {
                    if ((((crr[i - 1] >= 'A') && (crr[i - 1] <= 'Z')) || ((crr[i - 1] >= 'a') && (crr[i - 1] <= 'z')))) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

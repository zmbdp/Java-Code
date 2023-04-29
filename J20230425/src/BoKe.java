import java.text.*;
import java.util.Date;

public class BoKe {
    public static void main(String[] args) {
        String strDate = "2021-07-01";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(strDate);
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("日期格式不正确！");
            e.printStackTrace();
        }
    }
}

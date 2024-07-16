/**
 * 编写程序，对输入的年、月、日，给出该天是该年的第多少天？
 * 例如：2022年1月15日，是该年的第15天
 */

import java.util.Scanner;

public class Solution1 {
    public static boolean leapYearYesOrNo(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void isDays(int year, int month, int day) {
        if (month > 12 || month < 1 || day > 31 || day < 1) {
            System.out.println("输入错误!!!");
            return;
        }
        int countDay = -2;
        int count = 0;
        if (leapYearYesOrNo(year) && month > 2) {
            countDay++;
        }
        if (month > 1){
            int newMonth = month;
            while (newMonth > 0) {
                newMonth -= 2;
                count++;
            }
            countDay += ((((count - 1) * 31) + ((month - count) * 30)) + day);
            System.out.println(year + "年" + month + "月" + day + "日，是该年的第" + countDay + "天");
        }
        else {
            System.out.println(year + "年" + month + "月" + day + "日，是该年的第" + day + "天");
        }
    }

    public static void main(String[] args) {
        int year = 0;
        int month = 0;
        int day = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入年份->");
        year = sc.nextInt();
        System.out.print("请输入月份->");
        month = sc.nextInt();
        System.out.print("请输入天数->");
        day = sc.nextInt();
        isDays(year,month,day);
    }
}

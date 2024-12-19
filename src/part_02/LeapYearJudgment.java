package part_02;

import java.util.Scanner;

public class LeapYearJudgment {
    public static void main(String[] args) {
        // 能被400整除
        // 能被4整除，但不被100整除
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = input.nextInt();
        if(year%400==0 || (year%4==0&&year%100!=0)){
            System.out.printf("%d是闰年", year);
        }else{
            System.out.printf("%d不是闰年", year);
        }
        input.close();
    }
}

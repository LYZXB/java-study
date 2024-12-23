package part_03;

import java.util.Random;
import java.util.Scanner;

public class Math_GuessNumber {
    public static void main(String[] args) {
        // 编写一个 Java 程序，生成一个 1 到 100 之间的随机整数，要求用户猜测该数字。
        // 程序根据用户的输入给予提示“猜大了”或“猜小了”，直到用户猜中为止，并统计用户猜测的次数。
        Random random = new Random();
        int targetInt = random.nextInt(101);
//        double targetDouble = Math.random()*100;
        boolean isFind = false;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        try(sc){
            while (!isFind) {
                System.out.println("请输入你的正整数数字：");
                int inputInt = sc.nextInt();
                count++;
                if (inputInt == targetInt) {
                    isFind = true;
                    System.out.println("恭喜你猜对了！一共猜了" + count + "次。");
                } else if (inputInt > targetInt) {
                    System.out.println("输入数字太大了！");
                } else {
                    System.out.println("输入数字太小了！");
                }
            }
        }
    }
}

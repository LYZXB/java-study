package part_02;

import java.util.Scanner;

public class PrimeNumberJudgment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        int num = input.nextInt();
        if(num == 0 || num == 1){
            System.out.printf("%d不是质数", num);
        }
        for(int i = 2; i < num; i++){
            if(num%i==0){
                System.out.printf("%d不是质数", num);
                input.close();
                return;
            }
        }
        System.out.printf("%d是质数", num);
        input.close();
    }
}

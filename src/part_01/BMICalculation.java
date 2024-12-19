package part_01;

import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的体重(kg)：");
        double weight = input.nextDouble();
        System.out.print("请输入您的身高(m)：");
        double height = input.nextDouble();
        System.out.printf("您的BMI指数是：%.2f", weight/(height*height));
    }
}

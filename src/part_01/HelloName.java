package part_01;

import java.util.Scanner;

public class HelloName {
    public static void main(String[] args) {
        System.out.print("请输入你的名字：");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}

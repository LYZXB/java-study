package part_03;

import java.util.Scanner;

public class Math_SphereCalculation {
    public static void main(String[] args) {
        System.out.print("请输入球体的半径：");
        Scanner input = new Scanner(System.in);
        try(input){
            double radius = input.nextDouble();
            // 需要注意类型自动转换问题，如果4/3放在前面，会默认值为int，计算后得到1.
            System.out.printf("球体的体积是,%.2f%n", 4.0/3.0*Math.PI*Math.pow(radius, 3));
//            System.out.printf("球体的体积是,%.2f%n", Math.PI*Math.pow(radius, 3)*4/3);
            System.out.printf("球的表面积是,%.2f%n", 4*Math.PI*Math.pow(radius, 3));
        }
    }
}

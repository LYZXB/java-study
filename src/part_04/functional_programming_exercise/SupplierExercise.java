package part_04.functional_programming_exercise;

import java.util.function.Supplier;

public class SupplierExercise {
    public static void main(String[] args) {
        // 不接受任何输入，但返回一个类型为 T 的结果。
        // 用于生成随机数
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println("Random number: " + randomSupplier.get());
    }
}

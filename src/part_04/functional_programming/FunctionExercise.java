package part_04.functional_programming;

import java.util.function.Function;

public class FunctionExercise {
    public static void main(String[] args) {
        // 接受一个输入类型为 T 的参数，并返回一个类型为 R 的结果。
        // 用于将字符串转换为其长度
        Function<String, Integer> stringLength = str -> str.length();

        System.out.println("Length of 'Hello': " + stringLength.apply("Hello")); // 输出: 5
    }
}

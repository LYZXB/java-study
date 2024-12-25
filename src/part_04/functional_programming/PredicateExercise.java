package part_04.functional_programming;

import java.util.function.Predicate;

public class PredicateExercise {
    public static void main(String[] args) {
        // 接受一个输入类型为 T 的参数，并返回一个布尔值。通常用于条件判断。
        // 用于检查字符串是否为空
        Predicate<String> isEmpty = str -> str == null || str.isEmpty();

        System.out.println("Is 'Hello' empty? " + isEmpty.test("Hello")); // 输出: false
        System.out.println("Is '' empty? " + isEmpty.test("")); // 输出: true
    }
}

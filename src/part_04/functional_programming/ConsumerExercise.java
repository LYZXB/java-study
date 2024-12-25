package part_04.functional_programming;

import java.util.function.Consumer;

public class ConsumerExercise {
    public static void main(String[] args) {
        // 接受一个输入类型为 T 的参数，并执行某种操作（无返回值）。
        // 用于打印字符串
        Consumer<String> printString = str -> System.out.println(str);

        printString.accept("Hello, World!"); // 输出: Hello, World!
    }
}

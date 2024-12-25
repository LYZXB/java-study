package part_04.generic;

import java.lang.reflect.Array;
import java.util.function.Function;

public class ContainerUtil {
    public static <T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for(int i = 1; i<array.length; i++){
            // 使用compareTo，把对比的策略和责任放在对应泛型类中，保证扩展性和可读性。
            if(array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }
    public static <T, U> U[] convertArray(T[] array, Function<T, U> converter, Class<U> clazz){
        U[] us = (U[]) Array.newInstance(clazz, array.length);
        for(int i = 0; i < array.length; i++){
            us[i] = converter.apply(array[i]);
        }
        return us;
    }
    public static <T> void swapElements(T[] array, int i, int j){
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

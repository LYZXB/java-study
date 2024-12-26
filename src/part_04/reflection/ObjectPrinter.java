package part_04.reflection;

import java.lang.reflect.Field;

public class ObjectPrinter {
    public void printObject(Object obj){
        Class<?> objClass = obj.getClass();
        Field[] declaredFields = objClass.getDeclaredFields();
        for (Field field: declaredFields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + ":" + field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

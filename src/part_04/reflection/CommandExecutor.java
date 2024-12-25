package part_04.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandExecutor {
    /**
     * @param commandName 类名必须和命令名对应，SayHello命令对应SayHelloCommand类
     */
    public void ExecuteCommand(String commandName) {
        try {
            // 此处要求命令类和此类在同一个包中，否则全限定名会组装错误。当然也可以用其他方式获取命令类包名，例如当做构造参数传入此类实例中。
            Class<?> commandClazz = Class.forName(this.getClass().getPackageName() + "."
                    + commandName + "Command");
            // 使用反射函数方式调用
//            Object o = commandClazz.getDeclaredConstructor().newInstance();
//            Method exec = commandClazz.getMethod("exec");
//            exec.invoke(o);
            // 使用接口塑性方式调用
            Command command = (Command) commandClazz.getDeclaredConstructor().newInstance();
            command.exec();
        } catch (ClassNotFoundException e) {
            System.out.println("找不到对应的命令！");
            throw new RuntimeException(e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

package part_04.reflection;

public class CommandExecutionMain {
    public static void main(String[] args) {
        String commandStr = "SayHello";
        String commandStr2 = "SayGoodbye";
        CommandExecutor executor = new CommandExecutor();
        executor.ExecuteCommand(commandStr);
        executor.ExecuteCommand(commandStr2);
    }
}

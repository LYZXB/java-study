package part_04.reflection;

public class SayHelloCommand implements Command{
    @Override
    public void exec() {
        System.out.println("Hello!");
    }
}

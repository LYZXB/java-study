package part_04.reflection;

public class SayGoodbyeCommand implements Command{
    @Override
    public void exec() {
        System.out.println("Good Bye!");
    }
}

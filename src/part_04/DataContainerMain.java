package part_04;

public class DataContainerMain {
    public static void main(String[] args) {
        // 尝试使用DataContainer做字符串增删查找、遍历操作。
        // 使用ArrayList作为底层存储，而ArrayList也是支持泛型的，所以看起来就是对ArrayList做了一个简单包装。但是可以添加新功能，会更灵活
        DataContainer<String> strDC = new DataContainer<>();
        strDC.add("test1");
        strDC.add("hello1");
        strDC.add("world1");
        strDC.add("java1");
        strDC.foreach(str -> System.out.print(str + " "));
        strDC.remove("hello1");
        System.out.println();
        strDC.foreach(str -> System.out.print(str + " "));
    }
}

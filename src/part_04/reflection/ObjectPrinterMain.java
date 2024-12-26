package part_04.reflection;

import part_03.Student;

import java.util.HashMap;

public class ObjectPrinterMain {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("zss");
        HashMap<String, Float> gradesMap = new HashMap<>();
        gradesMap.put("shu", 80f);
        gradesMap.put("yu", 100f);
        stu.setGradesMap(gradesMap);
        ObjectPrinter objPrinter = new ObjectPrinter();
        objPrinter.printObject(stu);
    }
}

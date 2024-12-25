package part_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StudentGradeManager {
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 18, 100);
        Student stu2 = new Student("lisi", 17, 90);
        Student stu3 = new Student("wangwu", 16, 10);
        Student stu4 = new Student("zhuda", 19, 80);
        Student stu5 = new Student("waner", 20, 90);
        Student stu6 = new Student("yangliu", 21, 40);
        List<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stuList.add(stu6);

        // 过滤出成绩大于 60 分的学生。 jdk16+
        List<Student> passList = stuList.stream().filter(stu -> stu.getGrace() > 60).toList();
        passList.forEach(stu -> System.out.println(stu.toString()));
        // 将这些学生的姓名转换为大写。
        stuList.forEach(stu -> stu.setName(stu.getName().toUpperCase()));
        stuList.forEach(stu -> System.out.println(stu.toString()));
        // 对这些学生按成绩进行排序（从高到低）。
//        Comparator<Student> studentComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if(o1.getGrace() > o2.getGrace()){
//                    return -1;
//                } else if (o1.getGrace() == o2.getGrace()){
//                    return 0;
//                }
//                return 1;
//            }
//        }
        stuList = stuList.stream().sorted((o1, o2) -> {
            if(o1.getGrace() > o2.getGrace()){
                return -1;
            } else if (o1.getGrace() == o2.getGrace()){
                return 0;
            }
            return 1;
        }).toList();
        stuList.forEach(stu -> System.out.println(stu.toString()));
        // 计算这些学生的平均成绩。
        double graceAverage = stuList.stream().mapToDouble(Student::getGrace).average().getAsDouble();
        System.out.println(graceAverage);
        // 计算这些学生的总成绩。
        double graceSum = stuList.stream().mapToDouble(Student::getGrace).reduce(0, Double::sum);
        System.out.println(graceSum);
    }
}

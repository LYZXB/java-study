package part_03;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManager {
    private static Map<String, Student> studentMap = new HashMap<>();
    private static boolean isExit = false;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        homepageShow(input);
        input.close();
    }
    private static void homepageShow(Scanner input){
        System.out.println("欢迎来到学生成绩管理系统首页！请输入对应编号进行操作。");
        System.out.println("1.查看学生列表");
        System.out.println("2.添加学生");
        System.out.println("3.添加学生成绩");
        System.out.println("4.修改学生成绩");
        System.out.println("5.删除学生成绩");
        System.out.println("6.查看所有学生成绩列表");
        System.out.println("7.查看指定学生列表");
        System.out.println("q.退出");
        while(!isExit){
            String str = input.nextLine();
            if(str.equalsIgnoreCase("q")){
                isExit = true;
                break;
            }
            // TODO: 怎样减少重复代码？退出是否可以统一控制？
            switch (str){
                case "1": queryStudentListShow(input);break;
                case "2":addStudentShow(input);break;
                case "3":addStudentGradesShow(input, "添加");break;
                case "4":addStudentGradesShow(input, "修改");break;
                case "5":deleteStudentGradesShow(input);break;
                case "6":queryStudentGradesListShow(input);break;
                case "7":queryStudentGradesShow(input);break;
                default:
                    System.out.println("请输入数字1-7执行对应功能，或者输入q退出");
            }
        }
    }

    private static void queryStudentListShow(Scanner input){
        System.out.println("查看学生列表页面！返回首页请输入q。");
        int i = 1;
        for(Map.Entry<String, Student> entry : studentMap.entrySet()){
            System.out.printf("学生%d：%s%n",i++, entry.getValue().getName());
        }
        while(true){
            String str = input.nextLine();
            if(str.equalsIgnoreCase("q")){
                homepageShow(input);
                break;
            }
        }
    }
    private static void addStudentShow(Scanner input){
        System.out.println("添加学生页面！返回首页请输入q。");
        while(true){
            System.out.print("请输入学生姓名(返回首页输入q):");
            String str = input.nextLine();
            if (str.equalsIgnoreCase("q")) {
                homepageShow(input);
                return;
            } else {
                Student stu = new Student();
                stu.setName(str);
                studentMap.put(str, stu);
            }
        }
    }
    private static void addStudentGradesShow(Scanner input, String operation){
        System.out.printf("%s学生成绩页面！返回首页请输入q。%n", operation);
        while(true){
            System.out.print("请输入学生姓名(返回首页输入q):");
            String str = input.nextLine();
            if (str.equalsIgnoreCase("q")) {
                homepageShow(input);
                return;
            } else {
                Student stu = studentMap.get(str);
                if (stu != null) {
                    HashMap<String, Float> gradesMap1 = stu.getGradesMap();
                    HashMap<String, Float> gradesMap = gradesMap1 == null?new HashMap<>():gradesMap1;
                    addStudentGrades(input, gradesMap);
                    stu.setGradesMap(gradesMap);
                    System.out.printf("学生%s成绩：%s%n", str, stu.getGradesString());
                } else {
                    System.out.println("学生不存在！");
                }
            }
        }
    }
    private static void addStudentGrades(Scanner input, HashMap<String, Float> gradesMap){
        while(true){
            System.out.print("请输入科目(返回上一页输入q)：");
            String clazz = input.nextLine();
            if(clazz.equalsIgnoreCase("q")){
                return;
            }
            System.out.print("请输入成绩(返回上一页输入q)：");
            String gradesStr = input.nextLine();
            if(gradesStr.equalsIgnoreCase("q")){
                return;
            }
            gradesMap.put(clazz, Float.parseFloat(gradesStr));
            System.out.printf("%s成绩设置成功%n", clazz);
        }
    }
    private static void deleteStudentGradesShow(Scanner input){
        System.out.println("添加学生成绩页面！返回首页请输入q。");
        while(true){
            System.out.print("请输入学生姓名(返回首页输入q):");
            String str = input.nextLine();
            if (str.equalsIgnoreCase("q")) {
                homepageShow(input);
                return;
            } else {
                Student stu = studentMap.get(str);
                if (stu != null) {
                    HashMap<String, Float> gradesMap = new HashMap<>();
                    deleteStudentGrades(input, gradesMap);
                    stu.setGradesMap(gradesMap);
                    System.out.printf("学生%s成绩：%s%n", str, stu.getGradesString());
                } else {
                    System.out.println("学生不存在！");
                }
            }
        }
    }
    private static void deleteStudentGrades(Scanner input, HashMap<String, Float> gradesMap){
        while(true){
            System.out.print("请输入科目(返回首页输入q)：");
            String clazz = input.nextLine();
            if(clazz.equalsIgnoreCase("q")){
                return;
            }
            gradesMap.remove(clazz);
            System.out.printf("%s成绩删除成功%n", clazz);
        }
    }
    private static void queryStudentGradesListShow(Scanner input){
        System.out.println("查看所有学生成绩列表页面！返回首页请输入q。");
        for(Map.Entry<String, Student> entry : studentMap.entrySet()){
            HashMap<String, Float> gradesMap = entry.getValue().getGradesMap();
            if(gradesMap != null && !gradesMap.isEmpty()){
                System.out.printf("学生%s：%s%n",entry.getKey(), entry.getValue().getGradesString());
            }
        }
        while(true){
            String str = input.nextLine();
            if(str.equalsIgnoreCase("q")){
                homepageShow(input);
                break;
            }
        }
    }
    private static void queryStudentGradesShow(Scanner input){
        System.out.println("查看指定学生成绩页面！返回首页请输入q。");
        while(true){
            System.out.print("请输入学生姓名(返回首页输入q):");
            String str = input.nextLine();
            if (str.equalsIgnoreCase("q")) {
                homepageShow(input);
                return;
            } else {
                Student stu = studentMap.get(str);
                if (stu != null) {
                    System.out.printf("学生%s成绩：%s%n", str, stu.getGradesString());
                } else {
                    System.out.println("学生不存在！");
                }
            }
        }
    }
}

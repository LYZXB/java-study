package part_03;


import java.util.*;

public class StudentManager {
    private static Map<String, Student> studentMap = new HashMap<>();
    private static int pageIndex = 0;
    // 不需要重复执行的功能页面
    private static Set<Integer> nonDuplicateExec = new HashSet<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        nonDuplicateExec.add(0);
        nonDuplicateExec.add(1);
        nonDuplicateExec.add(6);
        exec(input);
        input.close();
    }
    private static void pageload(Scanner input){
        switch (pageIndex) {
            case 0:
                System.out.println("欢迎来到学生成绩管理系统首页！请输入对应编号进行操作。");
                System.out.println("1.查看学生列表");
                System.out.println("2.添加学生");
                System.out.println("3.添加学生成绩");
                System.out.println("4.修改学生成绩");
                System.out.println("5.删除学生成绩");
                System.out.println("6.查看所有学生成绩列表");
                System.out.println("7.查看指定学生列表");
                System.out.println("q.退出");
                break;
            case 1:
                System.out.println("欢迎来到查看学生列表页面！返回首页请输入q。");
                break;
            case 2:
                System.out.println("欢迎来到添加学生页面！返回首页请输入q。");
                break;
            case 3:
                System.out.println("欢迎来到添加学生成绩页面！返回首页请输入q。");
                break;
            case 4:
                System.out.println("欢迎来到修改学生成绩页面！返回首页请输入q。");
                break;
            case 5:
                System.out.println("欢迎来到删除学生成绩页面！返回首页请输入q。");
                break;
            case 6:
                System.out.println("欢迎来到查看所有学生成绩列表页面！返回首页请输入q。");
                break;
            case 7:
                System.out.println("欢迎来到查看指定学生成绩页面！返回首页请输入q。");
                break;
            default:
                System.out.println("请输入正确指令，或者输入q退出。");
        }
    }
    private static void exec(Scanner input){
        // 持续等待用户输入，并执行对应代码。
        // 首先是判断退出或者进入页面操作，然后进行实际操作,例如查询增加等。
        while(true) {
            // 这个输入命令只针对当前页面是非重复页面，例如首页和单次查询。需要重复操作的页面，则直接跳过，进入重复操作即可。
            // 因为在非重复页面（除首页）,没有输入操作，所以不会有对应退出判定，放在此和首页一起判定。
            if(nonDuplicateExec.contains(pageIndex)) {
                // 进入非重复操作页面
                pageload(input);
                String commandStr = input.nextLine();
                // 退出操作
                if(commandStr.equalsIgnoreCase("q")){
                    if(pageIndex == 0) {
                        break;
                    } else {
                        pageIndex = 0;
                        continue;
                    }
                }
                // 页面跳转
                if(commandStr.matches("[1-7]")){
                    pageIndex = Integer.parseInt(commandStr);
                } else {
                    System.out.println("请输入1-7进入对应页面，或者输入q退出。");
                    continue;
                }
            }
            // 进入/返回重复操作页面
            if(!nonDuplicateExec.contains(pageIndex)){
                pageload(input);
            }
            // 功能判定
            switch (pageIndex){
                case 0 :
                    break;
                case 1 :
                    // 如果在查询学生列表页面，则打印一次后直接返回首页
                    queryStudentList(input);
                    break;
                case 2 :
                    addStudent(input);
                    break;
                case 3 :
                case 4 :
                    setStudentGrades(input);
                    break;
                case 5 :
                    deleteStudentGrades(input);
                    break;
                case 6 :
                    // 如果在查询所有学生成绩列表页面，则打印一次后直接返回首页
                    queryStudentGradesList(input);
                    break;
                case 7 :
                    queryStudentGradesShow(input);
                    break;
                default:
                    System.out.println("请输入正确指令，或者输入q退出。");
            }
            // 执行其它功能
        }
    }

    private static void queryStudentList(Scanner input){
        int i = 1;
        for(Map.Entry<String, Student> entry : studentMap.entrySet()){
            System.out.printf("学生%d：%s%n",i++, entry.getValue().getName());
        }
    }
    private static void addStudent(Scanner input){
        System.out.print("请输入学生姓名:");
        String str = input.nextLine();
        if (str.equalsIgnoreCase("q")) {
            pageIndex = 0;
        } else {
            Student stu = new Student();
            stu.setName(str);
            studentMap.put(str, stu);
        }
    }
    private static void setStudentGrades(Scanner input){
        System.out.print("请输入学生姓名(返回首页输入q):");
        String str = input.nextLine();
        if (str.equalsIgnoreCase("q")) {
            pageIndex = 0;
        } else {
            Student stu = studentMap.get(str);
            if (stu != null) {
                // 如果存在则修改，如果不存在则新增
                HashMap<String, Float> gradesMap1 = stu.getGradesMap();
                HashMap<String, Float> gradesMap = gradesMap1 == null ? new HashMap<>() : gradesMap1;

                setStudentGrades(input, gradesMap);
                stu.setGradesMap(gradesMap);
                System.out.printf("学生%s成绩：%s%n", str, stu.getGradesString());
            } else {
                System.out.println("学生不存在！");
            }
        }
    }
    private static void setStudentGrades(Scanner input, HashMap<String, Float> gradesMap){
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
    private static void deleteStudentGrades(Scanner input){
        System.out.print("请输入学生姓名(返回首页输入q):");
        String str = input.nextLine();
        if (str.equalsIgnoreCase("q")) {
            pageIndex = 0;
        } else {
            Student stu = studentMap.get(str);
            if (stu != null) {
                HashMap<String, Float> gradesMap = stu.getGradesMap();

                deleteStudentGrades(input, gradesMap);
                stu.setGradesMap(gradesMap);
                System.out.printf("学生%s成绩：%s%n", str, stu.getGradesString());
            } else {
                System.out.println("学生不存在！");
            }
        }
    }
    private static void deleteStudentGrades(Scanner input, HashMap<String, Float> gradesMap){
        while(true){
            System.out.print("请输入科目：");
            String clazz = input.nextLine();
            if(clazz.equalsIgnoreCase("q")){
                // pageIndex不改，返回上一次操作——也就是重复一次删除成绩操作。
                return;
            }
            gradesMap.remove(clazz);
            System.out.printf("%s成绩删除成功%n", clazz);
        }
    }
    private static void queryStudentGradesList(Scanner input){
        for(Map.Entry<String, Student> entry : studentMap.entrySet()){
            HashMap<String, Float> gradesMap = entry.getValue().getGradesMap();
            if(gradesMap != null && !gradesMap.isEmpty()){
                System.out.printf("学生%s：%s%n",entry.getKey(), entry.getValue().getGradesString());
            }
        }
    }
    private static void queryStudentGradesShow(Scanner input){
        System.out.print("请输入学生姓名(返回首页输入q):");
        String str = input.nextLine();
        if (str.equalsIgnoreCase("q")) {
            pageIndex = 0;
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

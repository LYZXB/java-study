package part_03;

import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        homepageShow();
        while(true){
            String str = input.nextLine();
            if(str.equalsIgnoreCase("q")){
                break;
            }
            switch (str){
                case "1":break;
                case "2":break;
                case "3":break;
                case "4":break;
                case "5":break;
                case "6":break;
                case "7":break;
                default:
                    System.out.println("请输入数字1-7执行对应功能，或者输入q退出");
            }
        }

        input.close();
    }
    private static void homepageShow(){
        System.out.println("欢迎来到学生成绩管理系统首页！请输入对应编号进行操作。");
        System.out.println("1.查看学生列表");
        System.out.println("2.添加学生");
        System.out.println("3.添加学生成绩");
        System.out.println("4.修改学生成绩");
        System.out.println("5.删除学生成绩");
        System.out.println("6.查看所有学生成绩列表");
        System.out.println("7.查看指定学生列表");
    }

    private static void showStudentList(){

    }
}

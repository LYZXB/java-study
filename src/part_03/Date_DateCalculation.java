package part_03;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date_DateCalculation {
    public static void main(String[] args) {
        System.out.print("请输入日期（格式为:yyyy-MM-dd，例2025-10-10）：");
        Scanner input = new Scanner(System.in);
        try(input){
            String inputDateStr = input.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inputDate = LocalDate.parse(inputDateStr, dateTimeFormatter);
            Period between = Period.between(LocalDate.now(), inputDate);
            int days = between.getDays();
            System.out.printf("还剩下%d天到达指定日期", days);
        }
    }
}

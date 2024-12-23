package part_03;

import java.util.Scanner;

public class String_PasswordStrengthCheck {
    public static void main(String[] args) {
        //用户输入一个密码字符串，检测该密码的强度。密码强度判定规则：
        //- 包含数字、字母（大小写均可）、特殊字符三类中的两类，且长度不少于8位，判定为强密码。
        //- 否则，判定为弱密码。
        // 输出检测结果，并建议用户如何提高密码强度
        Scanner input = new Scanner(System.in);
        try (input) {
            // 判断长度
            String password = input.nextLine();
            if(password.length() < 8){
                System.out.println("长度小于8，这是弱密码！");
                return;
            }
            // 判断复杂度--是否弱密码
            int weakIndex = 0;
            boolean hasNumber = hasNumber(password);
            boolean hasLetter = hasLetter(password);
            boolean hasSpecialCharacter = hasSpecialCharacter(password);
            if (!hasNumber) {
                weakIndex++;
            }
            if (!hasLetter) {
                weakIndex++;
            }
            if (weakIndex <= 1 && !hasSpecialCharacter) {
                weakIndex++;
            }
            // 弱密码，建议。因为弱密码只有一种组成，所以只需要推荐其它两种即可。
            if(weakIndex > 1){
                if(hasNumber){
                    System.out.println("这是弱密码，可以加上字母或特殊字符");
                } else if(hasLetter){
                    System.out.println("这是弱密码，可以加上数字或特殊字符");
                } else {
                    System.out.println("这是弱密码，可以加上数字或字母");
                }
                return;
            }
            System.out.println("这是强密码！");
        }
    }

    private static boolean hasNumber(String password){
        return password.matches(".*\\d+.*");
    }
    private static boolean hasLetter(String password){
        return password.matches(".*[a-zA-Z]+.*");
    }
    private static boolean hasSpecialCharacter(String password){
        return password.matches(".*[~!@#$%^&*_]+.*");
    }
}

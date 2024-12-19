package part_02;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("张三");
        BankAccount account2 = new BankAccount("李四");
        BankAccount account3 = new BankAccount("王五");
        System.out.printf("%s的余额是%f%n", account1.getName(), account1.checkBalance());
        System.out.printf("%s的余额是%f%n", account2.getName(), account2.checkBalance());
        System.out.printf("%s的余额是%f%n", account3.getName(), account3.checkBalance());
        account1.deposit(100.5);
        account2.deposit(1000.5);
        account3.deposit(500.5);
        account1.withdraw(50,"购买皮肤");
        account2.withdraw(1000,"购买皮肤");
        account3.withdraw(20,"购买皮肤");
        account2.withdraw(5,"购买午餐");
    }
}

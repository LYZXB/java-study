package part_02;

public class BankAccount {
    public BankAccount(String name){
        this.name = name;
    }
    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double amount){
        balance = balance + amount;
        System.out.printf("%s充值%f元成功！现在余额是%f%n", name, amount, balance);
    }

    public void withdraw(double amount, String reason){
        if(checkBalance() < amount){
            System.out.printf("%s你好，%s支付失败！账户没有足够的余额支付！现在余额是%f%n", name, reason, balance);
            return;
        }
        balance = balance - amount;
        System.out.printf("%s你好，%s支付%f元成功！%n",name, reason, amount);
    }

    public double checkBalance(){
        return balance;
    }
}

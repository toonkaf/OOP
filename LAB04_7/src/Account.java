public class Account {
    public double balance;
    public String name;
    public void deposit(double b){
        if (b < 0){
            System.out.println("The balance variable must be greater than or equal to zero.");
        }else{
            balance += b;
        }
    }
    public double withdraw(double b){
        if (b < 0){
            System.out.println("The balance variable must be greater than or equal to zero.");
            return 0;
        }
        if (balance - b < 0){
            System.out.println("Your account balance is insufficient.");
            return 0;
        }
        return b;
    }
    public void showInfo(){
        System.out.println("In "+name+" account, there is a balance equal to "+balance+" baht. ");
    }
}

import java.util.*;
public class Customer{
    private String firstName,lastName;
    private ArrayList aact;
    public Customer(){
        this("","");
    }
    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.aact = new ArrayList();
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void addAccount(Account acct){
        this.aact.add(acct);
    }
    public Account getAccount(int index){
        return ((Account)this.aact.get(index));
    }
    public int getNumOfAccount(){
        return this.aact.size();
    }
    @Override
    public String toString(){
        if(this.getNumOfAccount() <= 1){
            return (this.getFirstName()+" "+this.getLastName()+" has "+this.getNumOfAccount()+" account.");
        }
        else{
            return (this.getFirstName()+" "+this.getLastName()+" has "+this.getNumOfAccount()+" accounts.");
        }
    }
    public boolean equals(Customer c){
        return this.firstName.equals(c.getFirstName()) & this.lastName.equals(c.getLastName());
    }
}

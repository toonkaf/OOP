public class Customer {
    private String firstName,lastName;
    private Account acct[];
    private int numOfAccount;
    public Customer(){
        this("","");
    }
    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new Account[5];
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
        this.acct[numOfAccount] = acct;
        this.numOfAccount += 1;
    }
    public Account getAccount(int index){
        return acct[index];
    }
    public int getNumOfAccount(){
        return this.numOfAccount;
    }
    @Override
    public String toString(){
        if(this.numOfAccount <= 1){
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

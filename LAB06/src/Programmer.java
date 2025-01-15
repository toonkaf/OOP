public class Programmer extends Employee{
    private int happiness;
    public int getHappiness(){
        return happiness;
    }
    public void setHappiness(int happiness){
        this.happiness = happiness;
    }
    public void coding(String str){
        if (super.getEnergy() >= 30){
            System.out.println("Your code is "+str);
        }else{
            System.out.println("Error Error Error");
        }
        this.setEnergy(super.getEnergy()-30);
        happiness -= 30;
    }
    public void coding(char str){
        String st = String.valueOf(str);
        this.coding(st);
    }
}

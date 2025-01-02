public class Vehicle {
    private int fuel;
    private String topSpeed;
    protected int getFuel(){
        return fuel;
    }
    protected String getTopSpeed(){
        return topSpeed;
    }
    protected void setFuel(int i){
        fuel = i;
    }
    protected void setTopSpeed(String n){
        topSpeed = n;
    }
    public void showInfo(){
        System.out.print("Fuel is "+fuel+" litre and Top Speed is "+topSpeed+" m/s.");
    }
}

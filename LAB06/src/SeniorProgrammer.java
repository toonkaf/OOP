public class SeniorProgrammer extends Programmer{
    @Override
    public void coding(String str){
        if (super.getEnergy() >= 10){
            System.out.println("I'm coding about "+str);
        }else{
            System.out.println("ZzZzZz");
        }
        this.setEnergy(super.getEnergy()-5);
        this.setHappiness(getHappiness()-5);
    }
    public void coding(String str,int num){
        for(int i=0;i < num;i++){
            this.coding(str);
        }
    }
    public void blame(Programmer p){
        System.out.println(p.getName()+" in a bad mood");
        p.setHappiness(p.getHappiness()-20);
    }
    public void compliment(Programmer p){
        System.out.println(p.getName()+" in a good mood");
        p.setHappiness(p.getHappiness()+20);
    }
}

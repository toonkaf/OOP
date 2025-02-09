public class Pigeous extends Bird{
    public Pigeous(){
        super("",0);
    }
    public Pigeous(String name,int age){
        super(name,age);
    }
    @Override
    public void wingAttack(Animal a) {
        a.setPower(a.getPower() - 5);
    }
    public void wingAttack(Animal a,int times) {
        for (int i = 0;i < times;i++){
            this.wingAttack(a);
        }
    }
    @Override
    public void eat(Food f) {
        this.setPower(this.getPower() + (2 * f.getPower()));
    }

    @Override
    public void fly() {
        System.out.println(this.getName()+" fly fly ....");
    }
}

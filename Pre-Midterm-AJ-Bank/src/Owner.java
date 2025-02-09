public class Owner {
    protected final String name;
    protected Animal animal;
    public Owner(){
        this("");
    }
    public Owner(String name){
        this(name,null);
    }
    public Owner(Animal animal){
        this("",animal);
    }
    public Owner(String name,Animal animal){
        this.name = name;
        this.animal = animal;
    }
    public String getName(){
        return this.name;
    }
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    public Animal getAnimal(){
        return this.animal;
    }
    public void feedFood(Food f){
        this.animal.eat(f);
    }
    @Override
    public String toString(){
        return "Owner : name = "+name+", "+this.animal.toString();
    }
    public void protectOwnerFrom(Animal a){
        if(this.animal instanceof Dog){
            ((Dog)this.animal).kick(a);
        }
        else{
            ((Pigeous)this.animal).wingAttack(a);
        }
    }
}

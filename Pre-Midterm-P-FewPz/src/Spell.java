public abstract class Spell {
    private int damage;
    private final String name;
    public Spell(String name){
        this.name = name;
    }
    public int getDamage(){
        return this.damage;
    }
    public String getName(){
        return this.name;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
}

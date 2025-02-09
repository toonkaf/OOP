public class Player {
    private Houses houses;
    private int hp = 20;
    private int mana = 50;
    private final int attackDamage = 2;
    private final String name;
    public Player(String name){
        this(name,20);
    }
    public Player(String name,int hp){
        this.name = name;
        this.hp = hp;
    }
    public int getAttackDamage(){
        return this.attackDamage;
    }
    public int getHP(){
        return this.hp;
    }
    public Houses getHouses(){
        return this.houses;
    }
    public int getMana(){
        return this.mana;
    }
    public String getName(){
        return this.name;
    }
    public void setHP(int hp){
        if (hp < 0 | hp > 20){
            if (hp < 0){
                this.hp = 0;
            }
            else{
                this.hp = 20;
            }
        }
        else{
            this.hp = hp;
        }
    }
    public void setHouses(Houses houses){
        this.houses = houses;
    }
    public void setMana(int mana){
        if (mana < 0 | mana > 50){
            if (mana < 0){
                this.mana = 0;
            }
            else{
                this.mana = 50;
            }
        }
        else{
            this.mana = mana;
        }
    }
    @Override
    public String toString(){
        return "[Player] : "+name+" HP: "+hp+" Mana: "+mana+" || "+houses;
    }
    public boolean equals(Player player){
        return player.getName().equals(this.name) & player.getHouses().equals(this.houses);
    }
    public void attack(Player target,Spell spell){
        if (this.houses instanceof Gryffindor){
            ((Gryffindor)houses).attackSpell(this, target, spell);
        }
        else{
            ((Hufflepuff)houses).attackSpell(this, target, spell);
        }
        if (target.getHP() == 0){
                System.out.println("[DEAD]: "+target.getName()+" was killed by "+this.name);
        }
    }
    public void protectFromPlayer(Player target){
        if (this.houses instanceof Gryffindor){
            ((Gryffindor)houses).defense(this, target);
        }
        else{
            ((Hufflepuff)houses).defense(this, target);
        }
    }
}

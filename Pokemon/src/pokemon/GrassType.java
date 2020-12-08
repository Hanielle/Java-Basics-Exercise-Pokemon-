package pokemon;

public class GrassType extends Monster{
    
    public GrassType(String n, int m, int base) {
        super(n, "grass", "water", "fire", m, base);
        this.atk = base;
        this.def = base;
    }
    
    @Override
    public void rest(){
        this.hp += this.maxHP * 0.3;
        super.rest();
    }
    
    @Override
    public void special(){
        super.special();
        this.hp += this.maxHP * 0.1;
    } 
       
}

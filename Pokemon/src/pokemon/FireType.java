package pokemon;

public class FireType extends Monster{
    
    public FireType(String n, int m, int base) {
        super(n, "fire", "grass", "water", m, base);
        this.atk = (int) (base * 1.3);
        this.def = (int) (base * 0.7);
    }
    
    @Override
    public void special(){
        super.special();
        this.atk += 2;
        this.hp -= (this.maxHP * 0.1);
    } 
}

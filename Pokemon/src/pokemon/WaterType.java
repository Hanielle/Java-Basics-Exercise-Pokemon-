package pokemon;

public class WaterType extends Monster{
    
    public WaterType(String n, int m, int base) {
        super(n, "water", "fire", "grass", m, base);
        this.atk = (int) (base * 0.7);
        this.def = (int) (base * 1.3);
    }
    
    @Override
    public void special(){
        super.special();
        this.def += 2;
        this.hp -= (this.maxHP * 0.1);
    } 
    
    
}

import java.util.ArrayList;

public class Mag extends Characters {
    private int mana_max = 100;
    int mana;
    public Mag(String name, int hp, int maxHp, int minAttack, int maxAttack, int armor,int speed, int x, int y){
        super(name, hp, maxHp, minAttack, maxAttack,armor, speed, x, y);
}
    public Mag(String name, int x, int y){
        super(name, 30,30,5, 17,12, 9, x, y);
        super.name = name;
    }

    @Override
    public void step(ArrayList<Characters> team1, ArrayList<Characters> team2){
        for (Characters unit: team1) {
            if(unit.hp < unit.maxHp){
                unit.GetDamage(maxAttack);
                break;
            }
        }
    }

    @Override
    public String getinfo(){
        return "Я Маг";
    }
}

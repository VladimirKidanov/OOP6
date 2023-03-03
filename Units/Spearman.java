import java.util.ArrayList;

public class Spearman extends Characters {
    int extraDamage;
    
    public Spearman(String name, int hp, int maxHp, int minAttack, int maxAttack, int armor, int speed, int x, int y){
        super(name, hp, maxHp, minAttack, maxAttack, armor, speed, x, y);
    }

    public Spearman(String name, int x, int y){
        super(name, 10,10, 2, 4,5, 4, x, y);
        super.name = name;
    }
    @Override
    public void step(ArrayList<Characters> team1, ArrayList<Characters> team2){
    }

    @Override
    public String getinfo(){
        return "Я копейщик";
    }

}

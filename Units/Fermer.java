import java.util.ArrayList;

public class Fermer extends Characters {
    
    int delivery;// доставка


    public Fermer(String name, int hp, int maxHp, int minAttack, int maxAttack, int armor, int speed, int x, int y){
        super(name, hp, maxHp, minAttack, maxAttack,armor, speed, x, y);
    }

    public int getcarttriges(){
        return 0;
    }

    public Fermer(String name, int x, int y){
        super(name, 1, 1, 1,1,1, 3, x, y);
        super.name = name;
    }

    @Override
    public void step(ArrayList<Characters> team1, ArrayList<Characters> team2){
        if(!state.equals("Die")){
            state = "Stand";
        }
    }

    @Override
    public String getinfo(){
        return "Я Крестьянин";
    }
}

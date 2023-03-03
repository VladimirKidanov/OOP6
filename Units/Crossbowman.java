import java.util.ArrayList;

public class Crossbowman extends Characters{
    int arrows = 10;//Стрелы

    public Crossbowman(String name, int hp, int maxHp, int minAttack, int maxAttack, int armor, int speed, int x, int y){
        super(name, hp, maxHp, minAttack, maxAttack,armor, speed, x, y);
    }

    public Crossbowman(String name, int x, int y){
        super(name, 10, 10,3,6,3,4,x,y);
        super.name = name;
    }

    @Override
    public void step(ArrayList<Characters> team1, ArrayList<Characters> team2){
        if(state.equals("Die") || arrows == 0) return;
        System.out.println("Арбалетчик в деле");
        int target = ClosestEnemy(team2);
        int damages;
        if(team2.get(target).armor < minAttack){
            damages = maxAttack;
        }else{
            damages = minAttack;
        }
        team2.get(target).GetDamage(damages);
        for (int i = 0; i < team1.size(); i++) {
          if((team1.get(i).getinfo().equals("Я Крестьянин")) && 
                team1.get(i).state.equals("Stand")){
                    team1.get(i).state = "Busy";
                    return;
            }
        }
        arrows --;
        System.out.println("dc`");
    }

    @Override
    public String getinfo(){
        return "Я арбалетчик";
    }

}

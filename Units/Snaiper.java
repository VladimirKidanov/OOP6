import java.util.ArrayList;

public class Snaiper extends Characters {
    
    int ammunition;//боезапас

    public Snaiper(String name, int hp, int maxHp, int minAttack, int maxAttack, int armor,int speed,int posX, int posY){
        super(name, hp, maxHp, minAttack, maxAttack, armor, speed, posX, posY);
        this.ammunition = 32;
}

    public Snaiper(String name,int x, int y){
        super(name,15,15,8,12,10,9,x,y);
        super.name = name;
    }

    // boolean FermerSearch(ArrayList<Characters> t){
    //     boolean fermer = true;
    //     for (int i = 0; i < t.size(); i++) {
    //         if(t.get(i) instanceof Fermer){
    //             fermer = false;
    //         }
    //     }
    //     return fermer;   
    // } Поиск фермера, задача 3.4

    @Override
    public void step(ArrayList<Characters> team1, ArrayList<Characters> team2){
        if(state.equals("Die") || ammunition == 0) return;
        System.out.println("Снайпер в деле");
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
        ammunition --;
        System.out.println("dc`");
    }
    @Override
    public String getinfo(){
        return "Я Снайпер";
    }
}

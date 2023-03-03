import java.util.ArrayList;
import java.util.Random;

public abstract class Characters implements Getinterface {
    protected String name;
    int hp;
    protected int maxHp;
    protected int minAttack;
    protected int maxAttack;
    protected int armor;
    protected int speed;
    public Vector2D pos;
    protected String state;
    
    public Characters(String name, int hp,int maxHp, int minAttack, int maxAttack,int armor, int speed, int x, int y){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.armor = armor;
        this.speed = speed;
        pos = new Vector2D(x,y);
        state = "Stand";
    }

    public int getAttack(){
        return 0;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed(){
        return speed;
    }

    public int[] getPos(){
        return new int[]{pos.x,pos.y};
    }

    @Override
    public void step(ArrayList<Characters> tean1, ArrayList<Characters> tean2){
        Getinterface.super.step(tean1, tean2);
    }

    @Override
    public String getinfo(){
        return "Я человек";
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",name,hp,speed);
    }

    public static String setName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length -1)]);
    }

   public static void createArrayList(ArrayList<Characters>  team, int offset, int posY){//создание команд
    for (int i = 1; i <= 10; i++) {
        int rnd = new Random().nextInt(4) + offset;
        switch (rnd){
            case (0):
                team.add(new Snaiper(Characters.setName(),i, posY));
                break;
            case (1):
                team.add(new Bandit(Characters.setName(),i, posY));
                break;
            case (2):
                team.add(new Mag(Characters.setName(),i, posY));
                break;
            case (3):
                team.add(new Fermer(Characters.setName(),i, posY));
                break;
            case (4):
                team.add(new Crossbowman(Characters.setName(),i, posY));
                break;
            case (5):
                team.add(new Monk(Characters.setName(),i, posY));
                break;
            case (6):
                team.add(new Spearman(Characters.setName(),i, posY));
                break;
        }
    }
}

    public int ClosestEnemy(ArrayList<Characters> team){//нахождение ближайшего живого противника
       double min = pos.Distance(team.get(0).pos);
       int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if(min > pos.Distance(team.get(i).pos) & !team.get(i).state.equals("Die")){
                index = i;
                min = pos.Distance(team.get(i).pos);
            }
        }
        return index;
    }
    
    protected void GetDamage(int damage){// метод атаки/лечения
        hp -= damage;
        if(hp > maxHp){
            hp = maxHp;
        }
        if(hp < 0){
            hp = 0;
            state = "Die";
        }
    }
} 


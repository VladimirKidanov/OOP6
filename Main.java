import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static ArrayList<Characters> allTeam = new ArrayList<>();
    public static ArrayList<Characters> holyTeam = new ArrayList<>();
    public static ArrayList<Characters> darkTeam = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Команда 1");
        Characters.createArrayList(allTeam, 0, 1);

        System.out.println("Команда 2");
        Characters.createArrayList(holyTeam, 0, 1);

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        sortTeam(allTeam);
        
        Scanner user_input = new Scanner(System.in);
        while (true){
            View.view();
            user_input.nextLine();
            for (Characters human: allTeam) {
                if (holyTeam.contains(human)) human.step(holyTeam, darkTeam);
                else human.step(darkTeam, holyTeam);
            }
        }
    }
 
    static void sortTeam (ArrayList<Characters> team){
        team.sort(new Comparator<Characters>() {
            @Override
            public int compare(Characters t0, Characters t1) {
                if (t1.getSpeed() == t0.getSpeed()) return (int) (t1.getHp() - t0.getHp());
                else  return (int) (t1.getSpeed() - t0.getSpeed());
            }
        });
    }
    static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }
}

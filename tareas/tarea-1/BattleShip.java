import java.util.Random;

public class BattleShip{

    static String ship[] = new String[7];

    static int numOfHits = 0;

    public static void shippy(){
        Random random = new Random();
        int pos = random.nextInt(5);

        for(int i = pos; i<pos+3; i++){
            ship[i] = "X";
        }
    }

    public static void main(String[] args) {
        shippy();

        for(int i = 0; i<ship.length; i++){
            System.out.print(ship[i] + " | ");
        }
    }
}
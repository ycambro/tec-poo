package tec.poo.tareas;

import java.util.Random;

public class BattleShip{

    public static String ship[] = new String[7];

    public static int numOfHits = 0;

    public static void shippy(){
        Random random = new Random();
        int pos = random.nextInt(5);

        for(int i = pos; i<pos+3; i++){
            ship[i] = "X";
        }
    }

    public static void main(String[] args) {
        shippy();

        }
    }
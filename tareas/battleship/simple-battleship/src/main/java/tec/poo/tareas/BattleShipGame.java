package tec.poo.tareas;
 
/*Bibliotecas */
import java.util.Scanner;

/* Clase principal */
public class BattleShipGame {
    /* Declaración de variables */
    static BattleShip battleShip = new BattleShip();
    public static int x;
    public static int y;
    public static int attemps;

    /* Creacion del main */
    public static void main(String... args){
        while (battleShip.getShips() != 0){
            System.out.print("Enter a guess:   ");
            Scanner scanner = new Scanner(System.in); //Input
            String userGuess = scanner.nextLine();
            if (userGuess.matches("A0")){   //Traducción del input
                x = 0;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A1")){
                x = 1;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A2")){
                x = 2;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A3")){
                x = 3;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A4")){
                x = 4;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A5")){
                x = 5;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("A6")){
                x = 6;
                y = 0;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B0")){
                x = 0;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B1")){
                x = 1;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B2")){
                x = 2;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B3")){
                x = 3;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B4")){
                x = 4;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B5")){
                x = 5;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("B6")){
                x = 6;
                y = 1;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C0")){
                x = 0;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C1")){
                x = 1;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C2")){
                x = 2;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C3")){
                x = 3;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C4")){
                x = 4;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C5")){
                x = 5;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("C6")){
                x = 6;
                y = 2;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D0")){
                x = 0;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D1")){
                x = 1;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D2")){
                x = 2;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D3")){
                x = 3;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D4")){
                x = 4;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D5")){
                x = 5;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("D6")){
                x = 6;
                y = 3;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E0")){
                x = 0;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E1")){
                x = 1;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E2")){
                x = 2;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E3")){
                x = 3;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E4")){
                x = 4;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E5")){
                x = 5;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("E6")){
                x = 6;
                y = 4;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F0")){
                x = 0;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F1")){
                x = 1;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F2")){
                x = 2;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F3")){
                x = 3;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F4")){
                x = 4;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F5")){
                x = 5;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("F6")){
                x = 6;
                y = 5;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G0")){
                x = 0;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G1")){
                x = 1;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G2")){
                x = 2;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G3")){
                x = 3;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G4")){
                x = 4;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G5")){
                x = 5;
                y = 6;
                battleShip.init(x, y);
            }
            else if (userGuess.matches("G6")){
                x = 6;
                y = 6;
                battleShip.init(x, y);
            }
            else{
                System.out.println("Please enter a valid option");
            }
            attemps ++;
        }
        System.out.println("You have win! Your attemps were "+ attemps);
    }
}

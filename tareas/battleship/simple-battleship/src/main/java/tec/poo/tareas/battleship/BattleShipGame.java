package tec.poo.tareas.battleship;

import java.io.ObjectInputFilter.Status;
import java.util.Scanner;

import tec.poo.tareas.BattleShip;

public class BattleShipGame{

    static int tries = 0;
    static int restart = 1;

    static BattleShip battleship = new BattleShip();

    public static void main(String[] args){
        while(restart == 1){
            System.out.print("Welcome to BattleShip!");

            battleship.ship = new String[7];
            battleship.numOfHits = 0;
            battleship.shippy();

            int hits = battleship.numOfHits;

            while(hits != 3){
                System.out.print("Enter a number: ");
                Scanner scanner = new Scanner(System.in);
                int userGuess = scanner.nextInt();

                System.out.println("User guess is " + userGuess);
                tries ++;
                if (userGuess <= 6 && userGuess >= 0){
                    if (battleship.ship[userGuess] == "X") {
                        System.out.println("hit");
                        battleship.numOfHits++;
                    System.out.println("miss");

                System.out.println("Try again");  
                    }
                }

            System.out.println("You have sunk the ship, your attemps were: " + tries);

            }
        }
    }
}
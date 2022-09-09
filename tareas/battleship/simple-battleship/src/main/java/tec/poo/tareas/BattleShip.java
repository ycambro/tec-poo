package tec.poo.tareas;

public class BattleShip{
    BattleField BattleField = new BattleField();
    int[][]board = BattleField.getBoard();
    private int ships_alive;
    
    
    public BattleShip(){
        this.ships_alive = 3;
    }
    public void init(int x, int y) {
        if (board [x][y] != 0){
            System.out.println("Hit!");
            if (board[x][y] == 1){
                var life1 = BattleField.setLife1();
                board[x][y] = 0;
                if (life1 == 0){
                    System.out.println("You sunk Ship1");
                    ships_alive --;
                }
            }
            if (board[x][y] == 2){
                var life2 = BattleField.setLife2();
                board[x][y] = 0;
                if (life2 == 0){
                    System.out.println("You sunk Ship2");
                    ships_alive --;
                }
            }
            if (board[x][y] == 3){
                var life3 = BattleField.setLife3();
                board[x][y] = 0;
                if (life3 == 0){
                    System.out.println("You sunk Ship3");
                    ships_alive --;
                }
            }
        }
        else {
            System.out.println("Miss!");
        }
    }
    public int getShips(){
        return this.ships_alive;
    }
}
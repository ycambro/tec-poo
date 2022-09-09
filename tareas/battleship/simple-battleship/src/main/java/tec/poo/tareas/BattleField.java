package tec.poo.tareas;

public class BattleField{
    private int[][] board;
    private int life_ship1;
    private int life_ship2;
    private int life_ship3;

    public BattleField(){
        this.board = new int[7][7];
        ships();
    }

    private void ships(){
        this.board[0][0] = 1;
        this.board[1][0] = 1;
        this.board[2][0] = 1;
        this.life_ship1 = 3;

        this.board[2][4] = 2;
        this.board[2][5] = 2;
        this.board[2][6] = 2;
        this.life_ship2 = 3;

        this.board[4][6] = 3;
        this.board[5][6] = 3;
        this.board[6][6] = 3;
        this.life_ship3 = 3;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int setLife1() {
        this.life_ship1 --;
        return this.life_ship1;
    } 
    public int setLife2() {
        this.life_ship2 --;
        return this.life_ship2;
    } 
    public int setLife3() {
        this.life_ship3 --;
        return this.life_ship3;
    } 

}
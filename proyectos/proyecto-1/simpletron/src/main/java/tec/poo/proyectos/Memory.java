package tec.poo.proyectos;

public class Memory {
    private String[] memory = new String [1000];

    public void setInMemory (int pos, String value) {
        if (pos <= 999 && pos != 0) {
            this.memory[pos] = value;
        } else {
            System.out.println("Error 04: Memory overflow");
        }
    }

    public String getMemory(int pos) {
        if (pos <= 999) {
            if (this.memory[pos] == null) {
                return "+00000";
            } else {
                return this.memory[pos];
            }
        } else {
            System.out.println("Error 05: There is no such memory address");
            return "-1";
        }
    }

    public void instructionInMemory (int actual_pos, String word) {
        if (actual_pos <= 999) {
            memory[actual_pos] = word;
        } else {
            System.out.println("Error 05: There is no such memory address");
        }
    }
}   

package tec.poo.proyectos;

public class Memory {
    /* Creacion de espacio de Memoria */
    private String[] memory = new String [1000];

    /* Funcion para almacenar un valor en memoria (variables)
     * Si esta en el rango de memoria maxima y no es en la posicion 0 se guarda la variable, sino se considera 
     * un Memory overflow, lo cual indica que excede la memoria.
     */
    public void SetInMemory (int pos, String value) {
        if (pos <= 999 && pos != 0) {
            this.memory[pos] = value;
        } else {
            System.out.println("Error 04: Memory overflow");
        }
    }

    /* Funcion para obtener un valor en memoria o instruccion
     * Si en la posicion de memoria no hay nada se considera un null, pero al estilo LMS (+00000)
     * sino, se retorna el valor que se encuentre ahí.
     */
    public String GetMemory(int pos) {
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

    /* Funcion para almacenar instrucciones en memoria (variables)
     * Trabaja con un contador que indica la posicion actual
     * Se almacena la instruccion en la memoria de forma ordenada a menos que se supere o que se trate de guardar en una direccion que no exista
     */
    public void InstructionInMemory (int actualPosition, String word) {
        if (actualPosition <= 999) {
            memory[actualPosition] = word;
        } else {
            System.out.println("Error 05: There is no such memory address");
        }
    }
}   

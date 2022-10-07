package tec.poo.proyectos;

/*Bibliotecas */
import java.util.Scanner;

public class Simpletron 
{
    static String instruction;
    static String memory_pos;
    static int opcion;
    static int pos = 0;
    static int memory_position;
    static Memory MemoryAccess = new Memory();
    static int[] MemoryList = new int[1000];
    static String[] MemoryListString = new String[1000];
    static String pre_intruction;
    static int pos_act = 0;
    static String compilation_instruction;
    static Funct Functions = new Funct();
    static int contador;
    static String word;
    static String fin;
    static int finInt;

    public static void main( String[] args )
    {
        for (int i = 0; i <= 999; i++ ) {
            MemoryList[i] = 000+i+1000;
            String list_act = Integer.toString(MemoryList[i]);
            MemoryListString[i] = list_act.substring(1, list_act.length());
        }  

        System.out.println("Simpletron [version 1.0.0]");
        System.out.println(" ");

        while (finInt != 99999) {
            System.out.print(MemoryListString[pos_act]);
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in); //Input
            word = scanner.nextLine();
            fin = word.substring(1, word.length());
            finInt = Integer.parseInt(fin);

            if (finInt == 99999) {
                break;
            } else if (word.length() == 6) {
                MemoryAccess.instructionInMemory(pos_act, word);
                pos_act ++;
            } else {
                System.out.println("Error 01: The operation code is invalid");
            }
        }
        System.out.println("Loading complete, running");
        System.out.println(" ");

        while (instruction != "+44") {
            compilation_instruction = MemoryAccess.getMemory(pos);
            instruction = compilation_instruction.substring(0,3);
            memory_pos = compilation_instruction.substring(3, compilation_instruction.length());
            memory_position = Integer.parseInt(memory_pos);

            
            // int entero = Integrer.parseInt(String);

            switch(instruction) {
                case "+10":
                System.out.print("Simple> ");
                Scanner num_scan = new Scanner(System.in);
                String number = num_scan.nextLine();
                MemoryAccess.setInMemory(memory_position, number);
                pos ++;
                break;
                
                case "+11":
                System.out.print("Simple> ");
                System.out.println(MemoryAccess.getMemory(memory_position));
                pos ++;
                break;

                case "+20":
                int word_int = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.setAcumulator(word_int);
                pos ++;
                break;

                case "+21":
                MemoryAccess.setInMemory(memory_position, Functions.getAcumulator());
                pos ++;
                break;

                case "+30":
                int num = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Sum(num);
                pos ++;
                break;

                case "+31":
                int numb = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Subtract(numb);
                pos ++;
                break;

                case "+32":
                int numr = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Multiply(numr);
                pos ++;
                break;

                case "+33":
                int numbr = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Divide(numbr);
                pos ++;
                break;

                case "+34":
                int numbe = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Module(numbe);
                pos ++;
                break;

                case "+35":
                int numbi = Integer.parseInt(MemoryAccess.getMemory(memory_position));
                Functions.Exponentiation(numbi);
                pos ++;
                break;

                case "+40":
                pos = memory_position;
                break;

                case "+41":
                String sign = Functions.getAcumulator().substring(0,1);
                if (sign == "-") {
                    pos = memory_position;
                } else {
                    pos ++;
                }
                break;
                
                case "+42":
                if (Functions.getAcumulator() == "+0") {
                    pos = memory_position;
                } else {
                    pos ++;
                }
                break;

                case "+43":
                String signe = Functions.getAcumulator().substring(0,1);
                if (signe == "+") {
                    pos = memory_position;
                } else {
                    pos ++;
                }
                break;

                case "+44":
                instruction = "+44";
                pos ++;
                break;

                case "+45":
                Functions.setAcumulator(0);
                pos ++;
                break;

                case "+50":
                while (contador != 0) {
                    pos = memory_position;
                    contador --;
                }

                case "+51":
                contador = memory_position;
                pos ++;
                break;

                default:
                System.out.println("Error 01: The operation code is not valid.");
                break;

            }
        }
    }
}

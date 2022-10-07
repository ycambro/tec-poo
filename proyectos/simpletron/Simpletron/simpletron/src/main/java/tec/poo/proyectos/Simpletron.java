package tec.poo.proyectos;

/*Bibliotecas */
import java.util.Scanner;

public class Simpletron 
{
    /* Variables */
    static String instruction; //La instruccion que se desea realizar (primeros 3 digitos)
    static String memoryPos; //Posicion de  memoria en la que se desea trabajar pero en formato String
    static int opcion; //Opcion para trabajar en el switch, lo que hace es verificar esta con la variable instruction
    static int pos = 0; //Variable para saber en que posicion de la memoria se encuentra actualmente
    static int memoryPosition; //Posicion de memoria en la que se desea trabajar.
    static int actualPosition = 0; //Posicion actual para guardar las instrucciones ordenadamente en el lenguaje LMS
    static String compilationInstruction; //Instruccion para la compilacion del código en LMS, se obtiene de la memoria
    static int counter;  //Contador para las funciones controlador de ciclos y bifurca hasta.
    static String word; //Palabras, el código de LMS
    static String fin; //Recibe las entradas para convertirlas a int
    static int finInt; //Para validar la entrada -99999

    /* Listas */
    static int[] memoryList = new int[1000]; //Lista para crear los nombres de las memorias de 000 a 999
    static String[] memoryListString = new String[1000]; //Lista para pasar la lista anterior a string

    /* Clases */
    static Memory MemoryAccess = new Memory(); //Clase Memoria, encargada de la memoria
    static Functions Functions = new Functions(); //Clase Functions, encargada de las funciones matematicas y otras

    public static void main( String[] args )
    {
        /* Creacion de lista para mostrar posicion de memoria de forma correcta */
        for (int i = 0; i <= 999; i++ ) {
            memoryList[i] = 000+i+1000; //Se le sumaba 1000
            String list_act = Integer.toString(memoryList[i]); //Se pasa a string
            memoryListString[i] = list_act.substring(1, list_act.length()); //Se guarda en la otra lista sin el 1 inicial
        }  

        System.out.println("Simpletron [version 1.0.0]");
        System.out.println(" ");

        /* Ciclo para crear el programa en LMS */
        while (finInt != 99999) {

            //Se imprime el nombre de memoria y el >
            System.out.print(memoryListString[actualPosition]);
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in); //Input
            word = scanner.nextLine(); //Se guarda la palabra
            fin = word.substring(1, word.length()); //Se elimina el simbolo "- ó +"
            finInt = Integer.parseInt(fin); //Se pasa el valor a entero

            if (finInt == 99999) { //Si el valor en entero es 99999 significa que es hora de compilar
                break;
            } else if (word.length() == 6) { //Sino, se verifica si el tamaño es correcto y se guarda la instruccion en memoria
                MemoryAccess.InstructionInMemory(actualPosition, word);
                actualPosition ++;
            } else { //Y sino, entonces el codigo es invalido
                System.out.println("Error 01: The operation code is invalid");
            }
        }
        System.out.println("Loading complete, running");
        System.out.println(" ");

        /* Inicio de la compilación */
        while (instruction != "+44") { //Mientras la instruccion no sea la final
            compilationInstruction = MemoryAccess.GetMemory(pos); //Se obtiene la intruccion de la memoria
            instruction = compilationInstruction.substring(0,3); //Obtiene la instruccion (primeros 3 digitos)
            memoryPos = compilationInstruction.substring(3, compilationInstruction.length()); //Obtiene la ubicacion en memoria (ultimos 3 digitos)
            memoryPosition = Integer.parseInt(memoryPos); //Se pasa la posicion de memoria en la cual se va a trabajar a entero

            /* Si la instruccion en la que estamos esta vacia, entonces salimos del programa */
            if (compilationInstruction == "+00000") {
                instruction = "+44";
            }

            /* Operaciones con las instrucciones (compilación) */
            switch(instruction) {

                /* Operacion Leer, escanea una palabra y la guarda en memoria, esto se recibe como string al guardarse en la memoria */
                case "+10": 
                System.out.print("Simple> ");
                Scanner numScan = new Scanner(System.in);
                String number = numScan.nextLine();
                MemoryAccess.SetInMemory(memoryPosition, number);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;
                
                /* Operacion Escribir, imprime en pantalla un valor guardado en memoria */
                case "+11":
                System.out.print("Simple> ");
                System.out.println(MemoryAccess.GetMemory(memoryPosition));
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Operación Carga, obtiene una palabra almacenada en memoria y se coloca en el acumulador */
                case "+20":
                int word_int = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.SetAcumulator(word_int);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Alamacena una palabra que se encuentra en el acumulador en la memoria */
                case "+21":
                MemoryAccess.SetInMemory(memoryPosition, Functions.getAcumulator());
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Suma un valor de la memoria con un valor del acumulador, esta suma se almacena en el acumulador */
                case "+30":
                int num = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Sum(num);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Resta un valor de la memoria con el valor del acumulador, el resultado se almacena en el acumulador */
                case "+31":
                int numb = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Subtract(numb);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;
        
                /* Se multiplica un valor en memoria con el valor del acumulador, el resultado es almacenado en el acumulador */
                case "+32":
                int numr = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Multiply(numr);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Se divide un valor en memoria por el valor del acumulador, el resultado se almacena en el acumulador */
                case "+33":
                int numbr = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Divide(numbr);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Se genera una division entera entre un valor en memoria y el valor de acumulador, almacenando el resultado en este ultimo */
                case "+34":
                int numbe = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Module(numbe);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Se eleva el contenido del acumulador por un valor en memoria, el resultado es guardado en el acumulador */
                case "+35":
                int numbi = Integer.parseInt(MemoryAccess.GetMemory(memoryPosition)); //El valor guardado en la posicion es convertido en int
                Functions.Exponentiation(numbi);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Hace un salto hasta cierta posicion de memoria */
                case "+40":
                pos = memoryPosition;
                break;

                /* Hace un salto hasta determinada posicion en memoria si el valor en acumulador es negativo */
                case "+41":
                String sign = Functions.getAcumulator().substring(0,1);
                if (sign == "-") {
                    pos = memoryPosition;
                } else {
                    pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                }
                break;
                
                 /* Hace un salto hasta determinada posicion en memoria si el valor en acumulador es cero */
                case "+42":
                if (Functions.getAcumulator() == "+0") {
                    pos = memoryPosition;
                } else {
                    pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                }
                break;

                 /* Hace un salto hasta determinada posicion en memoria si el valor en acumulador es positivo */
                case "+43":
                String signe = Functions.getAcumulator().substring(0,1);
                if (signe == "+") {
                    pos = memoryPosition;
                } else {
                    pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                }
                break;

                /* Detiene el programa */
                case "+44":
                instruction = "+44"; //Asegurar el cierre
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Limpia el acumulador, convirtiendolo en 0 */
                case "+45":
                Functions.SetAcumulator(0);
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Crea un ciclo, repite una sección o parte del código hasta que el contador llegue a 0 */
                case "+50":
                while (counter != 0) {
                    pos = memoryPosition;
                    counter --;
                }
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion

                /* Crea un contador para crear ciclos */
                case "+51":
                counter = memoryPosition;
                pos ++; //Se aumenta la posicion de las instrucciones, es decir siguiente instruccion
                break;

                /* Si la operacion o instruccion que se encuentre en la linea actual no esta en estas opciones o no haya instruccion en si, detendra el programa e imprimira el error 01 */
                default:
                System.out.println("Error 01: The operation code is not valid.");
                instruction = "+44";
                break;

            }
        }
    }
}

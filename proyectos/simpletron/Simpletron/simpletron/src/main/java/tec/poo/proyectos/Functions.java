package tec.poo.proyectos;

public class Functions {
    
    /* Creacion del acumulador (como una pila con espacio para una palabra) */
    private int acumulator;

    /* Funcion para dar un valor al Acumulador
     * Si el valor a guardar en el acumulador es menor o igual a 999 se guarda
     * sino, se considera un Acumulator overflow, que supera el tamaño del valor a guardar en el acumulador
     */
    public void SetAcumulator (int n) {
        if (n <= 999) {
            this.acumulator = n;
        } else {
            System.out.println("Error 02: Acumulator overflow");
        }
    }

    /* Funcion para ver el valor en el almacenador
     * Se convierte el almacenador a String y si este es negativo (menor a 0)
     * se le da el signo -, en caso contrario se le deja el signo +
     */
    public String getAcumulator () {
        String acumulatorSign;
        if (this.acumulator >= 0) {
            acumulatorSign = "+";
        } else {
            acumulatorSign = "-";
        }
        String tmp = Integer.toString(this.acumulator);
        return acumulatorSign + tmp;
    }
    
    /* Funcion para sumar
     * Recibe un valor y trabaja la suma en el acumulador, dejando ahi el resultado
     */
    public void Sum(int value) {
        this.acumulator += value;
    }

    /* Funcion para restar
     * Recibe un valor y trabaja la resta en el acumulador, dejando ahi el resultado
     */
    public void Subtract(int value) {
        this.acumulator -= value;
    }
    
    /* Funcion para multiplicar
     * Recibe un valor y trabaja la multiplicacion en el acumulador, dejando ahi el resultado
     */
    public void Multiply(int value) {
        this.acumulator *= value;
    }

    /* Funcion para dividir
     * Recibe un valor y trabaja la division en el acumulador, dejando ahi el resultado
     * Si el valor por el que se dividirá es 0, entonces se imprime un error por formula indeterminada
     */
    public void Divide(int value) {
        if (value != 0) {
        this.acumulator /= value;
        } else {
            System.out.println("Error 03: Attempt to divide by 0");
        }
    }

    /* Funcion modulo
     * Recibe un valor y trabaja la division entera en el acumulador, dejando ahi el resultado
     * Si el valor recibido es 0, se imprime el error 03 por formula indeterminada
     */
    public void Module(int value) {
        if (value != 0) {
            this.acumulator %= value;
            } else {
                System.out.println("Error 03: Attempt to divide by 0");
            }
    }

    /* Funcion exponenciacion
     * Recibe un valor y trabaja la elevacion en el acumulador, dejando ahi el resultado
     * El acumulador se multiplica "value" veces por si mismo, para esto se almacena el valor inicial
     * del acumulador (antes de la operacion) y se empieza operar hasta que el valor sea 0, por lo que es multiplicar
     * el valor inicial del acumulador por el valor que va resultando del acumulador.
     */
    public void Exponentiation(int value) {
        int acumulatorBackup = this.acumulator;
        while (value != 0) {
            this.acumulator *= acumulatorBackup;
            value --;
        }
    }
}

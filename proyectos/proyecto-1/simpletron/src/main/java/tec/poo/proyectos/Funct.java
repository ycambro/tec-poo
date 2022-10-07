package tec.poo.proyectos;

/* Bibliotecas */
import java.lang.Math;

public class Funct {

    private int acumulator;

    public void setAcumulator (int n) {

        if (this.acumulator <= 999) {
            this.acumulator = n;
        } else {
            System.out.println("Error 02: Acumulator overflow");
        }
    }

    public String getAcumulator () {
        String acumulator_sign;
        if (this.acumulator >= 0) {
            acumulator_sign = "+";
        } else {
            acumulator_sign = "-";
        }
        String tmp = Integer.toString(this.acumulator);
        acumulator_sign.concat(tmp);
        return acumulator_sign;
    }
    
    public void Sum(int value) {
        this.acumulator += value;
    }

    public void Subtract(int value) {
        this.acumulator -= value;
    }
    
    public void Multiply(int value) {
        this.acumulator *= value;
    }

    public void Divide(int value) {
        if (value != 0 || this.acumulator != 0) {
        this.acumulator /= value;
        } else {
            System.out.println("Error 03: Attempt to divide by 0");
        }
    }

    public void Module(int value) {
        if (value != 0 || this.acumulator != 0) {
            this.acumulator %= value;
            } else {
                System.out.println("Error 03: Attempt to divide by 0");
            }
    }

    public void Exponentiation(int value) {
        int acum_backup = this.acumulator;
        while (value != 0) {
            this.acumulator *= acum_backup;
            value --;
        }
    }
}

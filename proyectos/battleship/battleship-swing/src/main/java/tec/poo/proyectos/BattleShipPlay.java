package tec.poo.proyectos;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;

public class BattleShipPlay extends JDialog implements ActionListener{
    /* Declaración de variables */
    JButton buttons[] = new JButton[49];
    JButton save;
    JDialog dialog;
    JTextField text;
    JPanel panel;
    BattleField Battlefield;
    int[][]board;
    int x;
    int y;
    private int ships_alive;
    int attemps;
    Saver saver;
    String path;
    int x1;
    int y1;

    public BattleShipPlay(BattleShipUI father, boolean modal, BattleField board1, String pathO) {
        path = pathO; //Se guarda el path para usarse luego
        try {
            this.ships_alive = 3; //Se crean los barcos
            Battlefield = board1; //Se pasa el objeto battlefield a valor global 
            attemps = Battlefield.getAttemps(); //Se inician los intentos
            board = Battlefield.getBoard(); //Se obtiene la matriz
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "El archivo cargado no es permitido!");
        }

        saver = new Saver(); //Se crea un objeto capaz de cargar y guardar json files

        /* Creación de la ventana secundaria */
        dialog = new JDialog(father, modal); //Se crea y se asigna su padre
        dialog.setSize(600, 600); //Se le da un tamaño
        dialog.setLayout(null); //Se limpia para no tener problemas de distribución
        dialog.setAlwaysOnTop(true); //Siempre estará arriba
        dialog.setLocationRelativeTo(null); //Se centra
        dialog.getContentPane().setBackground(Color.CYAN); //Se le pone color Cyan al fondo

        /* Creación del botón para guardar */
        save = new JButton("Guardar Juego");
        save.setBounds(7, 410, 130, 30); //Tamaño
        save.addActionListener(this); //Se crea un action listener para cuando se de click
        save.setBackground(Color.GRAY); //Se cambia el color del botón

        /* Se crea espacio de texto, la miniconsola */
        text = new JTextField();
        text.setBounds(5, 450, 300, 100); //Tamaño
        text.setText("Iniciando juego!"); //Texto inicial
        Font font = new FontUIResource("Serif", 1, 16); //Fuente del texto
        text.setFont(font); //Se aplica la fuente
        text.setEditable(false); //Se impide la edición (para que no se pueda escribir nada)

        /* Creación del panel */
        panel = new JPanel(new GridLayout(7, 7, 10, 10)); //Se crea el panel en modo cuadrícula
        panel.setBounds(0, 0, 586, 400); //Se le da la posición y tamaño
        panel.setBackground(Color.CYAN); //Se cambia el color del fondo del panel

        /* Creación de los botones */
        for (int i = 0; i < 49; i ++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY); //Se les da el color gris
            panel.add(buttons[i]); //Se añaden al panel y guardan en una lista
            buttons[i].addActionListener(this); //Se les hace un action listener para cuando sean clickeados
        }

        /* Se añade todo al panel */
        dialog.add(panel);
        dialog.add(text);
        dialog.add(save);

        /* Verificación carga
         * Si el archivo fue cargado entonces, se modificaran los botones para que queden como estuvieron antes
         */
        int i = 0;
        //Se recorre la matriz en busca de los valores clickeados anteriormente
        for (y1 = 0; y1 < 7; y1 ++){
            for (x1 = 0; x1 < 7; x1 ++){
                if (board[x1][y1] == 5){ //5 significa que se clickeo y habia un barco
                    buttons[i].setBackground(Color.BLUE);
                    i ++;
                } else if (board[x1][y1] == 6) { //6 significa que se clickeo y no habia un barco
                    buttons[i].setBackground(Color.RED);
                    i ++;
                } else {
                    i ++;
                }
            }
            x1 = 0; //Prohibe un ciclo infinito
        }
        dialog.setVisible(true); //Se hace visible la ventana
    }

    /* Observador */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Al precionarse algun botón se realiza una acción
        if (e.getSource() == save) { //Si se clickeo el botón de guardar
            saver.saveObject(Battlefield, path); //Se guarda con el objeto correspondiente
            JOptionPane.showMessageDialog(this, "El juego se ha guardado en:\n "+ path); //Y se muestra un dialogo que informe
            dialog.dispose(); //Se cierra la ventana

        }
        //Si se presiona algun botón de la cuadrícula
        for (int i = 0; i < 49; i ++){
            if (e.getSource() == buttons[i]) {
                //Se traduce el input dependiendo del botón
                if (i == 0){ 
                    x = 0;
                    y = 0;
                }
                else if (i == 1){
                    x = 1;
                    y = 0;
                }
                else if (i == 2){
                    x = 2;
                    y = 0;
                }
                else if (i == 3){
                    x = 3;
                    y = 0;
                }
                else if (i == 4){
                    x = 4;
                    y = 0;
                }
                else if (i == 5){
                    x = 5;
                    y = 0;
                }
                else if (i == 6){
                    x = 6;
                    y = 0;
                }
                else if (i == 7){
                    x = 0;
                    y = 1;
                }
                else if (i == 8){
                    x = 1;
                    y = 1;
                }
                else if (i == 9){
                    x = 2;
                    y = 1;
                }
                else if (i == 10){
                    x = 3;
                    y = 1;
                }
                else if (i == 11){
                    x = 4;
                    y = 1;
                }
                else if (i == 12){
                    x = 5;
                    y = 1;
                }
                else if (i == 13){
                    x = 6;
                    y = 1;
                }
                else if (i == 14){
                    x = 0;
                    y = 2;
                }
                else if (i == 15){
                    x = 1;
                    y = 2;
                }
                else if (i == 16){
                    x = 2;
                    y = 2;
                }
                else if (i == 17){
                    x = 3;
                    y = 2;
                }
                else if (i == 18){
                    x = 4;
                    y = 2;
                }
                else if (i == 19){
                    x = 5;
                    y = 2;
                }
                else if (i == 20){
                    x = 6;
                    y = 2;
                }
                else if (i == 21){
                    x = 0;
                    y = 3;
                }
                else if (i == 22){
                    x = 1;
                    y = 3;
                }
                else if (i == 23){
                    x = 2;
                    y = 3;
                }
                else if (i == 24){
                    x = 3;
                    y = 3;
                }
                else if (i == 25){
                    x = 4;
                    y = 3;
                }
                else if (i == 26){
                    x = 5;
                    y = 3;
                }
                else if (i == 27){
                    x = 6;
                    y = 3;
                }
                else if (i == 28){
                    x = 0;
                    y = 4;
                }
                else if (i == 29){
                    x = 1;
                    y = 4;
                }
                else if (i == 30){
                    x = 2;
                    y = 4;
                }
                else if (i == 31){
                    x = 3;
                    y = 4;
                }
                else if (i == 32){
                    x = 4;
                    y = 4;
                }
                else if (i == 33){
                    x = 5;
                    y = 4;
                }
                else if (i == 34){
                    x = 6;
                    y = 4;
                }
                else if (i == 35){
                    x = 0;
                    y = 5;
                }
                else if (i == 36){
                    x = 1;
                    y = 5;
                }
                else if (i == 37){
                    x = 2;
                    y = 5;
                }
                else if (i == 38){
                    x = 3;
                    y = 5;
                }
                else if (i == 39){
                    x = 4;
                    y = 5;
                }
                else if (i == 40){
                    x = 5;
                    y = 5;
                }
                else if (i == 41){
                    x = 6;
                    y = 5;
                }
                else if (i == 42){
                    x = 0;
                    y = 6;
                }
                else if (i == 43){
                    x = 1;
                    y = 6;
                }
                else if (i == 44){
                    x = 2;
                    y = 6;
                }
                else if (i == 45){
                    x = 3;
                    y = 6;
                }
                else if (i == 46){
                    x = 4;
                    y = 6;
                }
                else if (i == 47){
                    x = 5;
                    y = 6;
                }
                else if (i == 48){
                    x = 6;
                    y = 6;
                }
                else{
                    text.setText("Please enter a valid option");
                }
                /* Acciones de casillas */
                if (buttons[i].getBackground() != Color.GRAY){ //Si la casilla no es gris entonces ya habia sido seleccionada
                    text.setText("Ya has seleccionado esta casilla!");
                } else if (board [x][y] != 0){ //Si el valor en la matriz no es 0 fue un impacto
                    text.setText("Impacto!"); //Se imprime en la miniconsola
                    buttons[i].setBackground(Color.BLUE); //El color del botón pasa de gris a azul
                    if (board[x][y] == 1) { //Si el barco era 1, pues se le resta la vida a el
                        var life1 = Battlefield.setLife1();
                        board[x][y] = 5; //Se cambia el valor a 5 para efectos del guardado
                        if (life1 == 0){
                            text.setText("Se hundió Cabista"); //Se imprime en la miniconsola que se hundió el barco
                            ships_alive --; //Se resta 1 a los barcos vivos
                        }
                    }
                    if (board[x][y] == 2) {  //Si el barco era 2, se le resta la vida a el
                        var life2 = Battlefield.setLife2();
                        board[x][y] = 5; //Se cambia el valor a 5 para efectos del guardado
                        if (life2 == 0){
                            text.setText("Se hundió Poniez"); //Si se derriba el barco se imprime que se hundió
                            ships_alive --;
                        }
                    }
                    if (board[x][y] == 3){ //Si el barco es 3, se le resta la vida
                        var life3 = Battlefield.setLife3();
                        board[x][y] = 5; //Se cambia el valor a 5 para efectos del guardado
                        if (life3 == 0){
                            text.setText("Se hundió Hacqi"); //Si se derriba el barco se imprime que se hundió
                            ships_alive --;
                        }
                    }
                } else {
                    text.setText("Fallaste!"); //Si se falla se imprime eso
                    board [x][y] = 6; //Se cambia el valor a 6 para efectos del guardado
                    buttons[i].setBackground(Color.RED); //Se cambia el color del boton a rojo indicando que fallo
                }
                Battlefield.setAttemps(); //Se añade 1 a intentos
                if (ships_alive == 0){ //Si se derribaron todos los barcos, se imprime la ventana en un popup y se cierra luego la ventana
                    JOptionPane.showMessageDialog(dialog, "Todos los barcos se han hundido!\n Has hecho "+ Battlefield.getAttemps() + " intentos");
                    dialog.dispose();
                }
            }
        }
    }
}
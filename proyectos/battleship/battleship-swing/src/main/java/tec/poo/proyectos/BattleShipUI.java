package tec.poo.proyectos;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.ImageIcon;

public class BattleShipUI extends JFrame implements ActionListener{
    /* Declaración de variables */
    JMenuItem exit;
    JMenuItem load;
    JMenuItem neu;
    JMenuItem us;
    JMenuItem rules;
    JMenuItem savep;
    BattleField field;
    JFrame window;
    JMenuBar menu;
    JMenu config;
    JMenu game;
    JMenu info;
    ImageIcon background;
    ImageIcon text;
    JLabel label1;
    JLabel label2;
    JsonSL saver;
    String path;
    String oldPath;
    BattleField gameLoad;
    BattleShipPlay gameStart;
    BattleShipPlay gameLoaded;
    int nopath;
    Image myIcon;
    Music mymusic;
    Clip backSound;

    public BattleShipUI (BattleField battle, String pathO) {
        /* Guarda las variables recibidas como variables globales*/
        path = pathO;
        field = battle;

        /* Crea el saver, objeto para guardar y cargar JSON files */
        saver = new JsonSL();

        /* Se crea la ventana principal */
        window = new JFrame("Sink a Ship");
        window.setSize(1200, 676); //Tamaño
        window.setResizable(false); //Se impide el cambio del tamaño
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Que se cierre al darle X
        window.setLocationRelativeTo(null); //Se posiciona la ventana en el centro

        /* Creación del menu y sus items */
        menu = new JMenuBar();
        game = new JMenu("Juego");
        info = new JMenu("Acerca de");
        config = new JMenu("Configuración");
        menu.add(game);
        menu.add(config);
        menu.add(info);

        /* Creación de los items del menu y creacion de sus action listeners */
        rules = new JMenuItem("Reglas");
        us = new JMenuItem("Sobre nosotros");
        rules.addActionListener(this);
        us.addActionListener(this);

        savep = new JMenuItem("Ruta guardado");
        savep.addActionListener(this);

        config.add(savep);
        info.add(rules);
        info.add(us);

        neu = new JMenuItem("Nuevo");
        load = new JMenuItem("Cargar");
        exit = new JMenuItem("Salir");

        game.add(neu);
        neu.addActionListener(this);
        game.add(load);
        load.addActionListener(this);
        game.add(exit);
        exit.addActionListener(this);

        window.getContentPane().add(BorderLayout.NORTH, menu); //Se pone el menu en el borde superior de la pantalla

        /* Creacion del background con la imagen */
        background = new ImageIcon(BattleShipUI.class.getResource("/gif.gif"));
        label1 = new JLabel(" ", background, SwingConstants.CENTER);
        label1.setSize(1200, 676);
        label1.setLocation(new Point(1,1)); //Se posiciona de primero, o atrás

        myIcon = Toolkit.getDefaultToolkit().getImage(BattleShipUI.class.getResource("/logo.png"));
        window.setIconImage(myIcon);

        /* Creación del texto battleship con la imagen */
        text = new ImageIcon(BattleShipUI.class.getResource("/text.png"));
        label2 = new JLabel(" ", text, SwingConstants.CENTER);
        label2.setSize(1200, 676);
        label2.setLocation(new Point(1,2)); //Se posiciona frente al background

        //Se añaden las imagenes a la ventana principal
        window.add(label2);
        window.add(label1);

        /* Test de si existe el directorio, si el directorio existe y no es un archivo entonces se sigue normal */
        try {
            File test = new File(path);
            if (test.exists() && test.isDirectory()) {
            } else { //Sino, se muestra un popup diciendo que no se encontró el directorio y que se restablecerá al directorio predeterminado
                JOptionPane.showMessageDialog(window, "No se encontró el directorio!\n Se restablecerá el directorio a predeterminado");
                path = null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window, "No se encontró el directorio!\n Se restablecerá el directorio a predeterminado");
            path = null;
        }

        window.setVisible(true); //Se hace visible la ventana principal

        /* Se inicializa el sonido de inicio */
        mymusic = new Music();
        backSound = mymusic.getSound("back.wav");
		mymusic.playSound(backSound);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == us) { //Si se selecciona la pestaña "sobre nosotros" se muestra la siguiente información
            JOptionPane.showMessageDialog(window, "Sink-a-Ship \n Hecho por: Yurgen Cambronero 2022128005");

        } else if (e.getSource() == savep) { //Si se selecciona la pestaña ruta guardado, se abre un filechooser y se selecciona un folder donde se guardaran los savefiles.json
            JFileChooser directoryChooser = new JFileChooser(path);
            directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Se activa el modo solo directorios
            directoryChooser.setDialogTitle("Seleccione donde desea guardar el archivo"); //Se le pone un titulo a la ventana FileChooser
            int response = directoryChooser.showSaveDialog(this); //Se almacena la respuesta dada en el seleccionador de archivos

            if (response == JFileChooser.APPROVE_OPTION){ //Si se dio aceptar entonces el path se guarda
                path = directoryChooser.getSelectedFile().toString();
            } else if (response == JFileChooser.CANCEL_OPTION) { //Sino, se da el mensaje de que se canceló la función
                  JOptionPane.showMessageDialog(this ,"Se canceló la selección de la ruta guardado!");
            } else { //Y en cualquier otro caso fue que sucedió un error
                JOptionPane.showMessageDialog(this ,"Error al cambiar la ruta de guardado!");
            }
        } else if (e.getSource() == rules) { //Si se selecciona el menu reglas, pues se muestran
            JOptionPane.showMessageDialog(window, " El juego trata de una cuadrícula con barcos escondidos en el océano\n Su deber es tratar de adivinar donde se encuentran los barcos!\n Si el barco se encuentra en la posición clickeada su color cambiará a azul, en caso contrario su color será rojo\n Al encontrar todos los barcos ganarás, muchos éxitos!");
            
        } else if (e.getSource() == load) { //Si se da cargar, se crea un filechooser que permita json files principalmente
            JFileChooser fileChooser = new JFileChooser(path);
            fileChooser.setFileFilter(new FileNameExtensionFilter("JSON Files", "json")); //Se crea el filtro para json files
            int result = fileChooser.showOpenDialog(this); //Se guarda el resultado
            fileChooser.setDialogTitle("Seleccione un archivo de guardado"); //Se abre el filechooser

            if (result != JFileChooser.CANCEL_OPTION) { //Si se da aceptar
                File fileName = fileChooser.getSelectedFile(); //Se recibe el archivo
                if ((fileName == null) || (fileName.getName().equals(""))) { //Se verifica que no este vacio
                    JOptionPane.showMessageDialog(this ,"El archivo cargado estaba vacio!");
                    nopath = 1; //Si es asi se envia una señal de no seguir
                } else { //Sino, se guarda el path y se da una señal de continuar
                    oldPath = path;
                    path = fileChooser.getSelectedFile().getAbsolutePath();
                    nopath = 0;
                }
            } else { //En caso de que se haya cancelado, pues se indica
                JOptionPane.showMessageDialog(this ,"Se canceló la carga!");
                nopath = 1;
            }
            if (nopath != 1) { //Si la señal recibida es de continuar (0) entonces, se almacena el guardado
                gameLoad = saver.loadField(path);
                path = oldPath;
                if (gameLoad == null) { //Si esta vacio, pues no se carga
                    JOptionPane.showMessageDialog(this, "El archivo cargado no es permitido!");
                } else {
                    gameLoaded = new BattleShipPlay(this, true, gameLoad, path); //Sino, lo carga desde donde quedó
                }
            } else {
                //Si la señal recibida es de no continuar no se hace nada
            }
        } else if (e.getSource() == neu) { //Si la opcion es nuevo
            if (path == null) { //Si el path es null, pues se indica que se debe seleccionar una ruta de guardado
                JOptionPane.showMessageDialog(this, "Selecciona primero una ruta de guardado!");
            } else { //Sino, se crea la ventana desde 0
                gameStart = new BattleShipPlay(this, true, field, path);
                field = new BattleField(); //Si se cierra la ventana se reinicia el campo
            }
        } else if (e.getSource() == exit) { //Si se desea salir, pues se sale y ya
            System.exit(0);
        }
    }
}
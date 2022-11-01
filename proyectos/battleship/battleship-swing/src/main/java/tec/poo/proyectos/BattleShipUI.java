package tec.poo.proyectos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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
    Saver saver;
    String path;
    BattleField gameLoad;
    BattleShipPlay gameStart;
    BattleShipPlay gameLoaded;
    int nopath;

    public BattleShipUI (BattleField battle, String pathO) {
        /* Guarda las variables recibidas como variables globales*/
        path = pathO;
        field = battle;

        /* Crea el saver, objeto para guardar y cargar JSON files */
        saver = new Saver();

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
        exit = new JMenuItem("exit");

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

        /* Creación del texto battleship con la imagen */
        text = new ImageIcon(BattleShipUI.class.getResource("/text.png"));
        label2 = new JLabel(" ", text, SwingConstants.CENTER);
        label2.setSize(1200, 676);
        label2.setLocation(new Point(1,2)); //Se posiciona frente al background

        //Se añaden las imagenes a la ventana principal
        window.add(label2);
        window.add(label1);

        /* Test de si existe el directorio, si el directorio existe y no es un archivo entonces se sigue normal */
        File test = new File(path);
        if (test.exists() && test.isDirectory()) {

        } else { //Sino, se muestra un popup diciendo que no se encontró el directorio y que se restablecerá al directorio predeterminado
            JOptionPane.showMessageDialog(window, "No se encontró el directorio!\n Se restablecerá el directorio a predeterminado");
            path = null;
        }

        window.setVisible(true); //Se hace visible la ventana principal
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == us) { //Si se selecciona la pestaña "sobre nosotros" se muestra la siguiente información
            JOptionPane.showMessageDialog(window, "Sink-a-Ship \n Hecho por: Yurgen Cambronero 2022128005");

        } else if (e.getSource() == savep) { //Si se selecciona la pestaña ruta guardado, se abre un filechooser y se selecciona un folder donde se guardaran los savefiles.json
            JFileChooser directoryChooser = new JFileChooser(path);
            directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Se activa el modo solo directorios
            directoryChooser.setDialogTitle("Seleccione donde desea guardar el archivo"); //Se le pone un titulo a la ventana FileChooser
            int response = directoryChooser.showSaveDialog(this);

            if (response == JFileChooser.APPROVE_OPTION){
                path = directoryChooser.getSelectedFile().toString();
            } else if (response == JFileChooser.CANCEL_OPTION) {
                  JOptionPane.showMessageDialog(this ,"Se canceló la selección de la ruta guardado!");
            } else {
                JOptionPane.showMessageDialog(this ,"Error al cambiar la ruta de guardado!");
            }
        } else if (e.getSource() == rules) {
            JOptionPane.showMessageDialog(window, " El juego trata de una cuadrícula con barcos escondidos en el océano\n Su deber es tratar de adivinar donde se encuentran los barcos!\n Si el barco se encuentra en la posición clickeada su color cambiará a azul, en caso contrario su color será rojo\n Al encontrar todos los barcos ganarás, muchos éxitos!");
            
        } else if (e.getSource() == load) {
            JFileChooser fileChooser = new JFileChooser(path);
            fileChooser.setFileFilter(new FileNameExtensionFilter("JSON Files", "json"));
            int result = fileChooser.showOpenDialog(this);
            fileChooser.setDialogTitle("Seleccione un archivo de guardado");

            if (result != JFileChooser.CANCEL_OPTION) {
                File fileName = fileChooser.getSelectedFile();
                if ((fileName == null) || (fileName.getName().equals(""))) {
                    nopath = 0;
                } else {
                    path = fileChooser.getSelectedFile().getAbsolutePath();
                    nopath = 0;
                }
            } else {
                JOptionPane.showMessageDialog(this ,"Se canceló la carga!");
                nopath = 1;
            }
            if (nopath != 1) {
                gameLoad = saver.loadBoard(path);
                if (gameLoad == null) {
                    JOptionPane.showMessageDialog(this, "El archivo cargado no es permitido!");
                } else {
                    gameLoaded = new BattleShipPlay(this, true, gameLoad, path);
                }
            } else {

            }
        } else if (e.getSource() == neu) {
            if (path == null) {
                JOptionPane.showMessageDialog(this, "Selecciona primero una ruta de guardado!");
            } else {
                gameStart = new BattleShipPlay(this, true, field, path);
                field = new BattleField();
            }
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
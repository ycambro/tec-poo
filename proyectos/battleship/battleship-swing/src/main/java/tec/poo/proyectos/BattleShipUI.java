package tec.poo.proyectos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.JsonSyntaxException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.ImageIcon;

public class BattleShipUI extends JFrame implements ActionListener{
    /* Declaración de variables */
    JMenuItem salir;
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
        salir = new JMenuItem("Salir");

        game.add(neu);
        neu.addActionListener(this);
        game.add(load);
        load.addActionListener(this);
        game.add(salir);
        salir.addActionListener(this);

        window.getContentPane().add(BorderLayout.NORTH, menu);

        background = new ImageIcon(getClass().getResource("gif.gif"));
        label1 = new JLabel(" ", background, SwingConstants.CENTER);
        label1.setSize(1200, 676);
        label1.setLocation(new Point(1,1));

        text = new ImageIcon(getClass(),getResource("text.png"));
        label2 = new JLabel(" ", text, SwingConstants.CENTER);
        label2.setSize(1200, 676);
        label2.setLocation(new Point(1,2));

        window.add(label1);
        window.add(label2);

        File test = new File(path);
        if (test.exists() && test.isDirectory()) {

        } else {
            JOptionPane.showMessageDialog(window, "No se encontró el directorio!\n Se restablecerá el directorio a predeterminado");
            path = null;
        }

        window.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == us) {
            JOptionPane.showMessageDialog(window, "Sink-a-Ship \n Hecho por: Yurgen Cambronero 2022128005");

        } else if (e.getSource() == savep) {
            JFileChooser directoryChooser = new JFileChooser(path);
            directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            directoryChooser.setDialogTitle("Seleccione donde desea guardar el archivo");
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
                    path = null;
                } else {
                    path = fileChooser.getSelectedFile().getAbsolutePath();
                }
            } else {
                JOptionPane.showMessageDialog(this ,"Se canceló la carga!");
                path = null;
            }
            if (path != null) {
                gameLoad = saver.loadBoard(path);
                if (gameLoad == null) {
                    JOptionPane.showMessageDialog(this, "El archivo cargado no es permitido!");
                } else {
                    gameLoaded = new BattleShipPlay(this, true, gameLoad, path);
                }
            } else {

            }
        } else if (e.getSource() == neu) {
            gameStart = new BattleShipPlay(this, true, field, path);
            field = new BattleField();
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
    }

    public static void main (String[] args) {
        BattleField battlef = new BattleField();
        BattleShipUI ui = new BattleShipUI(battlef, "hehe");
    }
}
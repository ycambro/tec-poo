package tec.poo.proyectos;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;


public class Saver {
    BattleField loadBoard;
    
    public void saveObject(BattleField board, String path){
        Gson gsonToSave = new Gson();
        String jsonString = gsonToSave.toJson(board);
        UUID id = UUID.randomUUID();
        System.out.println(jsonString);

        try(PrintWriter pw = new PrintWriter(new File(path + "\\" + id +".json"))){
            pw.write(jsonString);
        } catch(FileNotFoundException ex){
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public BattleField loadBoard(String archivo){
        String json = "";
        try{
            BufferedReader buffread = new BufferedReader(new FileReader(archivo));
            String linea;
            try{
                while((linea = buffread.readLine()) != null){
                    json += linea;
                }
            } catch(IOException ex){
                Logger.getLogger(Saver.class.getName()).log(Level.SEVERE,null,ex);
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        try {
            loadBoard = gson.fromJson(json,BattleField.class);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(null, "Este archivo no es permitido!");
        } catch (JsonSyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Este archivo no es permitido!");
        }
        return loadBoard;
    }
}
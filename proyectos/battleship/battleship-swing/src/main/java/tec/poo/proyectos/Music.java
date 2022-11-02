package tec.poo.proyectos;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
 
public class Music //Bublioteca para música de fondo
{
    private File music;
    private AudioInputStream audioInputStream;
    DataLine.Info info;
    Clip sound;
    Clip clip;
    AudioFormat format;

	public Clip getSound(String file) {
        //Trata de crear el archivo de música, si no se puede solo continua sin el e imprime el error
		try {
            this.music = new File(file);
			this.audioInputStream = AudioSystem.getAudioInputStream(music.getAbsoluteFile()); //Se recibe el archivo
            this.format = audioInputStream.getFormat(); //Se lee el formato del archivo
			this.info = new DataLine.Info(Clip.class, format); //Se lee en si el archivo
			this.sound = (Clip)AudioSystem.getLine(info); //El archivo y sus lineas de información son convertidos en un Clip, para poder ser reproducido
			this.sound.open(audioInputStream);//Se abre el archivo  y se retonrna el sonido
			return this.sound;
		} catch(Exception e) {
            e.printStackTrace();
			return null;
		}
	}
 
	public void playSound(Clip clip1) {
        this.clip = clip1;
		this.clip.stop(); //Se detiene el sonido
		this.clip.setFramePosition(0); //Se posiciona en el inicio de la canción
		this.clip.start(); //Se inicia la resproducción del sonido    
    }
}
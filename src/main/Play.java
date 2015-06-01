package main;

import javazoom.jl.player.advanced.*; /*Libreria para el reproductor de musica*/
import javax.swing.JFileChooser; /* Buscador de archivo de formato .mp3*/
import java.io.File; /*Libreria necesaria, para reproducir musica*/
import java.io.FileInputStream;

/*C�digo fuente*/
public class Play { 
	
	public static void main(String[] args) {
		
		/*Reproductor de musica*/
		AdvancedPlayer reproductor; 
		
		/*Selecci�n de archivo .mp3, abre l ventana para escoger nuestro archivo*/
		JFileChooser seleccionar = new JFileChooser();
		int a =seleccionar.showOpenDialog(null);
		if(a==JFileChooser.APPROVE_OPTION)
		{
			/*Este apartado, es para abrir la ventana y nos muestre no solo los archivos .mp3, tambien nos mostrara
			 * todas las carpetas y archivos en ella, ademas del .mp3, en otras palabras, es la t�pica ventana de
			 * selecci�n de archivo.
			 */
			File archivo = seleccionar.getSelectedFile();
			try
			{
 			reproductor = new AdvancedPlayer(new FileInputStream(archivo));
			reproductor.play();
			}
			catch(Exception e)
			{
				/*Mensaje de error si se abre otro archivo que no sea .mp3*/
				System.out.println("Error");
			}
		}
	}
}

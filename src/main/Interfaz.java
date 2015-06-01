package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import javazoom.jl.player.advanced.AdvancedPlayer;


public class Interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon(Interfaz.class.getResource("/images/stop.png")));
		btnStop.setForeground(UIManager.getColor("Button.foreground"));
		btnStop.setBackground(UIManager.getColor("Button.select"));
		btnStop.setBounds(0, 190, 160, 80);
		contentPane.add(btnStop);
		btnStop.setFocusPainted(false);
		/*btnStop.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent e){
		try {
		AdvancedPlayer reproductor = null;
		reproductor.stop();
			} catch (Exception e1) {
		// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		}
		});*/
		
		JButton btnP = new JButton("");
		btnP.setIcon(new ImageIcon(Interfaz.class.getResource("/images/play.png")));
		btnP.setBackground(UIManager.getColor("Button.select"));
		btnP.setForeground(UIManager.getColor("Button.foreground"));

		
		btnP.setBounds(140, 220, 170, 80);
		contentPane.add(btnP);
		
		JButton btnPause = new JButton("");
		btnPause.setIcon(new ImageIcon(Interfaz.class.getResource("/images/pause.png")));
		btnPause.setBackground(UIManager.getColor("Button.select"));
		btnPause.setForeground(UIManager.getColor("Button.foreground"));
		btnPause.setBounds(290, 190, 160, 80);
		
		contentPane.add(btnPause);
		
		//NO TOCAR!!!!
		
		//public void actionPerformed(ActionEvent e1) { 
			
		//	Play.Pause(cancion)
		//}
		//
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Interfaz.class.getResource("/images/cargar.png")));
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("Button.select"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					catch(Exception e1)
					{
						/*Mensaje de error si se abre otro archivo que no sea .mp3*/
						System.out.println("Error");
					}
				}
			
			}
		});
		btnNewButton.setBounds(0, 0, 60, 60);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(305, 5, 140, 180);
		contentPane.add(textArea);
	}
}
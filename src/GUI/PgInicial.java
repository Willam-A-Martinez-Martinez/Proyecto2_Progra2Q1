package GUI;


import Users.Datos;
import Users.ManejoAvatar;
import Users.ManejoUser;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PgInicial extends Grafico{
    JFrame frame = new JFrame();
    JLabel background = new JLabel();
    JButton iniciarSesion = new JButton();
    JButton registrarse = new JButton();
    JButton salir = new JButton();
    
    ImageIcon fondoGif = new ImageIcon("src/Assets/fondoPgInicial.gif");
    
    //Imagenes
    
    //Info de usuarios
    public Datos logUser;
    
    public String nombre, oponente;
    
    ManejoUser mUser;
    ManejoAvatar mAvatar;
    
    private File archM = new File("src/Musica/gigachad_8bit_song.wav");
    public AudioInputStream audioSM;
    public Clip clipM;
    
    public PgInicial(){
        try {
            
            if (!archM.exists()) {
                System.err.println("El archivo de audio no se encontró: " + archM.getAbsolutePath());
                return;
            }
            audioSM = AudioSystem.getAudioInputStream(archM);

            // Inicializar y abrir el clip
            clipM = AudioSystem.getClip();
            
            clipM.open(audioSM);
            clipM.start();
            clipM.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException  e) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, e);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PgInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mAvatar= new ManejoAvatar();
        mUser = new ManejoUser();
        
        
        //FRAME
        confFrame(frame, "Segmented & Corp", 1000, 700, "Pantalla");

        frame.add(iniciarSesion);
        frame.add(registrarse);
        frame.add(salir);
        frame.add(background);
        frame.setVisible(true);

        //BACKGROUND
        fondo(background, 0, 0, fondoGif, frame);

        //BOTON 1 Iniciar sesion
        boton(iniciarSesion, 375, 150, 235, 42, false, false, "Dialog", 28, "Iniciar sesion", 250);

        //BOTON 2 iniciar_Sesion
        boton(registrarse, 375, 225, 235, 42, false, false, "Dialog", 28, "Registrarse", 250);

        //BOTON 3 salir del sistema
        boton(salir, 375, 325, 235, 42, false, false, "Dialog", 28, "Salir", 250);

        iniciarSesion.addActionListener((ActionEvent e) -> {
            if(mUser.contarUsuario()>0){
                IniciarSesion iniciarSesion = new IniciarSesion(this);
                iniciarSesion.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        
        

        registrarse.addActionListener((ActionEvent e) -> {
            Registrarse registrarse = new Registrarse(this);
            registrarse.frame.setVisible(true);
            frame.setVisible(false);
        });
        
        salir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
    
}

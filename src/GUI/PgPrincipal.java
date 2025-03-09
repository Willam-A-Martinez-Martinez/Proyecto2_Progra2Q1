package GUI;

import Users.Datos;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PgPrincipal extends Grafico{
    JFrame frame= new JFrame("Menú Principal - Sokoban");
    private JLabel fondo = new JLabel();
    private JLabel titulo= new JLabel("Menú Principal", SwingConstants.CENTER);
    private JButton btnIniciarPartida= new JButton("️Jugar");
    private JButton btnPerfilUsuario= new JButton("Perfil de usuario");
    private JButton btnEstadisticas= new JButton("Estadisticas");
    private JButton btnRanking= new JButton("Ranking");
    private JButton btnPreferencias= new JButton("Configuracion");
    private JButton btnSalir= new JButton("Salir");

    ImageIcon backgroundI= new ImageIcon("src/Assets/FondoRegistro-Inicio Sesion.gif");
    
    public PgInicial pgInicial;
    
    public PgPrincipal(PgInicial pgInicial) {
        this.pgInicial= pgInicial;
        confFrame(frame, "Sokoban", 1000, 700, "Pantalla");
        
        fondo(fondo            , 0, 0, backgroundI, frame);
       titulo(titulo           , 400, 50 , 200, 50, "Dialog", 28, 250, "Menu principal");
        boton(btnIniciarPartida, 380, 110, 115, 50, false, false, "Dialog", 28, "Jugar", 250);
        boton(btnPerfilUsuario , 380, 170, 275, 50, false, false, "Dialog", 28, "Perfil de usuario", 250);
        boton(btnPreferencias  , 380, 230, 218, 50, false, false, "Dialog", 28, "Configuracion", 250);
        boton(btnEstadisticas  , 380, 290, 205, 50, false, false, "Dialog", 28, "Estadisticas", 250);
        boton(btnRanking       , 380, 350, 135, 50, false, false, "Dialog", 28, "Ranking", 250);
        boton(btnSalir         , 380, 410, 120, 50, false, false, "Dialog", 28, "Log out", 250);
        btnIniciarPartida.setAlignmentX(SwingConstants.LEFT);
        btnPerfilUsuario .setAlignmentX(SwingConstants.LEFT);
        btnPreferencias  .setAlignmentX(SwingConstants.LEFT);
        btnEstadisticas  .setAlignmentX(SwingConstants.LEFT);
        btnRanking       .setAlignmentX(SwingConstants.LEFT);
        btnSalir         .setAlignmentX(SwingConstants.LEFT);
        
        frame.add(titulo,0);
        frame.add(btnIniciarPartida,1);
        frame.add(btnPerfilUsuario,2);
        frame.add(btnPreferencias,3);
        frame.add(btnEstadisticas,4);
        frame.add(btnRanking,5);
        frame.add(btnSalir,6);
        frame.add(fondo,7);
        
        
        frame.setVisible(true);
        btnPerfilUsuario.addActionListener((ActionEvent e) -> {
            frame.remove(titulo);
            frame.remove(btnIniciarPartida);
            frame.remove(btnPerfilUsuario);
            frame.remove(btnPreferencias);
            frame.remove(btnEstadisticas);
            frame.remove(btnRanking);
            frame.remove(btnSalir);
            frame.remove(fondo);
            perfilUsuario();
        });
        
        btnPreferencias.addActionListener((ActionEvent e) -> {
            frame.remove(titulo);
            frame.remove(btnIniciarPartida);
            frame.remove(btnPerfilUsuario);
            frame.remove(btnPreferencias);
            frame.remove(btnEstadisticas);
            frame.remove(btnRanking);
            frame.remove(btnSalir);
            frame.remove(fondo);
            perfilUsuario();
        });
        
        btnEstadisticas.addActionListener((ActionEvent e) -> {
            frame.remove(titulo);
            frame.remove(btnIniciarPartida);
            frame.remove(btnPerfilUsuario);
            frame.remove(btnPreferencias);
            frame.remove(btnEstadisticas);
            frame.remove(btnRanking);
            frame.remove(btnSalir);
            frame.remove(fondo);
            perfilUsuario();
        });
        
        btnRanking.addActionListener((ActionEvent e) -> {
            frame.remove(titulo);
            frame.remove(btnIniciarPartida);
            frame.remove(btnPerfilUsuario);
            frame.remove(btnPreferencias);
            frame.remove(btnEstadisticas);
            frame.remove(btnRanking);
            frame.remove(btnSalir);
            frame.remove(fondo);
            perfilUsuario();
        });
        
        btnSalir.addActionListener((ActionEvent e) -> {
            pgInicial.logUser = null;
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });
    }

    

    private void perfilUsuario() {
        JButton salir = new JButton();
        
        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        
        frame.add(salir, 0);
        frame.add(fondo, 1);
        frame.repaint();
        frame.revalidate();
        
        salir.addActionListener((ActionEvent e) -> {
            frame.add(titulo,0);
            frame.add(btnIniciarPartida,1);
            frame.add(btnPerfilUsuario,2);
            frame.add(btnPreferencias,3);
            frame.add(btnEstadisticas,4);
            frame.add(btnRanking,5);
            frame.add(btnSalir,6);
            frame.add(fondo,7);
            
            frame.repaint();
            frame.revalidate();
        });
    }
    
    private void preferencia() {
        JButton salir = new JButton();
        
        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        
        frame.add(salir, 0);
        frame.add(fondo, 1);
        frame.repaint();
        frame.revalidate();
        
        salir.addActionListener((ActionEvent e) -> {
            frame.add(titulo,0);
            frame.add(btnIniciarPartida,1);
            frame.add(btnPerfilUsuario,2);
            frame.add(btnPreferencias,3);
            frame.add(btnEstadisticas,4);
            frame.add(btnRanking,5);
            frame.add(btnSalir,6);
            frame.add(fondo,7);
            
            frame.repaint();
            frame.revalidate();
        });
    }

    private void estadisticas() {
        JButton salir = new JButton();
        
        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        
        frame.add(salir, 0);
        frame.add(fondo, 1);
        frame.repaint();
        frame.revalidate();
        
        salir.addActionListener((ActionEvent e) -> {
            frame.add(titulo,0);
            frame.add(btnIniciarPartida,1);
            frame.add(btnPerfilUsuario,2);
            frame.add(btnPreferencias,3);
            frame.add(btnEstadisticas,4);
            frame.add(btnRanking,5);
            frame.add(btnSalir,6);
            frame.add(fondo,7);
            
            frame.repaint();
            frame.revalidate();
        });
    }
    
    private void ranking() {
        JButton salir = new JButton();
        
        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        
        frame.add(salir, 0);
        frame.add(fondo, 1);
        frame.repaint();
        frame.revalidate();
        
        salir.addActionListener((ActionEvent e) -> {
            frame.add(titulo,0);
            frame.add(btnIniciarPartida,1);
            frame.add(btnPerfilUsuario,2);
            frame.add(btnPreferencias,3);
            frame.add(btnEstadisticas,4);
            frame.add(btnRanking,5);
            frame.add(btnSalir,6);
            frame.add(fondo,7);
            
            frame.repaint();
            frame.revalidate();
        });
    }
    
    
}
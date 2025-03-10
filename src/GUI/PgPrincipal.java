package GUI;

import Users.Datos;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        boton(btnSalir         , 380, 410, 18*8, 50, false, false, "Dialog", 28, "Log out", 250);
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
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            perfilUsuario();
        });
        
        btnPreferencias.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            preferencia();
        });
        
        btnEstadisticas.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            estadisticas();
        });
        
        btnRanking.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            ranking();
        });
        
        btnSalir.addActionListener((ActionEvent e) -> {
            pgInicial.logUser = null;
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });
    }

    

    private void perfilUsuario() {
        JLabel tituloPerfil = new JLabel();
        JLabel lblPerfil       = new JLabel();
        JLabel lblNombre       = new JLabel("Nombre");
        JLabel lblApodo        = new JLabel("Apodo");
        JLabel lblFechaIngreso = new JLabel("Fecha de ingreso");
        JLabel lblUltimaSesion = new JLabel("Última sesión iniciada");
        JButton salir = new JButton();
        
        ImageIcon perfil = new ImageIcon(pgInicial.logUser.getAvatar());
        
        System.out.println("Ruta de imagen: "+pgInicial.logUser.getAvatar());
        
        
        
        titulo(tituloPerfil   , 400, 50 , 250, 50, "Dialog", 28, 250, "Perfil de usuario");
        titulo(lblPerfil      , 400, 110 , 100, 100, "Dialog", 28, 250, "");
        titulo(lblNombre      , 400, 215 , 18*(8+pgInicial.logUser.getNombreCompleto().length()) , 50, "Dialog", 28, 250, "Nombre: "+pgInicial.logUser.getNombreCompleto());
        titulo(lblApodo       , 400, 275 , 18*(7+pgInicial.logUser.getNombreUser().length()) , 50, "Dialog", 28, 250, "Apodo: "+pgInicial.logUser.getNombreUser());
        titulo(lblFechaIngreso, 400, 335 , 18*(18+pgInicial.logUser.getFechaRegistro().length()), 50, "Dialog", 28, 250, "Fecha de ingreso: "+pgInicial.logUser.getFechaRegistro());
        titulo(lblUltimaSesion, 400, 395 , 18*(15+pgInicial.logUser.getUltimaSesion().length()), 50, "Dialog", 28, 250, "Ultima sesion: "+pgInicial.logUser.getUltimaSesion());
        
        lblPerfil.setIcon(scaleImage(perfil, 100, 100));
        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        
        frame.add(tituloPerfil);
        frame.add(lblPerfil);
        frame.add(salir);
        frame.add(lblNombre);
        frame.add(lblApodo);
        frame.add(lblFechaIngreso);
        frame.add(lblUltimaSesion);
        frame.add(fondo);
        
        
        
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
        UIManager.put("TabbedPane.contentOpaque", false);
        UIManager.put("TabbedPane.tabsOpaque", false);
        
        JButton salir = new JButton();
        JTabbedPane configuracionTabs = new JTabbedPane();
        
        configuracionTabs.setBounds(320, 50, 650, 400);
        
        
        JPanel juego = new JPanel();
        JCheckBox muteCB = new JCheckBox();
        JCheckBox españolCB = new JCheckBox();
        JCheckBox inglesCB = new JCheckBox();
        JLabel volumenTitulo = new JLabel();
        JLabel idiomaTitulo = new JLabel();
        JLabel muteL = new JLabel();
        JSlider volumenM = new JSlider(-40,6);
        
        titulo(volumenTitulo, 20, 20 , 18*9, 50, "Dialog", 28, 250, "Volumen: ");
        titulo(idiomaTitulo, 20, 80 , 18*8, 50, "Dialog", 28, 250, "Idioma: ");
        titulo(muteL, (18*8)+200, 20 , 18*10, 50, "Dialog", 28, 250, "Silenciar: ");
        
        muteCB.setBounds((18*8)+(18*10)+200, 20, 50, 50);
        muteCB.setContentAreaFilled(false);
        
        españolCB.setBounds((18*7), 80, 50, 50);
        españolCB.setContentAreaFilled(false);
        
        inglesCB.setBounds((18*7)+50, 80, 50, 50);
        inglesCB.setContentAreaFilled(false);
        
        volumenM.setBounds((18*8), 35, 200, 25);
        volumenM.setLayout(null);
        volumenM.setOpaque(false);
        
        juego.add(muteL);
        juego.add(españolCB);
        juego.add(inglesCB);
        juego.add(muteCB);
        juego.add(volumenTitulo);
        juego.add(idiomaTitulo);
        juego.setOpaque(false);
        juego.setLayout(null);
        juego.add(volumenM);
        
        JPanel Perfil = new JPanel();
        Perfil.setOpaque(false);
        Perfil.setLayout(null);
        
        configuracionTabs.addTab("Juego", juego);
        configuracionTabs.addTab("Perfil", Perfil);
        
        configuracionTabs.setOpaque(false);
        configuracionTabs.setBorder(null);
        configuracionTabs.setFont(pixelMplus);

        boton(salir, 140, 180, 120, 50, false, false, "Dialog", 28, "Volver", 250);
        frame.add(configuracionTabs);
        frame.add(salir);
        frame.add(fondo);
        frame.repaint();
        frame.revalidate();
        
        volumenM.setValue(Math.round(pgInicial.music.volumen1));
        volumenM.addChangeListener((ChangeEvent e) -> {
            if(pgInicial.music.mute==false){
                pgInicial.music.volumen1 = volumenM.getValue();
                pgInicial.music.fc.setValue(pgInicial.music.volumen1);
                System.out.println("Valor de slider: "+volumenM.getValue());
            }
        });
        
        muteCB.addActionListener((ActionEvent e) -> {
            pgInicial.music.volumeMute();
        });
        
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
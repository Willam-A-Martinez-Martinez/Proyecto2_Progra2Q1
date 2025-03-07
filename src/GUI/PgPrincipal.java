package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PgPrincipal extends Grafico{
    JFrame frame= new JFrame("Menú Principal - Sokoban");;
    private JLabel fondo = new JLabel();
    private JLabel titulo= new JLabel("Menú Principal", SwingConstants.CENTER);;
    private JButton btnIniciarPartida= new JButton("1️⃣ Iniciar Partida 🎮");;
    private JButton btnPerfilUsuario= new JButton("2️⃣ Perfil de Usuario 👤");;
    private JButton btnEstadisticas= new JButton("3️⃣ Estadísticas 📊");;
    private JButton btnRanking= new JButton("4️⃣ Ranking Global 🏆");;
    private JButton btnPreferencias= new JButton("5️⃣ Preferencias ⚙️");;
    private JButton btnAdminCuenta= new JButton("6️⃣ Administración de Cuenta 🔐");;
    private JButton btnSalir= new JButton("7️⃣ Salir del Juego 🚪");;

    ImageIcon backgroundI= new ImageIcon("src/Assets/FondoRegistro-Inicio Sesion.gif");
    
    public PgInicial pgInicial;
    
    public PgPrincipal(PgInicial pgInicial) {
        this.pgInicial= pgInicial;
        confFrame(frame, "Sokoban", 1000, 700);
        
        fondo(fondo, 0, 0, backgroundI, frame);
        
        
        frame.add(titulo);
        frame.add(btnIniciarPartida);
        frame.add(btnPerfilUsuario);
        frame.add(btnEstadisticas);
        frame.add(btnRanking);
        frame.add(btnPreferencias);
        frame.add(btnAdminCuenta);
        frame.add(btnSalir);
        frame.add(fondo);
        
        frame.setVisible(true);
        configurarFrame();
    }

    

    private void configurarFrame() {
        
    }

}
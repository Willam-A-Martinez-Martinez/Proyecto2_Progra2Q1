/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class IniciarSesion extends Grafico{
    JFrame frame = new JFrame();
    JLabel tituloSuperior = new JLabel();
    JLabel background = new JLabel();
    JLabel nombreTxt = new JLabel();
    JLabel contraseñaTxt = new JLabel();
    JButton volver = new JButton();
    JButton iniciar_Sesion = new JButton();   
    JTextField nombreTxtF = new JTextField();
    JPasswordField contraseñaTxtF = new JPasswordField();
    
    //Imagenes
    ImageIcon backgroundI= new ImageIcon("src/Assets/FondoRegistro-Inicio Sesion.gif");
    
    //Info de usuarios
    PgInicial pgInicial;
    
    public IniciarSesion(PgInicial pgInicial){
        this.pgInicial =pgInicial;
        //FRAME
        confFrame(frame, "Segmented & Corp", 1000, 700, "Pantalla");

        frame.add(tituloSuperior);
        frame.add(nombreTxtF);
        frame.add(contraseñaTxtF);
        frame.add(nombreTxt);
        frame.add(contraseñaTxt);
        frame.add(volver);
        frame.add(iniciar_Sesion);
        frame.add(background);
        frame.setVisible(true);
        
        //BACKGROUND
        fondo(background, 0, 0, backgroundI, frame);

        //TITULO
        titulo(tituloSuperior, 590, 71, 200, 50, "Dialog", 28, 250, "Iniciar sesion");

        //Sub titulo 1
        titulo(nombreTxt, 610, 128, 170, 50, "Dialog", 28, 250, "Nombre:");
        
        //Textfield 1
        textfield(nombreTxtF, 585, 175, 170, 30, "Dialog", 20);
        
        //Sub titulo 2
        titulo(contraseñaTxt, 590, 235, 170, 50, "Dialog", 28, 250, "Contraseña:");
        
        //Textfield 2
        passwordfield(contraseñaTxtF, 585, 275, 170, 30, "Dialog", 20);
        
        //BOTON 1 Iniciar sesion
        boton(volver, 420, 350, 235, 42, false, false, "Dialog", 28, "Volver", 250);

        //BOTON 2 iniciar_Sesion
        boton(iniciar_Sesion, 660, 350, 235, 42, false, false, "Dialog", 28, "Iniciar sesion", 250);


        volver.addActionListener((ActionEvent e) -> {
            pgInicial.frame.setVisible(true);
            frame.dispose();
        });

        iniciar_Sesion.addActionListener((ActionEvent e) -> {
            String nombreC=nombreTxtF.getText();
            String contra = new String(contraseñaTxtF.getPassword()).trim();
            
            if(pgInicial.mUser.existeUsuario(nombreC, contra)!=null){
                JOptionPane.showMessageDialog(null, "Se ha iniciado sesión!");
                pgInicial.logUser = pgInicial.mUser.existeUsuario(nombreC, contra);
                PgPrincipal pgP = new PgPrincipal(pgInicial);
                pgP.frame.setVisible(true);
                frame.dispose();
            }
        });
        
        
    }
}
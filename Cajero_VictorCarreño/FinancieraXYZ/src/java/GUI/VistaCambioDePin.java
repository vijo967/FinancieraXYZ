package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author FamiliaQuiroga
 */
public class VistaCambioDePin extends JFrame{
    
    private JButton botonAceptar;
    private JTextField campoNuevoPin;
    private JTextField campoConfirmar;
    private JLabel etiquetaNuevoPin;
    private JLabel etiquetaConfirmar;
    
    public VistaCambioDePin() {
        setLayout(null);
        
        botonAceptar = new JButton("Aceptar");
        campoNuevoPin = new JTextField(200);
        campoConfirmar = new JTextField(200);
        etiquetaNuevoPin = new JLabel("Introduzca su nuevo PIN");
        etiquetaConfirmar = new JLabel("Reintroduzca su nuevo PIN");        
                
        add(botonAceptar);
        add(campoNuevoPin);
        add(campoConfirmar);
        add(etiquetaNuevoPin);
        add(etiquetaConfirmar);
        
        etiquetaNuevoPin.setBounds(125, 50, 300, 20);
        campoNuevoPin.setBounds(50, 75, 300, 20);
        
        etiquetaConfirmar.setBounds(125, 120, 300, 20);
        campoConfirmar.setBounds(50, 145, 300, 20);
        
        botonAceptar.setBounds(190,200,80,30);
        
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cambio de Pin");
    }
}

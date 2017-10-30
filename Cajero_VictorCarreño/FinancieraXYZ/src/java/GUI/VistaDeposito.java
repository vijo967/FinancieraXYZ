package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JFrame;

/**
 *
 * @author FamiliaQuiroga
 */
public class VistaDeposito extends JFrame{
    
    private JLabel etiqueta1;
    private JTextField campoMonto;
    private JButton botonConfirmar;
    
    public VistaDeposito() {
        
        setLayout(null);
        etiqueta1 = new JLabel("Introduzca el monto que desea depositar");
        campoMonto = new JTextField(250);
        botonConfirmar = new JButton("Aceptar");
        
        add(etiqueta1);
        add(campoMonto);
        add(botonConfirmar);
        
        etiqueta1.setBounds(50, 50, 300, 25);
        campoMonto.setBounds(50,90,175,25);
        botonConfirmar.setBounds(235,90,80,25);
        
        
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deposito");
    }
}

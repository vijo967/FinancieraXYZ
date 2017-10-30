package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import principal.Cajero;

/**
 *
 * @author FamiliaQuiroga
 */
public class LoginNroDeCuenta extends JFrame{
    
    private JLabel etiqueta;
    private JTextField campoTexto;
    private JButton boton;
    private Cajero cajero;
    
    public LoginNroDeCuenta(Cajero cajero) {
        this.cajero = cajero;
        setLayout(null);
         
        etiqueta = new JLabel("Nro de Cuenta");
        campoTexto = new JTextField(200);
        boton = new JButton("Aceptar");
       
        etiqueta.setBounds(50, 30, 90, 20);
        campoTexto.setBounds(150,30,150,20);
        boton.setBounds(115,75, 100, 25);
         
        add(boton);
        add(campoTexto);
        add(etiqueta);
        
        
         
         
         
        setSize(350,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        setResizable(false);
         
         
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aux = campoTexto.getText();
                int numeroDeCuenta = convertirANumero(aux);
                if(cajero.validarNroCuenta(numeroDeCuenta)) {
                    cajero.mostrarLoginPin();
                }
            }   
            });
    }
    
    private int convertirANumero(String num) {
        int numero = 0;
        for(int i=0; i<num.length(); i++) {
            numero*=10;
            numero +=(int) num.charAt(i) - 48;
            
        }
        return numero;
    }
}


package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import principal.Cajero;

/**
 *
 * @author FamiliaQuiroga
 */
public class LoginPin extends JFrame{
    
    private JLabel etiqueta;
    private JPasswordField campoTexto;
    private JButton boton;
    private Cajero cajero;
    
    public LoginPin(Cajero cajero) {
        this.cajero = cajero;
        setLayout(null);
       
        etiqueta = new JLabel("PIN");
        campoTexto = new JPasswordField(200);
        boton = new JButton("Aceptar");
        
        
        
        etiqueta.setBounds(65, 30, 50, 20);
        campoTexto.setBounds(150, 30, 120, 20);
        boton.setBounds(115, 75, 100, 25);
        
        add(etiqueta);
        add(campoTexto);
        add(boton);
        setLocationRelativeTo(null);
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Introduce tu Pin");
        setResizable(false);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               char[] password = campoTexto.getPassword();
               String pinCadena="";
               for(int i=0; i<password.length; i++) {
                   pinCadena = pinCadena + password[i];
               }
                int pin = convertirANumero(pinCadena);
                if(cajero.validarPin(pin)) {
                    cajero.mostrarVistaPrincipal();
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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Principal;
    private JTextField usuariotextField1;
    private JButton accederButton;
    private JPasswordField passwordField1;
    private JButton limpiarButton;

    public Login(){
        setTitle("Iniciar sesion");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setSize(300,300);


        accederButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuariotextField1.getText();
                String contrasenia = String.valueOf(passwordField1.getPassword());

                if (usuario.isEmpty() || contrasenia.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Los campos no pueden estar vacios");
                    return;
                }

                if (usuario.equals("Ayol") && contrasenia.equals("Esfot123")){
                    JOptionPane.showMessageDialog(null, "Acceso concedido ");
                    new Menu();
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuariotextField1.setText("");
                passwordField1.setText("");
            }
        });
    }
}

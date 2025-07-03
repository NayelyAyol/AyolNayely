import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarProductos extends JFrame{
    private JPanel Principal;
    private JTextArea textArea1;
    private JButton regresarAlMenuButton;


    public MostrarProductos(String codigo, String nombre, String detalle, double precio, int restante) {
        setTitle("Menu de opciones");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setSize(500,500);

        textArea1.setText("Codigo: "+ codigo+"\nNombre: "+nombre+"\nDetalle: "+detalle+"\nStock Actuario: "+restante);

        regresarAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel Principal;
    private JButton registroButton;
    private JButton ventasButton;
    private JButton verProductosButton;

    public Menu(){
        setTitle("Menu de opciones");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setSize(300,300);

        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registro();
                dispose();
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = "";
                String nombre ="";
                String detalle = "";
                String precioU = "";
                String stock = "";
                new Ventas(codigo,nombre,detalle,precioU,stock);
                dispose();
            }
        });
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = "";
                String nombre = "";
                String detalle = "";
                double precio = 0;
                int restante = 0;
                new MostrarProductos(codigo, nombre, detalle, precio,restante);
                dispose();
            }
        });
    }
}

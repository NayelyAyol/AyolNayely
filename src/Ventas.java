import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventas extends JFrame{
    private JPanel Principal;
    private JButton calcularButton;
    private JTextField codigotextField1;
    private JTextField cantidadtextField4;
    private JLabel productolb;
    private JLabel preciolb;
    private JLabel subtotallb;
    private JLabel totallb;
    private JLabel invalb;
    private JButton menuButton;


    public Ventas(String codigo, String nombre, String detalle, String precioU, String stock){
        setTitle("Menu de opciones");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setSize(500,500);


        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoT = codigotextField1.getText();
                String cantidad = cantidadtextField4.getText();

                if (codigoT.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                }
                if (codigoT.equals(codigo)){
                    productolb.setText(nombre);
                    preciolb.setText(precioU);
                }else {
                    JOptionPane.showMessageDialog(null, "Codigo no valido");
                }

                try {
                    int cantidadT = Integer.parseInt(cantidad);
                    double precioT = Double.parseDouble(precioU);
                    int stockT = Integer.parseInt(stock);
                    if (cantidadT>0 && cantidadT<stockT){
                        int restante = stockT-cantidadT;
                        double subtotal = cantidadT*precioT;
                        double iva = subtotal*015;
                        double total = subtotal + iva;
                        subtotallb.setText(String.format("%.2f", subtotal));
                        invalb.setText(String.format("%.2f", iva));
                        totallb.setText(String.format("%.2f", total));
                        new MostrarProductos(codigo, nombre, detalle, precioT, restante).setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero y no debe sobrepasar el stock");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cantidad no valida");
                }
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
    }
}

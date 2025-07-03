import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JPanel Principal;
    private JTextField codigotextField1;
    private JTextField nombretextField2;
    private JTextField detalletextField3;
    private JTextField punitariotextField4;
    private JTextField stocktextField5;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton regresarAlMenuButton;

    public Registro() {
        setTitle("Menu de opciones");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setSize(500,500);



        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigotextField1.getText();
                String nombre = nombretextField2.getText();
                String detalle = detalletextField3.getText();
                String precio = punitariotextField4.getText();
                String stock = stocktextField5.getText();


                if (codigo.isEmpty() || nombre.isEmpty() || detalle.isEmpty() || precio.isEmpty() || stock.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
                    return;
                }

                try {
                    double precioU = Double.parseDouble(precio);
                    int stockC = Integer.parseInt(stock);
                    if (precioU<0 && stockC<0){
                        JOptionPane.showMessageDialog(null, "El precio no puede ser negativo");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Productos guardados con exito");
                        new Ventas(codigotextField1.getText(), nombretextField2.getText(), detalletextField3.getText(), punitariotextField4.getText(), stocktextField5.getText()).setVisible(false);
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Precio no valido");
                }

            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigotextField1.setText("");
                nombretextField2.setText("");
                detalletextField3.setText("");
                punitariotextField4.setText("");
                stocktextField5.setText("");
            }
        });

        regresarAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JList lstTienda;
    private JButton btnOrdenar;
    Tienda neutron= new Tienda();

    public void llenarLista(){
        DefaultListModel dlm= new DefaultListModel();
        for(Procesador p:neutron.getTienda()){
            dlm.addElement(p);
        }
        lstTienda.setModel(dlm);
    }
    public Ventana() {
        llenarLista();
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                neutron.ordenar();
                llenarLista();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

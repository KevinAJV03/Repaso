import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JList lstTienda;
    private JButton btnOrdenId;
    private JButton btnOrdenarAnio;
    private JButton btnOrdenarPrecio;

    Tienda miTienda=new Tienda();
            public void llenarJList(){
                DefaultListModel dlm = new DefaultListModel();
                for(Moto m: miTienda.getTienda()){
                    dlm.addElement(m);
                }
                lstTienda.setModel(dlm);
            };
     public Ventana() {
         llenarJList();
        btnOrdenId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTienda.ordenarId();
                llenarJList();
            }
        });

         btnOrdenarAnio.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 miTienda.ordenarAnio();
                 llenarJList();
             }
         });

         btnOrdenarPrecio.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 miTienda.ordenarAnio();
                 llenarJList(); //ARREGLAR
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

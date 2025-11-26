import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JPanel ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cboPosicion;
    private JSpinner spiRendimiento;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JList lstJugadores;
    private JButton btnMostrar;
    Equipo equipo= new Equipo();
    int codigo=0;

    public Ventana() {
        SpinnerNumberModel snm=new SpinnerNumberModel(10,1,20,1);
        spiRendimiento.setModel(snm);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtId.getText());
                String nombre= txtNombre.getText();
                String pos=cboPosicion.getSelectedItem().toString();
                int rendi=Integer.parseInt(spiRendimiento.getValue().toString());
                if (id<=codigo){
                    JOptionPane.showMessageDialog(null, "Id invalido");
                }else{
                    Jugador jugador= new Jugador(id,nombre,pos,rendi);
                    equipo.agregar(jugador);
                    JOptionPane.showMessageDialog(null,"Jugador agregado");
                    codigo=id; //Genera id unico de cada jugador para que no se repita
                }
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtId.getText());
                String nombre= txtNombre.getText();
                String pos=cboPosicion.getSelectedItem().toString();
                int rendi=Integer.parseInt(spiRendimiento.getValue().toString());
                Jugador editar=new Jugador(id,nombre,pos,rendi);
                if(equipo.buscarEditar(id,editar)){
                    JOptionPane.showMessageDialog(null, "Se edito el jugador");
                }else{
                    JOptionPane.showMessageDialog(null,"No existe un jugador con ese ID");
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Jugador>listado=equipo.listarTodos(); //Obtener todos los jugadores
                DefaultListModel dlm=new DefaultListModel(); //Array list exclusivo para el JList  //Arreglo exlcusivo del objeto JList permite agregar, sacar elementos
                for(Jugador j:listado){ //for mejorado para listar todos los atributos de cada jugador
                    dlm.addElement(j.toString());
                }
                lstJugadores.setModel((dlm));
            }
        });
        lstJugadores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstJugadores.getSelectedIndex()!= -1){ //Seleccione algun elemento
                    int indice=lstJugadores.getSelectedIndex();
                    Jugador seleccionado=equipo.listarTodos().get(indice);
                    txtId.setText(""+seleccionado.getId());
                    txtNombre.setText(seleccionado.getNombre());
                    cboPosicion.setSelectedItem(seleccionado.getPosicion());
                    spiRendimiento.setValue((seleccionado.getRendimiento()));
                    JOptionPane.showMessageDialog(null,"Revise los campos de ingreso");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

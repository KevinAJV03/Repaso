import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class Ventana {
    private JPanel Principal;
    private JTextField txtPasajero;
    private JComboBox cboRuta;
    private JSpinner spiBoletos;
    private JButton btnComprar;
    private JButton btnLimpiar;
    private JButton btnListar;
    private JTextArea txtDetalle;
    private JLabel lblVendidosQG;
    private JLabel lblVendidosQC;
    private JLabel lblVendidosQL;
    private JLabel lblDispQG;
    private JLabel lblDispQC;
    private JLabel lblDispQL;
    private JLabel lblTotalRecaudado;

    // Estructura y contadores (idéntica a tu sintaxis)
    private ColaBoletos cola = new ColaBoletos();
    private final int CAPACIDAD = 20;
    private int vendidosQG = 0;
    private int vendidosQC = 0;
    private int vendidosQL = 0;
    private float total = 0f;

    public Ventana() {
        // Configuración inicial de controles
        spiBoletos.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        cboRuta.setModel(new DefaultComboBoxModel<>(new String[]{
                "QUITO - GUAYAQUIL",
                "QUITO - CUENCA",
                "QUITO - LOJA"
        }));
        txtDetalle.setEditable(false);
        txtDetalle.setLineWrap(true);
        txtDetalle.setWrapStyleWord(true);
        actualizarLabels();

        // Botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPasajero.setText("");
                txtDetalle.setText("");
                cboRuta.setSelectedIndex(0);
                spiBoletos.setValue(1);
                txtPasajero.requestFocus();
            }
        });

        // Botón Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDetalle.setText(cola.toString());
            }
        });

        // Botón Comprar
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pasajero = txtPasajero.getText().trim();
                String ruta = cboRuta.getSelectedItem().toString();
                int boletos = Integer.parseInt(spiBoletos.getValue().toString());

                // Validaciones
                if (pasajero.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre o cédula del pasajero.");
                    return;
                }
                if (boletos < 1 || boletos > 5) {
                    JOptionPane.showMessageDialog(null, "Solo se permiten entre 1 y 5 boletos por compra.");
                    return;
                }

                int vendidosActuales = getVendidos(ruta);
                int disponibles = CAPACIDAD - vendidosActuales;
                if (boletos > disponibles) {
                    JOptionPane.showMessageDialog(null,
                            "No hay suficientes asientos para la ruta seleccionada.\nDisponibles: " + disponibles);
                    return;
                }

                // Registrar la compra
                Boleto compra = new Boleto(pasajero, ruta, boletos, CAPACIDAD);
                cola.encolar(compra);
                sumarVendidos(ruta, boletos);
                total += precioRuta(ruta) * boletos;

                // Refrescar interfaz
                actualizarLabels();
                txtDetalle.setText(cola.toString());
                JOptionPane.showMessageDialog(null, "Compra registrada correctamente.");
            }
        });
        lblTotalRecaudado.addComponentListener(new ComponentAdapter() {});
        lblTotalRecaudado.addComponentListener(new ComponentAdapter() {});
    }

    // ==== Helpers (idéntica estructura, adaptado a rutas) ====
    private void actualizarLabels() {
        lblVendidosQG.setText("Q-G $10.50     -     Vendidos: " + vendidosQG);
        lblDispQG.setText("Disponibles: " + (CAPACIDAD - vendidosQG));

        lblVendidosQC.setText("Q-C $12.75     -     Vendidos: " + vendidosQC);
        lblDispQC.setText("Disponibles: " + (CAPACIDAD - vendidosQC));

        lblVendidosQL.setText("Q-L $15.00     -     Vendidos: " + vendidosQL);
        lblDispQL.setText("Disponibles: " + (CAPACIDAD - vendidosQL));

        lblTotalRecaudado.setText("Total Recaudado: " + String.format("$ %.2f", total));
    }

    private void sumarVendidos(String ruta, int cantidad) {
        if (ruta.equals("QUITO - GUAYAQUIL")) vendidosQG += cantidad;
        else if (ruta.equals("QUITO - CUENCA")) vendidosQC += cantidad;
        else vendidosQL += cantidad;
    }

    private int getVendidos(String ruta) {
        if (ruta.equals("QUITO - GUAYAQUIL")) return vendidosQG;
        if (ruta.equals("QUITO - CUENCA")) return vendidosQC;
        return vendidosQL;
    }

    private float precioRuta(String ruta) {
        if (ruta.equals("QUITO - GUAYAQUIL")) return 10.50f;
        if (ruta.equals("QUITO - CUENCA")) return 12.75f;
        return 15.00f;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ventana = new JFrame("Venta de Boletos - Rutas de Transporte");
                ventana.setContentPane(new Ventana().Principal);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.pack();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });
    }
}

public class Boleto {
    private String cliente;   // cédula o nombre del pasajero (según tu formulario original)
    private String pelicula;  // aquí usaremos la 'ruta' pero conservamos el nombre del atributo para no romper interfaz
    private int entradas;     // cantidad de boletos
    private int capacidad;    // capacidad total de la ruta

    public Boleto(String cliente, String pelicula, int entradas, int capacidad) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.entradas = entradas;
        this.capacidad = capacidad;
    }

    public String getCliente() {

        return cliente;
    }

    public String getPelicula() {
        return pelicula;
    }

    public int getEntradas() {
        return entradas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente +
                ", Ruta: " + pelicula +
                ", Boletos: " + entradas +
                ", Capacidad: " + capacidad + "\n";
    }
}

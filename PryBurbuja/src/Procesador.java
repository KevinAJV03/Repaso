public class Procesador {
    private int id;
    private String nombre;
    private float precio;
    private int generacion;

    public Procesador(int id, String nombre, float precio,int generacion ) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.generacion = generacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }


    @Override
    public String toString() {
        return "Procesador " +
                "generacion: " + id +
                ", id: " + generacion +
                ", nombre: " + nombre +
                ", precio: " + precio
                ;
    }
}

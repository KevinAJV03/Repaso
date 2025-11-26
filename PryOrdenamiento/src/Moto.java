public class Moto {
    private int codigo;
    private String modelo;
    private int cilindraje;
    private int anio;
    private float precio;

    public Moto(int codigo, String modelo, int cilindraje, int anio, float precio) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.anio = anio;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Moto" +
                "anio: " + anio +
                ", codigo: " + codigo +
                ", modelo: " + modelo +
                ", cilindraje: " + cilindraje +
                ", precio: " + precio
                ;
    }
}

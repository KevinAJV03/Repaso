import java.util.LinkedList;
import java.util.Queue;

public class ColaBoletos {
    private Queue<Boleto> cola;
    public ColaBoletos(){
        cola = new LinkedList<Boleto>();
    }
    public void encolar(Boleto compra){
        cola.add(compra);
    }
    public Boleto desencolar() throws Exception {
        if(cola.isEmpty())
            throw new Exception("No hay mas clientes en la cola: ");
        return cola.poll();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boleto c : cola ){
            sb.append(c.toString());
        }
        return sb.toString();
    }
}

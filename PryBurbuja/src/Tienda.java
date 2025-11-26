import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Procesador> tienda;

    public Tienda(){
        tienda = new ArrayList<Procesador>();
        predefinir();
    }

    public void predefinir(){
        Procesador pr1= new Procesador(1,"Intel i9 14900k",564.14f,14);
        Procesador pr2= new Procesador(2,"AMD 5600g",150.42f,15);
        Procesador pr3= new Procesador(3,"Intel i7 13900k",264.20f,13);
        Procesador pr4= new Procesador(4,"AMD 9950x",700.42f,9);
        Procesador pr5= new Procesador(5,"Intel i7 8900k",64.2f,8);
        tienda.add(pr1);
        tienda.add(pr2);
        tienda.add(pr3);
        tienda.add(pr4);
        tienda.add(pr5);
    }

    public void ordenar(){
        Procesador aux;

        for(int i=0 ; i<tienda.size()-1; i++){
            for(int j=i+1; j<tienda.size(); j++){
                if(tienda.get(i).getPrecio()>tienda.get(j).getPrecio()){
                    aux= tienda.get(i);
                    tienda.set(i,tienda.get(j));
                    tienda.set(j,aux);
                }
            }
        }
    }

    public List<Procesador> getTienda() {
        return tienda;
    }
}

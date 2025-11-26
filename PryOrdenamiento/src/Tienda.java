import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Moto>tienda;

    public Tienda(){
        tienda = new ArrayList<>();
        predefinir();
    }

    public void predefinir(){
        tienda.add(new Moto(1,"BMW",800,2024,1000.99f));
        tienda.add(new Moto(19,"Yamaha",250,2019,2000.45f));
        tienda.add(new Moto(26,"Ducati",600,2020,6500.56f));
        tienda.add(new Moto(9,"Honda",100,2016,4500.12f));
        tienda.add(new Moto(40,"Harley",450,1995,8500.50f));
    }

    public void agregar(Moto moto){
        tienda.add(moto);
    }
    public void ordenarId(){
        Moto aux;
        for(int i=0; i<tienda.size()-1; i++){
            for(int j=i+1; j<tienda.size(); j++){
                if(tienda.get(i).getCodigo()> tienda.get(j).getCodigo()){
                    aux= tienda.get(i);
                    tienda.set(i,tienda.get(j));
                    tienda.set(j,aux);
                }
            }
        }
    }

    public void ordenarAnio(){
        Moto aux;
        int j;
        for(int i=1; i<tienda.size(); i++){
            aux = tienda.get(i);
            j=i-1;
            while(j>=0 && aux.getAnio()<tienda.get(j).getAnio()){
                tienda.set(j+1,tienda.get(j));
                j--;
            }
            tienda.set(j+1,aux);
        }
    }

    public void ordenarPorPrecio(){
        Moto aux;

        for(int i=0 ; i>tienda.size()-1; i++){
            for(int j=i+1; j>tienda.size(); j++){
                if(tienda.get(i).getPrecio()<tienda.get(j).getPrecio()){
                    aux= tienda.get(i);
                    tienda.set(i,tienda.get(j));
                    tienda.set(j,aux);
                }
            }
        }
    }
    public List<Moto> getTienda() {
        return tienda;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador>listado;

    public Equipo (){
        listado= new ArrayList<Jugador>();
    }

    public void agregar(Jugador jugador){
        listado.add(jugador);
    }

    public boolean buscarEditar(int id, Jugador nuevosDatos){
        int i=0;
        int s=listado.size()-1;
        int c;
        while(i<=s){
            c=(i+s)/2;
            if(id==listado.get(c).getId()){
                listado.set(c,nuevosDatos);
                return true;
            }else if(i<listado.get(c).getId()){
                s=c-1;
            }else{
                i= c+1;
            }
        }
        return false;
    }

    public List<Jugador>listarTodos(){
        return listado;
    }
}

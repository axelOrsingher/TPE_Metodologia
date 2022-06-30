import java.util.ArrayList;

public class Secretaria {
    private String nombre;
    private ArrayList<Medico> medicosAsignados;

    
    public Secretaria(String nombre){
        this.nombre = nombre;
        medicosAsignados = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    
    public void addMedico(Medico m){
        medicosAsignados.add(m);
    }
}

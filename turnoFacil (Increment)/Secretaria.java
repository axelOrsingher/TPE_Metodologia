import java.util.ArrayList;

public class Secretaria {
    ArrayList<Medico> medicosAsignados;

    
    public Secretaria(){
        medicosAsignados = new ArrayList<>();
    }

    public void addMedico(Medico m){
        medicosAsignados.add(m);
    }
}

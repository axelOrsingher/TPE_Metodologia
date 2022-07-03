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

    public void agendarTurno(Medico m,Turno t){
        m.addTurno(t);
    }

    public void cancelarTurno(Medico m,Turno t){
        m.eliminarTurno(t);
    }

    public ArrayList<Medico> getMedicos(){
        return medicosAsignados;
    }

    public ArrayList<Turno> listarTurnos(FiltroTurno f){
        ArrayList<Turno> salida = new ArrayList<>();
        for(Medico m: medicosAsignados){
            ArrayList<Turno> aux = m.getTurnosOcupados();
            for (Turno t: aux){
                if (f == null)
                    salida.add(t);
                else {
                    if (f.cumple(t))
                        salida.add(t);
                }
            }
        }
        return salida;
    }

}

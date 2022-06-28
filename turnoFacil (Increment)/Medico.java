import java.time.LocalTime;
import java.util.ArrayList;

public class Medico {
    private String nombre;
    private String apellido;
    private String especialidad;
    private ArrayList<String> obrasSociales;
    private ArrayList<String> dias;
    private LocalTime inicio; //suponemos que trabajan todos los dias con los mismos horarios
    private LocalTime fin;
    private ArrayList<Turno> turnosOcupados;


    public Medico(String nombre, String apellido, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        dias = new ArrayList<>();
        turnosOcupados = new ArrayList<>();
    }

    public void setObrasSociales(ArrayList<String> obrasSociales){
        this.obrasSociales = new ArrayList<>(obrasSociales);
    }

    public void setDiasYHorarios(ArrayList<String> dias,LocalTime horarioInic,LocalTime horarioFin){
        this.dias = new ArrayList<String>(dias);
        inicio = horarioInic;
        fin = horarioFin;
    }

    public ArrayList<String> getObrasSociales(){
        return new ArrayList<>(obrasSociales);
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public LocalTime getHorarioInicio() {
        return inicio;
    }

    public LocalTime getHorarioFin() {
        return fin;
    }

    public ArrayList<Turno> getTurnosOcupados() {
        return new ArrayList<>(turnosOcupados);
    }

    public ArrayList<String> getDiasLaborales() {
        return new ArrayList<>(dias);
    }

    public boolean equals(Medico m){
        return (this.nombre.equals(m.getNombre()) && this.apellido.equals(m.getApellido()));
    }

    public String toString(){
        String salida = "Nombre: ";
        salida += nombre + " " + apellido + "| Obras Sociales: ";
        for (String os: obrasSociales)
            salida += os + ",";
        salida += "| Especialidad: " + especialidad;
        salida += "\n" + "| Días laborales: ";
        for (String s:dias)
            salida += s + ",";
        salida += "| Horario: " + inicio.toString() + "-" + fin.toString() + "\n";
        return salida;
    }


    public ArrayList<Turno> getTurnosDisp(FiltroTurno filtro){
        ArrayList<Turno> salida = new ArrayList<>();
        



        return salida;
    }

}

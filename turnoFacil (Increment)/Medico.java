import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medico {
    private String nombre;
    private String apellido;
    private String especialidad;
    private ArrayList<String> obrasSociales;
    private ArrayList<DayOfWeek> dias;
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

    public void setDiasYHorarios(ArrayList<DayOfWeek> dias,LocalTime horarioInic,LocalTime horarioFin){
        this.dias = new ArrayList<DayOfWeek>(dias);
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

    public ArrayList<DayOfWeek> getDiasLaborales() {
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
        for (DayOfWeek s:dias)
            salida += s + ",";
        salida += "| Horario: " + inicio.toString() + "-" + fin.toString() + "\n";
        return salida;
    }



    private boolean trabaja(LocalDate f){
        if (dias.contains(f.getDayOfWeek()))
            return true;
        return false;
    }

    public ArrayList<Turno> getTurnosDisp(LocalDate fechaInicio, LocalDate fechaFin,FiltroTurno filtro){
        ArrayList<Turno> salida = new ArrayList<>();
        LocalDate fecha = fechaInicio;
        if (fechaInicio.isAfter(LocalDate.now()) && fechaFin.isAfter(fechaInicio)){
            while (fecha.isBefore(fechaFin.plusDays(1))){
                if (trabaja(fecha) && fecha.isBefore(fechaFin.plusDays(1))){
                    for (int i = inicio.getHour();i<=fin.getHour();i++){
                        LocalTime horario = LocalTime.of(i,0);
                        LocalDateTime turno = LocalDateTime.of(fecha,horario);
                        Turno t = new Turno(turno, null, this);
                        if (filtro!=null){
                            if(filtro.cumple(t)){
                                salida.add(t);
                            }
                        }
                        else{salida.add(t);}  
                    }
                }
                fecha = fecha.plusDays(1);
            }
        }

        for (Turno t : turnosOcupados){
            if (salida.contains(t)){
                salida.remove(t);
            }
        }

        return salida;
    }

}

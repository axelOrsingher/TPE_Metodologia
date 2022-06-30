import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Turno implements Comparable<Turno>{
    private LocalDateTime fechaTurno;
    private Paciente paciente;
    private Medico medico;


    public Turno(LocalDateTime fechaTurno, Paciente paciente, Medico medico) {
        this.fechaTurno = fechaTurno;
        this.paciente = paciente;
        this.medico = medico;
    }
    
    public void setPaciente(Paciente p){
        paciente = p;
    }

    public LocalDate getFecha(){
        int anio = fechaTurno.getYear();
        int mes = fechaTurno.getMonthValue();
        int dia = fechaTurno.getDayOfMonth();
        return LocalDate.of(anio,mes,dia);
    }

    public LocalTime getHorario(){
        int hora = fechaTurno.getHour();
        int minutos = fechaTurno.getMinute();

        return LocalTime.of(hora, minutos);
    }

    public String getTurno(){
        if (fechaTurno.getHour() < 12)
            return "M";
        else 
            return "T";
    }


    public boolean equals(Turno t){
        return this.getFecha().equals(t.getFecha())&& (this.getHorario().equals(t.getHorario())); //&& (this.medico.equals(t.getMedico()));
    }

    public Medico getMedico(){
        return medico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public String toString(){
        return "Fecha: " + fechaTurno.getDayOfMonth() + "/" + fechaTurno.getMonthValue() + "/" + fechaTurno.getYear() 
            + "| Horario: " + fechaTurno.getHour() + ":" + fechaTurno.getMinute() + "0";

    }

    @Override
    public int compareTo(Turno o) {
        return this.getFecha().compareTo(o.getFecha());
    }

}

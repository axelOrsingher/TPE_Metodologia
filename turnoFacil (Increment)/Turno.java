import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Turno {
    private LocalDateTime fechaTurno;
    private Paciente paciente;
    private Medico medico;


    public Turno(LocalDateTime fechaTurno, Paciente paciente, Medico medico) {
        this.fechaTurno = fechaTurno;
        this.paciente = paciente;
        this.medico = medico;
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
        return this.getFecha().equals(t.getFecha())&& (this.getHorario().equals(t.getHorario())) && (this.getMedico().equals(t.getMedico()));
    }

    public Medico getMedico(){
        return medico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public String toString(){
        return "Fecha: " + fechaTurno.toString();

    }

}

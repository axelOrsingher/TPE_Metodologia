import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public String getTurno(){
        if (fechaTurno.getHour() > 12)
            return "mañana";
        else 
            return "tarde";
    }

    public Medico getMedico(){
        return medico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

}

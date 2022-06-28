import java.time.LocalDate;

public class FiltroRangoDias extends FiltroTurno{
    private LocalDate inicio;
    private LocalDate fin;

    public FiltroRangoDias(LocalDate f1,LocalDate f2){
        inicio = f1;
        fin = f2;
    }

    public boolean cumple(Turno t){
        return (t.getFecha().isBefore(fin) && t.getFecha().isAfter(inicio));
    }
}



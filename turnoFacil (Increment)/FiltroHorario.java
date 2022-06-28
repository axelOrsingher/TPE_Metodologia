public class FiltroHorario extends FiltroTurno {
    String turno;
    
    public boolean cumple(Turno t) {
        return t.getTurno().equalsIgnoreCase(turno);
    }
    
}

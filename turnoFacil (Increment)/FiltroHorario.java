public class FiltroHorario extends FiltroTurno {
    String turno;
    

    public FiltroHorario(String s){
        turno = s;
    }
    public boolean cumple(Turno t) {
        return t.getTurno().equalsIgnoreCase(turno);
    }
    
}

public class FiltroMedicoTurno extends FiltroTurno{
    Medico m;

    public FiltroMedicoTurno(Medico m){
        this.m = m;
    }

    public boolean cumple(Turno t){
        return t.getMedico().equals(m);
    }
}

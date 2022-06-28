public class FiltroMedicoTurno extends FiltroTurno{
    Medico m;

    public boolean cumple(Turno t){
        return t.getMedico().equals(m);
    }
}

public class FiltroANDTurno extends FiltroTurno {
    FiltroTurno f1;
    FiltroTurno f2;

    public FiltroANDTurno(FiltroTurno f1,FiltroTurno f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public boolean cumple(Turno t){
        return (f1.cumple(t) && f2.cumple(t));
    }
}

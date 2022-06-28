public class FiltroAND extends FiltroMedico {
    FiltroMedico f1;
    FiltroMedico f2;

    public FiltroAND(FiltroMedico f1,FiltroMedico f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public boolean cumple(Medico m){
        return (f1.cumple(m) && f2.cumple(m));
    }
}

public class FiltroObraSocial extends FiltroMedico{
    private String OS;


    public FiltroObraSocial(String OS){
        this.OS = OS;
    }

    public boolean cumple(Medico m){
        return m.getObrasSociales().contains(OS);
    }
}

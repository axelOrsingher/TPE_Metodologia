public class FiltroEspecialidad extends FiltroMedico {
    private String especialidad;

    public FiltroEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public boolean cumple(Medico m){
        return m.getEspecialidad().equalsIgnoreCase(especialidad);
    }
}

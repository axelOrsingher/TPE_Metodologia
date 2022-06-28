public class Inicializador {//se utiliza para que el usuario no vea las funcionalidades del centro medico
    private CentroMedico centroMedico;


    public Inicializador(CentroMedico cm){
        centroMedico = cm;
    }

    public void cargarNuevoPaciente(Paciente p){
        centroMedico.addPaciente(p);
    }

    public void cargarNuevoMedico(Medico m){
        centroMedico.addMedico(m);
    }

    public void cargarNuevaSecretaria(Secretaria s){
        centroMedico.addSecretaria(s);
    }

    
}

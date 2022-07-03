import java.util.ArrayList;

public class CentroMedico { //representa la carga de datos de los usuarios, medicos y secretarias
    private String nombre;
    private ArrayList<Medico> medicos;
    private ArrayList<Secretaria> secretarias;
    private ArrayList<Paciente> pacientes;


    public CentroMedico(String nombre){
        this.nombre = nombre;
        medicos = new ArrayList<>();
        secretarias = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void addMedico(Medico m){
        medicos.add(m);
    }

    public void addSecretaria(Secretaria s){
        secretarias.add(s);
    }

    public void addPaciente(Paciente p){
        pacientes.add(p);
    }

    public ArrayList<Medico> getMedicos(){
        return new ArrayList<>(medicos);
    }

    public Medico getMedico(String nombre, String apellido){
        for (Medico m: medicos)
            if (m.getNombre().equals(nombre) && m.getApellido().equals(apellido))
                return m;
        return null;    
    }
    
    public Medico getMedico(String apellido){
        for (Medico m: medicos)
            if (m.getApellido().equals(apellido))
                return m;
        return null;    
    }

    public ArrayList<Medico> getMedicos(FiltroMedico f){
        ArrayList<Medico> salida = new ArrayList<>();
        for(Medico m:medicos)
            if (f.cumple(m))
                salida.add(m);
        return salida;
    }

    public boolean existePaciente(long dni){
        for (Paciente p:pacientes)
            if (p.getDni() == dni)
                return true;
        return false;
    }

    public Paciente getPaciente(long dni){//siempre va a devolver un paciente ya que se hace una vez la cuenta fue creada
        for (Paciente p:pacientes)
            if (p.getDni() == dni)
                return p; 
        return null;
    }

    public Secretaria getSecretaria(String nombre){
        for (Secretaria s: secretarias)
            if (s.getNombre().equals(nombre))
                return s;
        return null;
    }

}
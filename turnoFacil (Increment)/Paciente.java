import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {
    private long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;
    private String email;
    private String obraSocial;
    private long nroAfiliado;
    private ArrayList<Turno> turnos;


    public Paciente(long dni, String nombre, String apellido, String direccion, long telefono, String email,
            String obraSocial, long nroAfiliado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.obraSocial = obraSocial;
        this.nroAfiliado = nroAfiliado;
        turnos = new ArrayList<>();
    }

    public long getDni(){
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getNroAfiliado() {
        return nroAfiliado;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public ArrayList<Turno> getTurnos() {
        return new ArrayList<>(turnos);
    }

    public boolean equals(Paciente p){
        return this.dni == p.getDni();
    }

    public Medico seleccionarMedico(ArrayList<Medico> opciones){
        Scanner medico = new Scanner(System.in);
        int opcionElegida = Integer.parseInt(medico.nextLine());
        if ((opcionElegida > opciones.size()) || (opciones.size() == 0)){
            System.out.println("Opción incorrecta.");
            //medico.close();
            return null;
        }
        //medico.close();
        return opciones.get(opcionElegida);

    }

    
}

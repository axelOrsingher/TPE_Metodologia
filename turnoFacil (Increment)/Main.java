
public class Main {
    public static void main(String[] args) {
        CentroMedico cm = new CentroMedico("Clinica");
        Inicializador i = new Inicializador(cm);
        Menu menu = new Menu(cm);


        i.crearCuentasEjemplo();
        //Paciente pacienteActual = menu.iniciarSesionPaciente();
        menu.mostrarOpciones();



    }

}





import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Inicializador {//se utiliza para que el usuario no vea las funcionalidades del centro medico
    private CentroMedico cm;


    public Inicializador(CentroMedico cm){
        this.cm = cm;
    }

    public void cargarNuevoPaciente(Paciente p){
        cm.addPaciente(p);
    }

    public void cargarNuevoMedico(Medico m){
        cm.addMedico(m);
    }

    public void cargarNuevaSecretaria(Secretaria s){
        cm.addSecretaria(s);
    }


    public void crearCuentasEjemplo(){
        //MEDICOS DE PRUEBA
        Medico m1 = new Medico("Santino", "Lucarini","Oftalmologo");
        cm.addMedico(m1);
        Medico m2 = new Medico("Lara","Venere","Pediatra");
        cm.addMedico(m2);
        Medico m3 = new Medico("Axel","Orsingher","Traumatologo");
        cm.addMedico(m3);

        //DIAS DE TRABAJO,HORARIOS y OBRAS SOCIALES DE CADA MEDICO
        ArrayList<DayOfWeek> diasDeTrabajo= new ArrayList<>();
        diasDeTrabajo.add(DayOfWeek.of(1));
        diasDeTrabajo.add(DayOfWeek.of(3));
        diasDeTrabajo.add(DayOfWeek.of(5));
        LocalTime inicio = LocalTime.of(8,0);
        LocalTime fin = LocalTime.of(16,0);
        ArrayList<String> obrasSociales = new ArrayList<>();
        obrasSociales.add("OS1");

        //Medico 1
        m1.setDiasYHorarios(diasDeTrabajo, inicio, fin);
        m1.setObrasSociales(obrasSociales);
        //Medico 2
        diasDeTrabajo.add(DayOfWeek.of(2));
        obrasSociales.add("OS2");
        inicio = LocalTime.of(10,0);
        fin = LocalTime.of(18,0);
        m2.setDiasYHorarios(diasDeTrabajo, inicio,fin);
        m2.setObrasSociales(obrasSociales);
        //Medico 3
        diasDeTrabajo.add(DayOfWeek.of(4));
        obrasSociales.add("OS3");
        inicio = LocalTime.of(8,0);
        fin = LocalTime.of(18,0);
        m3.setDiasYHorarios(diasDeTrabajo, inicio,fin);
        m3.setObrasSociales(obrasSociales);
        //PACIENTES DE PRUEBA
        Paciente p1 = new Paciente(12344,"Mateo","Rodon","Calle 123",56789,"mateorodon@gmail.com","OS1",01234);
        Paciente p2 = new Paciente(56789,"Agustina","Alabart","Calle 456",01234,"agusalabart@gmail.com","OS2",56789);
        cm.addPaciente(p1);
        cm.addPaciente(p2);
        //SECRETARIA DE LOS 3 MEDICOS CREADOS
        Secretaria s = new Secretaria("Josefa");
        m1.setSecretaria(s);
        m2.setSecretaria(s);
        m3.setSecretaria(s);
        cm.addSecretaria(s);

        Turno t1 = new Turno(LocalDateTime.of(LocalDate.of(2022,7,5),LocalTime.of(12,00)),p1,m1);
        Turno t2 = new Turno(LocalDateTime.of(LocalDate.of(2022,7,6),LocalTime.of(11,00)),p1,m2);
        Turno t3 = new Turno(LocalDateTime.of(LocalDate.of(2022,7,5),LocalTime.of(11,00)),p2,m1);

        p1.addTurno(t1);
        p1.addTurno(t2);
        p2.addTurno(t3);
        m1.addTurno(t1);
        m1.addTurno(t3);
        m2.addTurno(t2);
    }
    
}

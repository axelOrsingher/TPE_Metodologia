import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CentroMedico cm = new CentroMedico("Clinica");
        Menu menu = new Menu(cm);

        //MEDICOS DE PRUEBA
        Medico m1 = new Medico("Santino", "Lucarini","Oftalmologo");
        cm.addMedico(m1);
        Medico m2 = new Medico("Lara","Venere","Pediatra");
        cm.addMedico(m2);
        Medico m3 = new Medico("Axel","Orsingher","Traumatologo");
        cm.addMedico(m3);

        //DIAS DE TRABAJO,HORARIOS y OBRAS SOCIALES DE CADA MEDICO
        ArrayList<String> diasDeTrabajo= new ArrayList<>();
        diasDeTrabajo.add("Lunes");
        diasDeTrabajo.add("Miercoles");
        diasDeTrabajo.add("Viernes");
        LocalTime inicio = LocalTime.of(8,0);
        LocalTime fin = LocalTime.of(16,0);
        ArrayList<String> obrasSociales = new ArrayList<>();
        obrasSociales.add("OS1");



        //Medico 1
        m1.setDiasYHorarios(diasDeTrabajo, inicio, fin);
        m1.setObrasSociales(obrasSociales);
        //Medico 2
        diasDeTrabajo.add("Martes");
        obrasSociales.add("OS2");
        inicio = LocalTime.of(10,0);
        fin = LocalTime.of(18,0);
        m2.setDiasYHorarios(diasDeTrabajo, inicio,fin);
        m2.setObrasSociales(obrasSociales);
        //Medico 3
        diasDeTrabajo.add("Jueves");
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
        Secretaria s = new Secretaria();
        s.addMedico(m1);
        s.addMedico(m2);
        s.addMedico(m3);
        cm.addSecretaria(s);


        Scanner entrada = new Scanner (System.in);
		int opcion = 0;

        //INICIO DE SESION, EN CASO DE NO ESTAR REGISTRADO SE CREA UNA CUENTA
		System.out.println("Bienvenido a TurnoFacil");
        System.out.println("Ingrese su DNI: ");
        long dni = Long.parseLong(entrada.nextLine());
        menu.iniciarSesion(dni);
        Paciente pacienteActual = cm.getPaciente(dni);

        while (opcion!=4){
            System.out.println("1. Sacar turno");
            System.out.println("2. Ver próximos turnos");
            System.out.println("3. Cancelar turno");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(entrada.nextLine());

            if (opcion == 1){
                
                menu.sacarTurno(pacienteActual);
                //menu.sacarTurno(actual,entrada); PASAR EL SCANNER POR PARAMETRO ESTA BIEN?



                /*System.out.println("¿Desea filtrar por Obra Social?");
                System.out.println("1.Si");
                System.out.println("2.No");
                int respuesta1 = Integer.parseInt(entrada.nextLine());
                System.out.println("¿Desea filtrar por Especialidad?");
                System.out.println("1.Si");
                System.out.println("2.No");
                int respuesta2 = Integer.parseInt(entrada.nextLine());
                ArrayList<Medico> opciones;
                if (respuesta1 == 1 && respuesta2==1){
                    System.out.println("Ingrese la obra social:");
				    String obraSocial = entrada.nextLine();
                    System.out.println("Ingrese la especialidad:");
				    String esp = entrada.nextLine();
                    FiltroObraSocial f1 = new FiltroObraSocial(obraSocial);
                    FiltroEspecialidad f2 = new FiltroEspecialidad(esp);
                    FiltroAND f = new FiltroAND(f1, f2);
                    opciones = cm.getMedicos(f);
                    for(Medico m:opciones)
                        System.out.println(m.toString());

                }
                if (respuesta1 == 2 && respuesta2 == 1){
                    System.out.println("Ingrese la especialidad:");
				    String esp = entrada.nextLine();
                    FiltroEspecialidad f = new FiltroEspecialidad(esp);
                    opciones = cm.getMedicos(f);
                    for(Medico m:opciones)
                        System.out.println(m.toString());
                }
                if (respuesta1 == 1 && respuesta2 == 2){
                    System.out.println("Ingrese la Obra Social:");
				    String obraSocial = entrada.nextLine();
                    FiltroObraSocial f = new FiltroObraSocial(obraSocial);
                    opciones = cm.getMedicos(f);
                    for(Medico m:opciones)
                        System.out.println(m.toString());
                }
                if (respuesta1 == 2 && respuesta2 == 2){
                    opciones = cm.getMedicos();
                    for(Medico m:opciones)
                        System.out.println(m.toString());
                }*/
            }

        }
















    }
}

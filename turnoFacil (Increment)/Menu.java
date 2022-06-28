import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    CentroMedico cm;

    public Menu(CentroMedico cm){
        this.cm = cm;
    }

    public void iniciarSesion(long dni){
        Scanner inic = new Scanner(System.in);
        if (!cm.existePaciente(dni)){
            System.out.println("No se encuentra registrado, por favor complete sus datos:");
            System.out.println("Nombre:");
            String nombre = inic.nextLine();
            System.out.println("Apellido:");
            String apellido = inic.nextLine();
            System.out.println("Direccion:");
            String direccion = inic.nextLine();
            System.out.println("Telefono:");
            long tel = Long.parseLong(inic.nextLine());
            System.out.println("email:");
            String email = inic.nextLine();
            System.out.println("Obra Social:");
            String os = inic.nextLine();
            Paciente nuevo = new Paciente(dni, nombre, apellido, direccion, tel, email, os, dni);
            cm.addPaciente(nuevo);
        }
        //inic.close();
    }

    public void sacarTurno(Paciente actual){
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Desea filtrar por Obra Social?");
        System.out.println("1.Si");
        System.out.println("2.No");
        int respuesta1 = Integer.parseInt(entrada.nextLine());
        System.out.println("¿Desea filtrar por Especialidad?");
        System.out.println("1.Si");
        System.out.println("2.No");
        int respuesta2 = Integer.parseInt(entrada.nextLine());
        ArrayList<Medico> opciones = new ArrayList<>();
        if (respuesta1 == 1 && respuesta2==1){
            System.out.println("Ingrese la obra social:");
			String obraSocial = entrada.nextLine();
            System.out.println("Ingrese la especialidad:");
			String esp = entrada.nextLine();
            FiltroObraSocial f1 = new FiltroObraSocial(obraSocial);
            FiltroEspecialidad f2 = new FiltroEspecialidad(esp);
            FiltroANDMedico f = new FiltroANDMedico(f1, f2);
            opciones = cm.getMedicos(f);
        }
        if (respuesta1 == 2 && respuesta2 == 1){
            System.out.println("Ingrese la especialidad:");
			String esp = entrada.nextLine();
            FiltroEspecialidad f = new FiltroEspecialidad(esp);
            opciones = cm.getMedicos(f);
        }
        if (respuesta1 == 1 && respuesta2 == 2){
            System.out.println("Ingrese la Obra Social:");
			String obraSocial = entrada.nextLine();
            FiltroObraSocial f = new FiltroObraSocial(obraSocial);
            opciones = cm.getMedicos(f);
        }
        if (respuesta1 == 2 && respuesta2 == 2){
            opciones = cm.getMedicos();
        }
        for(int i =0;i<opciones.size();i++){
            System.out.println(i + ". " + opciones.get(i).toString());
        }
        System.out.println("Seleccione un médico: ");
        Medico medicoElegido = actual.seleccionarMedico(opciones);
        System.out.println("Ingrese el rango de fechas deseado(d/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.println("Primer fecha:");
        String date1 = entrada.nextLine();
        System.out.println("Segunda fecha:");
        String date2 = entrada.nextLine();
        //convertimos los string en fechas
        LocalDate inicio = LocalDate.parse(date1, formatter);
        LocalDate fin = LocalDate.parse(date2, formatter);
        System.out.println("¿Busca turno por la mañana o por la tarde?: ");
        System.out.println("1.Mañana");
        System.out.println("2.Tarde");
        System.out.println("3.Ver todas las opciones");
        int respuesta3 = Integer.parseInt(entrada.nextLine());
        ArrayList<Turno> opciones2 = new ArrayList<>();
        FiltroRangoDias fDias = new FiltroRangoDias(inicio, fin);
        if (respuesta3 == 1){
            FiltroHorario fHorario = new FiltroHorario("M");
            FiltroANDTurno f = new FiltroANDTurno(fDias,fHorario);
            opciones2 = medicoElegido.getTurnosDisp(f);
        }
        if (respuesta3 == 2){
            FiltroHorario fHorario = new FiltroHorario("T");
            FiltroANDTurno f = new FiltroANDTurno(fDias,fHorario);
            opciones2 = medicoElegido.getTurnosDisp(f);
        }
        if (respuesta3 == 3){
            opciones2 = medicoElegido.getTurnosDisp(fDias);
        }

    }


    public Paciente iniciarSesionPaciente(){
        Scanner entrada = new Scanner (System.in);
        //INICIO DE SESION, EN CASO DE NO ESTAR REGISTRADO SE CREA UNA CUENTA
		System.out.println("Bienvenido a TurnoFacil");
        System.out.println("Ingrese su DNI: ");
        long dni = Long.parseLong(entrada.nextLine());
        iniciarSesion(dni);
        Paciente pacienteActual = cm.getPaciente(dni);
        return pacienteActual;
    }

    public void mostrarOpciones(Paciente actual){
        int opcion = 0;
        Scanner entrada = new Scanner (System.in);
        while (opcion!=4){
            System.out.println("1. Sacar turno");
            System.out.println("2. Ver próximos turnos");
            System.out.println("3. Cancelar turno");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(entrada.nextLine());

            if (opcion == 1){
                sacarTurno(actual);

            }
            if (opcion == 2){
                //verTurnos(actual); //IMPLEMENTAR
            }
            if (opcion == 3){
                //cancelarTurno(actual); //IMPLEMENTAR
            }

        }
    }




}

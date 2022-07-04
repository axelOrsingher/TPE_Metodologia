import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private CentroMedico cm;

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
        ArrayList<Medico> opcionesMedicos = new ArrayList<>();
        if (respuesta1 == 1 && respuesta2==1){
            System.out.println("Ingrese la obra social:");
			String obraSocial = entrada.nextLine();
            System.out.println("Ingrese la especialidad:");
			String esp = entrada.nextLine();
            FiltroObraSocial f1 = new FiltroObraSocial(obraSocial);
            FiltroEspecialidad f2 = new FiltroEspecialidad(esp);
            FiltroANDMedico f = new FiltroANDMedico(f1, f2);
            opcionesMedicos = cm.getMedicos(f);
        }
        if (respuesta1 == 2 && respuesta2 == 1){
            System.out.println("Ingrese la especialidad:");
			String esp = entrada.nextLine();
            FiltroEspecialidad f = new FiltroEspecialidad(esp);
            opcionesMedicos = cm.getMedicos(f);
        }
        if (respuesta1 == 1 && respuesta2 == 2){
            System.out.println("Ingrese la Obra Social:");
			String obraSocial = entrada.nextLine();
            FiltroObraSocial f = new FiltroObraSocial(obraSocial);
            opcionesMedicos = cm.getMedicos(f);
        }
        if (respuesta1 == 2 && respuesta2 == 2){
            opcionesMedicos = cm.getMedicos();
        }
        for(int i =0;i<opcionesMedicos.size();i++){
            System.out.println(i + ". " + opcionesMedicos.get(i).toString());
        }
        System.out.println("Seleccione un médico(ingrese el numero): ");
        Medico medicoElegido = actual.seleccionarMedico(opcionesMedicos);
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
        ArrayList<Turno> opcionesTurnos = new ArrayList<>();
        //FiltroRangoDias fDias = new FiltroRangoDias(inicio, fin);
        if (respuesta3 == 1){
            FiltroHorario f = new FiltroHorario("M");
            //FiltroANDTurno f = new FiltroANDTurno(fDias,fHorario);
            opcionesTurnos = medicoElegido.getTurnosDisp(inicio,fin,f);
        }
        if (respuesta3 == 2){
            FiltroHorario f = new FiltroHorario("T");
            //FiltroANDTurno f = new FiltroANDTurno(fDias,fHorario);
            opcionesTurnos = medicoElegido.getTurnosDisp(inicio,fin,f);
        }
        if (respuesta3 == 3){
            opcionesTurnos = medicoElegido.getTurnosDisp(inicio,fin,null);
        }
        for(int i =0;i<opcionesTurnos.size();i++){
                System.out.println(i + ". " + opcionesTurnos.get(i).toString());
            }
        System.out.println("Seleccione un turno(ingrese el numero): ");
        Turno turnoNuevo = actual.seleccionarTurno(opcionesTurnos);
        System.out.println("Reconfirme sus datos: ");
        System.out.print("DNI:");
        long dni = Long.parseLong(entrada.nextLine());
        if (dni == actual.getDni()){
            Secretaria s = medicoElegido.getSecretaria();
            s.agendarTurno(medicoElegido,turnoNuevo);
            ArrayList<String> os = medicoElegido.getObrasSociales();
            if (!os.contains(actual.getObraSocial()))
                System.out.println("AVISO: El médico no trabaja con su obra social");
            System.out.println("Turno validado con éxito: ");
            System.out.println(turnoNuevo);
        }
        else 
            System.out.println("Datos incorrectos.");
    }


    public Paciente iniciarSesionPaciente(){
        Scanner entrada = new Scanner (System.in);
        //INICIO DE SESION, EN CASO DE NO ESTAR REGISTRADO SE CREA UNA CUENTA
		//System.out.println("Bienvenido a TurnoFacil");
        System.out.println("Ingrese su DNI (en este ejemplo ingrese 56789): ");
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
                verProximosTurnos(actual);
            }
            if (opcion == 3){
                cancelarTurno(actual);
            }
        }
    }

    public void mostrarOpciones(Secretaria s){
        int opcion = 0;
        Scanner entrada = new Scanner (System.in);
        while (opcion!=3){
            System.out.println("1. Ver próximos turnos");
            System.out.println("2. Cancelar turno");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(entrada.nextLine());
            if (opcion == 1){
                verProximosTurnos(s);
            }
            if (opcion == 2){
                cancelarTurno(s);
            }
        }
    }



    public void cancelarTurno(Secretaria s){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre y apellido del medico:");
        System.out.print("Nombre:");
        String nombre = entrada.nextLine();
        System.out.print("Apellido:");
        String apellido = entrada.nextLine();
        Medico med = cm.getMedico(nombre, apellido);
        if (med != null){
            ArrayList<Turno> turnosMedico = new ArrayList<>();
            turnosMedico = med.getTurnosOcupados();
            for(int i =0;i<turnosMedico.size();i++){
                System.out.println(i + ") " + turnosMedico.get(i).toString() + "| Medico: " + turnosMedico.get(i).getMedico().getApellido() +", "+ 
                    turnosMedico.get(i).getMedico().getNombre() + "| Especialidad: " + turnosMedico.get(i).getMedico().getEspecialidad() );
            }
            System.out.println("Ingrese numero del turno a cancelar:");
            Scanner medico = new Scanner(System.in);
            int turno = Integer.parseInt(medico.nextLine());
            if ((turno > turnosMedico.size()) || (turnosMedico.size() == 0)){
                System.out.println("Opción incorrecta.");
            }
            else{
                s.cancelarTurno(med,turnosMedico.get(turno));
            }
        }
        else {System.out.println("El médico no existe.");}
    }

    public Medico iniciarSesionMedico(){
        System.out.println("Ingrese su nombre (en este ejemplo puede ser Lucarini/Venere): ");
        Scanner entrada = new Scanner (System.in);
        String apellido = entrada.nextLine();
        Medico salida = cm.getMedico(apellido);
        return salida; 
    }

    public void mostrarOpciones (Medico m){
        int opcion = 0;
        Scanner entrada = new Scanner (System.in);
        while (opcion!=2){
            System.out.println("1. Ver próximos turnos");
            System.out.println("2. Salir");
            opcion = Integer.parseInt(entrada.nextLine());
            if (opcion == 1){
                verProximosTurnos(m);
            }
        }
    }

    public void mostrarOpciones(){
        int opcion = 0;
        System.out.println("Bienvenido a TurnoFacil");
        System.out.println("¿Cómo desea ingresar?");
        System.out.println("1.Paciente");
        System.out.println("2.Secretaria");
        System.out.println("3.Médico");
        Scanner entrada = new Scanner (System.in);
        opcion = Integer.parseInt(entrada.nextLine());
        if (opcion == 1){
            Paciente actual = iniciarSesionPaciente();
            mostrarOpciones(actual);
        }
        if (opcion == 2){
            Secretaria actual = iniciarSesionSecretaria();
            mostrarOpciones(actual);
        }
        if (opcion == 3){
            Medico actual = iniciarSesionMedico();
            mostrarOpciones(actual);
        }
    }


    public void verProximosTurnos(Medico m){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seleccione el tipo de filtro:");
        System.out.println("1.Turno(mañana o tarde)");
        System.out.println("2.Rango de días");
        System.out.println("3.Sin filtro (todos los turnos)");
        int respuesta = Integer.parseInt(entrada.nextLine());
        ArrayList<Turno> turnosMedico = new ArrayList<>();
        if (respuesta == 1){
            System.out.println("¿Busca turno por la mañana o por la tarde?: ");
            System.out.println("1.Mañana");
            System.out.println("2.Tarde");
            int respuestaAux = Integer.parseInt(entrada.nextLine());
            if (respuestaAux == 1){
                FiltroHorario f = new FiltroHorario("M");
                turnosMedico = m.listarTurnosFiltro(f); 
            }
            if (respuestaAux == 2){
                FiltroHorario f = new FiltroHorario("T");
                turnosMedico = m.listarTurnosFiltro(f);
            }
        }
        if (respuesta == 2){
            System.out.println("Ingrese el rango de fechas deseado(dd/MM/yyyy): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            System.out.println("Primer fecha:");
            String date1 = entrada.nextLine();
            System.out.println("Segunda fecha:");
            String date2 = entrada.nextLine();
            //convertimos los string en fechas
            LocalDate inicio = LocalDate.parse(date1, formatter);
            LocalDate fin = LocalDate.parse(date2, formatter);
            turnosMedico =  m.getTurnosOcupados(inicio,fin);

        }
        if (respuesta == 3){
            turnosMedico = m.getTurnosOcupados();
        }
        for(int i =0;i<turnosMedico.size();i++){
            System.out.println(i + ") " + turnosMedico.get(i).toString() + "| Medico: " + turnosMedico.get(i).getMedico().getApellido() +", "+ 
                turnosMedico.get(i).getMedico().getNombre() + "| Especialidad: " + turnosMedico.get(i).getMedico().getEspecialidad() );
        }
    
    }

    public Secretaria iniciarSesionSecretaria(){
        System.out.println("Ingrese su nombre (en este ejemplo es Josefa): ");
        Scanner entrada = new Scanner (System.in);
        String nombre = entrada.nextLine();
        Secretaria salida = cm.getSecretaria(nombre);
        return salida;
    }

    public void verProximosTurnos (Paciente a){
        ArrayList<Turno> copia = a.getTurnos();
        Collections.sort(copia);
        for(int i =0;i<copia.size();i++){
            System.out.println(i + ") " + copia.get(i).toString() + "| Medico: " + copia.get(i).getMedico().getApellido() +", "+ copia.get(i).getMedico().getNombre() + "| Especialidad: " + copia.get(i).getMedico().getEspecialidad() );
        }

    }

    public void cancelarTurno (Paciente a){
        verProximosTurnos(a);
        System.out.println("Ingrese numero del turno a cancelar:");
        Scanner medico = new Scanner(System.in);
        int turno = Integer.parseInt(medico.nextLine());
        if ((turno > a.getTurnos().size()) || (a.getTurnos().size() == 0)){
            System.out.println("Opción incorrecta.");
        }else{
            Turno t = a.getTurnos().get(turno);
            Secretaria s = t.getMedico().getSecretaria();
            s.cancelarTurno(t.getMedico(),t);
            a.eliminarTurno(t);
        }
    }


    public void verProximosTurnos(Secretaria s){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seleccione el tipo de filtro:");
        System.out.println("1.Medico");
        System.out.println("2.Turno(mañana o tarde)");
        System.out.println("3.Rango de días");
        System.out.println("4.Sin filtro (todos los turnos)");
        int respuesta = Integer.parseInt(entrada.nextLine());
        ArrayList<Turno> turnosMedico = new ArrayList<>();
        if (respuesta == 1){
            System.out.println("Ingrese el nombre y apellido del medico:");
            System.out.print("Nombre:");
            String nombre = entrada.nextLine();
            System.out.print("Apellido:");
            String apellido = entrada.nextLine();
            Medico med = cm.getMedico(nombre, apellido);
            if (med != null){
                FiltroMedicoTurno f = new FiltroMedicoTurno(med);
                turnosMedico = s.listarTurnos(f);
            }
            else {System.out.println("El médico no existe.");}
        }
        if (respuesta == 2){
            System.out.println("¿Busca turno por la mañana o por la tarde?: ");
            System.out.println("1.Mañana");
            System.out.println("2.Tarde");
            int respuestaAux = Integer.parseInt(entrada.nextLine());
            if (respuestaAux == 1){
                FiltroHorario f = new FiltroHorario("M");
                turnosMedico = s.listarTurnos(f); 
            }
            if (respuestaAux == 2){
                FiltroHorario f = new FiltroHorario("T");
                turnosMedico = s.listarTurnos(f);
            }
        }
        if (respuesta == 3){
            System.out.println("Ingrese el rango de fechas deseado(dd/MM/yyyy): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            System.out.println("Primer fecha:");
            String date1 = entrada.nextLine();
            System.out.println("Segunda fecha:");
            String date2 = entrada.nextLine();
            //convertimos los string en fechas
            LocalDate inicio = LocalDate.parse(date1, formatter);
            LocalDate fin = LocalDate.parse(date2, formatter);
            for (Medico m: s.getMedicos())
            turnosMedico.addAll(m.getTurnosOcupados(inicio,fin));

        }
        if (respuesta == 4){
            turnosMedico = s.listarTurnos(null);
        }
        for(int i =0;i<turnosMedico.size();i++){
            System.out.println(i + ") " + turnosMedico.get(i).toString() + "| Medico: " + turnosMedico.get(i).getMedico().getApellido() +", "+ 
                turnosMedico.get(i).getMedico().getNombre() + "| Especialidad: " + turnosMedico.get(i).getMedico().getEspecialidad() );
        }
    }




}

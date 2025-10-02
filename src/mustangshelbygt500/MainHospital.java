package mustangshelbygt500;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class MainHospital {
    private static final Scanner SC= new Scanner(System.in);
    private static final List<Paciente> Patients= new ArrayList<>();
    private static final List<Doctor> Doctors= new ArrayList<>();
    private static final List<Cita> Citas= new ArrayList<>();
    private static int ContadorPacientes=1;
    private static int ContadorDoctores=1;
    
    public static void main(String[] args){
        int Option;
        do{
            System.out.println("=== MENU HOSPITAL ANGELES ===");
            System.out.println("1. REGISTRAR PACIENTE");
            System.out.println("2. REGISTRAR DOCTOR");
            System.out.println("3. PROGRAMAR CITA");
            System.out.println("4. LISTAR CITAS");
            System.out.println("5. LISTAR PACIENTES");
            System.out.println("6. LISTAR DOCTORES");
            System.out.println("7. LISTAR CITAS DIARIAS");
            System.out.println("8. LISTAR CITAS POR DOCTOR");
            System.out.println("9. REPROGRAMAR CITA");
            System.out.println("10. CANCELAR CITA");
            System.out.println("0. SALIR");
            System.out.println("POR FAVOR SELECIONE UNA OPCION:");
            Option= SC.nextInt();
            SC.nextLine();
            
            switch(Option){
                case 1-> RegistrarPaciente();
                case 2-> RegistrarDoctor();
                case 3-> ProgramarCita();
                case 4-> ListarCitas();
                case 5-> ListarPacientes();
                case 6-> ListarDoctores();
                case 7-> ListarCitasDiarias();
                case 8-> ListarCitasPorDoctor();
                case 9-> ReprogramarCita();
                case 10-> CancelarCita();
                case 0-> System.out.println("SALIENDO..");
                default-> System.out.println("OPCION INVALIDA.");
            }
        } while(Option!=0);
    }
    
    private static void RegistrarPaciente(){
        System.out.println("INGRESE EL NOMBRE DEL PACIENTE:");
        String Nombre= SC.nextLine();
        System.out.println("INGRESE LA EDAD DEL PACIENTE:");
        int Edad= SC.nextInt();
        SC.nextLine();
        
        Paciente PA= new Paciente(ContadorPacientes, Nombre, Edad);
        Patients.add(PA);
        System.out.println("*PACIENTE REGISTRADO EXITOSAMENTE! ID: "+ ContadorPacientes+ "*");
        ContadorPacientes++; //INCREMENTAR VALOR
    }
    
    private static void RegistrarDoctor(){
        System.out.println("NOMBRE DEL DOCTOR:");
        String Nombre= SC.nextLine();
        System.out.println("ESPECIALIDAD: ");
        String Speciality= SC.nextLine();
        
        Doctor DR= new Doctor(ContadorDoctores, Nombre, Speciality);
        Doctors.add(DR);
        System.out.println("*DOCTOR REGISTRADO EXITOSAMENTE ID: "+ ContadorDoctores+ "*");
        ContadorDoctores++;
    }
    
    private static void ProgramarCita(){
        System.out.println("INGRESE EL ID DEL PACIENTE:");
        int IDPaciente= SC.nextInt();
        System.out.println("INGRESE EL ID DEL DOCTOR:");
        int IDDoctor= SC.nextInt();
        SC.nextLine(); //LIMPIAR BUFFER
        
        System.out.println("FECHA (DD/MM/AAAA):");
        String Fecha= SC.nextLine();
        System.out.println("HORARIO (HH:MM AM/PM):");
        String Horario= SC.nextLine();
        
        Paciente Patient= Patients.stream().filter(PA-> PA.getID()== IDPaciente).findFirst().orElse(null);
        Doctor DOCTOR= Doctors.stream().filter(DR-> DR.getID()== IDDoctor).findFirst().orElse(null);
        
        if(Patient==null || DOCTOR==null){
            System.out.println("PACIENTE O DOCTOR NO ENCONTRADO.");
        }
        //VALIDAR DISPONIBILIDAD
        boolean ExisteConflicto= Citas.stream().anyMatch(CI-> CI.getFecha().equals(Fecha) && CI.getHorario().equalsIgnoreCase(Horario)&& (CI.getPaciente().getID()== IDPaciente || CI.getDoctor().getID()== IDDoctor));
        
        if(ExisteConflicto){
            System.out.println("ERROR: YA EXISTE UNA CITA EN ESE HORARIO PARA ESTE PACIENTE O DOCTOR.");
        }
        //CREAR & GUARDAR CITA
        Cita cita= new Cita(Patient, DOCTOR, Fecha, Horario);
        Citas.add(cita);
        System.out.println("*CITA REGISTRADA CORRECTAMENTE!*");
    }
    
    private static void ListarCitas(){
        System.out.println("INGRESE LA FECHA A CONSULTAR (DD/MM/AAAA):");
        String Fecha= SC.nextLine();
        
        List<Cita> CitasDelDia= Citas.stream().filter(CI-> CI.getFecha().equals(Fecha)).sorted(Comparator.comparing(CI-> {
        try{
            return java.time.LocalTime.parse(CI.getHorario().replace(", ", ", "), java.time.format.DateTimeFormatter.ofPattern("HH:mm a", java.util.Locale.US));
        } catch(Exception e){
            return java.time.LocalTime.MIDNIGHT; //FALLBACK
        }
        })).toList();
        
        if(CitasDelDia.isEmpty()){
            System.out.println("NO HAY CITAS PARA ESTA FECHA.");
        } else{
            CitasDelDia.forEach(CI-> System.out.println("PACIENTE: "+ CI.getPaciente().getNombre()+ ", DOCTOR: "+ CI.getDoctor().getNombre()+ ", HORA: "+ CI.getHorario()));
        }
    }
    
    private static void ListarPacientes(){
        System.out.println("=== LISTA DE PACIENTES ===");
        for(Paciente PA: Patients){
            System.out.println("ID: "+ PA.getID()+ ", NOMBRE: "+ PA.getNombre()+ ", EDAD: "+ PA.getEdad());
        }
    }
    
    private static void ListarDoctores(){
        for(Doctor DR: Doctors){
            System.out.println("ID: "+ DR.getID()+ ", NOMBRE: "+ DR.getNombre()+ ", ESPECIALIDAD: "+ DR.getSpeciality());
        }
    }
    
    private static void ListarCitasDiarias(){
        System.out.println("INGRESE LA FECHA (DD/MM/AAAA):");
        String FechaConsultada= SC.nextLine();
        
        //CREAR LISTA TEMPORAL PARA PODER ORDENAR
        List<Cita> CitasDelDia= new ArrayList<>();
        for(Cita cita: Citas){
            if(cita.getFecha().equals(FechaConsultada)){
                CitasDelDia.add(cita);
            }
        }
        if(CitasDelDia.isEmpty()){
            System.out.println("NO HAY CITAS DISPONIBLES PARA ESA FECHA.");
        }
        DateTimeFormatter Formatter= DateTimeFormatter.ofPattern("HH:mm a", Locale.ENGLISH);
        CitasDelDia.sort(Comparator.comparing(C-> LocalTime.parse(C.getHorario(), Formatter)));
        
        System.out.println("=== CITAS DEL DIA "+ FechaConsultada+ " ===");
        for(Cita cita: CitasDelDia){
            Paciente PA= cita.getPaciente();
            Doctor DR= cita.getDoctor();
            System.out.println("PACIENTE: "+ PA.getNombre()+ "(ID "+ PA.getID()+ "), CON EL DOCTOR: "+ DR.getNombre()+ "(ID "+ DR.getID()+ "), EN HORARIO: "+ cita.getHorario());
        }
    }
    
    private static void ListarCitasPorDoctor(){
        System.out.println("INGRESE EL ID DEL DOCTOR PARA LISTAR SUS CITAS:");
        int IDDoctor= SC.nextInt();
        SC.nextLine(); //LIMPIAR BUFFER
        
        Doctor DoctorSeleccionado= null;
        for(Doctor DR: Doctors){
            if(DR.getID()== IDDoctor){
                DoctorSeleccionado= DR;
                break;
            }
        }
        
        if(DoctorSeleccionado== null){
            System.out.println("DOCTOR NO ENCONTRADO.");
        }
        
        boolean Encontrado= false;
        System.out.println("=== CITAS DEL DOCTOR "+ DoctorSeleccionado.getNombre()+ "(ID "+ DoctorSeleccionado.getID()+ ") ===");
        for(Cita cita: Citas){
            if(cita.getDoctor().getID()== IDDoctor){
                Paciente PA= cita.getPaciente();
                System.out.println("PACIENTE: "+ PA.getNombre()+ "(ID "+ PA.getID()+ ") , EL DIA: "+ cita.getFecha()+ ", EN HORARIO: "+ cita.getHorario());
                Encontrado= true;
            }
        }
        if(!Encontrado){
            System.out.println("EL DOCTOR NO TIENE CITAS REGISTRADAS");
        }
    }
    
    private static void ReprogramarCita(){
        System.out.println("INGRESE EL ID DEL PACIENTE:");
        int IDPaciente= SC.nextInt();
        SC.nextLine(); //LIMPIAR BUFFER
        System.out.println("INGRESE EL ID DEL DOCTOR:");
        int IDDoctor= SC.nextInt();
        SC.nextLine();
        System.out.println("NUEVA FECHA (DD/MM/AAAA):");
        String NuevaFecha= SC.nextLine();
        System.out.println("NUEVO HORARIO:");
        String NuevoHorario= SC.nextLine();
        
        boolean CitaEncontrada= false;
        for(Cita CI: Citas){
            if(CI.getPaciente().getID()== IDPaciente && CI.getDoctor().getID()== IDDoctor){
                CI.setFecha(NuevaFecha);
                CI.setHorario(NuevoHorario);
                CitaEncontrada= true;
                System.out.println("*CITA REPROGRAMADA CORRECTAMENTE!*");
                break;
            }
        }
        if(!CitaEncontrada){
            System.out.println("NO SE ENCONTRO LA CITA CON ESE PACIENTE Y DOCTOR");
        }
    }
    
    private static void CancelarCita(){
        System.out.println("INGRESE EL ID DEL PACIENTE:");
        int IDPaciente= SC.nextInt();
        SC.nextLine(); //LIMPIAR BUFFER
        System.out.println("INGRESE EL ID DEL DOCTOR:");
        int IDDoctor= SC.nextInt();
        SC.nextLine();
        
        boolean CitaEliminada= Citas.removeIf(CI-> CI.getPaciente().getID()== IDPaciente && CI.getDoctor().getID()== IDDoctor);
        
        if(CitaEliminada){
            System.out.println("*CITA CANCELADA CORRECTAMENTE!*");
        } else{
            System.out.println("NO SE ENCONTRO LA CITA CON ESE PACIENTE Y DOCTOR.");
        }
    }
        
}

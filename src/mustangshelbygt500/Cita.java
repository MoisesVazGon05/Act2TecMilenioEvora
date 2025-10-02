package mustangshelbygt500;

public class Cita {
    private final Paciente paciente;
    private final Doctor doctor;
    private String Fecha;
    private String Horario;
    
    public Cita(Paciente paciente, Doctor doctor, String Fecha, String Horario){
        this.paciente= paciente;
        this.doctor= doctor;
        this.Fecha= Fecha;
        this.Horario= Horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getHorario() {
        return Horario;
    }
    
    public void setFecha(String Fecha){
        this.Fecha= Fecha;
    }
    
    public void setHorario(String Horario){
        this.Horario= Horario;
    }
}

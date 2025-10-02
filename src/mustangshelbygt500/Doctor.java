package mustangshelbygt500;

public class Doctor {
    private final int ID;
    private final String Nombre;
    private final String Speciality;
    
    public Doctor(int ID, String Nombre, String Speciality){
        this.ID= ID;
        this.Nombre= Nombre;
        this.Speciality= Speciality;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getSpeciality() {
        return Speciality;
    }
    
}

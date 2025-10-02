package mustangshelbygt500;

public class Paciente {
    private final int ID;
    private final String Nombre;
    private final int Edad;
    
    public Paciente(int ID, String Nombre, int Edad){
        this.ID= ID;
        this.Nombre= Nombre;
        this.Edad= Edad;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }
}

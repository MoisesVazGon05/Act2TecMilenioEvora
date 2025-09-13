package evora;

public class Alumno {
    //ATRIBUTOS
    private final String Nombre; //NOMBRE DEL PARTICIPANTE
    private final int[] Calificaciones; //ARRAY CON 5 CALIFICACIONES
    
    //CONSTRUCTOR
    public Alumno(String Nombre, int[] Calificaciones){
        this.Nombre= Nombre;
        this.Calificaciones= Calificaciones;
    }
    
    //METODO A: CALCULAR PROMEDIO.
    public double CalcularPromedio(){
        int Suma=0;
        for(int Calificacion: Calificaciones){
            Suma+= Calificacion;
        }
        return (double) Suma/Calificaciones.length;
    }
    
    //METODO B: OBTENER CALIFICACION FINAL, SEGUN LA TABLA
    public char ObtenerCalificacion(double Average){
        if(Average>=91 && Average<=100){
            return 'A';
        } else if(Average>=81){
            return 'B';
        } else if(Average>=71){
            return 'C';
        } else if(Average>=61){
            return 'D';
        } else if(Average>=51){
            return 'E';
        } else{
            return 'F';
        }
    }
    
    //METODO C: IMPRIMIR RESULTADOS
    public void ImprimirResultados(double Average, char Calificacion){
        System.out.println("NOMBRE DEL ESTUDIANTE: "+ Nombre);
        for(int i=0; i<Calificaciones.length; i++){
            System.out.println("CALIFICACION "+ (i+1)+ ": "+ Calificaciones[i]);
        }
        System.out.println("PROMEDIO: "+ Average);
        System.out.println("CALIFICACION: "+ Calificacion);
    }
    
    //METODO MAIN PARA PROBAR
    public static void main(String[] args){
        int Notas[]= {85, 92, 78, 88, 90}; //EJEMPLO
        Alumno Alumno1= new Alumno("Moises", Notas);
        
        double Average= Alumno1.CalcularPromedio();
        char CalificacionFinal= Alumno1.ObtenerCalificacion(Average);
        
        Alumno1.ImprimirResultados(Average, CalificacionFinal);
    }
}

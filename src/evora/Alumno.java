package evora;
import java.util.Scanner;

public class Alumno {
    public static void main(String[] args){
        //PEDIR NOMBRE
        try (Scanner SC = new Scanner(System.in)) {
            //PEDIR NOMBRE
            System.out.println("===CALIFICACIONES TECMILENIO===");
            System.out.println("INGRESA EL NOMBRE DEL ESTUDIANTE: ");
            String Nombre= SC.nextLine();
            
            //CREAR ARRAY DE CALIFICACIONES
            int[] Calificaciones= new int[5];
            for(int i=0; i<5; i++){
                System.out.println("INGRESA CALIFICACION " +(i+1)+ ": ");
                Calificaciones[i]= SC.nextInt();
            }
            
            //CALIFICACION PROMEDIO
            double Suma=0;
            for(int Cal: Calificaciones){
                Suma+=Cal;
            }
            double Average= Suma/Calificaciones.length;
            
            //OBTENER CALIFICACION FINAL
            char CalFinal;
            if(Average>=91) CalFinal='A';
            else if(Average>=81) CalFinal='B';
            else if(Average>=71) CalFinal='C';
            else if(Average>=61) CalFinal='D';
            else if(Average>=51) CalFinal='E';
            else CalFinal='F';
            
            //IMPRIMIR CALIFICACIONES
            System.out.println("NOMBRE DEL ESTUDIANTE: "+ Nombre);
            for(int i=0; i<Calificaciones.length; i++){
                System.out.println("CALIFICACION "+ (i+1)+ ": "+ Calificaciones[i]);
            }
            System.out.println("PROMEDIO: "+ Average);
            System.out.println("CALIFICACION: "+ CalFinal);
        }
    }
}

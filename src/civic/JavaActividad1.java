package civic;

public class JavaActividad1 {
    public static void main(String[] args){
        //VARIABLES
        int NumeroEntero=262;
        double NumeroDecimal= 1.0115;
        float Pi= 3.1416f; //Π=3.1416
        float Euler= 2.7183f; //Numero de Euler
        boolean EsVerdadero= true;
        char Letra='I';
        String Nombre="Moises";
        
        //OPERADORES MATEMATICOS
        int Suma= NumeroEntero+87; //262+87=349
        int Resta= NumeroEntero-13; //262-13=249
        int Division= NumeroEntero/2; //262/2=131
        double Multiplicacion= NumeroDecimal*2000;
        int Diferencia= Suma-Resta;
        
        //OPERADORES LOGICOS
        boolean ResultadoSuma= (Suma>365) && EsVerdadero;
        boolean ResultadoResta= (Resta<250) && EsVerdadero;
        
        //IMPRIMIR VARIABLES
        System.out.println("Numero Entero: "+ NumeroEntero);
        System.out.println("Numero Decimal: "+ NumeroDecimal);
        System.out.println("Booleano: "+ EsVerdadero);
        System.out.println("Letra: "+ Letra);
        System.out.print("Nombre: "+Nombre);
        System.out.println("Suma: "+ Suma);
        System.out.println("Resta: "+ Resta);
        System.out.println("Division: "+ Division);
        System.out.println("Diferencia: "+ Diferencia);
        System.out.println("Multiplicacion: "+ Multiplicacion);
        System.out.println("Valor de Pi: "+ Pi);
        System.out.println("Valor del Numero Euler: "+ Euler);
        System.out.println("Resultado Logico de Suma: "+ ResultadoSuma);
        System.out.println("Resultado Logico de Resta: "+ ResultadoResta);
    }
}

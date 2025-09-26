package rs6avant;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    private final HashMap<String, String> Contactos;
    private final String FileName;
    
    public AddressBook(String FileName){
        this.FileName= FileName;
        this.Contactos= new HashMap<>();
        CargarContacto();
    }
    
    /**Cargar Contactos al Iniciar*/
    public final void CargarContacto(){
        Contactos.clear();
        try(BufferedReader BR= new BufferedReader(new FileReader(FileName))){
            String line;
            while((line= BR.readLine())!=null){
                String[] parts= line.split(", ", 2);
                if(parts.length==2){
                    Contactos.put(parts[0],parts[1]);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("ARCHIVO NO ENCONTRADO, SE CREARA UNO NUEVO AL GUARDAR.");
        } catch(IOException e){
            System.out.println("ERROR LEYENDO EL ARCHIVO: "+ e.getMessage());
        }
    }
    
    /** Guardar Contactos en el Archivo CSV*/
    public void GuardarContacto(){
        try(BufferedWriter BW= new BufferedWriter(new FileWriter(FileName))){
            for(Map.Entry<String, String> entry: Contactos.entrySet()){
                BW.write(entry.getKey()+", "+ entry.getValue());
                BW.newLine();
            }
            System.out.println("CONTACTO GUARDADO EXITOSAMENTE");
        }catch(IOException e){
            System.out.println("ERROR ESCRIBIENDO EL ARCHIVO: "+ e.getMessage());
        } 
    }
    
    /**Mostrar Contactos */
    public void ListarContactos(){
        System.out.println("CONTACTOS: ");
        for(Map.Entry<String, String> entry: Contactos.entrySet()){
            System.out.println(entry.getKey()+ ", "+ entry.getValue());
        }
    }
    
    /**Crear nuevo contacto*/
    public void CrearContacto(String Numero, String Nombre){
        if(Contactos.containsKey(Numero)){
            System.out.println("EL NUMERO YA EXISTE, ACTUALIZANDO NOMBRE...");
        }
        Contactos.put(Numero, Nombre);
        GuardarContacto(); //Guardar El HashMap en Archivo CSV
    }
    
    /**BORRAR UN CONTACTO*/
    public void EliminarContacto(String Numero){
        if(Contactos.remove(Numero)!=null){
            System.out.println("CONTACTO ELIMINADO.");
            GuardarContacto();
        } else{
            System.out.println("NUMERO NO ENCONTRADO.");
        }
    }
    
    /** MENU INTERACTIVO*/
    public void MenuInteractivo(){
        Scanner SC= new Scanner(System.in);
        int option=-1;
        
        while(option!=0){
            System.out.println("\n=== AGENDA TELEFONICA ===");
            System.out.println("\n==SELECCIONE UNA OPCION==");
            System.out.println("1. Listar Contactos");
            System.out.println("2. Crear Contacto");
            System.out.println("3. Borrar Contacto");
            System.out.println("0. Salir");
            
            try{
                option= Integer.parseInt(SC.nextLine());
            } catch(NumberFormatException e){
                option=-1;
            }
            
            switch(option){
                case 1-> ListarContactos();
                case 2->{
                    System.out.print("Numero: ");
                    String Num= SC.nextLine();
                    System.out.print("Nombre: ");
                    String Name= SC.nextLine();
                    CrearContacto(Num, Name);

                }
                case 3->{
                    System.out.print("Numero a Borrar: ");
                    String Num= SC.nextLine();
                    EliminarContacto(Num);
                }
                case 0-> System.out.println("Saliendo...");
                default-> System.out.println("Opcion Invalida.");
            }
        }
    }
}

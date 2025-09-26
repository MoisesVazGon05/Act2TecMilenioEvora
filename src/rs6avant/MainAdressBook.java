package rs6avant;

public class MainAdressBook {
   public static void main(String[] args){
       AddressBook ADBK= new AddressBook("Contacts.csv");
       ADBK.MenuInteractivo(); //Llamada al Metodo de la Clase AddressBook
    }
}
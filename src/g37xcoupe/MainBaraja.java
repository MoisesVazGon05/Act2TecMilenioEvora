package g37xcoupe;

public class MainBaraja {
   public static void main(String[] args){
       Baraja DECK= new Baraja();
       
       DECK.shuffle();
       System.out.println("\n---HEAD---");
       DECK.shuffle();
       
       System.out.println("\n---PICK---");
       DECK.pick();
       
       System.out.println("\n---HAND---");
       DECK.hand();
    } 
}

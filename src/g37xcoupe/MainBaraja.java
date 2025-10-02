package g37xcoupe;

public class MainBaraja {
    public static void main(String[] args){
        Baraja deck= new Baraja();
        
        deck.Shuffle();
        System.out.println("\n*--HEAD--*");
        deck.Head();
        
        System.out.println("\n*--PICK--*");
        deck.Pick();
        
        System.out.println("\n*--HAND--*");
        deck.Hand();
    }
}

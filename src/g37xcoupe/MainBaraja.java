package g37xcoupe;

public class MainBaraja {
    public static void main(String[] args){
        Baraja deck= new Baraja();
        
        deck.shuffle();
        System.out.println("\n*--HEAD--*");
        deck.head();
        
        System.out.println("\n*--PICK--*");
        deck.pick();
        
        System.out.println("\n*--HAND--*");
        deck.hand();
    }
}

package g37xcoupe;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;
    
    public Baraja(){
        System.out.println("===POKER TECMILENIO===");
        cartas= new ArrayList<>();
        String[] palos={"Corazones", "Diamantes", "Treboles", "Picas"};
        
        for(String palo: palos){
            String color;
            switch(palo){
                case "Corazones":
                case "Diamantes":
                    color= "Rojo";
                    break;
                default:
                    color= "Negro";
            }
            for(int value=1; value<=13; value++){
                cartas.add(new Carta(palo, color, value));
            }
        }
    }
    
    //A. SHUFFLE
    public void shuffle(){
        Collections.shuffle(cartas);
        System.out.println("Se Mezclo la Baraja.");
    }
    
    public void head(){
        if(!cartas.isEmpty()){
            Carta c= cartas.remove(0);
            System.out.println(c);
            System.out.println("Quedan "+ cartas.size()+ " Cartas en la Baraja");
        }
    }
    
    public void pick(){
        if(!cartas.isEmpty()){
            Random rand= new Random();
            int index= rand.nextInt(cartas.size());
            Carta card= cartas.remove(index);
            System.out.println(card);
            System.out.println("Quedan "+ cartas.size()+ " Cartas en la Baraja");
        }
    }
    
    public void hand(){
        int n= Math.min(5, cartas.size());
        
        if(n==0){
            System.out.println("No Quedan Cartas en la Baraja :(");
            return;
        }
        for(int i=0; i<n; i++){
            Carta carta= cartas.remove(0);
            System.out.println(carta.getPalo()+ ", "+ carta.getColor()+ ", "+ carta.getValue());
        }
        System.out.println("Quedan "+ cartas.size()+ " Cartas en la Baraja");
    }
    
    public int GetNumeroCartas(){
        return cartas.size();
    }
}

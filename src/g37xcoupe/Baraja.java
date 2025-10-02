package g37xcoupe;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;
    
    public Baraja(){
        System.out.println("*==POKER TECMILENIO==*");
      cartas= new ArrayList<>();
      String[] palos= {"Corazones", "Diamantes", "Treboles", "Picas"};
      
      for(String palo: palos){
          String color;
          switch(palo){
              case "Corazones":
              case "Diamantes":
                  color= "Rojo";
                  break;
              default: color= "Negro";
          }
          for(int value=1; value<=13; value++){
              cartas.add(new Carta(palo, color, value));
            }
      }
    }
    
    public void Shuffle(){
        Collections.shuffle(cartas);
        System.out.println("Se Mezclo la Baraja.");
    }
    
    public void Head(){
        if(!cartas.isEmpty()){
            Carta card= cartas.remove(0);
            System.out.println(card);
            System.out.println("Quedan "+ cartas.size()+ " Cartas en La Baraja.");
        }
    }
    
    public void Pick(){
        Random rand= new Random();
        int index= rand.nextInt(cartas.size());
        Carta card= cartas.remove(index);
        System.out.println(card);
        System.out.println("Quedan "+ cartas.size()+ " Cartas en La Baraja.");
    }
    
    public void Hand(){
        int n= Math.min(5, cartas.size());
        for(int i=0; i<n; i++){
            Carta card= cartas.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan "+ cartas.size()+ " Cartas en La Baraja.");
    }
    
    public int GetNumeroCartas(){ //DEVOLVER EL VALOR DE CARTAS RESTANTES.
        return cartas.size();
    }
}

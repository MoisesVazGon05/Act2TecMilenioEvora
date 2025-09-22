package g37xcoupe;

public class Carta {
    private String palo;
    private String color;
    private int value;
    
    public Carta(String palo, String color, int value){
        this.palo= palo;
        this.color= color;
        this.value= value;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return palo+ ", "+ color+ ", "+ value;
    }
}

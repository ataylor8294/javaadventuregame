
import java.util.LinkedList;

public class Player{
    private int health =10;
    private int energy =10;
    private String location;
    private int station=0;
    private LinkedList<String> tools = new LinkedList<String>();
    private boolean init = false;
    public Player(){

    }
    public void loseHealth(int amount){
        health = health - amount;
    }
    public void revive(){
        health = health+5;
    }
    public int getHealth(){
        return health;
    }
    public void loseEnergy(int amount){
        energy = energy - amount;
    }
    public void changeLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    public boolean hasTools(){
        if (init){
            return true;
        }
        else{
            return false;
        }
    }
    public void addTools(String tool){
        tools.add(tool);
        init =true;
    }
    public String loseTools (){

        String a= tools.getLast();
        if (tools.size()==1){
            init =false;
        }
        tools.removeLast();
        return a;
    }
    public void sleep(int danger){
        energy = energy +7;
        health = health - danger;
    }
    public int getEnergy(){
        return energy;
    }
    public int getScore(){
        
        if (!init)
        {
            return energy * health;
        }
        else
            return energy *health *(tools.size()+1);
    }

}
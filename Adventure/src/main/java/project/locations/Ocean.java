
public class Ocean implements World{
    private int danger =0;
    private String weapon = "seaweed";
    private String pred = "";
    public Ocean(){

    }
    public int Escape(int chance){
        return 0;
    }
    public String Search(int chance){
        System.out.println("Congragulations on finding " +weapon+"! Use Wisely");
        return weapon;
    }
    public int Fight(int chance){
        System.out.println("You flail wildly at the "+pred +". You kinda suck at combat but maybe youll get this one.");
        return danger - chance;
    }
    public int Befriend(int chance){
        System.out.println("You decide to make friends with "+pred +". The "+pred+" takes pity on you but still punches you in the face");
        return danger -chance*2;
    }
    public int getDanger(){
        return danger;
    }
    public String getMessage(int chance){
        switch(chance){
        case 1: danger =8;
        pred = "Water";
        return "Your boat has been surrounded by rough water that is threatenting to throw you overboard";
        case 2: danger = 10;
        pred = "sharks";
         return "You accidnetally cut your finger, blood drips into the ocean. A shark fin pops out";
        case 3: danger = 7;
        pred = "pirates";
        return "In the distance there is an large ship. Could be pirates";
        case 4:  danger = 1;
        pred = "Sea Lions";
        return "Some friendly sea lions seem to take pity on you as you pass by";
        default: return "";
        
    }
}
}
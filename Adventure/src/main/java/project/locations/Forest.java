

public class Forest implements World{
    private static int danger=0;
    private static String pred ="";
    private static String object = "berries";
    public Forest(){

    }
    public int Escape(int chance){
        return danger - chance;
    }
    public String Search(int chance){
        System.out.println("Congragulations on finding " +object+"! Use Wisely");
        return object;
    }
    public int Fight(int chance){
        System.out.println("You flail wildly at the "+pred +". You kinda suck at combat but maybe youll get this one.");
        return danger - chance;
 
    }
    public int Befriend(int chance){
        System.out.println("You decide to make friends with "+pred +". The "+pred+" takes pity on you but still punches you in the face");
        return danger - chance*2;    
    }
    public int getDanger(){
        return danger;
    }
    public String getMessage(int chance){
        switch(chance){
        case 1: 
        pred = "wolves";
        danger = 10;
        return "There is a clan of wolves peeking through the darkness. You look around and see there is an exit nearby";
        case 2: 
        pred = "cave";
        danger =4;
        return "The forest is thick. Theres a cave to recover and explore but it looks inhabited";
        case 3:pred = "forest";
        danger = 1;
        return "The forest is filled with thick, fierce looking bushes";
        case 4: danger = 10;
        pred = "bear";
        return "A bear fiercely comes out of the brush; you are on his territory";
        default: return "";
    }

    }
}
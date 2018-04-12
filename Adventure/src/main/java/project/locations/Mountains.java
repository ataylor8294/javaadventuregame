
public class Mountains implements World{
    private int count  = 0;
    private int danger=0;
    private String pred = "";
    private String object ="Mountain goat horns of death";
    public int Escape(int chance){
        return 0;
    }
    public String Search(int chance){
        System.out.println("Congragulations on finding " +object+"! Use Wisely");
        return object;
    }
    public int Fight(int chance){
        System.out.println("You flail wildly at the "+pred +". You kinda suck at combat but maybe youll get this one.");
        return danger-chance;
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
        case 1: danger = 4;
        pred = "dwarfs";
         return "The mountains are filled with manmade mines. This is dwarf country.";
        case 2: danger =10;
        pred = "Mountain Lion";
         return "Wandering, you accidentally run into a mountain lion. He sees you";
        case 3: danger = 7;
        pred = "hyenas";
        return "A pack of hyenas laugh and howl as they smell fresh meat";
        case 4: danger =1;
        pred= "mountains";
        return "The mountains are incredible steep and rocky";
        default: return "";
    }
}
}

import java.util.Random;
public class Jungles implements World{
    private int danger =0;
    private String weapon = "sticks";
    private String pred;
    public Jungles(){

    }
    public String Search(int chance) {
        System.out.println("Congragulations on finding " +weapon+"! Use Wisely");
        return weapon;
    }
    public int Escape(int chance){
        return danger - chance;
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
    //get message should be displayed before every turn
    public String getMessage(int chance){
        switch(chance){
        case 1: danger=5;
        pred = "monkeys";
        return "A whole community of monkeys hide in the trees around you. They stare intently";
        case 2: danger=5;
        pred = "snakes";
        return "In the ground there are giant holes as if made by a large mammal. But no such animals live here ";
        case 3: danger=10;
        pred = "tiger";
        return "A tiger is watching you. This is not the jungle book";
        case 4: danger = 6;
        pred = "evil rabbit";
        return "There are animal carcases everywhere. You are in someones lair";
        default: return "";
    }
}

}
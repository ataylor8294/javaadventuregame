
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Game{
    
    public static void main(String[] args) {
        int[][] gameboard = new int [5][5];
        Random ran= new Random();
        Player player = new Player();
        int toolbon=0;
        String loca = "";
        int danger =0;
        boolean won =false;
        int high;
        System.out.println("Welcome to the hardest text game!");
        System.out.println("Escape to civilization");
        System.out.println("You only get two words");
        high = getScore();
        System.out.println("Your high score is "+high);
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                int x = ran.nextInt(4)+1;
                gameboard[i][j] = x;
            }
        }
        int x = ran.nextInt(4)+1;
        int y = ran.nextInt(4)+1;
        int loc = gameboard[x][y];
        
        Jungles jun = new Jungles();
        Ocean oce = new Ocean();
        Mountains moun = new Mountains();
        Forest fore = new Forest();
        Scanner read = new Scanner(System.in);
        while(player.getHealth()>0 && !won)
        {   
            int a = ran.nextInt(4)+1;
            loc = gameboard[x][y];
            switch(loc){
            case 1:System.out.println("You are in the mountains");
            System.out.println(moun.getMessage(a));
            player.changeLocation("Mountains");
            danger = moun.getDanger();
            break;
            case 2:System.out.println("You are in the jungle");
            System.out.println(jun.getMessage(a));
            player.changeLocation("Jungle");
            danger = jun.getDanger();
            break;
            case 3: System.out.println("You are in the ocean");
            System.out.println(oce.getMessage(a));
            player.changeLocation("Ocean");
            danger = oce.getDanger();
            break;
            case 4: System.out.println("You are in the forest"); 
            System.out.println(fore.getMessage(a));
            player.changeLocation("Forest");
            danger = fore.getDanger();
            break;
            }
            if (player.getEnergy()<1){
                System.out.println("Your player must sleep now despite your present danger. Hopefully he doesnt die because of your negligence");
                player.sleep(danger);
            }


            else{
                
                int chance = ran.nextInt(4)+1;
                System.out.println("Fight, Escape, Search, or Befriend ");
                while(!read.hasNext()){

                }
                int effect=0;
                String choice = read.nextLine();
                loca = player.getLocation();
                if (choice.equalsIgnoreCase("fight")){
                    if (loca.equalsIgnoreCase("Ocean")){
                        effect = oce.Fight(chance);
                        player.loseHealth(effect);
                    }
                    else if (loca.equalsIgnoreCase("Mountains")){
                        effect = moun.Fight(chance);
                        player.loseHealth(effect);
                    }
                    else if (loca.equalsIgnoreCase("Jungle")){
                        effect= jun.Fight(chance);
                        player.loseHealth(effect);
                    }
                    else if (loca.equalsIgnoreCase("Forest")){
                        effect = fore.Fight(chance);
                        player.loseHealth(effect);
                    }
                }





                else if (choice.equalsIgnoreCase("escape")){
                    System.out.println("Where? (north, south, east, or west)");
                    choice = read.next();
                    if (choice.equalsIgnoreCase("North")){
                        if (y==4){
                            won=true;
                        }
                        else{
                        effect = oce.Escape(chance);
                        ++y;
                        loc = gameboard[x][y];
                        player.loseEnergy(effect);
                        }
                    }
                    else if (choice.equalsIgnoreCase("south")){
                        if (y==0){
                            won = true;
                        }
                        else{
                        effect = moun.Escape(chance);
                        player.loseEnergy(effect);
                        --y;
                        loc = gameboard[x][y];
                        }
                    }
                    else if (choice.equalsIgnoreCase("east")){
                        if (x ==4){
                            won = true;
                        }
                        else{
                            effect = jun.Escape(chance);
                            ++x;
                            loc = gameboard[x][y];
                            player.loseEnergy(effect);
                        }

                    }
                    else if (choice.equalsIgnoreCase("west")){
                        effect = fore.Escape(chance);
                        if (x==0){
                            won = true;
                        }
                        else{
                            effect = fore.Escape(chance);
                            --x;
                             loc = gameboard[x][y];
                             player.loseEnergy(3);
                        }
                    }
                }


                else if (choice.equalsIgnoreCase("search")){
                    loca = player.getLocation();
                    String item = "";
                    if (loca.equalsIgnoreCase("Ocean")){
                        item = oce.Search(chance);
                        player.loseEnergy(3);
                    }
                    else if (loca.equalsIgnoreCase("Mountains")){
                        item = moun.Search(chance);
                        player.loseEnergy(3);
                    }
                    else if (loca.equalsIgnoreCase("Jungle")){
                        item = jun.Search(chance);
                        player.loseEnergy(3);
                    }
                    else if (loca.equalsIgnoreCase("Forest")){
                        item = fore.Search(chance);
                        player.loseEnergy(3);
                    }
                    player.addTools(item);
                }


                else if (choice.equalsIgnoreCase("befriend")){
                    System.out.println("Befreinded");
                    String item;
                    if (loca.equalsIgnoreCase("Ocean")){
                        effect = oce.Befriend(chance);
                        player.loseHealth(effect);
                    
                    }
                    else if (loca.equalsIgnoreCase("Mountains")){
                        effect =moun.Befriend(chance);
                        player.loseHealth(effect);
                    }
                    else if (loca.equalsIgnoreCase("Jungle")){
                        effect =jun.Befriend(chance);
                        player.loseHealth(effect);
                    }
                    if (loca.equalsIgnoreCase("Forest")){
                        effect =fore.Befriend(chance);
                        player.loseHealth(effect);
                    }
                }
                

            }
            if (player.getHealth()<1 && player.hasTools()){
                System.out.println("You used your "+player.loseTools()+ " to revive you");
                player.revive();
            }

            
        }
        if (!won){
            System.out.println("Looks like you died! Better Luck next time!");
        }
        else{
            System.out.println("You escaped! Now you hav to deal with life on your own!");
            int score = player.getScore();
            record(high, score);
        }
    }

    public static void record(int highscore, int thisscore){
        System.out.println("Your score is "+thisscore);
        if (thisscore >= highscore){
            try{
                System.out.println("Congrats on a new hgih score of"+ thisscore);
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("highscores.ser"));
                os.writeObject(thisscore);
                os.close();
            }
            catch(IOException e){
                System.out.println("unable to record high score");
            }
        }
        
    }
    public static int getScore(){
        Integer high =0;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("highscores.ser"));
            high =(Integer) is.readObject();
            return high;

        }
        catch (IOException e){
            high=0;
            System.out.println("High Score is zero");
            System.out.println("IO Exception");
            return high;
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found");
            return high;
        }
    }
    public static boolean tools(int i){
        if (i>1){
            return true;
        }
        else{
            return false;
        }

    }
}
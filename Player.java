import java.util.ArrayList;
import java.util.Scanner;

class Player {
    private String name;
    private String strategy;
    private int bankedScore = 0;
    private int handScore = 0;


    public Player(String name){
        this.name = name;
    }
    public boolean wantsToRoll(ArrayList<Integer> otherScores, int winningScore){
        return true;
    }

   
    public void addToHandScore(int add){
        System.out.println(" "+ add + " points added");
        handScore += add;
    }

    public void bankScore(){
        System.out.println(name + " put " + handScore + " points in the bank");
        bankedScore += handScore;
        System.out.println("score is now " + bankedScore);
        handScore = 0;
    }


    public void resetHandScore(){
        handScore = 0;
    }

    public String getName(){
        return name;
    }

    public int getHandScore(){
        return handScore;
    }

    public int getScore(){
        return bankedScore;
    }

    public String getStrategy(){
        return strategy;
    }

    public boolean isWinner(int winningScore){
        if(bankedScore + handScore > winningScore){
            return true;
        } else {
            return false;
        }
    }
}

class Human extends Player{
    private Scanner sc;
    private String strategy = "Human thought";

    public Human(String name, Scanner scanner){
        super(name);
        sc = scanner;
    }

    public boolean wantsToRoll(ArrayList<Integer> otherScores, int winningScore){
        System.out.println("handScore is " + super.getHandScore() + ". do you want to role?");
        String answer = sc.nextLine();
        if(answer.equals("y")){
            return true;
        }
        return false;
    }
}

class GamblerBot extends Player{
    private String strategy = "roll until your hand is greated then 1/3 the winning score";


    public GamblerBot(){
        super("GamblerBot");
    }
    public boolean wantsToRoll(ArrayList<Integer> otherScores, int winningScore){
        if(this.getHandScore() > winningScore/3){
            return false;
        } else {
            return true;
        }
    }
}

class SafeBot extends Player{
    private String strategy = "roll until your hand is greated then 1/6 the winning score";

    public SafeBot(){
        super("SafeBot");
    }
    public boolean wantsToRoll(ArrayList<Integer> otherScores, int winningScore){
        if(this.getHandScore() > winningScore/6){
            return false;
        } else {
            return true;
        }
    }
}

class ChatGPT extends Player{
    private String strategy = "ChatGPT said the statistly best score to stop at is when hand > 20";

    public ChatGPT(){
        super("ChatGPT");
    }
    public boolean wantsToRoll(ArrayList<Integer> otherScores, int winningScore){
        if(this.getHandScore() > 20){
            return false;
        } else {
            return true;
        }

    }
}


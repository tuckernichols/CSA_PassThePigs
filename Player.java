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
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        return true;
    }
   
    
    public void addToHandScore(int add){
        handScore += add;
    }

    public void bankScore(){
        bankedScore += handScore;
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
}

class Human extends Player{
    private Scanner sc;

    public Human(String name, Scanner scanner){
        super(name);
        sc = scanner;
    }
}



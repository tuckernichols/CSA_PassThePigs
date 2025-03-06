import java.util.ArrayList;

class Player {
    private String name;
    private String strategy;


    public Player(String name){
        this.name = name;
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        return true;
    }
   
    public String getName(){
        return name;
    }
    public String getStrategy(){
        return strategy;
    }


}



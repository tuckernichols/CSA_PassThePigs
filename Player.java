import java.util.ArrayList;
import java.util.Scanner;

class Player {
    private String name;
    private String strategy;
    private int bankedScore = 0;
    private int handScore = 0;

    public Player(String name) {
        this.name = name;
    }

    // place holder function
    public boolean wantsToRoll(int score, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return true;
    }

    // Get other players scores
    public ArrayList<Integer> getScores(ArrayList<Player> players) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (Player p : players) {
            if (p != this) {
                scores.add(p.getScore());
            }
        }
        return scores;
    }

    // Add points to hand score
    public void addToHandScore(int add) {
        System.out.println(" " + add + " points added");
        handScore += add;
    }

    // Bank hand score 
    public void bankScore() {
        System.out.println(name + " put " + handScore + " points in the bank");
        bankedScore += handScore;
        System.out.println("Score is now " + bankedScore);
        handScore = 0; 
    }

    // pig out scenario
    public void resetHandScore() {
        handScore = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHandScore() {
        return handScore;
    }

    public int getScore() {
        return bankedScore;
    }

    public String getStrategy() {
        return strategy;
    }

    // Check if player won
    public boolean isWinner(int winningScore) {
        return (bankedScore + handScore) >= winningScore;
    }
}

// Human Player Class
class Human extends Player {
    private Scanner sc;
    private String strategy = "Human thought";

    public Human(String name, Scanner scanner) {
        super(name);
        this.sc = scanner;
    }

    public boolean wantsToRoll(int score, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        System.out.println("HandScore is " + super.getHandScore() + ". Do you want to roll? (y/n)");
        String answer = sc.nextLine().toLowerCase();
        return answer.equals("y");
    }
}

// Gambler Bot Class (Risky Strategy)
class GamblerBot extends Player {
    private String strategy = "Roll until hand > 1/3 of the winning score";

    public GamblerBot() {
        super("GamblerBot");
    }

    public boolean wantsToRoll(int score, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore <= winningScore / 3; // Roll while hand score is <= 1/3 of the winning score
    }
}

// Safe Bot Class (Conservative Strategy)
class SafeBot extends Player {
    private String strategy = "Roll until hand > 1/6 of the winning score";

    public SafeBot() {
        super("SafeBot");
    }

    public boolean wantsToRoll(int score, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore <= winningScore / 6; // Roll while hand score is <= 1/6 of the winning score
    }
}

// ChatGPT Bot Class (Adaptive Strategy)
class ChatGPT extends Player {
    private String strategy = "strategy idea given by chatGPT";
    private int handMax = 20; // statistically best safe point to stop

    public ChatGPT() {
        super("ChatGPT");
    }

    public boolean wantsToRoll(int score, int handScore, ArrayList<Integer> otherScores, int winningScore){
        int maxOpponentScore = otherScores.get(0);

        for(Integer points: otherScores){
            if(points > maxOpponentScore){
                maxOpponentScore = points;
            }
        }
        
        if (maxOpponentScore >= winningScore - 15) {
            handMax = 25;   // Play aggressively
        }
        if(maxOpponentScore > score + handScore + 15){
            handMax = 25;   // Play aggressively
        }

        if(maxOpponentScore + 10 < score + handScore){
            handMax = 15;   // play safe if leading
        }

        if(maxOpponentScore + 10 > winningScore && score + handScore +20 < maxOpponentScore ){
            handMax = 100;  // hail mary
        }

        if(handScore > handMax){
            return false;
        } else {
            return true;
        }
    }
}


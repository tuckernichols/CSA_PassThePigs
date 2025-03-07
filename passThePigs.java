import java.util.ArrayList;
import java.util.Scanner;

class passThePigs{
    public static void main(String[] args){
        Pigs pigs = new Pigs();
        Scanner sc = new Scanner(System.in);
        final int WINNINGSCORE = 15;

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Human("Tucker", sc));


        boolean winner = false;
        int roll;
        int runCount = 0;
        while(!winner){
            for(Player player: players){
                System.out.print(player.getName() + "'s turn. ");
                if(player.wantsToRoll(null, 0)){
                    roll = pigs.pigScore();
                    if(roll == 0){
                        System.out.println(" Pig out, 0 points added");
                        continue; // pig out
                    } else { 
                        player.addToHandScore(roll);
                        winner = player.isWinner(WINNINGSCORE);
                    }
                    System.out.println();
                } else {        // if choose not to roll bank points
                    player.bankScore();
                }
            }
        }
    }
}
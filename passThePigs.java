import java.util.ArrayList;
import java.util.Scanner;

class passThePigs{
    public static void main(String[] args){
        Pigs pigs = new Pigs();
        Scanner sc = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<Player>();
        Human me = new Human("tucker", sc);


        boolean winner = false;
        int roll;
        int runCount = 0;
        while(runCount < 3){
            runCount ++;
            System.out.println();
            System.out.print(me.getName() + "'s turn. rolls ");
            if(me.wantsToRoll(0, 0, null, 0)){
                roll = pigs.pigScore();
                if(roll == 0){
                    System.out.println(" Pig out, 0 points added");
                    continue; // pig out
                } else { 
                    System.out.println(" "+ roll + " points added");
                    me.addToHandScore(roll);
                }
                System.out.println();
            } else {
                System.out.print(" put " + me.getHandScore() + " points in the bank. ");
                me.bankScore();
                System.out.println("score is now " + me.getScore());
            }

        }
    }
}
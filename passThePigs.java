import java.util.ArrayList;
import java.util.Scanner;

class passThePigs{
    public static void main(String[] args){
        Pigs pigs = new Pigs();
        Scanner sc = new Scanner(System.in);
        final int WINNINGSCORE = 100;

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Human("Tucker", sc));
        players.add(new GamblerBot());
        players.add(new SafeBot());
        players.add(new ChatGPT());

        int roll;
        boolean running = true;
        while(running){
            for(Player player: players){
                System.out.println();
                System.out.println(player.getName() + "'s turn");
                while(player.wantsToRoll(null, WINNINGSCORE)){
                    roll = pigs.pigScore();
                    if(roll > 0){
                        player.addToHandScore(roll);
                        if(player.isWinner(WINNINGSCORE)){      // winner break first while loop
                            break;
                        }
                    } else {
                        System.out.println(" pig out");
                        player.resetHandScore();
                        break;
                    }
                }
                player.bankScore();
                if(player.isWinner(WINNINGSCORE)){      // winner break final loop
                    System.out.println(player.getName() + " is the winner");
                    running = false;
                    break;
                }
            }

        }
        }
    }

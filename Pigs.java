public class Pigs {
    double dotChance = 34.9;
    double noDotChance = 30.2;
    double razorback = 22.4;
    double trotter = 8.8;
    double snouter = 3.0;
    double leaningJowler = 0.7;


    public int rollPig(){
        double outcome =  Math.random() * 100;
        if(outcome < leaningJowler){
            System.out.print("leaning jowler ");
            return 15;
        } else if(outcome < leaningJowler + snouter){
            System.out.print("snouter ");
            return 10;
        } else if(outcome < leaningJowler + snouter + trotter){
            System.out.print("trotter ");
            return 5;
        } else if(outcome < leaningJowler + snouter + trotter + razorback){
            System.out.print("razorback ");
            return 5;
        } else if(outcome < leaningJowler + snouter + trotter + razorback + noDotChance){
            System.out.print("no dot ");
            return 1;       // return 1 if no dot
        } else{
            System.out.print("dot ");
            return 0;       // return 0 if dot
        }     
}

    public  int pigScore(){
        int roll1 = rollPig();
        int roll2 = rollPig();
        
        if(roll1 + roll2 == 1){
            System.out.print("pig out ");
            return 0;
        }
        if(roll1 + roll2 == 2 || roll1 + roll2 == 0){    // case if: one dot and one nodot
            return 1;
        } else if(roll1 == roll2){      // else case if a double *2
            return 2 * (roll1 + roll2);
        } else{
            return roll1 + roll2;
        }
    }  
// razorback
// no dot
// 6
}

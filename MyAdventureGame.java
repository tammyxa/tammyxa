import java.util.Scanner;
public class MyAdventureGame{
  public static void main (String[] args){
    Scanner input= new Scanner(System.in);
    System.out.println("\n             ~~~~~            WELCOME ADVENTURER!             ~~~~~             ");
    System.out.println("       Do you think you're worthy enough to become our next beloved hero?!      Go through a series of continuous battle to test whether or not you're worthy!\n");
    //default max health
    int health= 100;
    //default max damage
    int maxDam= 20;
    //default max monster damage
    int maxMonDam= 20;
    //monster encounters
    for(int i=1; i<=3; i++){
      System.out.println("     A monster approaches what do you do?     ");
      boolean monDead= false;
      //default monster health
      int monHealth= 50;
      while(monDead==false){
        System.out.print("Type '1' to attack. '2' to dodge (50% chance. Deal half damage if success): ");
        int option= input.nextInt();
        //pregenerate monster's attack damage
        int monDam= (int)(Math.random()*(maxMonDam+1))+1;
        //pregenerate user's attack damage
        int atk= (int)(Math.random()*maxDam+1);
        if(option==1){
          monHealth-=atk;
        }else if(option==2){
          int dodge= (int)(Math.random()*2);
          if(dodge==1){
            System.out.println("Dodged!");
            //change the monster's damage to 0 (like if it didn't hit)
            monDam= 0;
            //half damage
            atk=atk/2;
          }else{
            System.out.println("Unlucky!");
            //do nothing
            atk= 0;
          }
          monHealth-=atk;
        }else{
          System.out.println("You did nothing!");
        }
        if(atk==0){
          System.out.println("You missed!");
        }
        //subtract healths from player and monster
        health-=monDam;
        if(health<= 0){
          monDead= true;
          System.out.println("\n    ***  YOU DIED  ***   ");
          System.out.println("Train harder next time :(");
          System.exit(0);
        }else{
          System.out.println("You got hit for "+monDam+".              HP: "+health);
        }
        if(monHealth<= 0){
          //get out of while loop to generate next monster
          monDead= true;
          System.out.println("");
          System.out.println("      xxxx    MONSTER   SLAIN    xxxx    \n");
          System.out.println("Items Dropped!: (Choose one)");
          System.out.println("   1: Health Potion (+10)  2: Max Damage Buff (+2) 3: Armor (+2)");
          int option2= input.nextInt();
          if(option2==1){
            //increase health by 8
            health+=10;
            System.out.println("Health Potion Used! HP: "+health);
          }else if(option2==2){
            //increase maxDam range when generating a new number
            maxDam+= 2;
            System.out.println("Max Damaged increased to "+maxDam);
          }else if(option2==3){
            maxMonDam-= 2;
            System.out.println("Armour equipped.");
          }else{
            System.out.println("All items dropped.");
          }
          System.out.println("");
        }else{
          System.out.println("You dealt "+atk+" damage.   Monster's HP: "+monHealth);
        }
      }
    }
    System.out.println("      ***    A NEW HERO ARISES     ***     ");
    System.out.println("You are worthy enough to become the next hero!");
    System.exit(0);
  }
}

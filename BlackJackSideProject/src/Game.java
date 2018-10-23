import java.util.Scanner;
/**
 *  This is a comprehensive blackjack program I wrote as a side project while in AP Computer Science in my senior year of highschool.
 * 
 * @author Daniel Stoffel
 * @version 9/28/2014
 */
public class Game
{
   public static void main (String[] args)
   {
       Scanner scan = new Scanner(System.in);
       String welcome = "笙�笙｣笙ｦ笙･ | Welcome to BlackJack Simulator 2014! | 笙･笙ｦ笙｣笙�\n";
       String line = "___________________________________________________ ";
       String decLine = "\n笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･笙�笙｣笙ｦ笙･";
       String numPlayers = "\nNumber of Players(Max 4): ";
       String starMoney = "\nStarting Money: $";
       String diffAsk = "\nHouse Difficulty: \n(1) Easy \n(2) Medium \n(3) Hard \nChosen: ";
       String dealAsk = "\nDeal?(1.Yes 2.No): ";
       String nameAsk1 = "\nPlayer 1's Name: ";
       String nameAsk2 = "\nPlayer 2's Name: ";
       String nameAsk3 = "\nPlayer 3's Name: ";
       String nameAsk4 = "\nPlayer 4's Name: ";
       String nm1 = "Player 1",nm2 = "Player 2",nm3 = "Player 3" , nm4 = "Player 4";
       int inp;
       int players;
       int allMoney;
       int difficulty;
       int card;
       Player ply1 = new Player(nm1);
       Player ply2 = new Player(nm2);
       Player ply3 = new Player(nm3);
       Player ply4 = new Player(nm4);
       Dealer House = new Dealer();
       Deck mainDeck = new Deck();
       
       type(welcome,10);
       type(line,2);
       type(numPlayers,10);
       players = scan.nextInt();
       type(starMoney,10);
       allMoney = scan.nextInt();
       type(diffAsk,10);
       difficulty = scan.nextInt();
       type(line,2);
       type(decLine,2);
       type(dealAsk,10);
       inp = scan.nextInt();
       clear();
       
   }
   public static void clear()
   {
       System.out.print('\u000c');
   }
   public static void wait (int ms)
   {
        try 
        { 
            Thread.currentThread().sleep(ms); 
        }
        catch ( Exception e ) {}
   }
   public static void type (String input, int speed)
   {
       for(int i = 0; i < input.length(); i++)
       {
            System.out.print(input.charAt(i));
            wait(speed);
       }
   }
}

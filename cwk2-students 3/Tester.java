
import java.util.*;

/**
 * Write a description of class Tester here.
 * 
 * @author V S A L Narayana Lanka - Student Id : 21064721
 * @version
 */
public class Tester {
    private void doTest() {
        WIRE wayward = new Resort("Wayward Islands");
        // // Scanner enter = new Scanner(System.in);
        System.out.println("\n\nPlease Scroll Down to see Test Results\n\n");
        System.out.println("Option 1 : Listing All Resort Details");
        System.out.println(wayward.toString());
        System.out.println("\n\nOption 2 : Listing All Cards on All Islands\n");
        System.out.println(wayward.getAllCardsOnAllIslands());
        System.out.println("\n\nOption 3 : Listing All Cards on Yorkie Island\n");
        System.out.println(wayward.getAllCardsOnIsland("Yorkie"));
        System.out.println("\n\nOption 4 : Find Location of cardId 1000");
        System.out.println(wayward.findCardLocation(1000));
        System.out.println("\n\nOption 5 : Checking if card 1000 can travel to Yorkie or not\n");
        System.out.println(wayward.canTravel(1000, "ABC1"));
        System.out.println("\n\nOption 6 : Moving card 1000 from Base by ferry to Yorkie\n");
        System.out.println(wayward.travel(1000, "ABC1"));
        System.out.println("\n\nOption 7 : View a Card with Id 1000\n");
        System.out.println(wayward.viewACard(1000));
        System.out.println("\n\nOption 8 : topup 100 credits with CardId 1000\n");
        wayward.topUpCredits(1000, 100);
        System.out.println(wayward.viewACard(1000));
        System.out.println("\n\nMaking Journey with CardId : 1000 to check conversion of Journey Points");
        System.out.println("\n\nJourney 1 : Yorkie to Bounty [ Ferry : CDE3 ]\n");
        System.out.println(wayward.travel(1000, "CDE3"));
        System.out.println("\n\nJourney 2 : Bounty to Twirl [ Ferry : JKL8 ]\n");
        System.out.println(wayward.travel(1000, "JKL8"));
        System.out.println("\n\nJourney 3 : Twirl to Yorkie [ Ferry : EFG5 ]\n");
        System.out.println(wayward.travel(1000, "EFG5"));
        System.out.println("\n\nJourney 4 : Yorkie to Aero [ Ferry : GHJ6 ]\n");
        System.out.println(wayward.travel(1000, "GHJ6"));
        System.out.println("\n\nJourney 5 : Aero to Yorkie [ Ferry : HJK7 ]\n");
        System.out.println(wayward.travel(1000, "HJK7"));        
        System.out.println("\n\nJourney 6 : Yorkie to Base [ Ferry : BCD2 ]\n");
        System.out.println(wayward.travel(1000, "BCD2"));
        System.out.println("\n\nCard Details Before Conversion\n");
        System.out.println(wayward.viewACard(1000));
        System.out.println("\n\nOption 9 : Conversion of Journey Points on Card with Id 1000\n");
        wayward.convertPoints(1000);
        System.out.println("\n\nCard Details with updated credits and Journey Points after conversion\n");
        System.out.println(wayward.viewACard(1000));
    }

    // No need to change this
    public static void main(String[] args) {
        Tester xx = new Tester();
        xx.doTest();
    }
}

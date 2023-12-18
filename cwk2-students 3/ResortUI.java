import java.util.*;

/**
 * ResortUI class provides the frontend interface of the Resort
 * this class provides different input options for the resort like listing of
 * all the islands, card information, converting journey points, adding credits
 * to a card and also ferry travel can be made using this class
 * 
 * @author Rahul Ravala - Student Id : 21089189
 * @version 10/01/2022
 */
public class ResortUI {
    // declaring Scanner to take inoput from user
    private Scanner reader = new Scanner(System.in);
    // Creating new Resort by passing resort name /location as parameter
    final WIRE wayward = new Resort("Wayward Islands");

    /**
     * Takes input choice entered by the user from the frontend interface and
     * executes the related
     * method according to the input choice entered by the user
     * 
     */
    private void runUI() {
        int choice = getOption();
        while (choice != 0) {
            // process choice
            if (choice == 1) {
                listAllResort();
            } else if (choice == 2) {
                listAllCards();
            } else if (choice == 3) {
                listOneIsland();
            } else if (choice == 4) {
                findLocationOfCard();
            } else if (choice == 5) {
                tryTravel();
            } else if (choice == 6) {
                travelNow();
            } else if (choice == 7) {
                viewCard();
            } else if (choice == 8) {
                updateCredits();
            } else if (choice == 9) {
                convertPts();
            }

            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }

    /**
     * This method provides the user interface for the resort and takes Integer
     * input from the user and returns entered Integer input required to select a
     * method to execute on the Resort created.
     * 
     * @return option selected by the user
     */
    private int getOption() {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all cards on all islands");
        System.out.println("3. List all cards on one island");
        System.out.println("4. Find location of card");
        System.out.println("5. Say if card can move by ferry");
        System.out.println("6. Move a card by ferry");
        System.out.println("7. View card");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");
        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    /**
     * Prints information about the resort including its location/name, Island
     * Details and all
     * cards currently on each island, or "No cards" (if no card on that island)
     * 
     */
    private void listAllResort() {
        System.out.println(wayward.toString());
    }

    /**
     * Prints information of all cards on all islands
     * or "No cards" if there are no cards on an island
     */
    private void listAllCards() {
        System.out.println(wayward.getAllCardsOnAllIslands());
    }

    /**
     * Takes String input of island name and Prints a String representation of all
     * cards on a specified island or "Island Not Found" if no island exists with
     * that name.
     * 
     */
    private void listOneIsland() {
        System.out.println("Enter Island Name");
        String islandName = reader.nextLine();
        String ww = wayward.getAllCardsOnIsland(islandName);
        if (ww != null) {
            System.out.println(ww);
        } else {
            System.out.println("Island Not Found");
        }
    }

    /**
     * Takes integer input of the card id and prints name of the island which
     * contains the specified card or prints "Card Not Found" if no card exits with
     * the id
     */
    private void findLocationOfCard() {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        String ww = wayward.findCardLocation(trav);
        if (ww != null) {
            System.out.println(ww);
        } else {
            System.out.println("Card Not Found");
        }
    }

    /**
     * Takes integer input of CardId and String input of Ferrycode and prints if a
     * card can travel on that ferry to specified island or not
     */
    private void tryTravel() {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(wayward.canTravel(trav, ferry));
    }

    /**
     * Takes integer input of CardId and String input of Ferry code and moves
     * specified card to destination island only if all necessary conditions are
     * satisfied.
     */
    private void travelNow() {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(wayward.travel(trav, ferry));
    }

    /**
     * Takes integer input as CardId and prints String information of the card with
     * given CardId
     */
    private void viewCard() {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        System.out.println(wayward.viewACard(cId));

    }

    /**
     * Takes Integer input of CardId and Number of credits to be added to a Card and
     * update the credits on the specified card
     */
    private void updateCredits() {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        System.out.println("Enter number of Credits");
        int credits = reader.nextInt();
        wayward.topUpCredits(cId, credits);
    }

    /**
     * Takes Integer input of CardId and converts the journey points present on the
     * card according to the type of card and add the credits to the specifed card.
     */
    private void convertPts() {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        wayward.convertPoints(cId);
    }

    /**
     * this is the main method of the class when the program starts running its
     * starts executing from this method.
     */
    public static void main(String[] args) {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }

}

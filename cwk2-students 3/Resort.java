import java.util.*;

/**
 * This class implements the WIRE interface
 *
 * @author Rahul Ravala - Student Id : 21089189
 * @version 05/11/22
 **/
public class Resort implements WIRE // do not change this header
{
    private String location;
    // Collections
    // CardCollection to store information of all cards
    private ArrayList<Card> CardCollection = new ArrayList<Card>();
    // IslandCollection to store information of all Islands
    private ArrayList<Island> IslandCollection = new ArrayList<Island>();
    // FerryCollection to store information of all Ferry
    private ArrayList<Ferry> FerryCollection = new ArrayList<Ferry>();

    /**
     * constructor methiod to create a new Resort with provided name and also load
     * all cards, islands and ferry associated with the Resort created.
     * 
     * Initially all cards are added to base by default and moved from there
     * according to the requirement.
     * 
     */

    public Resort(String loc) {
        location = loc;
        loadIslandsAndFerries();
        loadCards();
        // Ensure all cards are added to Base Island
        // you may do this here or in one of the above method
        AddCardstoBase(CardCollection, getIsland("Base"));
        // Test Methods
    }

    /**
     * Returns information about the resort including its location/name and all
     * cards currently on each island, or "No cards" (if no card on that island)
     * 
     * @return all of the details of all islands including location
     *         and all cards currently on each island, or "No cards" if island has
     *         no cards
     */
    public String toString() {
        String s = "\n\n******************************************************\n" +
                "______________Welcome to " + location + "_____________\n" +
                "******************************************************\n\n";
        for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
            String islandDetails = "======================================================\n\n" +
                    "Island Number   : " + getIslandNumber(IslandCollection.get(i).getIslandName()) + "\n" +
                    "Island Name     : " + IslandCollection.get(i).getIslandName() + "\n" +
                    "Island Rating   : " + IslandCollection.get(i).getIslandRating() + "\n" +
                    "Island Capacity : " + IslandCollection.get(i).getIslandCapacity() + "\n" +
                    "Card Details    : \n\n------------------------------------------------------\n";
            islandDetails = islandDetails + IslandCollection.get(i).printActiveCards();
            s = s + islandDetails;
        }
        return s;
    }

    /**
     * Returns a String representation of all the cards on all islands
     * with "No cards" if there are no cards on an island
     * 
     * @return a String representation of all cards on all islands
     **/
    public String getAllCardsOnAllIslands() {
        String s = "\nLocation of Cards\n\n";
        String IslandDetails = "";
        if (IslandCollection.size() > 0) {
            for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
                String Island = "\n======================================================\n" +
                        IslandCollection.get(i).getIslandName() +
                        "\n======================================================\n\n";
                Island = Island + IslandCollection.get(i).printActiveCards();
                IslandDetails = IslandDetails + Island;
            }
        }
        s = s + IslandDetails;
        return s;
    }

    /**
     * Returns the name of the island which contains the specified card or "Not
     * found"
     * 
     * @param cd -the id of the card
     * @return the name of the Island which contains the card, or "Not found"
     **/
    public String findCardLocation(int cd) {
        String result = "Not found";
        for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
            if (IslandCollection.get(i).exist(cd) == true) {
                result = "\n\nCard is on " + IslandCollection.get(i).getIslandName() + "\n";
            }
        }
        return result;
    }

    /**
     * Returns details of the card with the specified id or "Not found"
     * 
     * @param cd - the id of the card
     * @return the details of the card, or "Not found"
     **/
    public String viewACard(int cd) {
        String result = "Not found";
        Card card = getCard(cd);
        if (card != null) {
            result = "Card Details" +
                    "\n======================================================\n";
            String output = "";
            output = output + Island.PrintCard(card);
            result = result + output;
        }
        return result;
    }

    /**
     * Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * 
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl) {
        int islandIndex = -1;
        for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
            if (IslandCollection.get(i).toString().contains(isl) == true) {
                islandIndex = i;
            }
        }
        ;
        return islandIndex;
    }

    /**
     * Returns a String representation of all cards on a specified island
     * 
     * @param isl - the name of the island
     * @return a String representation of all cards on specified island
     **/
    public String getAllCardsOnIsland(String isl) {
        String s = "";
        if (IslandCollection.size() > 0 && getIsland(isl) != null) {
            for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
                if (IslandCollection.get(i).toString().contains(isl) == true) {
                    s = "\nCards on " + IslandCollection.get(i).getIslandName() +
                            "\n======================================================\n";
                    s = s + IslandCollection.get(i).printActiveCards();
                }
            }
        } else {
            s = "No Island Found";
        }
        return s;
    }

    /**
     * Returns true if a Card is allowed to journey using a ferry, false otherwise
     * A journey can be made if:
     * the rating of the card >= the rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits (a journey costs 3 credits)
     * AND the card is currently in the source island
     * AND the card id and ferry code represent objects in the system
     * 
     * @param cdId    is the id of the card requesting the move
     * @param ferCode is the code of the ferry journey by which the card wants to
     *                move
     * @return true if the card is allowed on the ferry journey, false otherwise
     **/
    public boolean canTravel(int cdId, String ferCode) {
        boolean cantravel = false;
        Ferry ferry = getFerry(ferCode);
        Card card = getCard(cdId);
        Island SourceIsland = getIsland(ferry.getSourceIsland());
        Island DestinationIsland = getIsland(ferry.getDestinationIsland());
        if (conditionChecker(card, ferry, SourceIsland, DestinationIsland) == "success") {
            cantravel = true;
        }
        return cantravel;
    }

    /**
     * Returns the result of a card requesting to journey by Ferry.
     * A journey will be successful if:
     * the luxury rating of the card >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source island
     * AND both the card id and the ferry code is on the system
     * If the ferry journey can be made, the card is removed from the source island,
     * added to the destination island and a suitable message returned. Card
     * information should be updated (A journey costs 3 credits and journey points
     * incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains
     * unchanged
     * and a message specifying the reason is returned.
     * 
     * @param pCardId is the id of the card requesting the move
     * @param ferCode is the code of the ferry by which the card wants to travel
     * @return a String giving the result of the request
     **/
    public String travel(int pCardId, String ferCode) {
        String s = "";
        Ferry ferry = getFerry(ferCode);
        Card card = getCard(pCardId);
        if (card != null) {
            if (ferry != null) {
                Island SourceIsland = getIsland(ferry.getSourceIsland());
                Island DestinationIsland = getIsland(ferry.getDestinationIsland());
                if (conditionChecker(card, ferry, SourceIsland, DestinationIsland) == "success") {
                    SourceIsland.leave(card);
                    DestinationIsland.enter(card);
                    s = "\nCard " + card.getCardId() + " Moved from " + ferry.getSourceIsland() + " to "
                            + ferry.getDestinationIsland() +
                            "\nFerry Used : " + ferry.getFerryName() + "\n" + "Credits Remaining : "
                            + card.getcredits() + "\n";
                } else {
                    s = conditionChecker(card, ferry, SourceIsland, DestinationIsland);
                }
            } else {
                s = "Ferry does not Exist";
            }

        } else {
            s = "Card doest not Exist";
        }

        return s;
    }

    /**
     * Allows credits to be added to a card.
     * 
     * @param id    the id of the card toping up their credits
     * @param creds the number of credits to be added to card
     */
    public void topUpCredits(int id, int creds) {
        Card card = getCard(id);
        if (card == null) {
            System.out.println("Card Not Found");
        } else {
            if (card.getType() == "Employee") {
                System.out.println("\nCannot add credits to Employee\n");
            } else {
                card.addCredits(creds);
                System.out.println("\nCredits added to cardId : " + card.getCardId() + "\n");
            }
        }
    }

    /**
     * Converts a card's journey points into credits
     * 
     * @param id the id of the card whose points are to be converted
     */
    public void convertPoints(int id) {
        Card card = getCard(id);
        card.pointsConverter();
        System.out.println("\nPoints Converted to Credits\n");
    }

    // ***************private methods**************
    private void loadCards() {
        // Cards
        final Card Lynn = new Card(1000, "Lynn", 5, 10);
        final Card May = new Card(1001, "May", 3, 30);
        final Card Nils = new Card(1002, "Nils", 10, 0);
        final Card Olek = new Card(1003, "Olek", 1, 12);
        final Card Pan = new Card(1004, "Pan", 3, 3);
        final Card Quin = new Card(1005, "Quin", 1, 30);
        final Card Raj = new Card(1006, "Raj ", 4, 5);
        final Card Sol = new Card(1007, "Sol", 7, 20);
        final Card Tel = new Card(1008, "Tel", 6, 30);
        final Card Employee_1 = new EmployeeCard(1009, "Employee_1", "Employee of Resorts");
        final Card Tourist_1 = new TouristCard(1010, "Tourist_1", 10, 10, "United Kingdom");
        final Card Business_1 = new BusinessCard(1011, "Business_1", 10);
        CardCollection.add(Lynn);
        CardCollection.add(May);
        CardCollection.add(Nils);
        CardCollection.add(Olek);
        CardCollection.add(Pan);
        CardCollection.add(Quin);
        CardCollection.add(Raj);
        CardCollection.add(Sol);
        CardCollection.add(Tel);
        CardCollection.add(Employee_1);
        CardCollection.add(Tourist_1);
        CardCollection.add(Business_1);
    }

    private void loadIslandsAndFerries() {
        // Island
        final Island Base = new Island("Base", 100, 0);
        final Island Yorkie = new Island("Yorkie", 100, 1);
        final Island Bounty = new Island("Bounty", 10, 3);
        final Island Twirl = new Island("Twirl", 2, 5);
        final Island Aero = new Island("Aero", 1, 1);
        IslandCollection.add(Base);
        IslandCollection.add(Yorkie);
        IslandCollection.add(Bounty);
        IslandCollection.add(Twirl);
        IslandCollection.add(Aero);
        // Ferry
        final Ferry ABC1 = new Ferry("ABC1", Base.getIslandName(), Yorkie.getIslandName());
        final Ferry BCD2 = new Ferry("BCD2", Yorkie.getIslandName(), Base.getIslandName());
        final Ferry CDE3 = new Ferry("CDE3", Yorkie.getIslandName(), Bounty.getIslandName());
        final Ferry DEF4 = new Ferry("DEF4", Bounty.getIslandName(), Yorkie.getIslandName());
        final Ferry EFG5 = new Ferry("EFG5", Twirl.getIslandName(), Yorkie.getIslandName());
        final Ferry GHJ6 = new Ferry("GHJ6", Yorkie.getIslandName(), Aero.getIslandName());
        final Ferry HJK7 = new Ferry("HJK7", Aero.getIslandName(), Yorkie.getIslandName());
        final Ferry JKL8 = new Ferry("JKL8", Bounty.getIslandName(), Twirl.getIslandName());
        FerryCollection.add(ABC1);
        FerryCollection.add(BCD2);
        FerryCollection.add(CDE3);
        FerryCollection.add(DEF4);
        FerryCollection.add(EFG5);
        FerryCollection.add(GHJ6);
        FerryCollection.add(HJK7);
        FerryCollection.add(JKL8);
        // System.out.println(FerryCollection);
    }

    /**
     * Returns the card with the card id specified by the parameter
     * 
     * @param id card id
     * @return the card with the specified name
     **/
    public Card getCard(int id) {
        Card cardDetails = null;
        for (int i = 0; i <= (CardCollection.size() - 1); i++) {
            if (CardCollection.get(i).getCardId() == id) {
                cardDetails = CardCollection.get(i);

            }
        }
        ;
        return cardDetails;
    }

    /**
     * Returns the island with the name specified by the parameter
     * 
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName) {
        Island IslandDetails = null;
        for (int i = 0; i <= (IslandCollection.size() - 1); i++) {
            if (IslandCollection.get(i).getIslandName().toString().contains(islandName) == true) {
                IslandDetails = IslandCollection.get(i);
            }
        }
        ;
        return IslandDetails;
    }

    /**
     * Returns the ferry with the ferry code specified by the parameter
     * 
     * @param fer the ferry code
     * @return the Ferry with the specified name
     **/
    private Ferry getFerry(String fer) {
        Ferry FerryDetails = null;
        for (int i = 0; i <= (FerryCollection.size() - 1); i++) {
            if (FerryCollection.get(i).getFerryName().toString().contains(fer) == true) {
                FerryDetails = FerryCollection.get(i);
            }
            ;
        }
        ;
        return FerryDetails;
    }

    // private Methods
    /**
     * Method to add all cards to the base island.
     * 
     * This method executees when cards are created.
     */
    private void AddCardstoBase(ArrayList<Card> cardCollection, Island island) {
        for (int i = 0; i <= (cardCollection.size() - 1); i++) {
            island.enter(cardCollection.get(i));
        }
    }

    /**
     * This method checks if all conditions necessary for a card to travel are
     * satified or not.
     * 
     * if a condition is not met then it returns the appropriate error message
     * 
     * @return "success" if a card meets all necessary conditions to travel to an
     *         island using ferry or appropriate error message explaining why the
     *         specified card can not make a travel.
     * 
     */
    private String conditionChecker(Card card, Ferry ferry, Island SourceIsland, Island DestinationIsland) {
        String message = "";
        if (CardCollection.size() > 0 && FerryCollection.size() > 0) {
            // Island SourceIsland = getIsland(ferry.getSourceIsland());
            // Island DestinationIsland = getIsland(ferry.getDestinationIsland());
            message = ferry.FerryChecker(card, SourceIsland, DestinationIsland);
        } else {
            message = "No Card or Ferry Exists in the system";
        }
        return message;
    }
}

import java.util.*;

/**
 * An island is part of a WIRE resort.Each island has a name, a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can
 * be on the
 * island at any one time. Each island must maintain a list of all people
 * (cards)
 * currently on the island. These lists are updated whenever cards enter or
 * leave
 * an island,so that it is always possible to say which (cards) are on the
 * island
 * 
 * 
 * @author V S A L Narayana Lanka - Student Id : 21064721
 * @version 10/01/2023
 */

public class Island {
    private String IslandName;
    private int Capacity;
    private int Rating;
    private ArrayList<Card> ActiveCards = new ArrayList<Card>();

    /**
     * constructor method to create instance of an island
     * this method gets executed whenever an instance of island is created
     */
    public Island(String name, int capacity, int rating) {
        this.IslandName = name;
        this.Capacity = capacity;
        this.Rating = rating;
    };

    /**
     * method to return the name of the island instance created
     * 
     * @return name of the island
     *         return type : String
     */
    public String getIslandName() {
        return this.IslandName;
    };

    /**
     * method to return the capacity of the island instance created
     * 
     * @return capacity of the island
     */
    public int getIslandCapacity() {
        return this.Capacity;
    };

    /**
     * method to return the rating of the island instance created
     * 
     * @return rating of the island
     */
    public int getIslandRating() {
        return this.Rating;
    };

    /**
     * method used to enter a card to the island. This method adds a card to the
     * Active
     * Cards collection on an island
     */
    public void enter(Card card) {
        ActiveCards.add(card);
    };

    /**
     * method used to remove a card from an island. This method is used to remove a
     * card from the AActive Cards collection on an island
     * 
     */
    public void leave(Card card) {
        int cardPlace = ActiveCards.indexOf(card);
        ActiveCards.remove(cardPlace);
        card.travel();
    };

    /**
     * method to return the active cards present on the Island
     * 
     * @return Active Cards present on the Island
     */
    public ArrayList<Card> getActiveCards() {
        return ActiveCards;
    };

    /**
     * method to print the active cards present on the Island
     * 
     * @return Active Cards present on the Island
     */
    public String printActiveCards() {
        String card = "";
        if (ActiveCards.size() > 0) {
            for (int j = 0; j <= (ActiveCards.size() - 1); j++) {
                card = card + PrintCard(ActiveCards.get(j));
                card = card + "------------------------------------------------------\n";
            }
        } else {
            card = "\nNo Cards\n";
        }
        return card;
    };

    /**
     * method to return the name of the island instance created
     * 
     * @return name of the island
     */
    public boolean exist(int cardId) {
        boolean cardExists = false;
        for (int i = 0; i <= (ActiveCards.size() - 1); i++) {
            if (ActiveCards.get(i).toString().contains(Integer.toString(cardId)) == true) {
                cardExists = true;
            }
            ;
        }
        ;
        return cardExists;
    }

    /**
     * Method to check if the capacity of an island is full or not
     * 
     * @return Boolean value which represents if capacity of an island is full or
     *         not
     */
    public boolean checkCapacity() {
        boolean space = true;
        if (ActiveCards.size() >= this.Capacity) {
            space = false;
        }
        return space;
    }

    /**
     * Method to get a card present on an island
     * 
     * @return Card which is present on the island
     */
    public Card getCardOnIsland(int cardId) {
        Card cardDetails = null;
        for (int i = 0; i <= (ActiveCards.size() - 1); i++) {
            if (ActiveCards.get(i).getCardId() == cardId) {
                cardDetails = ActiveCards.get(i);
            }
        }
        ;
        return cardDetails;
    }

    /**
     * method to return the name of the island instance created
     * 
     * @return name of the island
     */
    @Override
    public String toString() {
        String IslandDetails = this.IslandName + " " + this.Capacity + " " + this.Rating;
        return IslandDetails;
    }

    /**
     * A Static method which prints the card information according to the type of
     * card
     * 
     * @return String value of the Card which has different fields based on the type
     *         of the card
     */
    static String PrintCard(Card card) {
        String cardDetails = "";
        switch (card.getType()) {
            case "Business":
                cardDetails = "CardId        : " + card.getCardId() + "\n" +
                        "Name          : " + card.getName() + "\n" +
                        "Rating        : " + card.getLuxuryRating() + "\n" +
                        "Credits       : " + card.getcredits() + "\n" +
                        "Type          : " + card.getType() + "\n" +
                        "JourneyPoints : " + card.getJourneyPoints() + "\n" +
                        "LoyaltyPoints : " + ((BusinessCard) card).getLoyaltyPoints() + "\n";
                break;
            case "Tourist":
                cardDetails = "CardId        : " + card.getCardId() + "\n" +
                        "Name          : " + card.getName() + "\n" +
                        "Rating        : " + card.getLuxuryRating() + "\n" +
                        "Credits       : " + card.getcredits() + "\n" +
                        "Type          : " + card.getType() + "\n" +
                        "JourneyPoints : " + card.getJourneyPoints() + "\n" +
                        "Citizenship   : " + ((TouristCard) card).getCitizenship()
                        + "\n";
                break;
            case "Employee":
                cardDetails = "CardId        : " + card.getCardId() + "\n" +
                        "Name          : " + card.getName() + "\n" +
                        "Rating        : " + card.getLuxuryRating() + "\n" +
                        "Credits       : " + card.getcredits() + "\n" +
                        "Type          : " + card.getType() + "\n" +
                        "Journey Score : " + ((EmployeeCard) card).getJourneyScore() + "\n" +
                        "Description   : " + ((EmployeeCard) card).getDescription()
                        + "\n";
                break;
            default:
                cardDetails = "CardId        : " + card.getCardId() + "\n" +
                        "Name          : " + card.getName() + "\n" +
                        "Rating        : " + card.getLuxuryRating() + "\n" +
                        "Credits       : " + card.getcredits() + "\n" +
                        "Type          : " + card.getType() + "\n" +
                        "JourneyPoints : " + card.getJourneyPoints() + "\n";
                break;
        }
        return cardDetails;
    }
}

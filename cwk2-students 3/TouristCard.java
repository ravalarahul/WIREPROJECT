
/**
 * TouristCard is a subclass which extends Card class.
 * 
 * TouristCards are created with a specified luxury rating and a number of
 * credits determined by parameter values
 * 
 * deducts 4 credits whenever a ferry journey is made
 * 
 * includes citizenship (country from which the person comes)
 *
 * @author Rahul Ravala - Student Id : 21089189
 * @version 10/01/2023
 */
public class TouristCard extends Card {
    private String Citizenship;

    /**
     * constructor class to create a new TouristCard Instance with fields like
     * Name, LuxuryRating, Credits, Citizenship.
     * 
     */
    public TouristCard(int cardId, String name, int luxuryRating, int credits, String Citizenship) {
        super(cardId, name, luxuryRating, credits);
        this.Citizenship = Citizenship;
        super.type = "Tourist";
    }

    /**
     * Returns information about the Citizenship of the User present on a card.
     * 
     * @return Citizenship of the User present on the card
     */
    public String getCitizenship() {
        return this.Citizenship;
    }

    /**
     * Method to check if a card meets all conditions required to travel on a ferry
     * 
     * This method overrides the original Card class method
     *
     * @return boolean value if a card can travel on a ferry
     */
    @Override
    public boolean canTravel() {
        if (this.credits > 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to make changes to the card parameters when a travel is made from one
     * island to another island. These changes include deduction of specified
     * credits from a card and also add loyalty points to the card .
     * This method overrides the original Card class method.
     */
    @Override
    public void travel() {
        super.removeCredits(4);
        super.setJourneyPoints(super.journeyPoints + 1);
    }

    /**
     * Method to return all the necessary details of the card including CardId,
     * Name, LuxuryRating, Credits, Type.
     * This method overrides the original 'toString' method
     * 
     * @return all details of the card including CardId, Name, LuxuryRating,
     *         Credits, Type, Journey Points and Citizenship.
     */
    @Override
    public String toString() {
        String cardDetails = this.cardId + " " + this.name + " " + this.luxuryRating + " " + this.credits + " "
                + " " + this.Citizenship;
        return cardDetails;
    }
}


/**
 * BusinessCard is a subclass which extends Card class.
 * 
 * BusinessCards are created with a specified luxury rating, 30 credits and 20
 * loyalty points
 * 
 * 3 credits are deducted and add 2 loyalty points are added whenever a ferry
 * journey is made
 * 
 * loyalty points can also be converted into credits (3 loyalty points = 1
 * credit)
 * 
 * @author Rahul Ravala - Student Id : 21089189
 * @version 10/01/2023
 */
public class BusinessCard extends Card {
    private int loyaltyPoints;

    /**
     * constructor class to create a new BusinessCard Instance with fields like
     * cardId, Name, LuxuryRating, Credits, Loyalty Points.
     * 
     * BusinessCard comes with 30 credits and 20 loyalty points
     */
    public BusinessCard(int cardId, String name, int luxuryRating) {
        super(cardId, name, luxuryRating, 30);
        super.type = "Business";
        this.loyaltyPoints = 20;
    }

    /**
     * Returns information about the Loyalty Points present on a card.
     * 
     * @return loyalty points present on a card
     */
    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    /**
     * This method take Integer input and set the LoyaltyPoints as per the value
     * entered
     * 
     * @param takes Integer input of loyaltyPoints
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
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
        if (this.credits > 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to make changes to the card parameters when a travel is made from one
     * island to another island. These changes include deduction of specified
     * credits from a card and also add loyalty points to the card .
     * 
     * for a business card when a travel is made 3 credits are deducted and 2
     * loyaltyPoints were added.
     * 
     * This method overrides the original Card class method.
     */
    @Override
    public void travel() {
        super.removeCredits(super.credits - 3);
        setLoyaltyPoints(this.loyaltyPoints + 2);
        super.setJourneyPoints(super.journeyPoints + 1);
    }

    /**
     * Method to convert Journey points acquired by a card making ferry journey from
     * one island to another island to credits.
     * 
     * for a card 5 Journey Points = 1 credit
     * 
     * This method overrides the original Card class methood
     */
    @Override
    public void pointsConverter() {
        double tempCreds = Math.floor(super.journeyPoints / 5);
        this.credits = (int) (this.credits + tempCreds);
        super.journeyPoints = (int) Math.ceil(super.journeyPoints % 5);
        LoyaltyPointsConverter();
    }

    /**
     * Method to convert Loyalty points acquired by a card making ferry journey from
     * one island to another island to credits.
     * 
     * for a business card 3 loyaltyPoints = 1 credit
     */
    private void LoyaltyPointsConverter() {
        double tempCreds = Math.floor(this.loyaltyPoints / 3);
        this.credits = (int) (this.credits + tempCreds);
        this.loyaltyPoints = (int) Math.ceil(this.loyaltyPoints % 3);
    }

    /**
     * Method to return all the necessary details of the card including CardId,
     * Name, LuxuryRating, Credits, Journey Points, Type and Loyalty Points.
     * 
     * This method overrides the original 'toString' method
     * 
     * @return all details of the card including CardId,
     *         Name, LuxuryRating, Credits, Journey Points, Type and Loyalty Points.
     */
    @Override
    public String toString() {
        String cardDetails = this.cardId + " " + this.name + " " + this.luxuryRating + " " + this.credits + " "
                + this.type + " " + this.loyaltyPoints;
        return cardDetails;
    }
}

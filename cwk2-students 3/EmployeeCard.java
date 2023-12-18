
/**
 * EmployeeCard is a subclass which extends Card class.
 * 
 * EmployeeCards are created with the highest luxury rating of 10 (Employees can
 * visit all islands) and no credits
 * 
 * zero credits for a journey, but add 1 to the journey score whenever
 * a ferry journey is made
 *
 * @author Rahul Ravala - Student Id : 21089189
 * @version 10/01/2023
 */
public class EmployeeCard extends Card {

    private String Description;
    private int JourneyScore;

    /**
     * constructor class to create a new EmployeeCard Instance with fields like
     * Name, LuxuryRating, Credits, Description.
     * 
     * EmployeeCard comes with 0 credits and 10 luxuryRating
     */
    public EmployeeCard(int cardId, String name, String Description) {
        super(cardId, name, 10, 0);
        this.Description = Description;
        this.JourneyScore = super.journeyPoints;
        super.type = "Employee";
    }

    /**
     * Returns information about the Employee Description present on a card.
     * 
     * @return Employee Description on a Card
     */
    public String getDescription() {
        return this.Description;
    }

    /**
     * Method to set description of the card
     * 
     * @param takes String input and set the Description of the card
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Returns information about the Employee Journey Points present on a card.
     * 
     * @return Employee JourneyPoints on a Card
     */
    public int getJourneyScore() {
        return this.JourneyScore;
    }

    /**
     * Method to set description of the card
     * 
     * @param takes integer input and set the Journey Score of the card
     */
    public void setJourneyScore(int journeyScore) {
        this.JourneyScore = journeyScore;
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
        return true;
    }

    /**
     * Method to make changes to the card parameters when a travel is made from one
     * island to another island. These changes include deduction of specified
     * credits from a card and also add loyalty points to the card .
     * This method overrides the original Card class method.
     */
    @Override
    public void travel() {
        setJourneyScore(this.JourneyScore + 1);
    }

    /**
     * Method to return all the necessary details of the card including CardId,
     * Name, LuxuryRating, Credits, Type.
     * This method overrides the original 'toString' method
     * 
     * @return all details of the card including CardId, Name, LuxuryRating,Journey
     *         Score, Credits, Type and Description.
     */
    @Override
    public String toString() {
        String cardDetails = this.cardId + " " + this.name + " " + this.luxuryRating + " " + this.credits + " "
                + this.JourneyScore + " "
                + this.Description;
        return cardDetails;
    }
}

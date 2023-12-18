/**
 * A Card has an id number, name, a luxury rating,
 * number of credits, journey points and type of card
 * 
 * @author Rahul Ravala - Student Id : 21089189
 * @version 10/01/2023
 */
public class Card  {
   /**
    * These fields represent the basic details of a Card
    * like ID, Name, LuxuryRating, Credits, JourneyPoints and Type of the
    * card
    *
    * 'protected' access modifier is used to use these variables in sub classes
    *
    */
   protected String name;
   protected int luxuryRating;
   protected int credits;
   protected int cardId;
   protected int journeyPoints;
   protected String type;

   // constructor
   /**
    * constructor method used to create a new instance of a card class with all the
    * required fields
    */
   public Card(int cardId, String name, int luxuryRating, int credits) {
      this.cardId = cardId;
      this.name = name;
      this.luxuryRating = luxuryRating;
      this.credits = credits;
      this.type = "Default";
      this.journeyPoints = 0;
   }

   /**
    * Returns information about the unique id of each card
    * 
    * @return unique id of each card object
    * 
    */
   public int getCardId() {
      return this.cardId;
   }

   /**
    * This method set the cardId
    * 
    * @param take integer input of cardId
    * 
    */
   public void setCardId(int cardId) {
      this.cardId = cardId;
   }

   /**
    * Returns information about the type of the card
    * 
    * @return type of the Card
    * 
    */
   public String getType() {
      return this.type;
   }

   /**
    * This method set the type of the card
    * 
    * @param takes String input and set the typ of the card
    * 
    */
   public void setType(String type) {
      this.type = type;
   }

   /**
    * Returns information about the name on the card
    * 
    * @return name on the card
    */
   public String getName() {
      return this.name;
   }

   /**
    * This method set the name of the card holder
    * 
    * @param take String input of name as parameter
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Returns information about the luxuryRating of the card
    * which determines the journey of a card through Islands.
    * 
    * if the card luxury rating is less than the Island rating that card holder can
    * not enter that specific island
    * 
    * @return luxury Rating of the User/Card
    */
   public int getLuxuryRating() {
      return this.luxuryRating;
   }

   /**
    * This method takes Integer parameter and set the luxury rating as per the
    * value provided
    * 
    * @param takes Integer input rating as parameter
    */
   public void setLuxuryRating(int rating) {
      this.luxuryRating = rating;
   }

   /**
    * Returns information about the journeyPoints on the card
    * 
    * @return Journey Points on the card
    */
   public int getJourneyPoints() {
      return this.journeyPoints;
   }

   /**
    * This method set the Journey Points of the card holder
    * 
    * @param take integer input of Journey Points as parameter
    */
   public void setJourneyPoints(int Journeypoints) {
      this.journeyPoints = Journeypoints;
   }

   /**
    * returns information about the credits present in a Card
    * credits are used to make a Ferry journey from one island to another island
    * 
    * @return returns credits present in the card
    */
   public int getcredits() {
      return this.credits;
   }

   /**
    * Method to add credits to a specific card
    * 
    * @param takes integer number of credits to be added to a specific card
    */
   public void addCredits(int credits) {
      this.credits = this.credits + credits;
   }

   /**
    * Method to remove credits from a specific card
    * 
    * @param takes integer number of credits to be removed from a specific card
    */
   public void removeCredits(int credits) {
      if (this.credits > 0) {
         this.credits = this.credits - credits;
      }
      ;
   }

   /**
    * Method to check if a card has enough credits to travel on a ferry
    * 
    * @return boolean value if a card can travel on a ferry
    */
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
    * credits from a card and also add journey points to the card based on the type
    * of card used for the journey.
    */
   public void travel() {
      if (this.credits > 3) {
         removeCredits(3);
         setJourneyPoints(this.journeyPoints + 1);
         ;
      }
   }

   /**
    * Method to convert journey points acquired by a card making ferry journey from
    * one island to another island to credits.
    * 
    * conversion of journey points to credits depends on the type of card
    */
   public void pointsConverter() {
      double tempCreds = Math.floor(this.journeyPoints / 5);
      addCredits((int) tempCreds);
      this.journeyPoints = (int) Math.floor(this.journeyPoints % 5);
   }

   /**
    * Method to return all the necessary details of the card including CardId,
    * Name, LuxuryRating, Credits, Type.
    * This method overrides the original 'toString' method
    * 
    * @return all details of the card including CardId, Name, LuxuryRating,
    *         Credits, Type.
    */
   @Override
   public String toString() {
      String cardDetails = this.cardId + " " + this.name + " " + this.luxuryRating + " " + this.credits + " "
            + this.type + " " + this.journeyPoints;
      return cardDetails;
   }
}

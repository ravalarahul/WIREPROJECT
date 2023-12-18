/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author V S A L Narayana Lanka - Student Id : 21064721
 * @version 10/01/2023
 */
public class Ferry {
    private String FerryName;
    private String sourceName;
    private String destinationName;

    /**
     * Constructor method used to create instance of a new ferry
     */
    public Ferry(String name, String sourceName, String destinationName) {
        this.FerryName = name;
        this.sourceName = sourceName;
        this.destinationName = destinationName;
    }

    /**
     * method to get the ferry name of an instance created
     * 
     * @return name of the ferry instance created
     */
    public String getFerryName() {
        return this.FerryName;
    }

    /**
     * method to set the ferry name of an instance created
     * 
     * @param take String Integer as input and set the name of the Ferry
     */
    public void setFerryName(String ferryName) {
        this.FerryName = ferryName;
    }

    /**
     * method to get the source island from where is ferry is starting
     * 
     * @return name of the source island from where the ferry is starting
     */
    public String getSourceIsland() {
        return this.sourceName;
    }

    /**
     * method to get the destination island name to where the ferry reaches
     * 
     * @return name of the destination island where ferry reaches
     */
    public String getDestinationIsland() {
        return this.destinationName;
    }

    /**
     * This Methods check the required conditions to travel from one island to
     * another island and returns information about the travel and also returns
     * error messages if any are present
     */
     public String FerryChecker(Card card, Island SourceIsland, Island DestinationIsland) {
        String message = "";        
        if (card.getLuxuryRating() >= DestinationIsland.getIslandRating()) {
            if (DestinationIsland.checkCapacity()) {
                if (card.canTravel() == true) {
                    if (SourceIsland.exist(card.getCardId())) {
                        message = "success";
                    } else {
                        message = "Card not found in " + SourceIsland.getIslandName();
                    }
                } else {
                    message = "Not Enough Credits";
                }
            } else {
                message = "Island Full";
            }
        } else {
            message = "Not Enoungh Luxury Rating";
        }
        return message;
    }

    /**
     * toString method which overrides the toString method of the object which
     * returns the necessary details of the ferry
     * 
     * @return details of the ferry like Name, Source Island, Destination Island
     */
    @Override
    public String toString() {
        String FerryDetails = this.FerryName + " " + this.sourceName + " " + this.destinationName;
        return FerryDetails;
    }
}

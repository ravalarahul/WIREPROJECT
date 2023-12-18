
/**
 * Details of your pair
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teamwork {
    private String[] details = new String[6];

    public Teamwork() { // In each line replace the contents of the String
                        // with the details of your team
                        // It will help us if the surname of programmer1 comes
                        // alphabetically before the surname of programmer2
                        // If there is only 1 team member, please complete details
                        // for programmer1

        details[0] = "Lanka";
        details[1] = "V S A L Narayana";
        details[2] = "21064721";
        details[3] = "Ravala";
        details[4] = "Rahul";
        details[5] = "21089189";
    }

    public String[] getTeamDetails() {
        return details;
    }

    public void displayDetails() {
        for (String temp : details) {
            System.out.println(temp.toString());
        }
    }
}

import java.util.*;

/**
 * Write a description of class CardTester here.
 *
 * @author Rahul Ravala - Student Id : 21089189
 * @version 
 */
public class CardTester {
    public static void main(String[] args) {

        Card card = new BusinessCard(1034, "testBusiness", 0);
        // write your tests here
        System.out.println(((BusinessCard) card).getLoyaltyPoints());

    }
}

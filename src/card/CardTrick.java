/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * 
 * Modified by: [Tirth Panchal]
 * Student Number: [991715624]
 * Date Modified: [1st February 2024]
 * 
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Filling magicHand with random Card Objects
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomNumber());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        // Display the generated magic hand
        System.out.println("Generated Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Asking the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuit = scanner.nextInt();

        // Creating user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        // Searching magicHand for the user's card
        boolean found = isCardInMagicHand(userCard, magicHand);

        // Reporting the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Helper method to check if a card is in the magic hand
    private static boolean isCardInMagicHand(Card card, Card[] magicHand) {
        for (Card c : magicHand) {
            if (c.equals(card)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to generate a random number between 1 and 13 (inclusive)
    private static int generateRandomNumber() {
        return (int) (Math.random() * 13) + 1;
    }

    // Helper method to generate a random number within a specified range
    private static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}

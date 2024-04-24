package main.java.com.game;

import main.java.com.game.character.Character;
import main.java.com.game.item.Item;
import main.java.com.game.character.Inventory;

import java.util.Scanner;

public class Main {
    // ANSI escape code to start italicized text
    private static final String ITALIC_ON = "\033[3m";
    // ANSI escape code to end italicized text / reset formatting
    private static final String ITALIC_OFF = "\033[0m";
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in); //scanner for user input

        /*----------------Initial Character Set Up------------------------*/
        System.out.print("Name: ");
        String playerName = scan.nextLine();
        printLine();
        Character character = new Character(playerName, 35);
        /*---------------------------------------------------------------*/

        System.out.println("Name: "+ character.getName() + " Health: " + character.getHealth() + "/100");
        printLine();
        printAnimatedText(ITALIC_ON + "Where am I?" + ITALIC_OFF, 175); // Using ANSI codes for italics
    }

    /*Helper function for UI in Terminal*/
    public static void printLine(){
        System.out.println("---------------------------------------");
    }

    /*Function to print text with animation*/
    public static void printAnimatedText(String text, int delay) throws InterruptedException {
        for (char c : text.toCharArray()) { // Iterate over each character in the text
            System.out.print(c); // Print the character without a newline
            Thread.sleep(delay); // Pause for the specified delay
            }
        System.out.println(); // Move to the next line after printing the entire text
        }

}

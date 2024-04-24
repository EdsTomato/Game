package main.java.com.game;

import main.java.com.game.ui.TextPrinter;
import main.java.com.game.character.Character;
import main.java.com.game.item.Item;
import main.java.com.game.character.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in); //scanner for user input

        /*----------------Initial Character Set Up------------------------*/
        System.out.print("Name: ");
        String playerName = scan.nextLine();
        TextPrinter.printLine();
        Character character = new Character(playerName, 35);
        /*---------------------------------------------------------------*/

        TextPrinter.printStats(character);
        TextPrinter.printLine();
        TextPrinter.printNarratorText("You wake up naked in an alley. Your head hurts and you can't remember anything",100);
        TextPrinter.printCharacterText("Where am I?", 175);
        TextPrinter.printNarratorText("As you look around you see a blinding light at the end of the alley", 100);

        /*----------------The Alley------------------------*/
        List<String> alleyOptions = new ArrayList<>();
        alleyOptions.add("Walk toward the light");
        alleyOptions.add("Look around");
        alleyOptions.add("Do nothing");
        TextPrinter.printOptions(alleyOptions);
        System.out.print("Choose an action (1, 2, or 3): ");
        int choice = scan.nextInt();
        // Use a switch statement to handle the player's choice
        switch (choice) {
            case 1:
                TextPrinter.printNarratorText("You walk toward the light.", 100);
                break;
            case 2:
                TextPrinter.printNarratorText("You look around.", 100);
                TextPrinter.printNarratorText("There is bloody metal pipe on the floor.", 100);
                break;
            case 3:
                TextPrinter.printNarratorText("You do nothing...", 100);
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                break;
        }
        /*---------------------------------------------------------------*/
    }
}

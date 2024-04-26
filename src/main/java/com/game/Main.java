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
        boolean continueGame = true;

        /*----------------Initial Character Set Up------------------------*/
        System.out.print("Name: ");
        String playerName = scan.nextLine();
        TextPrinter.printLine();
        Character character = new Character(playerName, 35);
        /*---------------------------------------------------------------*/

        TextPrinter.printStats(character);
        TextPrinter.printLine();
        TextPrinter.printNarratorText("You wake up naked in an alley. Your head hurts and you can't remember anything", 100);
        TextPrinter.printCharacterText("Where am I?", 175);
        TextPrinter.printNarratorText("As you look around you see a blinding light at the end of the alley", 100);

        /*----------------The Alley------------------------*/
        List<String> alleyOptions = new ArrayList<>();
        alleyOptions.add("Walk toward the light");
        alleyOptions.add("Look around");
        TextPrinter.printOptions(alleyOptions);
        System.out.print("Action to be performed (1 or 2): ");
        int choice = scan.nextInt();
        // Use a switch statement to handle the player's choice
        switch (choice) {
            case 1:
                TextPrinter.printNarratorText("You walk toward the light.", 100);
                break;
            case 2:
                TextPrinter.printNarratorText("You look around.", 100);
                TextPrinter.printNarratorText("There is a bloody metal pipe on the floor.", 100);

                List<String> pipeOptions = new ArrayList<>();
                pipeOptions.add("Pick up pipe");
                pipeOptions.add("Leave pipe");
                TextPrinter.printOptions(pipeOptions);
                System.out.print("Action to be performed:  ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        TextPrinter.printNarratorText("You pick up the pipe", 100);
                        Item metalPipe = new Item("Metal Pipe", 3.0);
                        character.addItemToInventory(metalPipe);
                        TextPrinter.printInventory(character.getInventory().getItems());
                        break;
                    case 2:
                        TextPrinter.printNarratorText("You leave the pipe", 100);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose between 1 and 2");
                        break;
                }
                alleyOptions.remove("Look around");
                break;
            default:
                System.out.println("Invalid choice. Please choose between 1 and 2");
                break;
        }

        TextPrinter.printOptions(alleyOptions);
        System.out.print("Action to be performed:  ");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                TextPrinter.printNarratorText("You walk toward the light.", 100);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        /*---------------------------------------------------------------*/


        /*----------------Kabukichō------------------------*/
        TextPrinter.printNarratorText("As you get closer to the light you hear people talking, cars driving by and laughter", 100);
        TextPrinter.printNarratorText("You step out of the alley and are on a busy street in Tokyo's red light district, Kabukichō.", 100);
        TextPrinter.printCharacterText("WHAT THE FUCK!", 0);
        TextPrinter.printCharacterText("How did I end up here...naked?", 175);
        TextPrinter.printCharacterText("I should get home...or maybe get some clothes first.", 175);

        List<String> kabukiOptions = new ArrayList<>();
        kabukiOptions.add("Start walking home");
        kabukiOptions.add("Get clothes");
        TextPrinter.printOptions(kabukiOptions);
        System.out.print("Action to be performed:  ");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                TextPrinter.printNarratorText("You start walking home.", 100);
                TextPrinter.printNarratorText("As you make your way home some people start running away from you, some laugh and one calls the police.", 100);
                TextPrinter.printNarratorText("The officer arrives and you explain that you woke up in an alley and are tying to get home.", 100);
                TextPrinter.printNarratorText("The officer turns out to be a nice guy and gives you a ride home.", 100);
                break;
            case 2:
                TextPrinter.printNarratorText("You decide to get clothes first.", 100);
                TextPrinter.printNarratorText("As there are no clothing stores nearby you decide to rob someone.", 100);
                TextPrinter.printNarratorText("While looking for a target you see a high schooler in his uniform, a banker in a suit " +
                        "and a guy that looks like a thug in biker clothes", 100);
                List<String> clothesOptions = new ArrayList<>();
                clothesOptions.add("Rob the high schooler.");
                clothesOptions.add("Rob the banker.");
                clothesOptions.add("Rob the thug.");
                TextPrinter.printOptions(clothesOptions);
                System.out.print("Action to be performed:  ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        TextPrinter.printNarratorText("You decide the high schooler is the easiest target.", 100);
                        TextPrinter.printNarratorText("The high schooler turns out to be the national Judo champion in his weight class and puts up a good fight.", 100);
                        if (character.getInventory().hasItem("Metal Pipe")) {
                            TextPrinter.printNarratorText("You are lucky you had the pipe with you.", 100);
                            TextPrinter.printNarratorText("With the school uniform on you decide to make you way home.", 100);
                        } else {
                            TextPrinter.printNarratorText("The high schooler beats the shit out of you.", 100);
                            character.takeDamage(10);
                            TextPrinter.printStats(character);
                            TextPrinter.printCharacterText("That little guy was stronger than I expected.", 175);
                            TextPrinter.printCharacterText("I'll try to rob one of the other guys.", 175);
                            kabukiOptions.remove("Rob the high schooler.");
                            TextPrinter.printOptions(kabukiOptions);
                            System.out.print("Action to be performed:  ");
                            choice = scan.nextInt();
                            switch (choice) {
                                case 1:
                                    TextPrinter.printNarratorText("You decide the banker is an easy target.", 100);
                                    if (character.getInventory().hasItem("Metal Pipe")) {
                                        TextPrinter.printNarratorText("As the banker sees a naked guy with a bloody pipe in his hand walking towards him he ran away", 100);
                                        TextPrinter.printCharacterText("This guy might be sprinter in his free time with how fast he ran.", 175);
                                    } else {
                                        TextPrinter.printNarratorText("As the banker sees a naked guy Hwalking towards him he ran away", 100);
                                        TextPrinter.printCharacterText("This guy might be sprinter in his free time with how fast he ran.", 175);
                                    }
                                    kabukiOptions.remove("Rob the banker.");
                                    TextPrinter.printCharacterText("I'll try to rob the thug.", 175);
                                    TextPrinter.printNarratorText("As you walk toward the thug he gets scared and puts his hands in the air.", 100);
                                    TextPrinter.printNarratorText("You easily take the clothes off his back and put them on while the \"thug\" cries.", 100);
                                    TextPrinter.printCharacterText("What a disappointment.", 175);
                                    break;
                                case 2:
                                    TextPrinter.printNarratorText("You decide you want an actual fight so you can let out some anger.", 100);
                                    TextPrinter.printNarratorText("As you walk toward the thug he gets scared and puts his hands in the air.", 100);
                                    TextPrinter.printNarratorText("You easily take the clothes off his back and put them on while the \"thug\" cries.", 100);
                                    TextPrinter.printCharacterText("What a disappointment.", 175);
                                    break;
                            }
                        }
                        break;
                    case 2:
                        TextPrinter.printNarratorText("You decide the banker is an easy target.", 100);
                        if (character.getInventory().hasItem("Metal Pipe")) {
                            TextPrinter.printNarratorText("As the banker sees a naked guy with a bloody pipe in his hand walking towards him he ran away", 100);
                            TextPrinter.printCharacterText("This guy might be sprinter in his free time with how fast he ran.", 175);
                        } else {
                            TextPrinter.printNarratorText("As the banker sees a naked guy walking towards him he ran away", 100);
                            TextPrinter.printCharacterText("This guy might be sprinter in his free time with how fast he ran.", 175);
                        }
                        kabukiOptions.remove("Rob the banker.");
                        TextPrinter.printOptions(kabukiOptions);
                        System.out.print("Action to be performed:  ");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1:
                                TextPrinter.printNarratorText("You decide the high schooler is the next easiest target.", 100);
                                TextPrinter.printNarratorText("The high schooler turns out to be the national Judo champion in his weight class and puts up a good fight.", 100);
                                if (character.getInventory().hasItem("Metal Pipe")) {
                                    TextPrinter.printNarratorText("You are lucky you had the pipe with you.", 100);
                                    TextPrinter.printNarratorText("With the school uniform on you decide to make you way home.", 100);
                                } else {
                                    TextPrinter.printNarratorText("The high schooler beats the shit out of you.", 100);
                                    character.takeDamage(10);
                                    TextPrinter.printStats(character);
                                    TextPrinter.printCharacterText("That little guy was stronger than I expected.", 175);
                                    TextPrinter.printCharacterText("I'll try to rob the thug.", 175);
                                    TextPrinter.printNarratorText("As you walk toward the thug he gets scared and puts his hands in the air.", 100);
                                    TextPrinter.printNarratorText("You easily take the clothes off his back and put them on while the \"thug\" cries.", 100);
                                    TextPrinter.printCharacterText("What a disappointment.", 175);
                                }
                                break;
                            case 2:
                                TextPrinter.printNarratorText("You decide to try and fight the thug.", 100);
                                TextPrinter.printNarratorText("As you walk toward the thug he gets scared and puts his hands in the air.", 100);
                                TextPrinter.printNarratorText("You easily take the clothes off his back and put them on while the \"thug\" cries.", 100);
                                TextPrinter.printCharacterText("What a disappointment.", 175);
                                break;
                        }
                        break;
                    case 3:
                        TextPrinter.printNarratorText("You decide you want an actual fight so you can let out some anger.", 100);
                        TextPrinter.printNarratorText("As you walk toward the thug he gets scared and puts his hands in the air.", 100);
                        TextPrinter.printNarratorText("You easily take the clothes off his back and put them on while the \"thug\" cries.", 100);
                        TextPrinter.printCharacterText("What a disappointment.", 175);
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose between 1 and 2");
                break;
        }
        /*---------------------------------------------------------------*/


    }
}

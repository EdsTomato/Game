package main.java.com.game;

import main.java.com.game.ui.TextPrinter;
import main.java.com.game.character.Character;
import main.java.com.game.item.Item;
import main.java.com.game.character.Inventory;

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
        TextPrinter.printCharacterText("Where am I?", 175); // Using ANSI codes for italics
    }
}

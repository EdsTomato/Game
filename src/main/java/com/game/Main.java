package main.java.com.game;

import main.java.com.game.character.Character;
import main.java.com.game.item.Item;
import main.java.com.game.character.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name: ");
        String playerName = scan.nextLine();
        System.out.println();
        Character character = new Character(playerName, 35);
        System.out.println("Name: "+ character.getName() + "Health: " + character.getHealth() + "/100");
    }
}

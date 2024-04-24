package main.java.com.game.ui;

import main.java.com.game.character.Character;

import java.util.List;

//This class is used for UI text output
public class TextPrinter {
    // ANSI escape code to start italicized text
    private static final String ITALIC = "\033[3m";
    // ANSI escape code to start bold text
    private static final String BOLD = "\033[1m";
    // ANSI escape code to start green text
    private static final String GREEN = "\033[32m";
    // ANSI escape code to reset formatting (turn off bold, italics, etc.)
    private static final String ANSI_OFF = "\033[0m";

    public static void printCharacterText(String text, int delay) throws InterruptedException {
        printWithStyle(text, delay, ITALIC);
    }

    public static void printNarratorText(String text, int delay) throws InterruptedException {
        printWithStyle(text, delay, BOLD);
    }

    public static void printSystemText(String text, int delay) throws InterruptedException {
        printWithStyle(text, delay, GREEN);
    }

    public static void printNormalText(String text, int delay) throws InterruptedException {
        printWithStyle(text, delay, ""); // Normal for default style
    }

    public static void printStats(Character character){
        System.out.println(GREEN + "Name: "+ character.getName());
        System.out.println(GREEN + "Health: " + character.getHealth() + "/100" + ANSI_OFF );
    }

    public static void printLine(){
        System.out.println("---------------------------------------");
    }

    public static  void printWithStyle(String text, int delay, String style) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(style + c + ANSI_OFF); // Apply style and reset
            Thread.sleep(delay); // Pause for the specified delay
        }
        System.out.println(); // Move to the next line
    }

    //method to print a list of options for selection
    public static void printOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(GREEN + (i + 1) + ". " + options.get(i) + ANSI_OFF); // Print with indices
        }
    }
}

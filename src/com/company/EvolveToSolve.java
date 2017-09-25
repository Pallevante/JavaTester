package com.company;

import java.util.Random;
import java.util.Scanner;

public class EvolveToSolve {
    // Generate ascii string.
    private static String generateAscii(){
        String result = "";
        for (char c = 'A'; c <= 'Z'; c++){
            result += c;
        }
        for (char c = 'a'; c <= 'z'; c++){
            result += c;
        }
        for (char c = '1'; c <= '9'; c++){
            result += c;
        }
        result += ",._-?!;:!@# €%&/\\()=?åäöÅÄÖ";
        return result;
    }

    // Retunerar en random char från vår ascii sträng.
    private static char returnRandomChar(String arg){
        Random rnd = new Random();
        int select = rnd.nextInt(arg.length());
        return arg.charAt(select);
    }

    public static void run(){
        // För att köra i intellij.
        Scanner reader = new Scanner(System.in);
        // Genererar en asciisträng.
        String possibleCharacters = generateAscii();

        System.out.println("Enter target: ");
        String target = reader.nextLine();
        String attemptThis = "";
        // Load with first try.
        for (int i = 0; i <= target.length() -1; i++)
            attemptThis += returnRandomChar(possibleCharacters);

        // Variabler ofc.
        String attemptNext = "";
        boolean completed = false;
        int generation = 0;

        while (!completed){
            System.out.println(attemptThis);
            completed = true;
            attemptNext = "";
            // Kollar igenom varje char.
            for (int i = 0; i <= target.length() -1; i++){
                // Om en char inte stämmer.
                if(attemptThis.charAt(i) != target.charAt(i)) {
                    completed = false;
                    // Sätt en ny random på nästa attempt.
                    attemptNext += returnRandomChar(possibleCharacters);
                }
                else
                    attemptNext += target.charAt(i);
            }
            generation++;
            attemptThis = attemptNext;
        }
        System.out.print("Target matched! That took " + generation + " generation(s)");
    }
}

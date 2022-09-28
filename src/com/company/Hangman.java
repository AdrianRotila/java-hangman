package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static com.company.HangmanUtils.generateWord;

public class Hangman {

    private int lives = 10;
    private boolean game = true;
    private boolean playAgainMenu = false;
    Display display = new Display();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        String word = generateWord();
        System.out.println("The word for this game is: " + word);
        String[] guessArr = new String[word.length()];
        Arrays.fill(guessArr, "_");


        String[] solutionArr = word.split("").clone();


        display.startingMenu();

        while (game) {
            display.hangmanDrawing(lives);
            display.updatedResult(guessArr, lives);

            String letter = scanner.next().toUpperCase();

            // decrease lives if wrong answer
            if (!Arrays.toString(solutionArr).contains(letter)) {
                lives--;
            }

            // Search and update the array
            for (int i = 0; i < word.length(); i++) {
                if (solutionArr[i].contains(letter)) {
                    guessArr[i] = letter;
                }
            }

            // Check for win
            if (!Arrays.asList(guessArr).contains("_")) {

                display.winningMessage();

                playAgainMenu = true;

                // Play again menu
                while (playAgainMenu) {
                    display.playAgainMessage();

                    String input = scanner.next().toUpperCase(Locale.ROOT);
                    if (input.contains("Y")) {

                        word = generateWord();
                        guessArr = new String[word.length()];
                        Arrays.fill(guessArr, "_");

                        solutionArr = word.split("").clone();


                        lives = 10;
                        playAgainMenu = false;
                        System.out.println(word);
                    } else if (input.contains("N")) {
                        game = false;
                        playAgainMenu = false;
                    } else {
                        display.invalidInput();
                    }
                }
            }

            // Check for lose
            if (lives == 0) {
                display.loosingMessage();

                // Play again menu
                playAgainMenu = true;
                while (playAgainMenu) {
                    display.playAgainMessage();

                    String input = scanner.next().toUpperCase(Locale.ROOT);
                    if (input.contains("Y")) {
                        word = generateWord();
                        guessArr = new String[word.length()];
                        Arrays.fill(guessArr, "_");

                        solutionArr = word.split("").clone();

                        lives = 10;
                        playAgainMenu = false;
                    } else if (input.contains("N")) {
                        game = false;
                        playAgainMenu = false;
                    } else {
                        display.invalidInput();
                    }
                }
            }
        }
    }
}

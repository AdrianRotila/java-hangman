package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import static com.company.HangmanUtils.generateWord;

public class Hangman {

    private int lives;
    private boolean game = true;
    private boolean playAgainMenu = false;
    private String[] guessArr;
    private String[] solutionArr;
    private final Scanner scanner = new Scanner(System.in);
    private String word;
    private final Display display = new Display();

    public void start() {
        initialize();
        System.out.println("The word for this game is: " + word);
        display.startingMenu();

        while (game) {
            display.hangmanDrawing(lives);
            display.updatedResult(guessArr, lives);
            String letter = scanner.next().toUpperCase();

            // decrease lives if wrong answer
            decreaseLives(solutionArr, letter);

            // Search and update the array
            updateArray(letter);

            // Check for win
            if (!Arrays.asList(guessArr).contains("_")) {
                display.winningMessage();

                // Play again?
                playAgainMenu = true;
                playAgainMenu();
            }

            // Check for lose
            if (lives == 0) {
                display.loosingMessage();

                // Play again?
                playAgainMenu = true;
                playAgainMenu();
            }
        }
    }

    private String[] emptyGuessArr(String word) {
        String[] guessArr = new String[word.length()];
        Arrays.fill(guessArr, "_");
        return guessArr;
    }

    private void decreaseLives(String[] solutionArr, String letter) {
        if (!Arrays.toString(solutionArr).contains(letter)) {
            lives--;
        }
    }

    private void updateArray(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (solutionArr[i].contains(letter)) {
                guessArr[i] = letter;
            }
        }
    }

    private void playAgainMenu() {
        while (playAgainMenu) {
            display.playAgainMessage();

            String input = scanner.next().toUpperCase(Locale.ROOT);
            if (input.contains("Y")) {
                initialize();

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

    private void initialize () {
        word = generateWord();
        guessArr = emptyGuessArr(word);
        solutionArr = word.split("").clone();
        lives = 10;
    }
}

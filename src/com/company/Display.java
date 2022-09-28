package com.company;

import java.util.Arrays;

public class Display {

    public void startingMenu() {
        System.out.println("--------------------------------------------       JAVA  HANGMAN  GAME       --------------------------------------------\n");
        System.out.println("============================================           R U L E S             ============================================");
        System.out.println("          1. Insert only letters and one at a time!");
        System.out.println("          2. Don't type in the same input twice!");
        System.out.println("          3. Have fun!\n\n");
    }

    public void winningMessage() {
        System.out.println("\n                                        //");
        System.out.println("                                      (°,°)");
        System.out.println("                                      \\ | /");
        System.out.println("                                        |");
        System.out.println("                                       / \\");
        System.out.println("                              ---------------------\n");
        System.out.println("============================================ CONGRATULATION, YOU HAVE WON! ============================================");
    }

    public void loosingMessage() {
        System.out.println("\n                                       _ _ _ _ _ _ _");
        System.out.println("                                        | /         |");
        System.out.println("                                        |         (°_°)");
        System.out.println("                                        |         --|--");
        System.out.println("                                        |           |");
        System.out.println("                                        |          / \\");
        System.out.println("                                        |");
        System.out.println("                                        |");
        System.out.println("                              _ _ _ _ _ | _ _ _ _ _\n");
        System.out.println("\n============================================      GAME OVER, TRY AGAIN!      ============================================");
    }

    public void hangmanDrawing(int lives) {
        switch (lives) {
            case 9:
                System.out.println("\n\n\n\n\n\n\n                                    _ _ _ _ _ _ _\n");
                break;
            case 7:
                System.out.println("\n                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                    _ _ | _ _ _ _ _\n");
                break;
            case 5:
                System.out.println("\n                                       _ _ _ _ _ _ _");
                System.out.println("                                        | /         |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                    _ _ | _ _ _ _ _\n");
                break;
            case 3:
                System.out.println("\n                                       _ _ _ _ _ _ _");
                System.out.println("                                        | /         |");
                System.out.println("                                        |         (°_°)");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                    _ _ | _ _ _ _ _\n");
                break;
            case 2:
                System.out.println("\n                                       _ _ _ _ _ _ _");
                System.out.println("                                        | /         |");
                System.out.println("                                        |         (°_°)");
                System.out.println("                                        |           |");
                System.out.println("                                        |           |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                              _ _ _ _ _ | _ _ _ _ _\n");
                break;
            case 1:
                System.out.println("\n                                       _ _ _ _ _ _ _");
                System.out.println("                                        | /         |");
                System.out.println("                                        |         (°_°)");
                System.out.println("                                        |         --|");
                System.out.println("                                        |           |");
                System.out.println("                                        |          / ");
                System.out.println("                                        |");
                System.out.println("                                        |");
                System.out.println("                              _ _ _ _ _ | _ _ _ _ _\n");
                break;
            default:
                break;
        }
    }

    public void playAgainMessage() {
        System.out.print("\n\n----------------------- Play again? (Y/N): ");
    }

    public void invalidInput() {
        System.out.print("\n\n================================      Your input is not valid, please insert Y or N      ================================\n");
    }

    public void updatedResult(String[] guessArr, int lives) {
        System.out.print(Arrays.toString(guessArr)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", " ") + "               Lives left: " + lives + "               Guess the next letter: ");
    }

}

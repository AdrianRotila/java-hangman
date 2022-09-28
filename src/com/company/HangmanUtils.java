package com.company;

import java.util.ArrayList;
import java.util.Random;

public class HangmanUtils {

    private static ArrayList<String> words = new ArrayList<>();
    private static Random RANDOM = new Random();

    static {
        words.add("BOXFUL");
        words.add("BUCKAROO");
        words.add("BUFFALO");
        words.add("JACKPOT");
        words.add("JAUNDICE");
        words.add("JAWBREAKER");
        words.add("JAYWALK");
        words.add("JAZZIEST");
        words.add("PSHAW");
        words.add("PSYCHE");
        words.add("PUPPY");
        words.add("PUZZLING");
        words.add("QUARTZ");
    }

    public static String generateWord() {
        return words.get(RANDOM.nextInt(words.size()));
    }
}

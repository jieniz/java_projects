/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a6_task2;

import java.util.ArrayList;

/**
 * generate sentences by random-number generation
 *
 * @author jieni
 */
public class RandomSentence {

    /**
     * the array list of Strings containing articles
     */
    public static ArrayList<String> article = new ArrayList<String>();

    /**
     * the array list of Strings containing nouns
     */
    public static ArrayList<String> noun = new ArrayList<String>();

    /**
     * the array list of Strings containing verbs
     */
    public static ArrayList<String> verb = new ArrayList<String>();

    /**
     * the array list of Strings containing prepositions
     */
    public static ArrayList<String> preposition = new ArrayList<String>();

    /**
     * initialize four array lists in the no-argument constructor
     */
    public RandomSentence() {
        article.add("the");
        article.add("a");
        article.add("one");
        article.add("some");
        article.add("any");

        noun.add("boy");
        noun.add("girl");
        noun.add("dog");
        noun.add("town");
        noun.add("car");

        verb.add("drove");
        verb.add("jumped");
        verb.add("ran");
        verb.add("walked");
        verb.add("skipped");

        preposition.add("to");
        preposition.add("from");
        preposition.add("over");
        preposition.add("under");
        preposition.add("on");
    }

    /**
     * generate a paragraph with 20 sentences.
     *
     * @return String of a paragraph
     */
    public String createParagraph() {
        System.out.println("Generate 20 sentences and append them all as a story: \n");
        String s = RandomSentence.createSentence();
        for (int i = 0; i < 19; i++) {
            s = s.concat(" " + RandomSentence.createSentence());
        }
        return s;
    }

    /**
     * generate a sentence with 6 words.
     *
     * @return String of a sentence
     */
    public static String createSentence() {
        String s0 = article.get(RandomSentence.createRandom());
        String s = s0.substring(0, 1).toUpperCase() + s0.substring(1);
        s = s.concat(" " + noun.get(RandomSentence.createRandom()));
        s = s.concat(" " + verb.get(RandomSentence.createRandom()));
        s = s.concat(" " + preposition.get(RandomSentence.createRandom()));
        s = s.concat(" " + article.get(RandomSentence.createRandom()));
        s = s.concat(" " + noun.get(RandomSentence.createRandom()) + ".");
        return s;
    }

    /**
     * generate a random integer from 0 to 4
     *
     * @return
     */
    public static int createRandom() {
        return (int) (Math.random() * 5);
    }
}

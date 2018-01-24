/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * contains up to 25 questions and several methods that can add a question, give
 * quiz to an user, accept answers and give results
 *
 * @author jieni
 */
public class Quiz {

    private ArrayList<Question> quiz = new ArrayList<Question>();//an arraylist that composed of question objects

    private String[] userAnswer = new String[25];//an array that contains 25 strings collecting answers of each questions from an user

    /**
     * add a question to Quiz class.
     *
     * @param q the added question object
     */
    public void add(Question q) {
        if (quiz.size() <= 25) {//quiz class contains up to 25 questions
            quiz.add(q);//use add method of ArrayList to add questions one by one
        } else {
            System.out.println("Sorry, the number of the question is up to 25, you cannot add another question.");
        }
    }

    /**
     * present each question in turn to the user, accept an answer for each one,
     * and keep track of the results.
     */
    public void giveQuiz() {
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.get(i).getQuestion());//present question to the user and ask the user to type answers
            Scanner scanner = new Scanner(System.in);
            userAnswer[i] = scanner.nextLine();//store the answer from the user into an array
        }
    }

    /**
     * present questions in a specific range of complexity in turn to the user,
     * accept an answer for each one, and keep track of the results.
     *
     * @param minLevel the minimum level of complexity
     * @param maxLevel the maximum level of complexity
     */
    public void giveQuiz(int minLevel, int maxLevel) {
        for (int i = 0; i < quiz.size(); i++) {
            if (quiz.get(i).getComplexity() >= minLevel && quiz.get(i).getComplexity() <= maxLevel) {//only give questions within the range
                System.out.println(quiz.get(i).getQuestion());
                Scanner scanner = new Scanner(System.in);
                userAnswer[i] = scanner.nextLine();
            }
        }
    }

    /**
     * print the final results of the quiz.
     */
    public void result() {
        int correctNumber = 0;
        int totalNumber = 0;
        for (int i = 0; i < quiz.size(); i++) {
            if (quiz.get(i).answerCorrect(userAnswer[i])) {
                correctNumber++;//calculate the number of correct answers
            }
            totalNumber++;
        }
        System.out.println("\nResults:\n" + "    Correct: " + correctNumber + "    Incorrect:  " + (totalNumber - correctNumber));
    }

    /**
     * print the final results of part of the quiz in a specific complexity
     * range.
     *
     * @param minLevel the minimum level of complexity
     * @param maxLevel the maximum level of complexity
     */
    public void result(int minLevel, int maxLevel) {
        int correctNumber = 0;
        int totalNumber = 0;
        for (int i = 0; i < quiz.size(); i++) {
            if (quiz.get(i).getComplexity() >= minLevel && quiz.get(i).getComplexity() <= maxLevel) {//within a complexity range
                if (quiz.get(i).answerCorrect(userAnswer[i])) {
                    correctNumber++;
                }
                totalNumber++;
            }
        }
        System.out.println("\nResults:\n" + "    Correct: " + correctNumber + "    Incorrect:  " + (totalNumber - correctNumber));
    }
}

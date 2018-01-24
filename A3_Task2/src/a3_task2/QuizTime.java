/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

import java.util.Scanner;

/**
 * present a quiz for the user with flexible complexity range and give results.
 *
 * @author jieni
 */
public class QuizTime {

    /**
     * ask the user to choose a complexity range or not, present questions,
     * accept answers and give results.
     *
     * @param args main method
     */
    public static void main(String[] args) {
        Quiz quiz = new Quiz();//create a new object quiz from Quiz class

        Question q1 = new Question("What room has no walls, no doors, no windows, and no floors?", "mushroom");//add 15 questions
        q1.setComplexity(4);
        quiz.add(q1);

        Question q2 = new Question("What's too much for one, just right for two, but nothing at all for three?", "secret");
        q2.setComplexity(5);
        quiz.add(q2);

        Question q3 = new Question("What animal has a head like a cat, eyes like a cat, a tail like a cat, but isn't a cat? ", "kitty");
        q3.setComplexity(3);
        quiz.add(q3);

        Question q4 = new Question("What is the square of 6?", "36");
        q4.setComplexity(1);
        quiz.add(q4);

        Question q5 = new Question("What can hear you without ears and can answer you without a mouth? ", "echo");
        q5.setComplexity(4);
        quiz.add(q5);

        Question q6 = new Question("What do you know about the kings of France? ", "all dead");
        q6.setComplexity(5);
        quiz.add(q6);

        Question q7 = new Question("Which is the first country in Asia to hold the Olympic game?", "japan");
        q7.setComplexity(2);
        quiz.add(q7);

        Question q8 = new Question("In which state Hollywood lie in?", "california");
        q8.setComplexity(2);
        quiz.add(q8);

        Question q9 = new Question("What is the color of panda’s tail?", "white");
        q9.setComplexity(3);
        quiz.add(q9);

        Question q10 = new Question("What will you break once you say it?", "silence");
        q10.setComplexity(5);
        quiz.add(q10);

        Question q11 = new Question("What always goes up and never goes down? ", "age");
        q11.setComplexity(4);
        quiz.add(q11);

        Question q12 = new Question("what kind of dog never bite?", "hotdog");
        q12.setComplexity(3);
        quiz.add(q12);

        Question q13 = new Question("Which is the first day of a week ?", "sunday");
        q13.setComplexity(2);
        quiz.add(q13);

        Question q14 = new Question("What is the result of (int)(100.0/25)？", "4");
        q14.setComplexity(1);
        quiz.add(q14);

        Question q15 = new Question("What two words have thousands of letters in them? ", "post office");
        q15.setComplexity(5);
        quiz.add(q15);

        System.out.print("----------------------JIENI'S QUIZ TIME WITH COMPLEXITY CUSTOMIZATION----------------------\n"
                + "#####Quiz questions range from a minimum difficulty level of 1 to max difficulty level of 5.\n"
                + "#####You should answer all questions in lower-case letters or numbers instead of capitals.\n"
                + "#####Decide if you want a random quiz or else provide a range to produce quiz questions.\n\n"
                + "Enter 1 for random quiz, 2 for customized quiz, 0 to quit: ");//titles of the quiz

        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();//get the answer whether the user wants to choose a complexity range
        while (type != 0 && type != 1 && type != 2) {//when the user inputs the wrong number, ask them to enter again
            System.out.print("Your have entered a wrong number, please enter again.\n"
                    + "Enter 1 for random quiz, 2 for customized quiz, 0 to quit: ");
            type = scanner.nextInt();
        }
        if (type == 1) {//if the input is 1, give quiz of all questions and then give results
            System.out.println("Let's go!\n");
            quiz.giveQuiz();
            quiz.result();
        } else if (type == 2) {//if the input is 2, ask the user to choose the range and then give questions only within the range and return results within the range as well.
            System.out.print("Please enter the minimum complexity level(from 1 to 5): ");
            int min = scanner.nextInt();
            System.out.print("Please enter the maximum complexity level(from 1 to 5): ");
            int max = scanner.nextInt();
            System.out.println("Let's go!\n");
            quiz.giveQuiz(min, max);
            quiz.result(min, max);
        }//otherwise(input is 0), end the program
    }

}

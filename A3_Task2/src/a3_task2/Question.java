  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task2;

/**
 * the class of question including fields of question, answer and complexity level and
 * related operations as well
 *
 * @author Murli
 */
public class Question {

    private String question, answer;
    private int complexityLevel;

    /**
     * a constructor that takes two parameters that sets up the question with a
     * default complexity.
     *
     * @param query the string of question
     * @param result the string of answer
     */
    public Question(String query, String result) {
        question = query;
        answer = result;
        complexityLevel = 1;
    }

    /**
     * Sets the complexity level for this question.
     *
     * @param level the value of complexity level
     */
    public void setComplexity(int level) {
        complexityLevel = level;
    }

    /**
     * Returns the complexity level for this question.
     *
     * @return the value of complexity level
     */
    public int getComplexity() {
        return complexityLevel;
    }

    /**
     * Returns the question.
     *
     * @return the string of question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer to this question.
     *
     * @return the string of answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns true if the candidate answer matches the answer.
     *
     * @param candidateAnswer the answer from the candidate
     * @return true if the answer is correct; otherwise, false
     */
    public boolean answerCorrect(String candidateAnswer) {
        return answer.equals(candidateAnswer);
    }

    /**
     * Returns this question (and its answer) as a string.
     *
     * @return the string of question and answer
     */
    public String toString() {
        return question + "\n" + answer;
    }

}

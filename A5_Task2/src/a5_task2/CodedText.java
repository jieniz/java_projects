/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task2;

/**
 * The CodedText Class translate text to a special coded language as an output.
 *
 * @author jieni
 */
public class CodedText {

    private char c = 'c';
    private final char[] lowConsonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private final char[] upperConsonant = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    private final char[] lowVowel = {'a', 'e', 'i', 'o', 'u'};
    private final char[] upperVowel = {'A', 'E', 'I', 'O', 'U'};

    /**
     * translate input String into a coded text
     *
     * @param text the text that user inputs
     * @return coded text
     */
    public String translation(String text) {
        String codeText = null;
        int check = 0;
        for (int i = 0; i < 21; i++) {
            if (text.charAt(0) == lowConsonant[i] || text.charAt(0) == upperConsonant[i]) {//if the first character is consonant
                char[] charText = text.toCharArray();//convert String to char array
                char first = charText[0];
                for (int j = 0; j < charText.length - 1; j++) {
                    charText[j] = charText[j + 1];//move the leading consonant to the end of the word
                }
                charText[charText.length - 1] = first;
                codeText = String.valueOf(charText);//convert char array to string
                codeText = codeText.concat("ay");//add "ay"
                check = 1;
            }
        }
        if (check != 1) {
            for (int i = 0; i < 5; i++) {
                if (text.charAt(0) == lowVowel[i] || text.charAt(0) == upperVowel[i]) {//if the first character is vowel
                    codeText = text.concat("way");//add "way"
                    check = 1;
                }
            }
            if (check != 1) {//if the first character is neither consonant or vowel
                codeText = text;//remain the same
            }
        }

        return codeText;
    }
}

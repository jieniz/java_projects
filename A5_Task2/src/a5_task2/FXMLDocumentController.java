/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a5_task2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The controller handles the button for translation, which takes the text from
 * above box as input and output in the bottom box.
 *
 * @author jieni
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;//the FXML "TRANSLATION" button
    @FXML
    private TextField text;//the above text field as input, editable
    @FXML
    private TextField transText;//the bottom text field as output, not editable

    /**
     * The action of translation text into a coded one triggered by pushing the
     * "TRANSLATION" button,
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String text1 = text.getText();//get the content of above text field as input
        CodedText codedtext = new CodedText();//create an instance of class CodedText
        transText.setText(codedtext.translation(text1));//set the output text in the bottom text filed
        text.setText("");//clear the above text field
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

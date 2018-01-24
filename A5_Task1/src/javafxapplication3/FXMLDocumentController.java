/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The actions triggered by buttons about Staff table
 * @author jieni
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button displayButton;//"Display All Records" button
    @FXML
    private TextArea record;//text area at the right, not editable
    @FXML
    private Label menuLabel;//"MAIN MENU" label
    @FXML
    private MenuItem info1;//menu item of "staff displayed by position"
    @FXML
    private MenuItem info2;//menu item of "staff earning the lease salaries"
    @FXML
    private MenuItem info3;//menu item of "staff earning the highest salaries"
    @FXML
    private MenuItem info4;//menu item of "staff earning above average salaries"
    @FXML
    private MenuItem info5;//menu item of "staff earning more than $55000"
    @FXML
    private TextField text1;//text field to input first name
    @FXML
    private TextField text2;//text field to input last name
    @FXML
    private TextField text3;//text field to input position
    @FXML
    private TextField Text4;//input salary, integer
    @FXML
    private TextField Text5;//input age, integer
    @FXML
    private Label warning;
    @FXML
    private Button dataButton;
    @FXML
    private Button chartButton;
    @FXML
    private AnchorPane textPane;
    @FXML
    private BarChart<?, ?> chart;//salary bar chart
    @FXML
    private NumberAxis y;//y axis of salary chart
    @FXML
    private CategoryAxis x;//x axis of salary chart

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * display all records from Staff table
     * @param event click the "Display All Records" button
     */

    @FXML
    private void handleDisplayButton(ActionEvent event) {

        record.setVisible(true);//set text area is visible
        Staff staff = new Staff();
        staff.init();
        String s = staff.display();//get values of string
        record.setText(s);//display them on the text field
        staff.close();

    }

    /**
     * display all records from Staff table by Position
     * @param event click on the first item of menu item
     */
    @FXML
    private void HandleInfo1(ActionEvent event) {
        record.setVisible(true);

        Staff staff = new Staff();
        staff.init();
        String s = staff.displayByPosition();
        record.setText(s);
        staff.close();

    }

    /**
     * display staff records from Staff table who earns the least salaries
     * @param event click on the second item of menu item
     */
    @FXML
    private void HandleInfo2(ActionEvent event) {
        record.setVisible(true);

        Staff staff = new Staff();
        staff.init();
        String s = staff.printMinSalary();
        record.setText(s);
        staff.close();

    }

    /**
     * display staff records from Staff table who earn the highest salaries
     * @param event click on the third item of menu item
     */
    @FXML
    private void HandleInfo3(ActionEvent event) {
        record.setVisible(true);

        Staff staff = new Staff();
        staff.init();
        String s = staff.printMaxSalary();
        record.setText(s);
        staff.close();

    }

    /**
     * display records from Staff table who earn above average salaries
     * @param event click on the fourth item of menu item
     */
    @FXML
    private void HandleInfo4(ActionEvent event) {
        record.setVisible(true);

        Staff staff = new Staff();
        staff.init();
        String s = staff.printAveSalary();
        record.setText(s);
        staff.close();

    }

    /**
     * display records from Staff table who earn above $55000 salaries
     * @param event click on the fifth item of menu item
     */
    @FXML
    private void HandleInfo5(ActionEvent event) {
        record.setVisible(true);

        Staff staff = new Staff();
        staff.init();
        String s = staff.printAboveSalary();
        record.setText(s);
        staff.close();

    }

    /**
     * enter new data to Staff table from inputs
     * @param event click on the "Enter Data" button
     */
    @FXML
    private void HandleDataButton(ActionEvent event) {
        record.setVisible(true);

        boolean b = true;
        if ("".equals(text1.getText()) || "".equals(text2.getText()) || "".equals(text3.getText()) || "".equals(Text4.getText()) || "".equals(Text5.getText())) {
            warning.setText("Input cannot be empty.");//if any of the five is empty, ask the user to input
        } else {
            try {
                int salary = Integer.parseInt(Text4.getText());
                int age = Integer.parseInt(Text5.getText());
            } catch (NumberFormatException e) {
                System.out.println(e);//if the fourth and fifth are not integer, ask user to try again
                b = false;
            }
            if (!b) {
                warning.setText("Salary and Age have to be integers.");
            } else {
                int salary = Integer.parseInt(Text4.getText());
                int age = Integer.parseInt(Text5.getText());

                if (salary < 0 || salary > 200000) {
                    warning.setText("The range of salary is 0 to 200000.");//if out of the range of salary, warn the user
                } else if (age < 0 || age > 100) {
                    warning.setText("The range of age is 0 to 100.");//if put of the range of age, warn the user
                } else {
                    warning.setText("");
                    Staff staff = new Staff();
                    staff.init();
                    staff.enterData(text1.getText(), text2.getText(), text3.getText(), salary, age);//pass inputs
                    staff.close();
                    record.setText("Enter data successfully.");
                    text1.setText("");//clear the input text fields
                    text2.setText("");
                    text3.setText("");
                    Text4.setText("");
                    Text5.setText("");
                }
            }
        }
    }

    /**
     * display a bar chart from Staff table showing average salary for each position
     * @param event a bar chart
     */
    @FXML
    private void HandleChartButton(ActionEvent event) {
        record.setVisible(false);//set the text area invisible
        Staff staff = new Staff();
        staff.init();

        XYChart.Series salary = new XYChart.Series<>();
        salary.getData().add(new XYChart.Data("Engineer", staff.getSalary1()));//insert values to the bar chart
        salary.getData().add(new XYChart.Data("Clerk", staff.getSalary2()));
        salary.getData().add(new XYChart.Data("Cook", staff.getSalary3()));
        salary.getData().add(new XYChart.Data("Technician", staff.getSalary4()));
        salary.getData().add(new XYChart.Data("Mechanic", staff.getSalary5()));
        salary.getData().add(new XYChart.Data("Doctor", staff.getSalary6()));

        chart.getData().addAll(salary);
        staff.close();

    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class Controller {

    @FXML
    private Tab tab1;

    @FXML
    private Button button1;

    @FXML
    private TextField textfield1;

    @FXML
    private TextArea textarea1;


    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    void oneButtonOnePress(ActionEvent event)  {


        try {
            Databasemanager pm = new Databasemanager();


            pm.selectAll(textfield1.getText());
            String nameValue = pm.getNameF();
            textarea1.setText(nameValue);
            System.out.println(nameValue);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}

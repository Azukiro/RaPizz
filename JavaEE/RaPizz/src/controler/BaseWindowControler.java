package controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.MainView;

public class BaseWindowControler {

    @FXML
    private Button orderInputWindowButton;

    @FXML
    private Button orderHistoryWindowButton;

    @FXML
    private Button statisticsWindowButton;

    @FXML
    void switchToOrderHistoryWindow(ActionEvent event) throws IOException {
    	MainView.changeScene((Stage)orderHistoryWindowButton.getScene().getWindow(), "OrderHistory.fxml");
    }

    @FXML
    void switchToOrderInputWindow(ActionEvent event) throws IOException {
    	MainView.changeScene((Stage)orderHistoryWindowButton.getScene().getWindow(), "Command.fxml");
    }

    @FXML
    void switchToStatisticsWindow(ActionEvent event) {
    	
    }

}

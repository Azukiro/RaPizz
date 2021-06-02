package controler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StatisticsControler {

    @FXML
    private TextField bestClientTF;

    @FXML
    private TextField worstDeliveryGuyTF;

    @FXML
    private TextField worstVehicleTF;

    @FXML
    private TextField bestPizzaTF;

    @FXML
    private TextField bestIngredientTF;

    @FXML
    private TextField averageOrderCountTF;

    @FXML
    private ListView<?> orderCountByClientTV;

    @FXML
    private ListView<?> neverUsedVehiclesTV;

    @FXML
    private ListView<?> clientWithOrderCountSuperiorToAverageTV;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }

}

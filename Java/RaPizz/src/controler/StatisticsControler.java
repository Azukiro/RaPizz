package controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;
import model.DeliveryGuy;
import model.SQLManager;
import model.Vehicle;

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
    private ListView<Vehicle> neverUsedVehiclesTV;

    @FXML
    private ListView<Client> clientWithOrderCountSuperiorToAverageTV;
    
	public void initialize() throws SQLException {
		 Map.Entry<DeliveryGuy,Vehicle> entry = SQLManager.getInstance().worthDeliveryGuy().entrySet().iterator().next();
		 DeliveryGuy key = entry.getKey();
		 Vehicle value = entry.getValue();
		bestIngredientTF.setText(SQLManager.getInstance().favoriteIngredient().toString());
    	worstDeliveryGuyTF.setText(key.toString());
    	worstVehicleTF.setText(value.toString());
    	System.out.println(value.toString());
    	averageOrderCountTF.setText(Double.toString(SQLManager.getInstance().getAvgCommand()));
    	averageOrderCountTF.setText(Double.toString(SQLManager.getInstance().getAvgCommand()));
    	ArrayList<Vehicle> uselessVehicles = SQLManager.getInstance().uselessVehicles();
    	ObservableList<Vehicle> obl_uselessVehicles = FXCollections.observableArrayList(uselessVehicles);
    	neverUsedVehiclesTV.setItems(obl_uselessVehicles);
    	ArrayList<Client> moreThanAvg = SQLManager.getInstance().clientsCommandMoreThanAvg();
    	ObservableList<Client> obl_moreThanAvg = FXCollections.observableArrayList(moreThanAvg);
    	clientWithOrderCountSuperiorToAverageTV.setItems(obl_moreThanAvg);
    }

}

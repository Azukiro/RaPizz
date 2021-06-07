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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Client;
import model.ClientCountOrder;
import model.DeliveryGuy;
import model.SQLManager;
import model.Vehicle;

public class StatisticsControler {

    @FXML
    private Label bestClientLB;

    @FXML
    private Label worstDeliveryGuyLB;

    @FXML
    private Label worstVehicleLB;

    @FXML
    private Label bestPizzaLB;

    @FXML
    private Label bestIngredientLB;

    @FXML
    private Label averageOrderCountLB;

    @FXML
    private ListView<ClientCountOrder> orderCountByClientTV;

    @FXML
    private ListView<Vehicle> neverUsedVehiclesTV;

    @FXML
    private ListView<Client> clientWithOrderCountSuperiorToAverageTV;
    
	public void initialize() throws SQLException {
		Map.Entry<DeliveryGuy,Vehicle> entry = SQLManager.getInstance().worthDeliveryGuy().entrySet().iterator().next();
		DeliveryGuy key = entry.getKey();
		Vehicle value = entry.getValue();
		bestIngredientLB.setText(SQLManager.getInstance().favoriteIngredient().toString());
		worstDeliveryGuyLB.setText(key.toString());
		worstVehicleLB.setText(value.toString());
		
		bestClientLB.setText(SQLManager.getInstance().bestClient().toString());
		bestPizzaLB.setText(SQLManager.getInstance().bestPizza().toString());
		
		averageOrderCountLB.setText(String.format("%.2f", SQLManager.getInstance().getAvgCommand()));
		
		ArrayList<Vehicle> uselessVehicles = SQLManager.getInstance().uselessVehicles();
		ObservableList<Vehicle> obl_uselessVehicles = FXCollections.observableArrayList(uselessVehicles);
		neverUsedVehiclesTV.setItems(obl_uselessVehicles);
		
		ArrayList<Client> moreThanAvg = SQLManager.getInstance().clientsCommandMoreThanAvg();
		ObservableList<Client> obl_moreThanAvg = FXCollections.observableArrayList(moreThanAvg);
		clientWithOrderCountSuperiorToAverageTV.setItems(obl_moreThanAvg);
		
		ArrayList<ClientCountOrder> countPerclients = SQLManager.getInstance().countCommandPerClient();
		ObservableList<ClientCountOrder> obl_countPerclients = FXCollections.observableArrayList(countPerclients);
		orderCountByClientTV.setItems(obl_countPerclients);
		orderCountByClientTV.setCellFactory((Callback<ListView<ClientCountOrder>, ListCell<ClientCountOrder>>) new Callback<ListView<ClientCountOrder>, ListCell<ClientCountOrder>>() {
		
			    @Override 
			    public ListCell<ClientCountOrder> call(ListView<ClientCountOrder> list) {
			        ListCell<ClientCountOrder> cell = new ListCell<ClientCountOrder>() {
			            @Override
			            public void updateItem(ClientCountOrder item, boolean empty) {
			                super.updateItem(item, empty);
			                if (item != null) {
			                    setText(item.getClient().getFullName()+" ["+item.getCountOrder()+"]");
			                }
			            }
			        };
			
			        return cell;
			    }
			}
		);
    }

}

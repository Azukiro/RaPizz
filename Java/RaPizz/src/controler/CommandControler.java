package controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.Client;
import model.DeliveryGuy;
import model.SQLManager;
import model.Vehicle;

public class CommandControler {

	@FXML
	private FlowPane fp_pizzas;
	
	@FXML
	private ListView<DeliveryGuy> lv_delivryguys;
	
	@FXML
	private ListView<Vehicle> lv_vehicles;
	
	@FXML
	private ListView<Client> lv_clients;
	
	
	public void initialize() throws SQLException {
		
		ArrayList<Vehicle> vehicles = SQLManager.getInstance().getVehicles();
		ObservableList<Vehicle> obl_vehicles = FXCollections.observableArrayList(vehicles);
		lv_vehicles.setItems(obl_vehicles);
		lv_vehicles.setCellFactory((Callback<ListView<Vehicle>, ListCell<Vehicle>>) new Callback<ListView<Vehicle>, ListCell<Vehicle>>() {

	            @Override 
	            public ListCell<Vehicle> call(ListView<Vehicle> list) {
	                ListCell<Vehicle> cell = new ListCell<Vehicle>() {
	                    @Override
	                    public void updateItem(Vehicle item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (item != null) {
	                            setText(item.getLabel()+" ["+item.getType()+"]");
	                        }
	                    }
	                };
	
	                return cell;
	            }
	        }
	    );
			
		ArrayList<Client> clients = SQLManager.getInstance().getClients();
		ObservableList<Client> obl_clients = FXCollections.observableArrayList(clients);
		lv_clients.setItems(obl_clients);
		lv_clients.setCellFactory((Callback<ListView<Client>, ListCell<Client>>) new Callback<ListView<Client>, ListCell<Client>>() {
	            @Override 
	            public ListCell<Client> call(ListView<Client> list) {
	                ListCell<Client> cell = new ListCell<Client>() {
	                    @Override
	                    public void updateItem(Client item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (item != null) {
	                            setText(item.getFirstName()+" "+item.getLastName());
	                        }
	                    }
	                };
	
	                return cell;
	            }
	        }
	    );
		
		ArrayList<DeliveryGuy> deliveryGuys = SQLManager.getInstance().getDeliveryGuys();
		ObservableList<DeliveryGuy> obl_deliveryGuys = FXCollections.observableArrayList(deliveryGuys);
		lv_delivryguys.setItems(obl_deliveryGuys);
		lv_delivryguys.setCellFactory((Callback<ListView<DeliveryGuy>, ListCell<DeliveryGuy>>) new Callback<ListView<DeliveryGuy>, ListCell<DeliveryGuy>>() {
	            @Override 
	            public ListCell<DeliveryGuy> call(ListView<DeliveryGuy> list) {
	                ListCell<DeliveryGuy> cell = new ListCell<DeliveryGuy>() {
	                    @Override
	                    public void updateItem(DeliveryGuy item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (item != null) {
	                            setText(item.getFirstName()+" "+item.getLastName());
	                        }
	                    }
	                };
	
	                return cell;
	            }
	        }
	    );
	}
}

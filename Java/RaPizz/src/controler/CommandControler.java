package controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import model.Client;
import model.DeliveryGuy;
import model.Pizza;
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
	
	@FXML
	private Button bt_command;
	
	public void initialize() throws SQLException {
		
		//Init Vehicles
		ArrayList<Vehicle> vehicles = SQLManager.getInstance().getVehicles();
		ObservableList<Vehicle> obl_vehicles = FXCollections.observableArrayList(vehicles);
		lv_vehicles.setItems(obl_vehicles);
		
		//Change cell visual
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
		
		//Init Clients
		ArrayList<Client> clients = SQLManager.getInstance().getClients();
		ObservableList<Client> obl_clients = FXCollections.observableArrayList(clients);
		lv_clients.setItems(obl_clients);
		
		//Change cell visual
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
		
		//Init DeliveryGuys
		ArrayList<DeliveryGuy> deliveryGuys = SQLManager.getInstance().getDeliveryGuys();
		ObservableList<DeliveryGuy> obl_deliveryGuys = FXCollections.observableArrayList(deliveryGuys);
		lv_delivryguys.setItems(obl_deliveryGuys);
		
		//Change cell visual
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
		
		//init flowpane of Pizzas
		Collection<Pizza> pizzas = SQLManager.getInstance().getPizzas();
		ToggleGroup group = new ToggleGroup();
		for (Pizza pizza : pizzas) {
			RadioButton rectangle = new RadioButton(pizza.getLabel());
			rectangle.setUserData(pizza);
			rectangle.setToggleGroup(group);
			fp_pizzas.getChildren().add(rectangle);
		}
		
		//Set action for command a pizza
		bt_command.setOnAction((event)->{
			RadioButton resultButton = (RadioButton)group.getSelectedToggle();
			Pizza pizza = resultButton != null ? (Pizza)resultButton.getUserData() : null;
			Client client = lv_clients.getSelectionModel().getSelectedItem();
			Vehicle vehicle =lv_vehicles.getSelectionModel().getSelectedItem();
			DeliveryGuy deliveryGuy =lv_delivryguys.getSelectionModel().getSelectedItem();
			//Check if all information are give 
			if(pizza == null || client == null || vehicle ==null || deliveryGuy ==null) {
				System.out.println("Tout les champs ne sont pas remplies");
				return;
			}else {
				try {
					SQLManager.getInstance().insertOrder(pizza, client, vehicle, deliveryGuy);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
}

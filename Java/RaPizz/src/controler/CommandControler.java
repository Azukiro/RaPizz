package controler;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
		
		ArrayList<Pizza> pizzas = SQLManager.getInstance().getPizzas();
		ToggleGroup group = new ToggleGroup();
		for (Pizza pizza : pizzas) {
			RadioButton rectangle = new RadioButton(pizza.getLabel());
			rectangle.setUserData(pizza);
			rectangle.setToggleGroup(group);
			/*BorderPane root = new BorderPane();
			root.setPrefWidth(100.0);

			root.setPrefHeight(100.0);
			root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
					BorderWidths.DEFAULT)));
			root.setTop(new Label(pizza.getLabel()));
			BorderPane.setAlignment(root.getTop(), Pos.CENTER);
			ImageView view = new ImageView();
			view.prefHeight(75.0);
			view.prefWidth(75.0);
			view.setFitHeight(75.0);
			view.setFitWidth(75.0);
			view.setImage(new Image(new FileInputStream("Pictures/pizza.png"),75.0, 75.0, false, false);
			root.setCenter(view);

			BorderPane.setAlignment(root.getCenter(), Pos.CENTER);
			rectangle.setOnMouseClicked(event);*/
			fp_pizzas.getChildren().add(rectangle);
		}
		
		bt_command.setOnAction((event)->{
			RadioButton resultButton = (RadioButton)group.getSelectedToggle();
			Pizza pizza = resultButton != null ? (Pizza)resultButton.getUserData() : null;
			Client client = lv_clients.getSelectionModel().getSelectedItem();
			Vehicle vehicle =lv_vehicles.getSelectionModel().getSelectedItem();
			DeliveryGuy deliveryGuy =lv_delivryguys.getSelectionModel().getSelectedItem();
			if(pizza == null || client == null || vehicle ==null || deliveryGuy ==null) {
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

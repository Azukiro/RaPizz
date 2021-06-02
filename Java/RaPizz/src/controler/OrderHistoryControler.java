package controler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;
import model.DeliveryGuy;
import model.Order;
import model.Pizza;
import model.Vehicle;

public class OrderHistoryControler implements Initializable{

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, String> numCol;

    @FXML
    private TableColumn<Order, Date> orderTimeCol;

    @FXML
    private TableColumn<Order, Date> deliveryTimeCol;

    @FXML
    private TableColumn<Order, Client> clientNameCol;

    @FXML
    private TableColumn<Order, DeliveryGuy> deliveryGuyCol;

    @FXML
    private TableColumn<Order, Pizza> pizzaCol;

    @FXML
    private TableColumn<Order, Vehicle> vehicleCol;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	numCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	orderTimeCol.setCellValueFactory(new PropertyValueFactory<>("orderTime"));
    	deliveryTimeCol.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));
    	clientNameCol.setCellValueFactory(new PropertyValueFactory<>("client"));
    	deliveryGuyCol.setCellValueFactory(new PropertyValueFactory<>("deliveryGuy"));
    	pizzaCol.setCellValueFactory(new PropertyValueFactory<>("pizza"));
    	vehicleCol.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
    	table.setItems(getOrderList());
    }
    
    ObservableList<Order> getOrderList(){
    	ObservableList<Order> orders = FXCollections.observableArrayList();
    	Order o = new Order(1, new Pizza(1, "MaPizza", new ArrayList(), 10), new Client(1, "Fabien", "COURTOIS", "0457691356", "MonAdresse"), new DeliveryGuy(1, "LivreurP", "LivreurN", "0564534695"), new Vehicle(1, "Yaris", "Voiture"), new Date(), new Date());
    	for (int i = 0; i < 20; i++) {
    		orders.add(o);	
		}
    	return orders;
    }

}

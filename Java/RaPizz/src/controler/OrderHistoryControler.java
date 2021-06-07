package controler;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Client;
import model.DeliveryGuy;
import model.Order;
import model.Pizza;
import model.PizzaSize;
import model.SQLManager;
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
    	ArrayList<Order> orders;
    	ObservableList<Order> ordersObl;
		try {
			orders = SQLManager.getInstance().getOrders();
			ordersObl = FXCollections.observableArrayList(orders);
			return ordersObl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }

}

package application;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.SQLManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("RaPizz");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/base_window.fxml"));
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(Main.class.getResource("../view/Command.fxml"));
			BorderPane root = (BorderPane) loader.load();
			root.setCenter((BorderPane) loader2.load());
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {  
		
		
		
		launch(args);
	}
}

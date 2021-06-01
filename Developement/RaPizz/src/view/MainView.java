package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {
	
	private static MainView mainView= new MainView();
	
	public static void changeScene(Stage currentStage, String fxml) throws IOException {
	
    	BorderPane rootBorderPane = (BorderPane)currentStage.getScene().getRoot();
    	rootBorderPane.setCenter(FXMLLoader.load(mainView.getClass().getResource(fxml)));
	}
}

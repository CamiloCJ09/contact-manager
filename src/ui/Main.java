package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ContactManager;


public class Main extends Application{

	private ContactManagerGUI contactManagerGUI;
	private ContactManager contactManager;
	
	public Main() {
		contactManager = new ContactManager();
		contactManagerGUI = new ContactManagerGUI(contactManager);
	}
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("welcom.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcom.fxml"));
		fxmlLoader.setController(contactManagerGUI);
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}

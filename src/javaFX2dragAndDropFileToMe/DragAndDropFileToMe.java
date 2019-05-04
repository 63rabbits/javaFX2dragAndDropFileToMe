package javaFX2dragAndDropFileToMe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DragAndDropFileToMe extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(this.getClass().getResource("DragAndDropFileToMe.fxml"));
		Scene scene = new Scene(root);

		stage.setTitle("JavaFX 2 drag and drop file to me");

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

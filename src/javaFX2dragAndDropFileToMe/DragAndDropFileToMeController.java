package javaFX2dragAndDropFileToMe;

import java.io.File;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

public class DragAndDropFileToMeController {

	@FXML
	private AnchorPane ancp;

	@FXML
	private TextArea txa;

	@FXML
	void initialize() {
		assert ancp != null : "fx:id=\"ancp\" was not injected: check your FXML file 'DragAndDropFileToMe.fxml'.";
		assert txa != null : "fx:id=\"txa\" was not injected: check your FXML file 'DragAndDropFileToMe.fxml'.";

		ancp.setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent e) {
				if (e.getDragboard().hasFiles()) {
					ancp.setStyle("-fx-background-color: pink;");
				}
				e.consume();
			}
		});

		ancp.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent e) {
				Dragboard db = e.getDragboard();
				if (db.hasFiles()) {
					e.acceptTransferModes(TransferMode.COPY);
					e.consume();
				}
			}
		});

		ancp.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent e) {
				Dragboard db = e.getDragboard();
				boolean success = false;
				if (db.hasFiles()) {
					success = true;
					String filePath = null;
					for (File file : db.getFiles()) {
						filePath = file.getAbsolutePath();
						txa.appendText(filePath + "\n");
					}
				}
				e.setDropCompleted(success);
				e.consume();
			}
		});

		ancp.setOnDragExited(new EventHandler<DragEvent>() {
			public void handle(DragEvent e) {
				ancp.setStyle("-fx-background-color: white;");
				e.consume();
			}
		});

	}
}

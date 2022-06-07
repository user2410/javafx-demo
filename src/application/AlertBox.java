package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	Stage window;
	Button closeBtn;
	
	public AlertBox() {
		window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMaxWidth(800);
		
		closeBtn = new Button("Close");
		closeBtn.setOnAction(e -> window.close());
	}

	public void display(String title, String message) {
		window.setTitle(title);
		
		Label label1 = new Label(message);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, closeBtn);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 400, 400);
		window.setScene(scene);
		window.showAndWait();
	}
}

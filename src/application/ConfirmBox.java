package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	Stage window;
	boolean answer;
	
	public ConfirmBox() {
		window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMaxWidth(800);
		
	}

	public boolean display(String title, String message) {
		window.setTitle(title);
		
		Label label1 = new Label(message);
		
		Button btnYes = new Button("Yes");
		Button btnNo = new Button("No");
		
		btnYes.setOnAction(e -> {
			answer = true;
			window.close();
		});

		btnNo.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, btnYes, btnNo);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 400, 400);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}

}

package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			// Text field
			TextField userInput = new TextField();
			userInput.setMaxWidth(200);
			
			Label firstLabel = new Label("Welcome");
			Label secondLabel = new Label();
			HBox bottomText = new HBox(firstLabel, secondLabel);
			bottomText.setAlignment(Pos.CENTER);
			secondLabel.textProperty().bind(userInput.textProperty());
			
			VBox vbox = new VBox(10, userInput, bottomText);
			vbox.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(vbox, 300, 200);
			
			window.setScene(scene);
			window.setTitle("JavaFx demo");
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

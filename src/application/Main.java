package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Main extends Application {
	Stage window;
	Scene scene1, scene2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			Label label1 = new Label("Welcome to scene 1");
			Button button1 = new Button("Go to scene 2");
			button1.setOnAction(e -> window.setScene(scene2));
			
			Label label2 = new Label("Welcome to scene 2");
			Button button2 = new Button("Go to scene 1");
			button2.setOnAction(e -> window.setScene(scene1));
			
			// Layout 1 - childre are laid out in vertial column
			VBox layout1 = new VBox(20);	// spacing = 20
			layout1.getChildren().addAll(label1, button1);
			scene1 = new Scene(layout1, 200, 200);
			
			// Layout 2 - childre are laid out in vertial column
			StackPane layout2 = new StackPane();	// spacing = 20
			layout2.getChildren().addAll(label2, button2);
			scene2 = new Scene(layout2, 600, 300);
			
			window.setScene(scene1);
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

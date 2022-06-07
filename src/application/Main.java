package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	Stage window;
	static int times = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			AlertBox abox = new AlertBox();
			Button b1 = new Button("Click me");
			b1.setOnAction(e -> abox.display("You clicked me " + (times++), "Hey, I'm your little box"));

			StackPane layout = new StackPane();
			layout.getChildren().add(b1);
			
			Scene scene = new Scene(layout, 600, 400);
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

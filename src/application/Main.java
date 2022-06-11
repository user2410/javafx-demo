package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});
			
			ComboBox<String> cbox = new ComboBox<String>();
			cbox.getItems().addAll(
					"Good Will Hunting", 
					"St Vincent",
					"Blackhat"
			);
			cbox.setEditable(true);
			cbox.setPromptText("What's your favorite movie?");
			// An Event is emitted when user selects 
			cbox.setOnAction(e->System.out.println("User selected: " + cbox.getValue()));
			
			Button b = new Button("Click me");
			b.setOnAction(e->printMovie(cbox));
			
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(20, 20, 20, 20));
			layout.getChildren().addAll(cbox, b);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printMovie(ComboBox<String> cbox) {
		System.out.println(cbox.getValue());
	}
	
	private void closeProgram() {
		ConfirmBox cbox = new ConfirmBox();
		boolean answer = cbox.display("Title", "Are you sure want to close?");
		if(answer)
			window.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

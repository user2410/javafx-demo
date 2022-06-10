package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
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
			
			ChoiceBox<String> choiceBox = new ChoiceBox<String>();
			choiceBox.getItems().addAll("Apple", "Orange", "Grape");
			choiceBox.setValue("Apple");
			
			Button b1 = new Button("submit");
			b1.setOnAction(e->getChoice(choiceBox));
			
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(20, 20, 20, 20));
			layout.getChildren().addAll(choiceBox, b1);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getChoice(ChoiceBox<String> cb) {
		System.out.println(cb.getValue());		
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

package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
// import javafx.scene.layout.StackPane;
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
			
			// Form
			TextField inputField = new TextField();
			Button submitBtn = new Button("Submit");
			submitBtn.setOnAction(e -> {
				checkUserInput(inputField);
				System.out.println(inputField.getText());
			});

			VBox layout = new VBox(10);
			layout.setPadding(new Insets(10, 10, 10, 10));
			layout.getChildren().addAll(inputField, submitBtn);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkUserInput(TextField inputField) {
		String msg = inputField.getText();
		try {
			int num = Integer.parseInt(msg);
			System.out.println(num);
			return true;
		}catch(NumberFormatException e) {
			System.err.println(msg + "is not a number");
			return false;
		}
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

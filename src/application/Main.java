package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


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
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			
			Label nameLabel = new Label("Username: ");
			GridPane.setConstraints(nameLabel, 0, 0); // set position of node
			
			// TextField nameInput = new TextField("Name"); // default text
			TextField nameInput = new TextField();
			nameInput.setPromptText("username");
			GridPane.setConstraints(nameInput, 1, 0);

			Label passLabel = new Label("Password: ");
			GridPane.setConstraints(passLabel, 0, 1); // set position of node
			
			TextField passInput = new TextField();
			passInput.setPromptText("password");
			GridPane.setConstraints(passInput, 1, 1);
			
			Button loginBtn = new Button("Login");
			GridPane.setConstraints(loginBtn, 1, 2);
			
			grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginBtn);
			
			Scene scene = new Scene(grid, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
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

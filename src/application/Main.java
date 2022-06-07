package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

			HBox topMenu = new HBox();
			Button btn1 = new Button("File");
			Button btn2 = new Button("Edit");
			Button btn3 = new Button("View");
			topMenu.getChildren().addAll(btn1, btn2, btn3);

			VBox leftMenu = new VBox();
			Button btn4 = new Button("File1");
			Button btn5 = new Button("File2");
			Button btn6 = new Button("File3");
			leftMenu.getChildren().addAll(btn4, btn5, btn6);		

			BorderPane layout = new BorderPane();
			layout.setTop(topMenu);
			layout.setLeft(leftMenu);
			
			Scene scene = new Scene(layout, 600, 400);
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

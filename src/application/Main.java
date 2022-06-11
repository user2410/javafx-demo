package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
			
			ListView<String> list = new ListView<String>();
			list.getItems().addAll(
					"Iron man",
					"Titanic",
					"Contact",
					"Surrogate"
			);
			list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			Button b1 = new Button("Click me");
			b1.setOnAction(e->buttonClicked(list));
			
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(20, 20, 20, 20));
			layout.getChildren().addAll(list, b1);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void buttonClicked(ListView<String> list) {
		ObservableList<String> movies = list.getSelectionModel().getSelectedItems();
		
		for(String m : movies) {
			System.out.println(m);
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

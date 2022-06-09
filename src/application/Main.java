package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
			
			// checkboxes
			CheckBox cb1 = new CheckBox("Orange");
			CheckBox cb2 = new CheckBox("Apple");
			CheckBox cb3 = new CheckBox("Grape");
			
			cb2.setSelected(true);
			
			Button b1 = new Button("Order");
			b1.setOnAction(e->handleOptions(cb1, cb2, cb3));
			
			VBox layout = new VBox();
			layout.getChildren().addAll(cb1, cb2, cb3, b1);
			
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

	private void handleOptions(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
		String msg = "You ordered:\n";
		if(cb1.isSelected()) msg+= "Orange\n";
		if(cb2.isSelected()) msg+= "Apple\n";
		if(cb3.isSelected()) msg+= "Grape\n";
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

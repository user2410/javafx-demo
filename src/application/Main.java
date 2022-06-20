package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			Person pc = new Person("pc");
			pc.firstNameProperty().addListener((v, oldValue, newValue)->{
				System.out.println("new name: "+newValue);
				System.out.println("firstnameProperty: "+v);
				System.out.println("getfirstname: "+pc.getFirstName());
			});;
			
			Button submit = new Button("Submit");
			submit.setOnAction(e->pc.setFirstName(pc.getFirstName()=="pc" ? "th" : "pc"));
			
			StackPane layout = new StackPane();
			layout.getChildren().add(submit);
			
			Scene scene = new Scene(layout, 300, 200);
			
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

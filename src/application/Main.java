package application;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		// Drawing a Circle
		Circle circle = new Circle();

		// Setting the position of the circle
		circle.setCenterX(300.0f);
		circle.setCenterY(135.0f);

		// Setting the radius of the circle
		circle.setRadius(25.0f);

		// Setting the color of the circle
		circle.setFill(Color.BROWN);

		// Setting the stroke width of the circle
		circle.setStrokeWidth(20);

		// Setting the text
		Text text = new Text("Click on the middle section to change circle's color");

		// Setting the font of the text
		text.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		text.setFill(Color.CRIMSON);

		// setting the position of the text
		text.setX(150);
		text.setY(50);

		// Creating the mouse event handler
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.printf("getSceneX: %f, getSceneY: %f\n", e.getSceneX(), e.getSceneY());
				System.out.printf("getScreenX: %f, getScreenY: %f\n", e.getScreenX(), e.getScreenY());
				System.out.printf("getX: %f, getY: %f\n", e.getX(), e.getY());
				Paint p = circle.getFill();
				circle.setFill(p == Color.DARKSLATEBLUE ? Color.BROWN : Color.DARKSLATEBLUE);
			}
		};

		// Creating a Layout object
		BorderPane root = new BorderPane();
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(text, circle);
		root.setCenter(vbox);
		root.setTop(new TextField("Top"));
		root.setBottom(new TextField("Bottom"));
		root.setLeft(new TextField("Left"));
		root.setRight(new TextField("Right"));

		// Registering the event filter
		vbox.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		
		// Creating a scene object
		Scene scene = new Scene(root, 600, 300);

		// Setting the fill color to the scene
		scene.setFill(Color.LAVENDER);

		// Setting title to the Stage
		stage.setTitle("Event Filters Example");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
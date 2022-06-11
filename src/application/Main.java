package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

			
			TreeItem<String> root, branch1, branch2;
			
			root = new TreeItem<>();
			root.setExpanded(true);
			
			branch1 = makeBranch("b1", root);
			makeBranch("b11", branch1);
			makeBranch("b12", branch1);
			makeBranch("b13", branch1);
			
			branch2 = makeBranch("b2", root);
			makeBranch("b21", branch2);
			makeBranch("b22", branch2);
			
			TreeView<String> tree = new TreeView<String>(root);
			tree.setShowRoot(false);
			tree.getSelectionModel().selectedItemProperty().addListener(
					(v, oldVal, newVal)->System.out.println(newVal.getValue()));

			Button b1 = new Button("Close the program");

			VBox layout = new VBox(10);
			layout.setPadding(new Insets(20, 20, 20, 20));
			layout.getChildren().addAll(tree, b1);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private TreeItem<String> makeBranch(String name, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<String>(name);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
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

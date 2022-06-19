package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
//import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;


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
			
			// File menu
			Menu fileMenu = new Menu("_File");
			
			MenuItem newFile = new MenuItem("New project...");
			newFile.setOnAction(e->System.out.println("Create a new file"));
			fileMenu.getItems().add(newFile);
			fileMenu.getItems().add(new MenuItem("New module..."));
			fileMenu.getItems().add(new MenuItem("Import project..."));

			fileMenu.getItems().add(new SeparatorMenuItem());
			
			fileMenu.getItems().add(new MenuItem("Settings..."));
			fileMenu.getItems().add(new MenuItem("Project settings..."));

			fileMenu.getItems().add(new SeparatorMenuItem());
			
			fileMenu.getItems().add(new MenuItem("Exit..."));
			
			// Edit menu
			Menu editMenu = new Menu("_Edit");
			editMenu.getItems().add(new MenuItem("Cut"));
			editMenu.getItems().add(new MenuItem("Copy"));
			MenuItem pasteItem = new MenuItem("Paste");
			pasteItem.setOnAction(e->System.out.println("Paste some crap"));
			pasteItem.setDisable(true);
			editMenu.getItems().add(pasteItem);
			
			// Help menu
			Menu helpMenu = new Menu("_Help");
			CheckMenuItem showLines = new CheckMenuItem("Show line number");
			showLines.setOnAction(a->{
				if(showLines.isSelected()) {
					System.out.println("Display line numbers");
				}else {
					System.out.println("Hide line numbers");					
				}
			});
			
			CheckMenuItem autoSave = new CheckMenuItem("Autosave");
			autoSave.setSelected(true);
			
			helpMenu.getItems().addAll(showLines, autoSave);
			
			// Difficulty menu
			Menu difficulties = new Menu("_Difficulty");
			
			ToggleGroup diffToggle = new ToggleGroup();
			RadioMenuItem easy = new RadioMenuItem("Easy");
			easy.setSelected(true);
			RadioMenuItem medium = new RadioMenuItem("Medium");
			RadioMenuItem hard = new RadioMenuItem("Hard");
			
			easy.setToggleGroup(diffToggle);
			medium.setToggleGroup(diffToggle);
			hard.setToggleGroup(diffToggle);
			
			difficulties.getItems().addAll(easy, medium, hard);
			
			
			// Main menu bar
			MenuBar menubar = new MenuBar();
			menubar.getMenus().addAll(fileMenu, editMenu, difficulties, helpMenu);

			BorderPane layout = new BorderPane();
			layout.setTop(menubar);
			
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

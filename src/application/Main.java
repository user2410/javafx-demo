package application;
	
import application.product.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
			
			
			TableColumn<Product, String> nameCol = new TableColumn<>("Name");
			nameCol.setMinWidth(200);
			nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
			
			TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
			priceCol.setMinWidth(150);
			priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
			
			TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
			quantityCol.setMinWidth(100);
			quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			
			TextField nameInput = new TextField();
			nameInput.setPromptText("Name");
			
			TextField priceInput = new TextField();
			priceInput.setPromptText("Price");
			
			TextField quantityInput = new TextField();
			quantityInput.setPromptText("Quantity");
			
			TableView<Product> table = new TableView<>();
			table.setItems(getProduct());
			table.getColumns().addAll(nameCol, priceCol, quantityCol);

			// Buttons
			Button addBtn = new Button("Add");
			addBtn.setOnAction(e->addBtnClicked(table, nameInput, priceInput, quantityInput));
			Button delBtn = new Button("Delete");
			delBtn.setOnAction(e->delBtnClicked(table));
			
			HBox hBox = new HBox();
			hBox.setPadding(new Insets(10, 10, 10, 10));
			hBox.setSpacing(10);
			hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addBtn, delBtn);
			
			

			VBox layout = new VBox();
			layout.getChildren().addAll(table, hBox);
			
			Scene scene = new Scene(layout, 600, 400);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void delBtnClicked(TableView<Product> table) {
		ObservableList<Product> selectedProducts, allProducts;
		allProducts = table.getItems();
		selectedProducts = table.getSelectionModel().getSelectedItems();
		
		selectedProducts.forEach(allProducts::remove);
	}
	
	private void addBtnClicked(TableView<Product> table, TextField nameInput, TextField priceInput, TextField quantityInput) {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();	
	}
	
	private ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("laptop", 7.59, 20));
		products.add(new Product("Ball", 9.6, 10));
		products.add(new Product("toilet", 10.79, 30));
		products.add(new Product("Bouncy Ball", 3.69, 40));
		products.add(new Product("Corns", 8.59, 50));
		return products;
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

module javafx_demo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.product to javafx.base, javafx.graphics, javafx.fxml;
}

package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {
	
	public Label label1;
	public Button button1;
	
	public void handleButtonClick() {
		System.out.println("button clicked");
		label1.setText("stop touching me");
	}
}

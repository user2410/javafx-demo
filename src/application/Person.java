package application;

import javafx.beans.property.*;

public class Person {

	private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

	public Person(String name){
		setFirstName(name);
	}
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
}

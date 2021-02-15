package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Contact;
import model.ContactManager;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

public class ContactManagerGUI {

	private ContactManager contactManager;
	
	public ContactManagerGUI(ContactManager contactManager) {
		this.contactManager = contactManager;
	}

	@FXML
	private TableView<Contact> tableViewW;

	@FXML
	private TableColumn<Contact, String> numColumn;

	@FXML
	private TableColumn<Contact, String> nameColumn;

	@FXML
	private TableColumn<Contact, String> emailColumn;
	@FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button saveButton;

	@FXML
	private Pane mainPanel;

    @FXML
    public void saveContact(ActionEvent event) {
    	try {
			contactManager.addContact(nameTextField.getText(), emailTextField.getText());
			nameTextField.setText("");
			emailTextField.setText("");
    	} catch (Exception ex){
			nameTextField.setText("");
			emailTextField.setText("");
		}


    }

     private void initializeTableView(){
    	ObservableList<Contact> observableList;
    	observableList = FXCollections.observableArrayList(contactManager.getContacts());

    	tableViewW.setItems(observableList);
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));

	 }

	 @FXML
	 public void showAddContact(ActionEvent event) throws IOException {
    	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addContact.fxml"));
    	 fxmlLoader.setController(this);
    	 Parent addContactPane = fxmlLoader.load();

		 //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
		 mainPanel.getChildren().setAll(addContactPane);
	 }

	 @FXML
	 public void showListContact(ActionEvent event) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contactList.fxml"));
		 fxmlLoader.setController(this);
		 Parent contactListPane = fxmlLoader.load();

		 //Parent addContacts = FXMLLoader.load(getClass().getResource("addContact.fxml"));
		 mainPanel.getChildren().setAll(contactListPane);
		 initializeTableView();
	 }
	@FXML
	public void exportContacts(ActionEvent event) {

	}

	@FXML
	public void importContacts(ActionEvent event) {

	}
}

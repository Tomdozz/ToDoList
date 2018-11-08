package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.database.databasecontent.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.database.*;

public class LoginController implements Initializable {	

	double x = 0;
	double y = 0;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	Text errText;
	@FXML
	Text errTextSignup;
	@FXML
	VBox loginScreen;
	@FXML
	VBox signupScreen;
    @FXML
    TextField usernameSignUp;
    @FXML
    TextField passwordSignUp;
    @FXML
    TextField emailSignUp;
	

    @FXML
    void exit(ActionEvent event) {
    	System.out.println("exit");
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    void signupScreen(ActionEvent event) {
    	System.out.println("signup");
    	loginScreen.setVisible(false);
    	signupScreen.setVisible(true);
    }
    @FXML
    void logInScreen(ActionEvent event) {
    	System.out.println("Login");
    	signupScreen.setVisible(false);
    	loginScreen.setVisible(true);
    }
    @FXML
    void signUp(ActionEvent event) {
    	String usrName = usernameSignUp.getText();
    	String usrPassword = passwordSignUp.getText();
    	String usrEmail = emailSignUp.getText();
    	User user = new User(usrName, usrPassword, usrEmail);
    	errTextSignup.setText("");
    	if (usernameSignUp.getText().isEmpty() || 
    			passwordSignUp.getText().isEmpty() ||
    			emailSignUp.getText().isEmpty()) {
    		errTextSignup.setText("Please fill out all feilds");
		}
    	else if (Login.getUser(usrEmail).email != null)
    		errTextSignup.setText("Email alredy exists");
    	else {
    		Login.addUser(user);    		
    	}

    }

    @FXML
    void login(ActionEvent event) {
    	User user = new User(null, null, null);
    	errText.setText("");
    	String usrName = username.getText();
    	String usrPassword = password.getText();
    	
    	System.out.println(usrName);
    	System.out.println(usrPassword);
    	
    	if (username.getText().isEmpty() || 
    			password.getText().isEmpty()) {
    		errText.setVisible(true);
    		errText.setText("Username or password can not be blank");
    	}	
    	user = Login.getUser(usrName, usrPassword);
    	if (user.username == null || user.password == null) {
    		errText.setText("Invalid username or password");
    		username.clear();
    		password.clear();
		}
    	else {
    		//send to login screen
    	}
    	
    	System.out.println(user.id);
    	System.out.println(user.email);
    	System.out.println(user.username);
    	System.out.println(user.password);
    }
    
	@FXML
    void dragged(MouseEvent event) {
    	Node node = (Node) event.getSource();
    	Stage stage = (Stage) node.getScene().getWindow();
    	
    	stage.setX(event.getScreenX() - x);
    	stage.setY(event.getScreenY() -y);
    }
    @FXML
    void pressed(MouseEvent event) {
    	x = event.getSceneX();
    	y = event.getSceneY();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}

package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerInterface {
	@FXML
	private Label myLabel;
	@FXML
	private TextField myTextField1;
	@FXML
	private TextField myTextField2;
	@FXML
	private TextField myTextField3;
	@FXML
	private TextField myTextField4;
	@FXML
	private Button myButton;
	
	
	String nom;
	String prénom;
	int age;
	String email;
	
	
	public void valider(ActionEvent event) throws SQLException {
		nom = String.valueOf(myTextField1.getText());
		
		prénom = String.valueOf(myTextField2.getText());
		
		age = Integer.parseInt(myTextField3.getText());
		
		email = String.valueOf(myTextField4.getText());
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdUlt","root","");
		
		Statement stmt = con.createStatement();
		
		int result = stmt.executeUpdate("insert into etudiant(nom,prénom,age,email) values('"+nom+"','"+prénom+"','"+age+"','"+email+"' )");
		
		System.out.println(result);
		try {
			if (age<=60) {
			myLabel.setText("Informations enregistrés avec succès");
			}
		}
		catch(NullPointerException e) {
			myLabel.setText("Entrer que des chiffres SVP");
		}
		catch(Exception e) {
			myLabel.setText("error");
		}

	}
	
}



package application;
	
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdUlt","root","");
		System.out.println(con);
		try {
			Parent root =FXMLLoader.load(getClass().getResource("Interface.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Image A3 = new Image("A3.jpg");
		primaryStage.getIcons().add(A3);
		primaryStage.setTitle("Informations Etudiant");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
package aplicacion;


import Controladores.LoginController;
import conexion.Conexion;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	// Declaración del primer escenario

	private Stage primaryStage;
	private String idUsuario;

	// Método principal

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		Login();
	}


	
	private void Login() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/Vistas/Login.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);
			
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mostrarVentanaPrincipalEmpresa() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/Vistas/VistaEmpresa.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void mostrarVentanaPrincipalCliente() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/Vistas/VistaCliente.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public static void main(String[] args) {
		launch(args);
	}
}


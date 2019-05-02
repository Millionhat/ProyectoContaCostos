package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelo.Costeo;
import view.Main;

public class PonderadoViewController implements Initializable {

	@FXML
    private GridPane equiProducGridPane;
    @FXML
    private GridPane unitTable;
    @FXML
    private GridPane asignedTable;
    private Costeo costeo;
    
    public void calculate(Costeo costeo) {
		this.costeo = costeo;
		costeo.produccionEquivalente();
		costeo.calcularValorUnidad();
		double[][] data = costeo.getProdEquiv();
		double[] data2 = costeo.darValUnitario();
		double[] data3 = costeo.darValorAsignado();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length ; j++) {
				Label l = new Label();
				l.setText(String.valueOf(data[i][j]));
				equiProducGridPane.add(l, j+1, i+1);
			}
			Label l2 = new Label();
			l2.setText(String.valueOf(data2[i]));
			unitTable.add(l2, 1, i+1);
			if(i < 3) {
				Label l3 = new Label();
				l3.setText(String.valueOf(data3[i]));
				asignedTable.add(l3, 1, i+1);
			}
		}
		
	}

    @FXML
    void returnPressed(ActionEvent event) {
    	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/MainWindow.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Costeo por procesos");
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    public void shutdown() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Espere!");
    	alert.setHeaderText(null);
    	alert.setContentText("¿Desea salir? Si desea retornar, presione volver.");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
        	Platform.exit();
    	} 
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}

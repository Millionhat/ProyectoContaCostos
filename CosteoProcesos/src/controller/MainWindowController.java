package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Costeo;

public class MainWindowController implements Initializable {

    @FXML
    private TextField unitsInitialTF;

    @FXML
    private TextField initPercentMDTF;

    @FXML
    private TextField initValueMDTF;

    @FXML
    private TextField initPercentMODTF;

    @FXML
    private TextField initValueMODTF;

    @FXML
    private TextField initPercentCIFTF;

    @FXML
    private TextField initValueCIFTF;

    @FXML
    private TextField finUnitsTF;

    @FXML
    private TextField finPercentMDTF;

    @FXML
    private TextField finPercentMODTF;

    @FXML
    private TextField finPercentCIFTF;

    @FXML
    private TextField unitsStartedEndedTF;

    @FXML
    private TextField valueMDTF;

    @FXML
    private TextField valueMODTF;

    @FXML
    private TextField valueCIFTF;

    @FXML
    private Button pepsButton;

    @FXML
    private Button ponderadoButton;
    private Costeo costeo;
    

    @FXML
    void pepsPressed(ActionEvent event) {
    	
    	double[] info = new double[15];
    	info[0] = Double.parseDouble(unitsInitialTF.getText());
    	info[1] = Double.parseDouble(initPercentMDTF.getText());
    	info[2] = Double.parseDouble(initValueMDTF.getText());
    	info[3] = Double.parseDouble(initPercentMODTF.getText());
    	info[4] = Double.parseDouble(initValueMODTF.getText());
    	info[5] = Double.parseDouble(initPercentCIFTF.getText());
    	info[6] = Double.parseDouble(initValueCIFTF.getText());
    	info[7] = Double.parseDouble(unitsStartedEndedTF.getText());
    	info[8] = Double.parseDouble(valueMDTF.getText());
    	info[9] = Double.parseDouble(valueMODTF.getText());
    	info[10] = Double.parseDouble(valueCIFTF.getText());
    	info[11] = Double.parseDouble(finUnitsTF.getText());
    	info[12] = Double.parseDouble(finPercentMDTF.getText());
    	info[13] = Double.parseDouble(finPercentMODTF.getText());
    	info[14] = Double.parseDouble(finPercentCIFTF.getText());
    	boolean full = false;
    	for(int i = 0; i < info.length-1; i++) {
    		if(info[i] == 0) {
    			full = false;
    			Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Cuidado!");
				alert.setHeaderText(null);
				alert.setContentText("Por favor complete todos los datos.");
				alert.showAndWait();
				i = 15;
    		}
    	}
    	if(full) {
    		costeo = new Costeo(info);
    		try {
    			FXMLLoader loader = new FXMLLoader();
    			loader.setLocation(getClass().getResource("/view/PEPSView.fxml"));
    			Parent root;
    			root = loader.load();
    			Scene scene = new Scene(root);
    			Stage window = new Stage();
    			window.setResizable(false);
    			window.setScene(scene);
    			window.setTitle("Graph View");
    			window.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
		
    }

    @FXML
    void ponderadoPressed(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    
}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Costeo;

public class PEPSViewController implements Initializable {

	@FXML
    private TableView<Costeo> equiProduTable;

    @FXML
    private TableColumn<Costeo, String> equiProduColumn;

    @FXML
    private TableColumn<Costeo, String> mDColumn;

    @FXML
    private TableColumn<Costeo, String> mODColumn;

    @FXML
    private TableColumn<Costeo, String> cIFColumn;

    @FXML
    private TableView<Costeo> asignedTable;

    @FXML
    private TableColumn<Costeo, String> asignedColumn;

    @FXML
    private TableColumn<Costeo, String> asignedValueColumn;

    @FXML
    private TableView<Costeo> unitaryTable;

    @FXML
    private TableColumn<Costeo, String> unitValueColumn;
    private Costeo costeo;
    
    public PEPSViewController(Costeo costeo) {
		this.costeo = costeo;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Operaciones;
import Modelo.Persona;
import Modelo.Suma;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class Controlador implements Initializable {

    @FXML
    private TextField txtop2;
    @FXML
    private TextField txtop1;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button btnClic;
    @FXML
    private RadioButton rbtSuma;
    @FXML
    private RadioButton rdtResta;
    @FXML
    private RadioButton rbtMultiplicar;
    @FXML
    private RadioButton rbtDivision;
    @FXML
    private TableView<Persona> tblPersona;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colEdad;
    @FXML
    private Button btnAgregar;
    private ObservableList<Persona> personas;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtApellido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup grupo = new ToggleGroup();
        this.rbtSuma.setToggleGroup(grupo);
        this.rdtResta.setToggleGroup(grupo);
        this.rbtMultiplicar.setToggleGroup(grupo);
        this.rbtDivision.setToggleGroup(grupo);
        
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        
        // TODO
    }    

    private void Encender(ActionEvent event) {
        System.out.println("hola mundo");
        
    }

    private void sumar(ActionEvent event) {
        int op1 = Integer.parseInt(this.txtop1.getText());
        int op2 = Integer.parseInt(this.txtop2.getText());
        Suma s= new Suma(op1,op2);
        int resultado= s.sumar();
        this.txtResultado.setText(resultado + "");
        
    }

    @FXML
    private void hacerOperacion(ActionEvent event) {
        int op1 = Integer.parseInt(this.txtop1.getText());
        int op2 = Integer.parseInt(this.txtop2.getText());
        Operaciones operar = new Operaciones(op1 , op2);
        if(this.rbtSuma.isSelected()){
            this.txtResultado.setText(operar.suma()+ "");
        }else if(this.rdtResta.isSelected()){
            this.txtResultado.setText(operar.resta()+ "");
        }else if(this.rbtMultiplicar.isSelected()){
            this.txtResultado.setText(operar.mult() + "");
        }else if(this.rbtDivision.isSelected()){
            if(op2>0){
                this.txtResultado.setText(operar.div()+ "");
            }      
        }
        
    }

    @FXML
    private void AgregarPersona(ActionEvent event) {
        
        personas= FXCollections.observableArrayList();
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        int edad = Integer.parseInt(this.txtEdad.getText());
        Persona p = new Persona(nombre,apellido,edad);
        /*this.personas.add(p);
        this.tblPersona.setItems(personas);*/
        
        if(!personas.contains(p)){
            this.personas.add(p);
            this.tblPersona.setItems(personas);
            
           }else{
            JOptionPane.showMessageDialog(null,"Debe ingresar persona" ,"aviso" , JOptionPane.INFORMATION_MESSAGE);   
        }                     
    }
    
}

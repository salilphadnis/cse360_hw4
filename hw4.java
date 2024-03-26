package hw4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hw4 extends Application {
	
		int patientID = 12344;

		public void start(Stage primaryStage) {
		   
			showMainMenu(primaryStage);
					   
	   }
	   
		public void showMainMenu(Stage primaryStage)
		{
			
			//Main UI
			try {
				
				BorderPane root = new BorderPane();

				GridPane grid = new GridPane();
				//grid.setGridLinesVisible(true);
				
				Label lblWelcome = new Label("Welcome to Heart Health Imaging and Recording System");
			    Font font = Font.font("Roboto", FontWeight.BOLD, 20);
				lblWelcome.setFont(font);
				
				//Buttons
				Button btnPatientIntake = new Button("Patient Intake");
				Button btnTechnician = new Button("CT Scan Tech View");
				Button btnPatientView = new Button("Patient View");
				
				
				btnPatientIntake.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		            	showPatientIntakeForm(primaryStage);
		            }       
				});
				
				btnTechnician.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		            	showTechnicianView(primaryStage);
		            }       
				});
				
				btnPatientView.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		            	//showPatientView(primaryStage);
		            	showPatientLogin(primaryStage);
		            }       
				});
				
				//col, row, colSpan, rowSpan
				grid.add(lblWelcome, 0, 0, 3, 1);
				grid.add(btnPatientIntake, 1, 2, 1, 1);
				grid.add(btnTechnician, 1, 3, 1, 1);
				grid.add(btnPatientView, 1, 4, 1, 1);
				
				// Set Column and Row Gap
				grid.setHgap(20);
				grid.setVgap(20);
				
				grid.setPadding(new Insets(10, 10, 10, 10));
				
				// Column Constraints
				ColumnConstraints column1 = new ColumnConstraints();
				ColumnConstraints column2 = new ColumnConstraints();
				ColumnConstraints column3 = new ColumnConstraints();
				
				grid.getColumnConstraints().add(column1);
				grid.getColumnConstraints().add(column2);
				grid.getColumnConstraints().add(column3);
				
				column1.setPrefWidth(200);
				column2.setPrefWidth(300);
				column3.setPrefWidth(200);
				
				// Horizontal alignment
				//GridPane.setHalignment(lblJoesDeli, HPos.CENTER);
				//GridPane.setHalignment(lblLastName, HPos.RIGHT);
				
				root.setCenter(grid);

				Scene scene = new Scene(root, 900, 600);
				primaryStage.setScene(scene);
				//primaryStage.setTitle("");
				primaryStage.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void showPatientIntakeForm(Stage primaryStage)
		{
		   
			try {
				BorderPane root = new BorderPane();
				
				GridPane grid = new GridPane();
				//grid.setGridLinesVisible(true);
			   
				// Create JavaFX Controls (nodes) to add to the GridPane
				
				//Labels for text
				Label lblIntakeForm = new Label("Patient Intake Form");
			    Font font = Font.font("Roboto", FontWeight.BOLD, 20);
				lblIntakeForm.setFont(font);
			    
				Label lblFirstName = new Label("First Name:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblFirstName.setFont(font);
				
				Label lblLastName = new Label("Last Name:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLastName.setFont(font);
				
				Label lblEmail = new Label("Email:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblEmail.setFont(font);
				
				Label lblPhoneNumber = new Label("Phone Number:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPhoneNumber.setFont(font);
				
				Label lblHealthHistory = new Label("Health History:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblHealthHistory.setFont(font);
				
				Label lblInsuranceID = new Label("Insurance ID:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblInsuranceID.setFont(font);
				
				//Add all the above components to the Grid so that they line up neatly
				//col, row, colSpan, rowSpan
				grid.add(lblIntakeForm, 1, 0, 1, 1);
				grid.add(lblFirstName, 0, 1, 1, 1);
				grid.add(lblLastName, 0, 2, 1, 1);
				grid.add(lblEmail, 0, 3, 1, 1);
				grid.add(lblPhoneNumber, 0, 4, 1, 1);
				grid.add(lblHealthHistory, 0, 5, 1, 1);
				grid.add(lblInsuranceID, 0, 6, 1, 1);

				//Text Fields
				TextField txtFirstName = new TextField();
				TextField txtLastName = new TextField();
				TextField txtEmail = new TextField();
				TextField txtPhoneNumber = new TextField();
				TextField txtHealthHistory = new TextField();
				TextField txtInsuranceID = new TextField();

				grid.add(txtFirstName, 1, 1, 1, 1);
				grid.add(txtLastName, 1, 2, 1, 1);
				grid.add(txtEmail, 1, 3, 1, 1);
				grid.add(txtPhoneNumber, 1, 4, 1, 1);
				grid.add(txtHealthHistory, 1, 5, 1, 1);
				grid.add(txtInsuranceID, 1, 6, 1, 1);
				
				//Buttons
				Button btnSave = new Button("Save");		
				grid.add(btnSave, 1, 7, 1, 1);
				
				Button btnCancel = new Button("Cancel");		
				grid.add(btnCancel, 2, 7, 1, 1);
				
				//Save Button functionality
				btnSave.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		                
		                //Write to File
		            	//Increment Patient ID since this is a new patient
		            	patientID++;
		            	
		            	String fileName = patientID + "_Patientinfo.txt";
		                File file = new File(fileName);
		                FileWriter fr = null;
		                try {
		                    fr = new FileWriter(file);
		                    fr.write(txtFirstName.getText()+"\n");
		                    fr.write(txtLastName.getText()+"\n");
		                    fr.write(txtEmail.getText()+"\n");
		                    fr.write(txtPhoneNumber.getText()+"\n");
		                    fr.write(txtHealthHistory.getText()+"\n");
		                    fr.write(txtInsuranceID.getText()+"\n");
		                } catch (IOException e) {
		                    e.printStackTrace();
		                } finally{
		                    //close resources
		                    try {
		                        fr.close();
		                    } catch (IOException e) {
		                        e.printStackTrace();
		                    }
		                }
		                
		                //Go back to Main Menu after patient is saved
		                showMainMenu(primaryStage);
		            }
				});
		            	
				
				//Cancel Button functionality
				btnCancel.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		            	//Go back to main menu
		            	showMainMenu(primaryStage);
		            }
				});
		            	
				// Set Column and Row Gap
				grid.setHgap(20);
				grid.setVgap(20);
				
				grid.setPadding(new Insets(10, 10, 10, 10));
				
				// Column Constraints
				ColumnConstraints column1 = new ColumnConstraints();
				ColumnConstraints column2 = new ColumnConstraints();
				ColumnConstraints column3 = new ColumnConstraints();
				
				grid.getColumnConstraints().add(column1);
				grid.getColumnConstraints().add(column2);
				grid.getColumnConstraints().add(column3);
				
				column1.setPrefWidth(200);
				column2.setPrefWidth(300);
				column3.setPrefWidth(200);
				
				// Horizontal alignment
				//GridPane.setHalignment(lblJoesDeli, HPos.CENTER);
				//GridPane.setHalignment(lblLastName, HPos.RIGHT);
				
				root.setCenter(grid);

				Scene scene = new Scene(root, 900, 600);
				primaryStage.setScene(scene);
				//primaryStage.setTitle("");
				primaryStage.show();
				
				
		   } catch (Exception e) {
				e.printStackTrace();
			}
		   
	   }
		
		public void showTechnicianView(Stage primaryStage)
		{
		   
			try {
				BorderPane root = new BorderPane();
				
				GridPane grid = new GridPane();
				//grid.setGridLinesVisible(true);
			   
				// Create JavaFX Controls (nodes) to add to the GridPane
				Label lblPatientID = new Label("Patient ID:");
				Font font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPatientID.setFont(font);
				
				Label lblTotalCACscore = new Label("The total Agatston CAC score:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblTotalCACscore.setFont(font);
				
				Label lblVesselCACscore = new Label("Vessel Level Agatston CAC score:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblVesselCACscore.setFont(font);
				
				Label lblLM = new Label("LM:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLM.setFont(font);
				
				Label lblLAD = new Label("LAD:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLAD.setFont(font);
				
				Label lblLCX = new Label("LCX:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLCX.setFont(font);
				
				Label lblRCA = new Label("RCA:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblRCA.setFont(font);
				
				Label lblPDA = new Label("PDA:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPDA.setFont(font);
				
				//Add all the above components to the Grid so that they line up neatly
				//col, row, colSpan, rowSpan
				grid.add(lblPatientID, 0, 0, 2, 1);
				grid.add(lblTotalCACscore, 0, 1, 2, 1);
				grid.add(lblVesselCACscore, 0, 2, 2, 1);
				grid.add(lblLM, 0, 3, 1, 1);
				grid.add(lblLAD, 0, 4, 1, 1);
				grid.add(lblLCX, 0, 5, 1, 1);
				grid.add(lblRCA, 0, 6, 1, 1);
				grid.add(lblPDA, 0, 7, 1, 1);

				//Text Fields
				TextField txtPatientID = new TextField();
				TextField txtTotalScore = new TextField();
				TextField txtLM = new TextField();
				TextField txtLAD = new TextField();
				TextField txtLCX = new TextField();
				TextField txtRCA = new TextField();
				TextField txtPDA = new TextField();

				grid.add(txtPatientID, 1, 0, 1, 1);
				grid.add(txtTotalScore, 1, 1, 1, 1);
				grid.add(txtLM, 1, 3, 1, 1);
				grid.add(txtLAD, 1, 4, 1, 1);
				grid.add(txtLCX, 1, 5, 1, 1);
				grid.add(txtRCA, 1, 6, 1, 1);
				grid.add(txtPDA, 1, 7, 1, 1);
				
				//Error messages for fields
				Label lblPatientIDEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPatientIDEmpty.setFont(font);
				grid.add(lblPatientIDEmpty, 2, 0, 1, 1);
				
				Label lblTotalScoreEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblTotalScoreEmpty.setFont(font);
				grid.add(lblTotalScoreEmpty, 2, 1, 1, 1);
				
				Label lblLMEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLMEmpty.setFont(font);				
				grid.add(lblLMEmpty, 2, 3, 1, 1);
				
				Label lblLADEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLADEmpty.setFont(font);
				grid.add(lblLADEmpty, 2, 4, 1, 1);

				Label lblLCXEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLCXEmpty.setFont(font);			
				grid.add(lblLCXEmpty, 2, 5, 1, 1);
				
				Label lblRCAEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblRCAEmpty.setFont(font);
				grid.add(lblRCAEmpty, 2, 6, 1, 1);
				
				Label lblPDAEmpty = new Label("");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPDAEmpty.setFont(font);
				grid.add(lblPDAEmpty, 2, 7, 1, 1);				
				
				//Buttons
				Button btnSave = new Button("Save");		
				grid.add(btnSave, 1, 8, 1, 1);
				Button btnCancel = new Button("Cancel");		
				grid.add(btnCancel, 2, 8, 1, 1);
				
				//Save Button functionality
				btnSave.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		                		            	
		            	int error = 0;
		            	//Check for empty fields
		            	
		            	//First clear out all error messages
		            	lblPatientIDEmpty.setText("");
		            	lblTotalScoreEmpty.setText("");
		            	lblLMEmpty.setText("");
		            	lblLADEmpty.setText("");
		            	lblLCXEmpty.setText("");
		            	lblRCAEmpty.setText("");
		            	lblPDAEmpty.setText("");
		            	
		            	if (txtPatientID.getText().equals("")) {
		            		lblPatientIDEmpty.setText("Error: Patient ID cannot be empty!!");
		            		error = 1;
		            	}

		            	if (txtTotalScore.getText().equals("")) {
		            		lblTotalScoreEmpty.setText("Error: Total Score cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (txtLM.getText().equals("")) {
		            		lblLMEmpty.setText("Error: LM cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (txtLAD.getText().equals("")) {
		            		lblLADEmpty.setText("Error: LAD cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (txtLCX.getText().equals("")) {
		            		lblLCXEmpty.setText("Error: LCX cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (txtRCA.getText().equals("")) {
		            		lblRCAEmpty.setText("Error: RCA cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (txtPDA.getText().equals("")) {
		            		lblPDAEmpty.setText("Error: PDA cannot be empty!!");
		            		error = 1;
		            	}
		            	
		            	if (error == 0) {
		            		//Check that patient exists
		            		String checkPatientID = txtPatientID.getText();
		            		String checkPatientFile = checkPatientID + "_PatientInfo.txt";
		            		File file =  new File(checkPatientFile);
		            		if (!file.exists()) {
		            			//System.out.println("Patient " + checkPatientID + " doesn't exist");
		            			Label lblError = new Label("Error: Patient " + checkPatientID + " doesn't exist");
		            			Font font = Font.font("Roboto", FontWeight.BOLD, 15);
		            			lblError.setFont(font);
		            		
		            			grid.add(lblError, 2, 0, 1, 1);
		            		}	
		            		else {
		            			//Write to File
			            		String fileName = patientID + "CTResults.txt";
			            		File file1 = new File(fileName);
			            		FileWriter fr = null;
			            		try {
			            			fr = new FileWriter(file1);
			            			fr.write(txtTotalScore.getText()+"\n");
			            			fr.write(txtLM.getText()+"\n");
			            			fr.write(txtLAD.getText()+"\n");
			            			fr.write(txtLCX.getText()+"\n");
			            			fr.write(txtRCA.getText()+"\n");
			            			fr.write(txtPDA.getText()+"\n");
			            		} catch (IOException e) {
			            			e.printStackTrace();
			            		} finally{
			            			//close resources
			            			try {
			            				fr.close();
			            			} catch (IOException e) {
			            				e.printStackTrace();
			            			}
			            		}
		            		
			            		//Go back to Main Menu after patient is saved
			            		showMainMenu(primaryStage);
		            		}
		                
		            	}
		            }
				});
				
				//Cancel Button functionality
				btnCancel.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		            	//Go back to main menu
		            	showMainMenu(primaryStage);
		            }
				});
				
				// Set Column and Row Gap
				grid.setHgap(20);
				grid.setVgap(20);
				
				grid.setPadding(new Insets(10, 10, 10, 10));
				
				// Column Constraints
				ColumnConstraints column1 = new ColumnConstraints();
				ColumnConstraints column2 = new ColumnConstraints();
				ColumnConstraints column3 = new ColumnConstraints();
				
				grid.getColumnConstraints().add(column1);
				grid.getColumnConstraints().add(column2);
				grid.getColumnConstraints().add(column3);
				
				column1.setPrefWidth(200);
				column2.setPrefWidth(200);
				column3.setPrefWidth(300);
				
				// Horizontal alignment
				//GridPane.setHalignment(lblJoesDeli, HPos.CENTER);
				//GridPane.setHalignment(lblLastName, HPos.RIGHT);
				
				root.setCenter(grid);

				Scene scene = new Scene(root, 900, 600);
				primaryStage.setScene(scene);
				//primaryStage.setTitle("");
				primaryStage.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   
		public void showPatientView(Stage primaryStage, String name)
		{
		   
			try {
				BorderPane root = new BorderPane();
				
				GridPane grid = new GridPane();
				//grid.setGridLinesVisible(true);
			   
				// Create JavaFX Controls (nodes) to add to the GridPane
				Label lblHello = new Label("Hello " + name);
				Font font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblHello.setFont(font);
				
				Label lblTotalCACscore = new Label("The total Agatston CAC score:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblTotalCACscore.setFont(font);
				
				Label lblLM = new Label("LM:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLM.setFont(font);
				
				Label lblLAD = new Label("LAD:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLAD.setFont(font);
				
				Label lblLCX = new Label("LCX:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblLCX.setFont(font);
				
				Label lblRCA = new Label("RCA:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblRCA.setFont(font);
				
				Label lblPDA = new Label("PDA:");
				font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPDA.setFont(font);
				
				//Add all the above components to the Grid so that they line up neatly
				//col, row, colSpan, rowSpan
				grid.add(lblHello, 1, 0, 2, 1);
				grid.add(lblTotalCACscore, 0, 1, 2, 1);
				grid.add(lblLM, 0, 2, 1, 1);
				grid.add(lblLAD, 0, 3, 1, 1);
				grid.add(lblLCX, 0, 4, 1, 1);
				grid.add(lblRCA, 0, 5, 1, 1);
				grid.add(lblPDA, 0, 6, 1, 1);

				//Text Fields
				TextField txtTotalScore = new TextField();
				TextField txtLM = new TextField();
				TextField txtLAD = new TextField();
				TextField txtLCX = new TextField();
				TextField txtRCA = new TextField();
				TextField txtPDA = new TextField();

				grid.add(txtTotalScore, 1, 1, 1, 1);
				grid.add(txtLM, 1, 2, 1, 1);
				grid.add(txtLAD, 1, 3, 1, 1);
				grid.add(txtLCX, 1, 4, 1, 1);
				grid.add(txtRCA, 1, 5, 1, 1);
				grid.add(txtPDA, 1, 6, 1, 1);
				
				
				Button btnCancel = new Button("Cancel");		
				grid.add(btnCancel, 2, 6, 1, 1);
				
				//Cancel Button functionality
				btnCancel.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		            	//Go back to main menu
		            	showMainMenu(primaryStage);
		            }
				});
				
				
				//Read patient file and populate the text fields
        		String fileName = patientID + "CTResults.txt";

            	
            	try {
            		File file = new File(fileName);

                	Scanner myReader = new Scanner(file);
                	/*while (myReader.hasNextLine()) {
                		String data = myReader.nextLine();
                		System.out.println(data);
                	}*/

                	//Read CT results file and fill info in text fields
                	String data = myReader.nextLine();
                	txtTotalScore.setText(data);
                	
                	data = myReader.nextLine();
                	txtLM.setText(data);                	
                	
                	data = myReader.nextLine();
                	txtLAD.setText(data);
                	
                	data = myReader.nextLine();
                	txtLCX.setText(data);
                	
                	data = myReader.nextLine();
                	txtRCA.setText(data);                	
                	
                	data = myReader.nextLine();
                	txtPDA.setText(data);
                	
                	myReader.close();
            	} catch (FileNotFoundException e) {
            	      System.out.println("An error occurred.");
            	      e.printStackTrace();
            	}
				

				
				// Set Column and Row Gap
				grid.setHgap(20);
				grid.setVgap(20);
				
				grid.setPadding(new Insets(10, 10, 10, 10));
				
				// Column Constraints
				ColumnConstraints column1 = new ColumnConstraints();
				ColumnConstraints column2 = new ColumnConstraints();
				
				grid.getColumnConstraints().add(column1);
				grid.getColumnConstraints().add(column2);
				
				column1.setPrefWidth(200);
				column2.setPrefWidth(300);
				
				// Horizontal alignment
				GridPane.setHalignment(lblHello, HPos.CENTER);
				//GridPane.setHalignment(lblLastName, HPos.RIGHT);
				
				root.setCenter(grid);
				
				
				Scene scene = new Scene(root, 900, 600);
				primaryStage.setScene(scene);
				//primaryStage.setTitle("");
				primaryStage.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		public void showPatientLogin(Stage primaryStage)
		{
		   
			try {
				BorderPane root = new BorderPane();
				
				GridPane grid = new GridPane();
				grid.setGridLinesVisible(true);
			   
				// Create JavaFX Controls (nodes) to add to the GridPane
				
				Label lblPatientID = new Label("Patient ID:");
				Font font = Font.font("Roboto", FontWeight.BOLD, 15);
				lblPatientID.setFont(font);
								
				//Add all the above components to the Grid so that they line up neatly
				//col, row, colSpan, rowSpan
				grid.add(lblPatientID, 0, 1, 2, 1);
				
				//Text Fields
				TextField txtPatientID = new TextField();				
				grid.add(txtPatientID, 1, 1, 1, 1);

				//Buttons
				Button btnLogin = new Button("Login");
				Button btnCancel = new Button("Cancel");
				
				grid.add(btnLogin, 1, 2, 1, 1);
				grid.add(btnCancel, 2, 2, 1, 1);				
				
				
				btnLogin.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //Check whether Patient file exist
		            	//Check that patient exists
		            	String checkPatientID = txtPatientID.getText();
		            	String checkPatientFile = checkPatientID + "_PatientInfo.txt";
		            	File file =  new File(checkPatientFile);
		            	if (!file.exists()) {
		            		//System.out.println("Patient " + checkPatientID + " doesn't exist");
		    				Label lblError = new Label("Error: Patient " + checkPatientID + " doesn't exist");
		    				Font font = Font.font("Roboto", FontWeight.BOLD, 15);
		    				lblError.setFont(font);
		            		
		    				grid.add(lblError, 2, 1, 1, 1);
		            	}	
		            	else {
		            		
		            		//Read patient name from file
		                	Scanner myReader;
							try {
								myReader = new Scanner(file);
			            		String name = myReader.nextLine();
			                	myReader.close();
			            		showPatientView(primaryStage, name);

							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
		            	}
		            }       
				});
				
				btnCancel.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		                //System.out.println(txtFirstName.getText());
		            	showMainMenu(primaryStage);
		            }       
				});
				
				// Set Column and Row Gap
				grid.setHgap(20);
				grid.setVgap(20);
				
				grid.setPadding(new Insets(10, 10, 10, 10));
				
				// Column Constraints
				ColumnConstraints column1 = new ColumnConstraints();
				ColumnConstraints column2 = new ColumnConstraints();
				
				grid.getColumnConstraints().add(column1);
				grid.getColumnConstraints().add(column2);
				
				column1.setPrefWidth(200);
				column2.setPrefWidth(300);
				
				// Horizontal alignment
				//GridPane.setHalignment(lblHello, HPos.CENTER);
				//GridPane.setHalignment(lblLastName, HPos.RIGHT);
				
				root.setCenter(grid);
				
				
				Scene scene = new Scene(root, 900, 600);
				primaryStage.setScene(scene);
				//primaryStage.setTitle("");
				primaryStage.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	   public static void main(String[] args) {
	        launch(args);
	    }
	   
}

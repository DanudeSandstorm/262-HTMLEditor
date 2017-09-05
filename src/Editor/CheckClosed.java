package Editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import FileManager.FileManager;
import java.util.logging.Logger;

public class CheckClosed {
	
	private static CheckClosed cc = new CheckClosed();

	public CheckClosed(){ }
	
	public static CheckClosed getInstance(){
		return cc;
	}
	
	/**
	 * Checks if any tabs have unsaved documents, if so 
	 * pops up a notification before exiting.
	 */
	public static void close(){
		ArrayList<Tab> unsavedTabs = checkUnsavedTabs();
	    if (unsavedTabs.size() != 0) {                  
	        CloseWindow(unsavedTabs);
	    }
	    else {
                Platform.exit();
	    }
	    
	}
	
	/**
	 * Checks if any tabs have unsaved documents, if so 
	 * pops up a notification before exiting.
	 */
	public static void close(final WindowEvent ev){
		ArrayList<Tab> unsavedTabs = checkUnsavedTabs();
	    if (unsavedTabs.size() != 0) {
	        ev.consume(); //Cancels the close window event.                   
	        CloseWindow(unsavedTabs);
	    }
	}
	

	/**
     * Loops through all tabs, seeing if any of them are not open,
     * if so adds names to
     */
	private static ArrayList<Tab> checkUnsavedTabs(){
		
		TabPanes tabPane = TabPanes.getInstance();
	    ObservableList<Tab> tabs = tabPane.getTabs();
	    ArrayList<Tab> unsavedTabs = new ArrayList<Tab>();
	    
	    for (Tab tab : tabs) {
	    	TextArea textArea = (TextArea) tab.getContent();
	
	      //Text has been saved is stored in the id. "no" = has not been saved.
	        if (textArea.getId().equals("no")) {      
	        	unsavedTabs.add(tab);
	        }
	
	    }
	    return unsavedTabs;
	}
	

	private static void CloseWindow(final ArrayList<Tab> tabs){       
        final Stage stage = new Stage();
        
        String dialogString = "The following files has not been saved, "
        		+ "would you like to save before closing?";
        
        
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        Button cancelButton = new Button("Cancel");
        
        //If the user selected "Save", save open files
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	TabPanes tabPane = TabPanes.getInstance();
            	SingleSelectionModel<Tab> selectionModel = tabPane.getTabPane().getSelectionModel();
            			
            	for(Tab tab : tabs){
            		try{
            			selectionModel.select(tab);
            			FileManager.saveSelectedFile();
            		}
            		catch (IOException ex){
            			Logger.getLogger(CheckClosed.class.getName(), null).log(Level.SEVERE, null, ex);
            		}
            	}
                stage.close();
                Platform.exit();
            }
        });

        //If user selects "Don't Save", closes exits
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
                Platform.exit();
            }
        });

        //If the user selects "Cancel", close the dialog
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });  
        
        //add buttons to array list
        ArrayList<Button> buttons = new ArrayList<Button>(
        		Arrays.asList(yesButton, noButton, cancelButton));

        CreateNotification(buttons, dialogString, stage);
    }
	
    /**
     * Creates a dialog box asking if the user would like to close the tab.
     * @param tab: The tab to possibly close.
     */
    public static void closeTab(final Tab tab) {
        final Stage stage = new Stage();
        
        String dialogString = "This file has not been saved, would you like to save it?";
        
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        Button cancelButton = new Button("Cancel");
        
        //If the user selected "Yes", closes tab.
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	try {
            		FileManager.saveSelectedFile();
            	} catch (IOException ex){
            		Logger.getLogger(CheckClosed.class.getName(), null).log(Level.SEVERE, null, ex);
            	}
                stage.close();
            }
        });

        //If user selects "No", closes dialog box.
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	tab.getTabPane().getTabs().remove(tab);
            	stage.close();
            }
        });
        
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });  
              
        
        //add buttons to array list
        ArrayList<Button> buttons = new ArrayList<Button>(
        		Arrays.asList(yesButton, noButton, cancelButton));

        CreateNotification(buttons, dialogString, stage);
    }
    
    /**
     * Creates a pop-up dialog box showing all the files that are not
     * open and asks if the user would still like to exit, if yes, exits.
	*/
    private static void CreateNotification(ArrayList<Button> buttons, String dialogString, final Stage stage){
        stage.initModality(Modality.WINDOW_MODAL);
         
        //Add Buttons
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(20, 0, 10, 0));
        buttonBox.setSpacing(14);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(buttons);
        
        stage.setScene(new Scene(
        	VBoxBuilder.create().children(new Text(dialogString), buttonBox).
        	alignment(Pos.CENTER).padding(new Insets(10)).build()
        	)
        );
        
        stage.show();
    }
    
}

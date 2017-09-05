/*
 * FileManger.java
 *  
 * Version:
 * $Id$
 * 
 * Revisions:
 * $Log$
 */

/**
 * 
 * 
 * @author jmb2636 Joshua Berk
 */
package FileManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Editor.HtmlTab;
import Editor.TabPanes;
import HTMLValidator.HTMLValidator;

/**
 * This class will be used to grab files and import their data into
 * the HTML editor.
 */
public class FileManager
{
	
    /**
     *This method grabs the file from a file path
     *
     * @param filePath - The full path of the file FileManager must look
     * 		for.
     * @return data - The data from the file FileManager was
     * 		requested to access.
     */
    public static File retrieveFile (String filePath)
    {
            File f = new File(filePath);
            return f;
    }

    //TODO Check for file type to confirm that Editor can open the file
    //TODO Tell user filetype cannot be opened.
    //TODO for retrieve and write, set default filename/directory
    public static String retrieveFileData (File file) throws IOException
    {
    	if (!hasExtension(file))
    	{
    		System.out.println("This file is not supported");
    		
    		final Stage fileTypeWarning = new Stage();
    		Text notSupportedText = new Text("This filetype is not supported");
    		Button dissmiss = new Button("Dissmiss");
    		
    		dissmiss.setOnAction(new EventHandler<ActionEvent>()
    			{
    				public void handle(ActionEvent ae)
    				{
    					fileTypeWarning.close();
    				}
    			});
    		fileTypeWarning.initModality(Modality.WINDOW_MODAL);
            fileTypeWarning.setScene(new Scene(
    			VBoxBuilder.create().children(notSupportedText, dissmiss).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
            fileTypeWarning.show();
    		
    		return null;
    	}
    	
    	String fileData = "";

        if (file != null)
        {
                BufferedReader fileBuffer = new BufferedReader(new FileReader(file));

                String line;
                while ((line = fileBuffer.readLine()) != null)
                {
                        fileData += line + "\n";
                }
                fileBuffer.close();
                //System.out.print(fileData);
        }

        return fileData;
    }

    public static void saveSelectedFile() throws IOException {
        /**
         * Called to save file, calls "Write file data" to save data.
         */
        final TextArea textBox = (TextArea)  TabPanes.getSelectedTab().getContent();

        boolean passedValidation = HTMLValidator.validateHTML(textBox.getText());
        
        if (passedValidation == false) {
            final Stage dialogStage = new Stage();
            Text validateResult = new Text("Your HTML did not validate correctly.");
            
            Button saveButton = new Button("Save");
            saveButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    try {
                        dialogStage.close();
                        writeFileData(textBox.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    textBox.setId("yes");
                }
            });
            
            Button cancelButton = new Button("Cancel");
            cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    dialogStage.close();
                }
            });
            
            //Creates custom dialog box detailing the results of the validation.
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
            children(validateResult, saveButton, cancelButton).
            alignment(Pos.CENTER).padding(new Insets(5)).build()));
            dialogStage.show();
        }
        
        else {
            try {
                writeFileData(textBox.getText());
                textBox.setId("yes");
            }
            catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static boolean hasExtension(File file)
    {
    	String fileName = file.getName();
    	
    	if (fileName.endsWith(".html") || fileName.endsWith(".htm") || fileName.endsWith(".shtml"))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public static boolean writeFileData(String bufferData) throws IOException
    {
            Stage FileManagerStage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save HTML File");
            fileChooser.setInitialFileName(".html");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                	"All Files (*.*)", "*.*"),
                new FileChooser.ExtensionFilter(
                	"HTML Files (*.html)", "*.html"),
                new FileChooser.ExtensionFilter(
                	"HTM Files (*.htm)", "*.htm"),
                new FileChooser.ExtensionFilter(
                	"SHTML Files (*.shtml)", "*.shtml"));
            
            //TODO automatically append file extension.
            File file = fileChooser.showSaveDialog(FileManagerStage);
            
            if(!hasExtension(file))
            {
            	file.renameTo(new File(file.getParentFile(), file.getName() + ".html"));
            }

            try {
                // Create the empty file with default permissions, etc.
                ;
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(bufferData);
                fileWriter.close();
            } catch (FileAlreadyExistsException x) {
                System.err.format("file named %s" +
                    " already exists\n", file);
                /*
                Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
            children(new Text("File already exits!")).
            alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.show();		   
        */ 
            } catch (IOException x) {
                // Some other sort of failure, such as permissions.
                System.err.format("createFile error: %s%n", x);
            }		

            return true;
    }

    public static File getFile()
    {
            Stage FileManagerStage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open HTML File");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "HTML Files (*.html)", "*.html"));
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "SHTML Files (*.shtml)", "*.shtml"));
            File file = fileChooser.showOpenDialog(FileManagerStage);

            return file;
    }
    
    public static void openFile() throws IOException
    {
    	File file = getFile();
    	openFile(file);
    }
    
    public static void openFile(File file) throws IOException{
        if(file != null)
            {
        		Tab newTab = HtmlTab.createTab(file.getName(), FileManager.retrieveFileData(file));
				TabPanes tabPane = TabPanes.getInstance();
                tabPane.addTab(newTab);
            }
        
        //TODO Override the default unmodified new file (not a neccisary feature)
        /*for (Tab tab : TabPanes.getTabs()) {
            if (tab.getText().equals(TabPanes.getNewTabName())) {
                TabPanes.getTabs().remove(tab);
            }
        }
        */
    }
}

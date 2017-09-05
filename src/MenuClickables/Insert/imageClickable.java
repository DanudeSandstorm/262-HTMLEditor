
package MenuClickables.Insert;

import Editor.TabPanes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Grant Gadomski
 */
public class imageClickable {
    /**
     * Creates a new menu item, sets it's onAction to call imagePopup().
     * @param name: The name of the MenuItem to create.
     * @return The MenuItem created.
     */
    public static MenuItem setClickable(final String name ) {
        MenuItem imageItem = new MenuItem(name);        
        imageItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                imagePopup();
            }
        });
        return imageItem;
    }
    
    /**
     * Creates a pop up for the user to enter the url of their image.
     */
    public static void imagePopup() {
        final Stage imageStage = new Stage();
        
        Label imageLabel = new Label("Please put a url for your image");
        final TextField imageField = new TextField();
        Button submitButton = new Button("Ok");
        
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                imageStage.close();
                String imageText = imageField.getText();
                addImage(imageText);
            }
        });
        submitButton.setDefaultButton(true);
        
        imageStage.initModality(Modality.WINDOW_MODAL);
        imageStage.setScene(new Scene(VBoxBuilder.create().
                children(imageLabel, imageField, submitButton)
                .alignment(Pos.CENTER).padding(new Insets(5)).build()));
        imageStage.show();
    }
    
    /**
     * Adds the image tag to the text editor.
     * @param imageText: The text to place within the <img> tag as the src. 
     */
    public static void addImage(String imageText) {
    	TextArea textBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretPosition = textBox.getCaretPosition();
        
        textBox.insertText(caretPosition, "<img src=\"" + imageText + "\">");
    }
}

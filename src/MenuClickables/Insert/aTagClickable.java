
package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Editor.TabPanes;

/**
 *
 * @author Grant Gadomski
 */
public class aTagClickable {
    /**
     * Creates a new MenuItem, sets it's onAction to all aTagPopup().
     * @param name: The name of the MenuItem to create.
     * @return The <a> MenuItem.
     */
    public static MenuItem setClickable(final String name) {
        MenuItem aItem = new MenuItem(name);
        aItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                aTagPopup();
            }
        });
        return aItem;
    }
    
    /**
     * Creates a pop up for the user to create a new <a> tag.
     */
    public static void aTagPopup() {
        final Stage aStage = new Stage();
        
        Label aTagLabel = new Label("Add a link for your <a> tag.");
        final TextField aField = new TextField();
        Button submitButton = new Button("Ok");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                aStage.close();
                String aText = aField.getText();
                addATag(aText);
            }
        });
        submitButton.setDefaultButton(true);
        
        aStage.initModality(Modality.WINDOW_MODAL);
        aStage.setScene(new Scene(VBoxBuilder.create().
                children(aTagLabel, aField, submitButton)
                .alignment(Pos.CENTER).padding(new Insets(5)).build()));
        aStage.show();
    }
    
    /**
     * Adds a new <a> tag with the href being whatever's passed through aText.
     * @param aText: The text to reference in the href of the anchor tag.
     */
    public static void addATag(String aText) {
    	TextArea textBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretPosition = textBox.getCaretPosition();
        
        textBox.insertText(caretPosition, "<a href=\"" + aText + "\"></a>");
    }
}

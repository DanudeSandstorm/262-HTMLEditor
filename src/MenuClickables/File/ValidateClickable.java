package MenuClickables.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Editor.TabPanes;
import HTMLValidator.HTMLValidator;

/**
 * @author ?, Grant Gadomski
 */
public class ValidateClickable
{
    /**
     * Creates a menu clickable, calls HTMLValidator.validateHTHML to ensure the HTML is valid
     * and presents a pop up detailing the results.
     * @param name: The name of the menu item to create.
     * @return The MenuItem to add to a menu.
     */
    public static MenuItem setClickable(final String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent t)
            {
                TextArea textBox = (TextArea) TabPanes.getSelectedTab().getContent();
                String currentText = textBox.getText();

                boolean passValidation = HTMLValidator.validateHTML(currentText);
                
                String validateResult;
                if (passValidation) validateResult = "Your HTML validated!";
                else validateResult = "Your HTML did not validate correctly.";

                // Creates custom dialog box detailing the results of the
                // validation.
                final Stage dialogStage = new Stage();

                Button okButton = new Button("Ok");
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {
                        dialogStage.close();
                    }
                });

                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create()
                        .children(new Text(validateResult), okButton)
                        .alignment(Pos.CENTER).padding(new Insets(5))
                        .build()));
                dialogStage.show();
            }
        });
        return newItem;
    }
}

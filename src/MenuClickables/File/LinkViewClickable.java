
package MenuClickables.File;

import Editor.TextBox;
import HTMLHelper.LinkView;
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

/**
 *
 * @author Grant Gadomski
 */
public class LinkViewClickable {
    /**
     * Creates a MenuItem, sets it's onAction to show the link view pop-up.
     * @param name: The name of the MenuItem to create.
     * @return The MenuItem created.
     */
    public static MenuItem setClickable(final String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                showLinkView();
            }
        });
        return newItem;
    }
    
    /**
     * Creates a new pop-up displaying the link view.
     */
    public static void showLinkView() {
        final Stage popupStage = new Stage();
        Text headerText = new Text("Your Current Links");
        
        Button alphaButton = new Button("Alphabetical Order");
        Button chronButton = new Button("Chronological Order");
        
        final String html = TextBox.getActiveTextArea().getText();
        final TextArea display = new TextArea();
        display.setEditable(false);
        
        display.setText(LinkView.chronOrder(html));        
        
        alphaButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                display.setText(LinkView.alphOrder(html));
            }
        });
        
        chronButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                display.setText(LinkView.chronOrder(html));
            }
        });
        alphaButton.setDefaultButton(true);
        
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.setScene(new Scene(VBoxBuilder.create().
                children(headerText, alphaButton, chronButton, display).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        
        popupStage.show();
    }
}

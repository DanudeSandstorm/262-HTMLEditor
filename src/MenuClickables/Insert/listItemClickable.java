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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Editor.TabPanes;
import HTMLHelper.IndentationManager;
import HTMLHelper.TagMatcher;
import HTMLValidator.ListItemTag;

/**
 * 
 * @author ?, Grant Gadomski
 */
public class listItemClickable
{
    /**
     * Creates a MenuItem, sets it's onAction to generate a new list item tag.
     * @param name: The name of the MenuItem to create.
     * @return The MenuItem created.
     */
    public static MenuItem setClickable(final String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                TagMatcher.generateTag(new ListItemTag());
            }
        });
        return newItem;
    }
    
    /**
     * Creates a pop up asking how many items to add to the list.
     * @param ordered: If true, create ordered list. If false create
     * unordered list.
     */
    public static void listItemPopup(final boolean ordered) {
        final Stage itemPopupStage = new Stage();

        String headerString;
        if (ordered) {
            headerString = "Add an Ordered List";
        }
        else {
            headerString = "Add an Unordered List";
        }
        Text headerText = new Text(headerString);

        Label itemsNumberLabel = new Label("How many items would you like?");

        final TextField itemsNumberField = new TextField() {
            public void handle(KeyEvent ke) {
                char rawInput[] = ke.getCharacter().toCharArray();
                char input = rawInput[ke.getCharacter().toCharArray().length - 1];

                if ((input < '0') || (input > '9')) {
                    ke.consume();
                }
            }
        };

        Button submitButton = new Button("Ok");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent ae) {
                int itemsNumber = Integer.parseInt(itemsNumberField.getText());
                
                createList(ordered, itemsNumber);
                itemPopupStage.close();
            }
        });
           
        submitButton.setDefaultButton(true);

        itemPopupStage.initModality(Modality.WINDOW_MODAL);
        itemPopupStage.setScene(new Scene(VBoxBuilder.create().
                children(headerText, itemsNumberLabel, itemsNumberField, submitButton).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        itemPopupStage.show();
    }
    
    /**
     * Creates the list tags on the screen.
     * @param ordered: If true, creates ordered list. If false,
     * creates unordered list.
     * @param itemsNumber: Number of list items to generate.
     */
    public static void createList(boolean ordered, int itemsNumber) {
        String openTag;
        String closeTag;
        if (ordered) {
            openTag = "<ol>";
            closeTag = "</ol>";
        }
        else {
            openTag = "<ul>";
            closeTag = "</ul>";
        }
        
        TextArea textBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretPosition = textBox.getCaretPosition();
        
        textBox.insertText(caretPosition, (openTag + "\n"));
        caretPosition += 5;
        textBox.positionCaret(caretPosition);
        /*TODO: Call indent manager to indent to the proper position + 1, loop
        * itemsNumber of times, adding <li></li> in, at the proper tabulation
        * position. Detab by one and add closeTag.
        */
        
        int tabNumber = (IndentationManager.getIndentation() + 1);
        System.out.println("tabNumber: " + tabNumber); //DEbug
        for (int i=0; i<itemsNumber; i++) {
            for (int j=0; j<tabNumber; j++) {
                textBox.insertText(caretPosition, "\t");
                caretPosition += 1;
                textBox.positionCaret(caretPosition);
            }
            textBox.insertText(caretPosition, "<li></li>\n");
            caretPosition += 10;
            textBox.positionCaret(caretPosition);
        }
        textBox.positionCaret(caretPosition);
        textBox.insertText(caretPosition, closeTag+"\n");
        caretPosition += 5;
        textBox.positionCaret(caretPosition);
    }
}

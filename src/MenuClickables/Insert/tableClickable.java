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

/**
 * 
 * @author ?, Grant Gadomski
 */
public class tableClickable
{
    public static MenuItem setClickable(String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                tablePopup();
            }
        });
        return newItem;
    }

    /**
     * Displays a GUI pop up for the user to create a table.
     */
    public static void tablePopup() {
        final Stage tableStage = new Stage();
        Text headerText = new Text("Create a Table");

        Label numRowsLabel = new Label("How many Rows?");
        Label numColsLabel = new Label("How many Columns?");

        final TextField numRowsField = new TextField() {
            public void handle(KeyEvent ke) {
                char rawInput[] = ke.getCharacter().toCharArray();
                char input = rawInput[ke.getCharacter().toCharArray().length - 1];

                if (input < '0' || input > '9') {
                    ke.consume();
                }
            }
        };

        final TextField numColsField = new TextField() {
            public void handle(KeyEvent ke) {
                char rawInput[] = ke.getCharacter().toCharArray();
                char input = rawInput[ke.getCharacter().toCharArray().length - 1];

                if (input < '0' || input > '9') {
                    ke.consume();
                }
            }
        };

        Button submitButton = new Button("Ok");
            
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                int numRows = Integer.parseInt(numRowsField.getText());
                int numCols = Integer.parseInt(numColsField.getText());
                
                createTable(numRows, numCols);
                tableStage.close();
            }
        });    
        
        submitButton.setDefaultButton(true);
    
        tableStage.initModality(Modality.WINDOW_MODAL);
        tableStage.setScene(new Scene(VBoxBuilder.create().
                children(headerText, numRowsLabel, numRowsField,
                        numColsLabel, numColsField, submitButton).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        tableStage.show();
    }
    
    /**
     * Adds the desired number of tab spaces.
     * @param textBox: The textBox in which to add the spaces.
     * @param caretPosition: The current position of the caret.
     * @param tabs: The number of tabs to insert.
     * @return The new position of the caret.
     */
    public static int addIndents(TextArea textBox, int caretPosition, int tabs) {
        for (int i=0; i<tabs; i++) {
            textBox.insertText(caretPosition, "\t");
            caretPosition++;
            textBox.positionCaret(caretPosition);
        }
        return caretPosition;
    }
	
    /**
     * Builds the outline code for the table.
     * @param numRows: Number of rows requested.
     * @param numCols: Number of columns requested.
     */
    public static void createTable(int numRows, int numCols) {
    	TextArea textBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretPosition = textBox.getCaretPosition();
        
        textBox.insertText(caretPosition, "<table>\n"); //Adds the opening table tag.
        caretPosition += 8;
        textBox.positionCaret(caretPosition);
        
        int currentIndentation = IndentationManager.getIndentation();
        int headBodyIndentation = currentIndentation + 1;
        int trIndentation = currentIndentation + 2;
        int tdIndentation = currentIndentation + 3;
        
        caretPosition = addIndents(textBox, caretPosition, headBodyIndentation);
        textBox.insertText(caretPosition, "<thead></thead>\n"); //Adds table head tag.
        caretPosition += 16;
        textBox.positionCaret(caretPosition);
        
        caretPosition = addIndents(textBox, caretPosition, headBodyIndentation);
        textBox.insertText(caretPosition, "<tbody>\n"); //Adds the opening table body tag.
        caretPosition += 8;
        textBox.positionCaret(caretPosition);
        
        for (int trInt=0; trInt<numRows; trInt++) { //Loops, adding the specified number of table row tags.
            caretPosition = addIndents(textBox, caretPosition, trIndentation);
            textBox.insertText(caretPosition, "<tr>\n");
            caretPosition += 5;
            textBox.positionCaret(caretPosition);
            
            for (int tdInt=0; tdInt<numCols; tdInt++) { //Loops, adding the specified number of table data tags
                caretPosition = addIndents(textBox, caretPosition, tdIndentation);
                textBox.insertText(caretPosition, "<td></td>\n");
                caretPosition += 10;
                textBox.positionCaret(caretPosition);
            }
            
            caretPosition = addIndents(textBox, caretPosition, trIndentation);
            textBox.insertText(caretPosition, "</tr>\n"); //Closes the table row tag.
            caretPosition += 6;
            textBox.positionCaret(caretPosition);
        }
        
        caretPosition = addIndents(textBox, caretPosition, headBodyIndentation);
        textBox.insertText(caretPosition, "</tbody>\n"); //Closes the table body tag.
        caretPosition += 9;
        textBox.positionCaret(caretPosition);
        
        caretPosition = addIndents(textBox, caretPosition, currentIndentation);
        textBox.insertText(caretPosition, "</table>\n"); //Closes the table tag.
        caretPosition += 9;
        textBox.positionCaret(caretPosition);
    }
}


package HTMLHelper;

import javafx.scene.control.TextArea;
import Editor.TabPanes;

/**
 *
 * @author Grant Gadomski
 */
public class IndentationManager {
    public static int getIndentation() {
        /**
         * @returns The indentation level of the line above.
         */
        int currentIndentation = 0;
        
        TextArea currentTextBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretLocation = currentTextBox.getCaretPosition();
        final int startingCaretLocation = caretLocation;
        
        for (int i=0; i<2; i++) { //Reverts the cursor back to the start of the line above.
            while ((currentTextBox.getText(caretLocation-1, caretLocation).equals("\n")) == false && (caretLocation > 1)) {
                caretLocation -= 1;
            }
        }
        
        if (caretLocation == 0) {
            caretLocation += 1;
        }
        
        while ((caretLocation > 0) && (caretLocation <= currentTextBox.getLength()) && (currentTextBox.getText(caretLocation-1, caretLocation).equals("\t"))) {
            currentIndentation += 1; //Adds to current indentation so long as it keeps reading tabs.
            caretLocation += 1;
            currentTextBox.positionCaret(caretLocation);
        }
        
        currentTextBox.positionCaret(startingCaretLocation);
        return currentIndentation;
    }
    
    public static void setIndentation() {
        /**
         * Sets the indentation for the next line.
         */
        int currentIndentation = getIndentation();
        
        TextArea currentTextBox = (TextArea) TabPanes.getSelectedTab().getContent();
        int caretLocation = currentTextBox.getCaretPosition();
        
        alterIndentation(currentTextBox, currentIndentation, caretLocation);
    }
    
    public static void alterIndentation(TextArea currentTextBox, int caretLocation, int expectedIndentation) {
        /**
         * If an open tag is the last thing on the previous line, iterates the tab
         * by plus one.
         * Takes in the cursor's current location where the user pressed enter,
         * and the current selected text box.
         */ 
        currentTextBox.insertText(caretLocation, "\n");
        caretLocation += 1;
        currentTextBox.positionCaret(caretLocation+10);
        
        for (int i=0; i<expectedIndentation; i++) {
            currentTextBox.insertText(caretLocation, "\t");
            caretLocation += 1;
            currentTextBox.positionCaret(caretLocation);
        }
        currentTextBox.positionCaret(caretLocation-2);
    }
}
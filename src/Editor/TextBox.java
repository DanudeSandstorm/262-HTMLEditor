package Editor;


import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import UndoRedo.UndoRedoController;

/**
 * @authors Grant Gadomski, Daniel Santoro
 */
public class TextBox extends TextArea {    
	
    private static boolean textWrap = false;
    private static long lastActive;
    private static Map<TextArea, UndoRedoController> undoRedoControllers = new HashMap<TextArea, UndoRedoController>();
	
    /**
     * @param bounds: The dimensions of the screen, could be used to make the text area full size.
     * @return A newly created ScrollPane containing a new text box.
     */
    public TextArea createTextBox(double width, double height) {
        final TextArea textBox = new TextArea();
        
        textBox.setPrefWidth(width);
        textBox.setPrefHeight(height);
        textBox.setId("yes");

        lastActive = System.currentTimeMillis();
        UndoRedoController controller = new UndoRedoController(textBox);
        undoRedoControllers.put(textBox, controller);
        
        textBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                textBox.setId("no");
                UndoRedoController currentController = getController(textBox);
                
                if ((System.currentTimeMillis() - lastActive) >= 1000) {
                    //Saves state of document
                    currentController.addState(textBox.getText());
                    currentController.toggleFix();
                    lastActive = System.currentTimeMillis();
                }
                
                if ((ke.getCode().equals(KeyCode.ENTER)) ||
                        ke.getCode().equals(KeyCode.SPACE)) {
                    if (textBox.getCaretPosition() > 1) {
                        String wordToPush = "";
                        int startingCaretPosition = textBox.getCaretPosition();
                        textBox.positionCaret(startingCaretPosition - 1);
                        String currentText = textBox.getText(startingCaretPosition-2, startingCaretPosition-1);
                        
                        while ((currentText.equals(" ") == false) && (currentText.equals("\n") == false) &&
                                textBox.getCaretPosition() != 0) {
                            wordToPush += currentText;
                            int currentPosition = textBox.getCaretPosition();
                            textBox.positionCaret(currentPosition-1);
                            currentText = textBox.getText(currentPosition-1, currentPosition);
                        }
                    
                        textBox.positionCaret(startingCaretPosition);

                        if (wordToPush.equals("") == false) {
                            //Saves the word.
                            currentController.addWord(wordToPush);
                        }
                    }
                }
            }
        });
        
        return textBox;
    }
    
    /**
     * Toggles the state of the text wrap for all tabs currently open.
     */
    public static void toggleTextWrap() {

        textWrap = !textWrap; //Switch the textWrap
        
    	TabPanes tabPane = TabPanes.getInstance();
	    ObservableList<Tab> tabs = tabPane.getTabs();
	    
        //Set the text wrap in each textBox
        for (Tab tab : tabs) {
        	TextArea textBox = (TextArea) tab.getContent();
            
            textBox.setWrapText(textWrap);
        }  
    }
    
    /**
     * @return The current state of textWrap.
     */
    public static boolean getTextWrap() {
    	return textWrap;
    }

    /**
     * @return The text area in the current tab.
     */
    public static TextArea getActiveTextArea() {
    	TextArea currentTextArea = (TextArea) TabPanes.getSelectedTab().getContent();
        return currentTextArea;
    }
    
    /**
     * @param textArea: The text area to get the undo redo of.
     * @return The controller associated with the undo redo passed in.
     */
    public static UndoRedoController getController(TextArea textArea) {
        return undoRedoControllers.get(textArea);
    }
    
}

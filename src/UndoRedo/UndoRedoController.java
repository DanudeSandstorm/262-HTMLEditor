package UndoRedo;

import javafx.scene.control.TextArea;
import Editor.TextBox;



public class UndoRedoController {
    TextArea textBox;
    private UndoRedo state;
    private UndoRedo word;
    private boolean bugFix;

    public UndoRedoController(TextArea textBox){
            this.textBox = textBox;
            state = new UndoRedo(50);
            word = new UndoRedo(3);
            bugFix = false;
    }

    /**
     * Adds the passed in state to the undo stack
     * @param text A string containing the state of the document
     */
    public void addState(String text){
            state.add(text);
    }

    /**
     * Adds the passed in string of characters to the undo stack
     * @param text A string containing a "word"
     */
    public void addWord(String text){
            word.add(text);
    }

    /**
     * The undo operation for the text area
     * Checks the word undo stack; if it has an entry, it undoes the
     * typing of the word. If empty, it will check the state undo stack and restore
     * the document to a previous state.
     */
    public void undo(){
    	final TextArea textBox = TextBox.getActiveTextArea();
        int startCaretPosition = textBox.getCaretPosition();
        
        String text;
        if ((text = word.undo()) != null){
                for (int i = 0; i <= text.length(); i++){
                	textBox.deletePreviousChar();
                }
                if (bugFix == false){
                	bugFix = true;
                	state.undo(); //undoes the first state to fix a bug
                }
        }
        else if ((text = state.undo()) != null){
            int beforeLength = textBox.getLength();

            textBox.setText(text);
            int newCaretPosition;
            int newLength = textBox.getLength();
            if (startCaretPosition > newLength) {
                newCaretPosition = newLength;
            }
            else {
                int lengthDifference = beforeLength - newLength;
                newCaretPosition = startCaretPosition - lengthDifference;
            }
            textBox.positionCaret(newCaretPosition);
        }
    }
    
    /**
     * Turns the bug fix variable to false
     */
    public void toggleFix(){
    	bugFix = false;
    }

    /**
     * The redo operation for the text area
     * Checks the state redo stack; if it has an entry, changes the state of the
     * document to a future state. If empty, it will check whether the word redo stack 
     * has an entry and restores an undone word.
     */
    public void redo(){
		TextArea textBox = TextBox.getActiveTextArea();
        int startCaretPosition = textBox.getCaretPosition();
        
        String text;
        if ((text = state.redo()) != null){
            textBox.setText(text);
            int newLength = textBox.getLength();
            if (startCaretPosition > newLength) {
                startCaretPosition = newLength;
            }
            textBox.positionCaret(startCaretPosition);
        }
        else if ((text = word.redo()) != null){
        	textBox.insertText(startCaretPosition, text);
        }
    }
}

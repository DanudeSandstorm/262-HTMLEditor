package UndoRedo;

/**
 * Stores a limited sized stack of strings that the user can undo/redo
 */
public class UndoRedo {
	
	FixedStack<String> undoStack;
	FixedStack<String> redoStack;
	
	/**
	 * @param maxsize The amount of undo's that are stored
	 */
	public UndoRedo(int maxsize){
		undoStack = new FixedStack<String>(new String[maxsize]);
		redoStack = new FixedStack<String>(new String[maxsize]);
	}
	
	/**
	 * Adds text to the undo stack and clears the redo stack
	 * @param text The text to be added
	 */
	public void add(String text){
		undoStack.push(text);
		clearRedo();
	}
	
	/**
	 * Takes the top item from the undo stack and moves it to the redo stack
	 * @return A string of text to be undone or null if no more items are in the stack
	 */
	public String undo(){
		if (undoStack.isEmpty()) return null;
		
		String text = undoStack.pop();
		redoStack.push(text);
		 
		return text;
	}
	
	/**
	 * Takes the top item from the redo stack and moves it to the undo stack
	 * @return A string of text to be redone or null if no more items are in the stack
	 */
	public String redo(){
        if (redoStack.isEmpty()) return null;

        String text = redoStack.pop();
        undoStack.push(text);

        return text;
	}
        
	/**
	 * Clears the redo stack
	 */
	public void clearRedo(){
        redoStack.clear();
	}
	
	/**
	 * Clears the undo stack
	 */
	public void clearUndo(){
		undoStack.clear();
	}

}

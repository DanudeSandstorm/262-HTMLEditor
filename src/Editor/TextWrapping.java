package Editor;

public class TextWrapping {
	
    private static TextWrapping tw = null;
	
    private static boolean textWrap = false;
    
    private TextWrapping(){ }

    public static TextWrapping getInstance(){
            //Lazy Initialization
            if (tw == null){
                    tw = new TextWrapping();
            }
            return tw;
    }

    /**
     * @return The current text wrap setting.
     */
    public boolean getTextWrap(){
        return textWrap;
    }

    /**
     * Changes the text wrap setting, called by changeTextWrapping().
     */
    public void toggleTextWrap(){
        if (textWrap) {
            textWrap = false;
        }
        else {
            textWrap = true;
        }
    }

    /**
     * Sets the current textWrap value to be what's passed in.
     * @param bool: The value to set the text wrap to.
     */
    public void setTextWrap(boolean bool){
            textWrap = bool;
    }
	
}

package HTMLHelper;

import javafx.scene.control.TextArea;
import Editor.TabPanes;
import Editor.TextBox;
import HTMLValidator.Tag;
import UndoRedo.UndoRedoController;

/**
 *
 * @author Grant Gadomski
 */
public class TagMatcher {
    public static void generateTag(Tag tag) {
        /**
         * Adds the tag and end tag to the page, places the cursor in between the
         * tags.
         */
        TabPanes tabPane = TabPanes.getInstance();
        if (tabPane.getTabs().isEmpty() == false) {
            TextArea currentTextArea = (TextArea) TabPanes.getSelectedTab().getContent();
            UndoRedoController controller = TextBox.getController(currentTextArea);
            controller.addState(currentTextArea.getText());
            currentTextArea.setId("no");
            
            currentTextArea.insertText(currentTextArea.getCaretPosition(), "<" + tag.getName() + ">");
            currentTextArea.insertText(currentTextArea.getCaretPosition(), "</" + tag.getName() + ">");
            currentTextArea.positionCaret((currentTextArea.getText().length()) - (("</" + tag.getName() + ">").length()));
        }
    }
}
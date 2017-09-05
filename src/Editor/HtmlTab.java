package Editor;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Grant Gadomski, Daniel Santoro
 */
public class HtmlTab {    
    public static Tab createTab(String tabName, String initText) {
        /**
         * @return New tab with an empty text box in it.
         * Note: You can get the tab's stuff via Tab.getText or Tab.getContent.
         * Get the actual tab itself via HtmlEditor.getSelectedTab().
         */
    	final Tab tab = new Tab();
    	final TextBox textBox = new TextBox();
        final TextArea theTextBox = textBox.createTextBox(
        		HtmlEditor.getWindowWidth(), HtmlEditor.getWindowHeight());
        
        theTextBox.insertText(0, initText);
        tab.setContent(theTextBox);
        theTextBox.setId("yes");
        tab.setText(tabName);
        
        Hyperlink hyperLink = new Hyperlink();
        Image closeImage = new Image(
        		HtmlTab.class.getResourceAsStream("close.png"), 17, 17, false, false);
        hyperLink.setGraphic(new ImageView(closeImage));
        hyperLink.setFocusTraversable(false);
        tab.setGraphic(hyperLink);
        
        hyperLink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {                
            	TextArea textArea = (TextArea) tab.getContent();

                if (textArea.getId().equals("no")) {
                    CheckClosed.closeTab(tab);
                }
                else {
                    tab.getTabPane().getTabs().remove(tab);
                }
            }
        });
        
        return tab;
    }
}

package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * 
 * @author ?, Grant Gadomski
 */
public class unorderedListClickable
{
    public static MenuItem setClickable(String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                listItemClickable.listItemPopup(false);
            }
    });
            return newItem;
    }
}

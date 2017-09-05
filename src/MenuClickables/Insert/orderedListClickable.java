package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

/**
 * 
 * @author ?, Grant Gadomski
 */
public class orderedListClickable
{
    /**
     * Creates a new MenuItem, sets it's onAction to call listItemClickable.listItemPopup(true).
     * The true parameter means to create an ordered list.
     * @param name: The name of the MenuItem to create.
     * @return The created MenuItem.
     */
    public static MenuItem setClickable(String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                listItemClickable.listItemPopup(true);
            }
    });
            return newItem;
    }
}

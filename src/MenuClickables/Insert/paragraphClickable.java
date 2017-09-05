package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import HTMLHelper.TagMatcher;
import HTMLValidator.ParaTag;

public class paragraphClickable
{
    public static MenuItem setClickable(final String name) {
        // TODO Auto-generated method stub
        MenuItem newItem = new MenuItem(name);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                TagMatcher.generateTag(new ParaTag());
            }
        });
        return newItem;
    }
}

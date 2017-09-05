package MenuClickables.File;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import FileManager.FileManager;

/**
 * @author ?
 */
public class saveClickable
{
    public static MenuItem setClickable(final String name)
    {
        MenuItem newItem = new MenuItem(name);
        newItem .setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                try {
                    FileManager.saveSelectedFile();
                } catch (IOException ex) {
                    Logger.getLogger(
                        name).log(
                                Level.SEVERE, null, ex);
                }
            }
        });
        return newItem;
    }
}

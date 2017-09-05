package MenuClickables;

import Editor.TextBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class textWrapClickable {

	public static MenuItem setClickable(final String name)
	{
		final MenuItem newItem = new MenuItem(name);
		newItem.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent t)
			{
				TextBox.toggleTextWrap();
				if (TextBox.getTextWrap()){
					newItem.setText("\u2713" + name);
				}
				else {
					newItem.setText(name);
				}
			}
		});
		return newItem;
	}
}
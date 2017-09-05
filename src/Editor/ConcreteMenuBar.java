package Editor;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import MenuClickables.*;
import MenuClickables.File.LinkViewClickable;
import MenuClickables.File.ValidateClickable;
import MenuClickables.File.exitClickable;
import MenuClickables.File.newClickable;
import MenuClickables.File.openClickable;
import MenuClickables.File.saveClickable;
import MenuClickables.Insert.aTagClickable;
import MenuClickables.Insert.bodyClickable;
import MenuClickables.Insert.boldClickable;
import MenuClickables.Insert.descDataClickable;
import MenuClickables.Insert.descListClickable;
import MenuClickables.Insert.descTermClickable;
import MenuClickables.Insert.headClickable;
import MenuClickables.Insert.headingClickable;
import MenuClickables.Insert.htmlClickable;
import MenuClickables.Insert.imageClickable;
import MenuClickables.Insert.listItemClickable;
import MenuClickables.Insert.orderedListClickable;
import MenuClickables.Insert.paragraphClickable;
import MenuClickables.Insert.tableClickable;
import MenuClickables.Insert.tableDataClickable;
import MenuClickables.Insert.tableHeadClickable;
import MenuClickables.Insert.tableRowClickable;
import MenuClickables.Insert.unorderedListClickable;

/**
 * 
 * @author ?
 */
public class ConcreteMenuBar
{
	public static MenuBar createMenuBar()
	{
		//Create menu bar
		MenuBar menuBar = new MenuBar();
		
		//Create File menu
		Menu File = createFileMenu();
		
		//Create Edit menu
		Menu Edit = createEditMenu();
			
		//Create View menu
		Menu View = createViewMenu();
		
		//Create Insert menu
		Menu Insert = createInsertMenu();
			
		menuBar.getMenus().addAll(File, Edit, View, Insert);
		
		return menuBar;
	}
	
        /**
         * Creates the file menu.
         * @return Menu: The file menu for the menu bar.
         */
	private static Menu createFileMenu()
	{
		Menu File = new Menu("File");
		
		MenuItem New = newClickable.setClickable("New");
		MenuItem Save = saveClickable.setClickable("Save");
		MenuItem Open = openClickable.setClickable("Open");
		MenuItem Validate = ValidateClickable.setClickable("Validate");
                MenuItem LinkView = LinkViewClickable.setClickable("View Links");
		MenuItem Exit = exitClickable.setCLickable("Exit");
	
		File.getItems().addAll(New, Save, Open, Validate, LinkView, Exit);
		
		return File;
	}
	
        /**
         * Creates the edit menu.
         * @return Menu: The Edit menu for the menu bar.
         */
	private static Menu createEditMenu()
	{
		Menu Edit = new Menu("Edit");
		
		//TODO Implement Undo, Redo, Cut, Copy, and Paste Clickables.
		MenuItem Undo = undoClickable.setClickable("Undo");
		MenuItem Redo = redoClickable.setClickable("Redo");
		
		Edit.getItems().addAll(Undo, Redo);
		
		return Edit;
	}
	
        /**
         * Creates the view menu.
         * @return Menu: The View menu for the menu bar.
         */
	private static Menu createViewMenu()
	{
		Menu View = new Menu("View");
		MenuItem TextWrap = textWrapClickable.setClickable("Text Wrap");
		
		View.getItems().addAll(TextWrap);
		
		return View;
	}
	
        /**
         * Creates the Insert Menu.
         * @return Menu: The Insert menu for the menu bar.
         */
	private static Menu createInsertMenu()
	{
		Menu Insert = new Menu("Insert");
		
		Menu Document = createDocumentMenu();
		Menu FontStyles = createFontStylesMenu();
		Menu Heading = createHeadingMenu();
		Menu Lists = createListsMenu();
		
		Insert.getItems().addAll(Document, FontStyles, Heading, Lists);
		
		return Insert;
	}

        /**
         * Creates the Document submenu under the Insert menu.
         * @return Menu: The Document submenu for the Insert menu.
         */
	private static Menu createDocumentMenu()
	{
		Menu Document = new Menu("Document");
		
		MenuItem HTML = htmlClickable.setClickable("HTML");
		MenuItem Head = headClickable.setClickable("Head");
		MenuItem Body = bodyClickable.setClickable("Body");
		MenuItem Paragraph = paragraphClickable.setClickable("Paragraph");
        MenuItem anchor = aTagClickable.setClickable("Anchor");
        MenuItem image = imageClickable.setClickable("Image");
		
		Document.getItems().addAll(HTML, Head, Body, Paragraph, anchor, image);
		
		return Document;
	}
	
        /**
         * Creates the Font Styles submenu under the Insert menu.
         * @return Menu: The Font Styles submenu.
         */
	private static Menu createFontStylesMenu()
	{
		Menu FontStyles = new Menu("Font Styles");
		
		MenuItem Bold = boldClickable.setClickable("Bold");
		//TODO Implement Italics Clickable.
		
		FontStyles.getItems().addAll(Bold); // Italics not added yet
		
		return FontStyles;
	}
	
        /**
         * Creates the Heading submenu under the Insert menu.
         * @return Menu: The Heading submenu.
         */
	private static Menu createHeadingMenu()
	{
		Menu Heading = new Menu("Heading");
		
		MenuItem Level_1 = headingClickable.setClickable("Level 1", 1);
		MenuItem Level_2 = headingClickable.setClickable("Level 2", 2);
		MenuItem Level_3 = headingClickable.setClickable("Level 3", 3);
		MenuItem Level_4 = headingClickable.setClickable("Level 4", 4);
		MenuItem Level_5 = headingClickable.setClickable("Level 5", 5);
		MenuItem Level_6 = headingClickable.setClickable("Level 6", 6);
			
		Heading.getItems().addAll(Level_1, Level_2, Level_3,
				Level_4, Level_5, Level_6);
		
		return Heading;
	}
	
        /**
         * Creates the Lists submenu under the Insert menu.
         * @return Menu: The Lists submenu.
         */
	private static Menu createListsMenu()
	{
		Menu Lists = new Menu("Lists");
		
		Menu GeneralList = createGeneralListMenu();
		Menu Description = createDescriptionListMenu();
		Menu Table = createTableMenu();
		
		Lists.getItems().addAll(GeneralList, Description, Table);
		
		return Lists;
	}
	
        /**
         * Creates the General List submenu under the Insert menu.
         * @return Menu: The General List submenu.
         */
	private static Menu createGeneralListMenu()
	{
		Menu GeneralList = new Menu("General List");
		
		// TODO Implement createListClickable
		MenuItem OrderedList = orderedListClickable.setClickable("Ordered List");
		MenuItem UnorderedList = unorderedListClickable.setClickable("Unordered List");
		MenuItem ListItem = listItemClickable.setClickable("List Item");
		
		GeneralList.getItems().addAll(OrderedList, UnorderedList, ListItem);
		
		return GeneralList;
	}
	
        /**
         * Creates the Description List submenu under the Insert menu.
         * @return Menu: The Description List submenu.
         */
	private static Menu createDescriptionListMenu()
	{
		Menu Description = new Menu("Description List");
		
		// TODO Implement createDescListClickable
		MenuItem DescriptionList = descListClickable.setClickable("Description List");
		MenuItem DescriptionTerm = descTermClickable.setClickable("Term");
		MenuItem DescriptionData = descDataClickable.setClickable("Data");
	
		Description.getItems().addAll(DescriptionList, DescriptionTerm, DescriptionData);
		
		return Description;
	}
	
        /**
         * Creates the Table submenu under the Insert menu.
         * @return Menu: The Table submenu.
         */
	private static Menu createTableMenu()
	{
		Menu Table = new Menu("Table");
		
		// TODO Implement createTableClickable
		MenuItem CreateTable = tableClickable.setClickable("Create");
		MenuItem TableHead = tableHeadClickable.setClickable("Head");
		MenuItem TableRow = tableRowClickable.setClickable("Row");
		MenuItem TableData = tableDataClickable.setClickable("Data");
		
		Table.getItems().addAll(CreateTable, TableHead, TableRow, TableData);
		
		return Table;
	}	
}

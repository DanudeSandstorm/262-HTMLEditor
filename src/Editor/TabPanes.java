package Editor;

import javafx.scene.control.SingleSelectionModel;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * 
 * @author Daniel Santoro, Grant Gadomski
 */
public class TabPanes {
	
    private static TabPanes tp = null;
	
    private static TabPane tabPane = new TabPane();
    
    private static String newTabName = "Untilted";
    
    private TabPanes(){ }

    public static TabPanes getInstance(){
            if (tp == null){
                    tp = new TabPanes();
            }
            return tp;
    }

    /**
     * Method for other classes to know with what name 
     * a new tab is instantiated with
     * @return The value of the name on a new tab
     */
    public String getNewTabName(){
        return newTabName;
    }

    /**
     * Adds a new tab
     */
    public void newTab(){
    	addTab(HtmlTab.createTab(newTabName, ""));
    }
	
    /**
     * Adds a tab to the window
     * @param newTab the tab to be added
     */
    public void addTab(final Tab newTab)
    {
    	tabPane.getTabs().addAll(newTab);
        setSelectedTab(tabPane.getTabs().size() - 1);
        
    }
            
    public TabPane getTabPane(){
    	return tabPane;
    }
	

    /**
     * @return The currently selected tab.
     */
    public static Tab getSelectedTab() {
    	 SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
         return tabPane.getTabs().get(selectionModel.getSelectedIndex());
    }
    
    /**
     * @return Currently opened tabs.
     */
    public ObservableList<Tab> getTabs() {
        return tabPane.getTabs();
    }

    /**
     * Selects the tab at the index specified as the currently selected tab.
     * @param index: The index of the tab to be selected.
     */
    public static void setSelectedTab(int index) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(index);
    }
    
    	
}

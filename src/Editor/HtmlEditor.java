package Editor;

import java.io.File;
import java.io.IOException;

import FileManager.FileManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * @author Daniel Santoro, Grant Gadomski
 */
public class HtmlEditor extends Application{

    private static String[] args;
    private static double windowWidth;
    private static double windowHeight;
    
    
	public static void main(String[] args)
    {
		HtmlEditor.args = args;
		launch(args);
    }

    /**
     * Initializes application window, first method called upon initialization.
     */
	@Override
	public void start(Stage stage) throws Exception {
        //Sets title of application.
        stage.setTitle("HTMLEditor");

        //Initializes window with specific dimensions
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        windowWidth = bounds.getWidth() * 4/5;
        windowHeight = bounds.getHeight() * 4/5;
        Scene scene = new Scene(new VBox(), windowWidth, windowHeight);
		
        //Initializes menu bar.
        MenuBar menuBar = ConcreteMenuBar.createMenuBar();
        
        //Start with a blank tab or the file the user loaded in
        TabPanes tabPane = TabPanes.getInstance();
        tabPane.getTabPane().setTabClosingPolicy(UNAVAILABLE); //Remove the ability to close tabs
        
        if (args.length != 0)
    	{
            String fileName = args[0];
                    String filePath = System.getProperty("user.dir") + "\\" + fileName;
            try
            {	
                System.out.println(filePath);
                File file = new File(filePath);		
                FileManager.openFile(file);
            } 
            catch (IOException e) {
                tabPane.newTab( );
            }
    	}
    	else {
    		tabPane.newTab();
    	}
        
        //Adds menu bar, tab pane to window.
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, tabPane.getTabPane());
        
        stage.setScene(scene);
        
        //Displays window.
        stage.show();
        
        //Sets up action listener for when a user hits the close button
        scene.getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(final WindowEvent ev) {
                CheckClosed.close(ev);
            }
        });
        
	}
	
	public static double getWindowWidth(){
		return windowWidth;
	}
	
	public static double getWindowHeight(){
		return windowHeight;
	}
	
	
}


/**
 * 
 */
package demo;
import javafx.application.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * @author DELL
 *
 */
public class BookMaintenance extends Application{

	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Application.launch(args);
//
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		Button btOK = new Button("OK");
//		Scene scene = new Scene(btOK, 200, 250);
//		primaryStage.setTitle("MyJavaFX"); // Set the stage title
//		primaryStage.setScene(scene); // Place the scene in the stage
//		primaryStage.show(); // Display the stage
		
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(0.5, 0.5, 0.5, 0.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		// Place nodes in the pane
		pane.add(new Label("Code:"), 0, 0);
		pane.add(new TextField(), 1, 0);
		pane.add(new Label("Title:"), 0, 1);
		pane.add(new TextField(), 1, 1);
		pane.add(new Label("Price:"), 0, 2);
		pane.add(new TextField(), 1, 2);
		pane.setPadding(new Insets(1,2,3,4));
		pane.getChildren().addAll(getFirstSet());
		pane.getChildren().addAll(getSecondSet());
		
		/*Button btAdd0 = new Button("Add ");
		pane.add(btAdd0, 1, 3);
		GridPane.setHalignment(btAdd0, HPos.LEFT);
		
		Button btAdd1 = new Button("Update");
		pane.add(btAdd1, 2, 3);
		GridPane.setHalignment(btAdd1, HPos.CENTER);
		
		Button btAdd2 = new Button("Delete");
		pane.add(btAdd2, 3, 3);
		GridPane.setHalignment(btAdd2, HPos.RIGHT);
		
		Button btAdd3 = new Button("Exit");
		pane.add(btAdd3, 4, 3);
		GridPane.setHalignment(btAdd3, HPos.LEFT);
		
		Button btAdd4 = new Button("First");
		pane.add(btAdd4, 1, 4);
		GridPane.setHalignment(btAdd4, HPos.CENTER);
		
		Button btAdd5 = new Button("Prev");
		pane.add(btAdd5, 2, 4);
		GridPane.setHalignment(btAdd5, HPos.LEFT);
		
		Button btAdd6 = new Button("Next");
		pane.add(btAdd6, 3, 4);
		GridPane.setHalignment(btAdd6, HPos.LEFT);
		
		Button btAdd7 = new Button("Last");
		pane.add(btAdd7, 4, 4);
		GridPane.setHalignment(btAdd7, HPos.LEFT);*/
		
		/*pane.setPadding(new Insets(11, 12, 10, 13));
		pane.setHgap(5);
		pane.setVgap(10);
		pane.getChildren().addAll(new Label("Code:"),new TextField());
		TextField tf = new TextField();
		tf.setPrefColumnCount(20);
		pane.getChildren().addAll(new Label("Title:"), tf);
		pane.getChildren().addAll(new Label("Price:"), new TextField());*/
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Book Maintenance ME"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

	}
	
	private HBox getFirstSet() {
		 HBox vBox = new HBox(15);
		 vBox.setPadding(new Insets(150, 5, 5, 5));
		 vBox.getChildren().add(new Label("      "));

		 Button[] courses = {new Button("Add"), new Button("Update"),
		 new Button ("Delete"), new Button ("Exit")};
		 for (Button course: courses) {
		 HBox.setMargin(course, new Insets(0, 0, 0, 2));
		 vBox.getChildren().add(course);
		 }
		
		 return vBox;
		 }
	
	private HBox getSecondSet() {
		 HBox vBox = new HBox(15);
		 vBox.setPadding(new Insets(200, 5, 5, 5));
		 vBox.getChildren().add(new Label("      "));

		 Button[] courses = {new Button("First"), new Button("Prev     "),
		 new Button ("Next    "), new Button ("Last ")};
		 for (Button course: courses) {
		 HBox.setMargin(course, new Insets(0, 0, 0, 2));
		 vBox.getChildren().add(course);
		 }
		
		 return vBox;
		 }

}




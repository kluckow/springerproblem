package kluckow.org.springerproblem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kluckow.org.springerproblem.view.components.Chessboard;
import kluckow.org.springerproblem.view.components.Toolbar;

/**
 * The Class App.
 */
public class App extends Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		// main layout
		BorderPane root = new BorderPane();

		// board
		Chessboard<?> board = new Chessboard<>();
		root.setCenter(board);

		// toolbar
		Toolbar toolbar = new Toolbar(board);
		root.setBottom(toolbar);

		// stage
		primaryStage.setTitle("Springerproblem");
		primaryStage.setScene(new Scene(root, 560, 586));
		primaryStage.show();

	}

}

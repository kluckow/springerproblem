package kluckow.org.springerproblem;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kluckow.org.springerproblem.view.nodes.Chessboard;
import kluckow.org.springerproblem.view.nodes.Toolbar;

public class App extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// main layout
		BorderPane root = new BorderPane();

		// board
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_CENTER);
		Chessboard<?> board = new Chessboard<>();
		vbox.getChildren().add(board);
		root.setCenter(board);

		// toolbar
		Toolbar toolbar = new Toolbar(board);
		root.setBottom(toolbar);

		primaryStage.setTitle("Springerproblem");
		primaryStage.setScene(new Scene(root, 560, 586));
		primaryStage.show();

	}

}

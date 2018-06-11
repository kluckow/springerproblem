package kluckow.org.springerproblem;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kluckow.org.springerproblem.view.Chessboard;
import kluckow.org.springerproblem.view.Field;

public class App extends Application {

	Chessboard board;

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
		this.board = new Chessboard();
		this.board.setAlignment(Pos.BASELINE_CENTER);
		vbox.getChildren().add(this.board);

		root.setCenter(vbox);

		// toolbar
		Button btnStart = new Button("Start");
		btnStart.setMinWidth(100);
		btnStart.setOnAction(event -> {
			this.board.clear();
			Field rndField = this.board.getFields()[0][0];
			Image img = new Image("knight_black.png");
			ImageView imgView = new ImageView(img);
			rndField.getChildren().addAll(imgView);
		});
		// TODO: img arrow left, disabled if knight not positioned yet
		Button btnPrevious = new Button("Previous");
		btnPrevious.setMinWidth(100);
		// TODO: img arrow right, disabled if knight not positioned yet
		Button btnNext = new Button("Next");
		btnNext.setMinWidth(100);

		Button rndKnightPosition = new Button("Randomize");
		rndKnightPosition.setMinWidth(100);
		rndKnightPosition.setOnAction(event -> {

			this.board.clear();

			Random rnd = new Random();
			int col = rnd.nextInt(8);
			int row = rnd.nextInt(8);
			Field rndField = this.board.getFields()[col][row];
			Image img = new Image("knight_black.png");
			ImageView imgView = new ImageView(img);
			rndField.getChildren().addAll(imgView);
			System.out.println("Setting knight on a random position: (" + col + "|" + row + ")");
		});

		HBox toolbar = new HBox(btnStart, btnPrevious, btnNext, rndKnightPosition);
		toolbar.setAlignment(Pos.TOP_CENTER);
		toolbar.setSpacing(10);
		root.setBottom(toolbar);

		primaryStage.setTitle("Springerproblem");
		primaryStage.setScene(new Scene(root, 560, 586));
		primaryStage.show();

	}

}

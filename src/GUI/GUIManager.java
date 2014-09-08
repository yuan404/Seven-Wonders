package GUI;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Lane 界面管理者-通过该类管理所有界面
 */

public class GUIManager {

	private double XScreen;
	private double YScreen;

	private Group root;
	private Scene scene;
	private Stage stage;

	private Block block;

	private Image icon = new Image("resource/image/icon.png");
	private Image cursor = new Image("resource/image/arrow.png");

	public ChoiceBox<Integer> PlayerNum;
	@SuppressWarnings("unchecked")
	public ChoiceBox<String>[] PlayerLevel = new ChoiceBox[7];

	public String[] Level = { "Level1" };

	public GUIManager() {
		XScreen = 1099;
		YScreen = 713;
		root = new Group();
		block = new Block(XScreen, YScreen);
	}

	public void initScene() {
		scene = new Scene(root, XScreen, YScreen);
		scene.setCursor(new ImageCursor(cursor));
	}

	public void initStage() throws Exception {
		stage = new Stage();
		stage.setTitle("Seven Wonders");
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.getIcons().add(icon);
		setBlock();
	}

	public Group getGroup() {
		return root;
	}

	public Scene getScene() {
		return scene;
	}

	public Stage getStage() {
		return stage;
	}

	public void setBlock() {
		root.getChildren().add(block.getBlock());
		root.getChildren().add(block.getLogo());
		root.getChildren().add(block.getVersion());
		root.getChildren().add(block.getpt());
		root.getChildren().add(block.getpm());
		root.getChildren().add(block.getpf());
		root.getChildren().add(block.getMenu());
		for (int i = 0; i < 7; i++)
			root.getChildren().add(block.getLabel(i));
		block.setStartEffect();
	}

	public ImageView iv;
	public Text[] text = new Text[8];
	public Button[] button = new Button[2];

	public void setNewGame() {
		if (PlayerNum != null)
			removeNewGame();
		iv = block.getMenuBg();
		root.getChildren().add(iv);

		PlayerNum = block.getPlayerNum();
		root.getChildren().add(PlayerNum);

		text[0] = block.getText("Player Num", XScreen / 3 + 30,
				YScreen / 3 - 20, 25);
		root.getChildren().add(text[0]);
		setPlayer(PlayerNum.getSelectionModel().getSelectedItem());

		button[0] = block.getStart();
		button[1] = block.getCancel();
		root.getChildren().add(button[0]);
		root.getChildren().add(button[1]);
	}

	public void setPlayer(int num) {
		for (int i = 1; i <= num; i++) {
			text[i] = block.getText("Player " + i, XScreen / 3 + 30, YScreen
					/ 3 - 20 + i * 40, 25);
			root.getChildren().add(text[i]);
			PlayerLevel[i - 1] = block.getPlayerLevel(i);
			root.getChildren().add(PlayerLevel[i - 1]);
		}
	}

	public void removePlayer(int num) {
		for (int i = 1; i <= num; i++) {
			root.getChildren().remove(text[i]);
			root.getChildren().remove(PlayerLevel[i - 1]);
		}
	}

	public void removeNewGame() {
		root.getChildren().remove(iv);
		root.getChildren().remove(PlayerNum);
		root.getChildren().remove(text[0]);
		root.getChildren().remove(button[0]);
		root.getChildren().remove(button[1]);
		removePlayer(PlayerNum.getSelectionModel().getSelectedItem());
	}
}
